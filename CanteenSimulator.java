import java.io.*;
import java.util.*;

public class CanteenSimulator {
    public static class Result {
        public double meanStudentWait;
        public double meanStaffWait;
        public int hungryStudents;
        public int hungryStaff;
    }

    private List<int[]> config = new ArrayList<>(); // [students, staff, served] per minute
    private int maxQueueLength = 15; // You can make this configurable

    public void loadConfig(String filename) throws IOException {
        config.clear();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int students = Integer.parseInt(parts[1]);
            int staff = Integer.parseInt(parts[2]);
            int served = Integer.parseInt(parts[3]);
            config.add(new int[]{students, staff, served});
        }
        br.close();
    }

    // staffJump: true = staff jump queue, false = staff wait in line
    public Result runSimulation(boolean staffJump) {
        Queue<Person> queue = new LinkedList<>();
        List<Integer> studentWaits = new ArrayList<>();
        List<Integer> staffWaits = new ArrayList<>();
        int hungryStudents = 0, hungryStaff = 0;
        int currentTime = 0;

        for (int[] minute : config) {
            int students = minute[0], staff = minute[1], served = minute[2];

            // Add arrivals
            for (int i = 0; i < students; i++) {
                if (queue.size() < maxQueueLength) {
                    queue.add(new Person(currentTime, false));
                } else {
                    hungryStudents++;
                }
            }
            for (int i = 0; i < staff; i++) {
                if (queue.size() < maxQueueLength) {
                    if (staffJump) {
                        // Insert after current front (if any)
                        if (queue.isEmpty()) {
                            queue.add(new Person(currentTime, true));
                        } else {
                            List<Person> temp = new ArrayList<>(queue);
                            temp.add(1, new Person(currentTime, true));
                            queue = new LinkedList<>(temp);
                        }
                    } else {
                        queue.add(new Person(currentTime, true));
                    }
                } else {
                    hungryStaff++;
                }
            }

            // Serve people
            for (int i = 0; i < served && !queue.isEmpty(); i++) {
                Person p = queue.poll();
                int wait = currentTime - p.arrivalTime;
                if (p.isStaff) staffWaits.add(wait);
                else studentWaits.add(wait);
            }
            currentTime++;
        }

        // Calculate means
        Result result = new Result();
        result.meanStudentWait = studentWaits.stream().mapToInt(i -> i).average().orElse(0);
        result.meanStaffWait = staffWaits.stream().mapToInt(i -> i).average().orElse(0);
        result.hungryStudents = hungryStudents;
        result.hungryStaff = hungryStaff;
        return result;
    }

    private static class Person {
        int arrivalTime;
        boolean isStaff;
        Person(int arrivalTime, boolean isStaff) {
            this.arrivalTime = arrivalTime;
            this.isStaff = isStaff;
        }
    }
}