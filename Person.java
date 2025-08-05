public class Person {
    public enum Type { STUDENT, STAFF }
    public String name;
    public Type type;

    public Person(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}