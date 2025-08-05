/**
 * 
 * Canteen Queues
 * Your student council needs you!
 * The WHS student council has fielded many complaints about staff members jumping the queue in the canteen.
 * They are gathering concrete information about how often this happens, and how many students turn up and what rates during interval and lunch time.
 * While they gather this information,
 * they have asked help from computer science students to build a simulator that will allow them to demonstrate how this behaviour by staff impacts students
 * 
 * The task
 * 
 * The council has determined that the simulator must:
 * 
 * 1: Have a configuration file that lists minute by minute the number of:
 *    Students arriving, staff arriving, customers served.
 * The student council is working with maths department students to generate this information.  
 * It is not yet ready, so you will have to come up with a starting set of values.
 * 2: After each run, the simulator must show mean student and staff wait times,  
 * both in the situation where staff members are served immediately the current person is served, 
 * and when the staff member has to wait in line.
 * In addition the simulator could:
 * 3: Be able to run a configurable number of simulations on the same configuration file but introducing a small degree of randomness to exact arrivals and serving numbers; 
 * and present summary statistics.
 * 4: The simulator could have options for trying various “What if” scenarios (changed student/staff arrival rate by a %; changed time to serve%).
 * 5: The simulator could also be able to accommodate a configurable maximum queue length, after which nobody joins the queue as it is too long. 
 * Statistics about how many people “go hungry” because of the queue length in both the staff queue jumping, and non-queue jumping should also be kept and made available.
 * 
 * You may
 * You may have a purely text-based interface or use a GUI with menus for selecting options.
 * No visual representation of a queue is required, although you may optionally provide one.
 * If 2m distancing is in place in the queue, this will restrict the number of people in the queue, 
 * you might have an option for indicating how this could affect things.
 * 
 * 
 * @author Duc Tran Tri
 * 16/06/2025
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener, MouseListener, ItemListener
{
    /**
     *  
     * 
     */
    
    //Class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemNew;
    JMenuItem menuItemOpen;
    JMenuItem menuItemSave;
    JMenuItem menuItemExit;
    JMenuItem menutemPase;

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    JButton button1;
   
    JLabel label1;
    JLabel label2;
    JLabel label3;

    // Declare a queue for students
   //  java.util.Queue<String> studentQueue = new java.util.LinkedList<>();
   java.util.Queue<Person> queue = new java.util.LinkedList<>();
   //  JTextField textField1;

    JComboBox comboBox;
    String choice = " ";
    /**
     * Constructor for objects of class blank
     * 
     */
   public GUI()
   {
 

    //Create a new window
    super();
    
    //Set the size of the window
    this.setSize(1920, 1080);
    
    //Set the location of the window
    this.setLocation(0, 0);
    
    //Set the default close operation
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set the icon image for the window                   //Address of the image
    ImageIcon icon = new ImageIcon(getClass().getResource("/Project Images/WHS-Logo-Master-Small.png"));
    this.setIconImage(icon.getImage());

    //Make the window visible
    this.setVisible(true);
    
    //Add a menu bar to the window
    menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
   {
    //Naming window method
    setTitle("Canteen Queue window");
    this.getContentPane().setPreferredSize(new Dimension(1980,1080)); // Set the preferred size of the content pane
    //                                                   Width, Heigh  
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    //make the window appear on the screen 
    this.pack();
    this.toFront();
   //  this.setVisible(true);
    
    //Add the menuBar
    
    menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    


    //Add the menu 
    //(in this case it's the File menu)
    
    menu = new JMenu("Files");
    menuBar.add(menu);
    
    //If I was building a bigger program with more things in the menu, 
    //I would probably use a different variable for "menu". Perhaps I would call it menuFile. 
    
    //Add the three menuItems 
    
    menuItemNew = new JMenuItem("New");
    menuItemOpen = new JMenuItem("Open");
    menuItemSave = new JMenuItem("Save");
    menuItemExit = new JMenuItem("Exit");

    menu.add(menuItemNew);
    menuItemNew.addActionListener(this);
    menu.add(menuItemOpen);
    menuItemOpen.addActionListener(this);
    menu.add(menuItemSave);
    menuItemSave.addActionListener(this);
    menu.add(menuItemExit);
    menuItemExit.addActionListener(this);

    addMouseListener(this);

   String items[] = {"Item 1", "Item 2", "Item 3", "Item 4"};
   comboBox = new JComboBox(items);
   comboBox.addItemListener(this);

   /*---SET UP PANELS---*/
   panel1 = new JPanel();
   panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS)); // Set layout to BoxLayout with vertical alignment

   
   panel1.setBackground(Color.decode("#f3f0df")); // Set background color to white
   panel1.setPreferredSize(new Dimension(1980, 200)); // Set preferred size
   // panel1.add(Box.createRigidArea(new Dimension(50, 50))); // Add space at the top of the panel
   //Use BoxLayout to align components vertically
   // panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel
   panel1.add(Box.createHorizontalGlue()); // Add horizontal glue to center the components in panel1


   // Create a sub-panel for logo and label1
   JPanel logoAndLabelPanel = new JPanel();
   logoAndLabelPanel.setLayout(new BoxLayout(logoAndLabelPanel, BoxLayout.LINE_AXIS));
   logoAndLabelPanel.setOpaque(false); // Transparent background


   //Add a second panel to the window
   panel2 = new JPanel();

   panel2.setBackground(Color.decode("#7bb830")); // Set background color to green
   // Set small preferred size of panel2
   
   // Set preferred size to the height of the button and the width of the panel equal to the width of the window
   panel2.setPreferredSize(new Dimension(1980, 50)); // Set preferred size to the height of the button and the width of the panel equal to the width of the window
   // panel2.add(Box.createRigidArea(new Dimension(50, 50))); // Add space at the middle of window
   // panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel

   //Set position of panel2 above panel3 and below panel1
   // panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS)); // Set layout to BoxLayout with vertical alignment




   // //Add a third panel to the window
   panel3 = new JPanel();
   panel3.setBackground(Color.decode("#f3f0df"));
   // Set preferred size of panel3
   // Set preferred size the width of the panel equal to the width of the window
   // Set preferred size to the height of all the space below panel2 and the width of the panel equal to the width of the window
   panel3.setPreferredSize(new Dimension(1980, 800)); // Set preferred size to the height of all the space below panel2 and the width of the panel equal to the width of the window
   // panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel
   //Add panel3 to the bottom of the
   //Set layout of panel3 to the end of the Jframe
   panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS)); // Set layout

   //Set the layout of the content pane to vertical BoxLayout
   this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS)); // Set layout to BoxLayout with vertical alignment

   //Add the panels in the correct orders: top to bottom
   this.getContentPane().add(panel1); // Add panel1 to the top
   this.getContentPane().add(panel2); // Add panel2 below panel1
   //Because the panel2 is the smallest panel, so BorderLayout does not add it to the center, it adds it to the top
   this.getContentPane().add(panel3); // Add panel3 below panel2


   // Create a new panel for the buttons with horizontal BoxLayout
   JPanel buttonPanel = new JPanel();
   buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
   buttonPanel.setOpaque(false); // Transparent background

   //Remove the button1 and add a new button to run the simulation because this feature take so much time to work on and unnecessary for the project
   // button1 = new JButton("Add student");
   // button1.addActionListener(this);
   // button1.setFont(new Font("Arial", Font.BOLD, 20));
   // button1.setPreferredSize(new Dimension(200, 50));



   JButton simulateButton = new JButton("Run Simulation");
   simulateButton.setFont(new Font("Arial", Font.BOLD, 20));
   simulateButton.setPreferredSize(new Dimension(200, 50));
   simulateButton.addActionListener(e -> runSimulation());


   buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button panel horizontally

   // Add buttons to the panel with glue in between
   // buttonPanel.add(button1); // Left
   // buttonPanel.add(Box.createHorizontalGlue());
   
   buttonPanel.add(simulateButton); // Right

   // Add some vertical space above the button panel if you want
   panel3.add(Box.createVerticalStrut(40));
   panel3.add(buttonPanel);

   

   // //Add WHS logo to the first panel in the CENTER of label 1 and label 2 e.g: (WHS logo) Wellington High School
   // //Class variables for the image WHS logo
   // String image1 = "WHS-Logo-Master-Small.png" ; // Address of the image
   // JLabel image1Label;
    


   // //Declare image
   // ImageIcon firstImage = new ImageIcon(image1); // Create an ImageIcon from the image address

   // //Add ImageIcon to JLabel we declared earlier
   // image1Label = new JLabel(firstImage);

   // //Add the image to the first panel
   // panel1.add(image1Label);

   // // Set the size of the logo
   // int width = 100; // Width of the logo
   // int height = 100; // Height of the logo
   
   // //Move image to the left side of the panel
   // // image1Label.setAlignmentX(Component.LEFT_ALIGNMENT); // Set horizontal alignment to LEFT
   // Image myImage = firstImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Get the image from the ImageIcon
   // ImageIcon scaledIcon = new ImageIcon(myImage); // Scale the image to the desired size

   // image1Label.setIcon(scaledIcon); // Set the scaled image to the JLabel
   
      // Add image to the left
   String image1 = "WHS-Logo-Master-Small.png";
   ImageIcon firstImage = new ImageIcon(image1);
   JLabel image1Label = new JLabel();
   int width = 100, height = 100;
   Image myImage = firstImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
   ImageIcon scaledIcon = new ImageIcon(myImage);
   image1Label.setIcon(scaledIcon);
   
   // Set the alignment of the image label to the left
   image1Label.add(Box.createVerticalGlue()); 

   //Canteen Image
   String canteenImage = "canteen.png"; // Address of the canteen image
   ImageIcon canteenIcon = new ImageIcon(getClass().getResource("/Project Images/canteen.png"));
   JLabel canteenImageLabel = new JLabel(canteenIcon);
   //Set horizontal alignment of the canteen image on top of the queue
   canteenImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Set horizontal alignment to CENTER
   panel3.add(canteenImageLabel); // Add the canteen image to panel3
   // Set the size of the canteen image
   int canteenWidth = 400; // Width of the canteen image
   int canteenHeight = 400; // Height of the canteen image
   Image canteenImageScaled = canteenIcon.getImage().getScaledInstance(canteenWidth, canteenHeight, Image.SCALE_SMOOTH); // Scale the image to the desired size
   ImageIcon scaledCanteenIcon = new ImageIcon(canteenImageScaled);
   canteenImageLabel.setIcon(scaledCanteenIcon); // Set the scaled image to the JLabel
   //Set hozizontal alignment of the canteen image to the center of panel3 and move on top of the queue 
   canteenImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Set horizontal alignment to CENTER
   canteenImageLabel.setAlignmentY(Component.TOP_ALIGNMENT); // Set vertical alignment to TOP

   
   //Add a label to the first panel
   label1 = new JLabel("Wellington High School");
   label1.setFont(new Font("Arial", Font.BOLD, 40));
   label1.setForeground(Color.decode("#e64b6d")); // Set font color to #e64b6d
   label1.setAlignmentY(Component.LEFT_ALIGNMENT); // Set vertical alignment to CENTER

   // Add logo and label to sub-panel
   logoAndLabelPanel.add(image1Label);
   logoAndLabelPanel.add(Box.createHorizontalStrut(0)); // Space between logo and label
   logoAndLabelPanel.add(label1);

   // Add sub-panel to panel1
   panel1.add(logoAndLabelPanel);
   //move the lebel to the right side of the image
   

   // panel1.add(label1);

   //Add a label to the second panel
   label2 = new JLabel("Te Kura Tuarua o Taraika ki Pukeahu");
   label2.setFont(new Font("Arial", Font.BOLD, 40));
   label2.setForeground(Color.decode("#e64b6d")); // Set font color to #e64b6d
  
   //Set the size of the label2 only enough to fit the text
   label2.setPreferredSize(new Dimension(500, 50)); 
   // panel1.add(label2);
   
   // Create a vertical panel for the two labels
   JPanel labelsPanel = new JPanel();
   labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.PAGE_AXIS));
   labelsPanel.setOpaque(false);
   labelsPanel.add(label1);
   labelsPanel.add(label2);

   // Add image and labels panel to the horizontal panel
   logoAndLabelPanel.add(image1Label);
   logoAndLabelPanel.add(Box.createHorizontalStrut(20)); // Space between image and labels
   logoAndLabelPanel.add(labelsPanel);

   label3 = new JLabel("Canteen");
   label3.setFont(new Font("Arial", Font.BOLD, 40));
   label3.setForeground(Color.WHITE); // Set font color to White
   label3.setAlignmentX(Component.CENTER_ALIGNMENT); //move the lebel to the center of the panel2 and above the button1
   panel2.add(label3);

   this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the window to full screen
   // this.setUndecorated(false); // Set to true for borderless fullscreen, false
   // to keep window borders
   // Show the window
   this.setVisible(true);

   //Add a text field to the first panel
   // textField1 = new JTextField(30); // 30 columns
   // panel1.add(textField1);


   JComboBox comboBox;
   String choice = " ";
   }

   boolean command = true;
}

   public static void main(String[] args) {
        Window window = new GUI();
         // window.setVisible(true); // Make the window visible
         window.setLayout(new BorderLayout()); // Set layout manager to BorderLayout
   }
   
    //This method is called when a menu item is clicked
    public void actionPerformed(ActionEvent e) {
        System.out.println("You clicked the " + e.getActionCommand() + " menu item");
        //Using if/else statements to determine which menu item was clicked
        //and print a message to the console
       String command = e.getActionCommand();
       

       switch(command){

            case "Add student":
               String name = JOptionPane.showInputDialog(this, "Enter student name:");
               if (name != null && !name.trim().isEmpty()) {
                  queue.add(new Person(name.trim(), Person.Type.STUDENT));
                  repaint();
                  JOptionPane.showMessageDialog(this, name + " has been added to the queue. 😊");
               } else {
                  JOptionPane.showMessageDialog(this, "Invalid name. Please try again.");
               }
               break;
                
            case "New":
               System.out.println("Creating new document...");

               break;
            case "Open":
               System.out.println("Opening existing document...");
               //Create a dialog box that contains the text "No file found" when the user clicks open
               OpenDialog();
                  break;
            case "Save":
               System.out.println("Saving existing document...");
               //Create a dialog box that contains the text "file successfully saved" when the user clicks save
               SaveDialog();
            
                  break;
            case "Exit":
               System.exit(0);
               break;
            default:
               System.out.println("Unknown command");
               //Create a dialog box that contains the text "Unknown command" when the user clicks an unknown command
               GenericDialog("Unknown command");
               break;
       }
    }

    //Visualize the queue
    //Adding two gray rectangles to the panel2
      //The first rectangle is 500 pixels wide and 20 pixels high
      //The second rectangle is 20 pixels wide and 150 pixels high
      @Override
public void paint(Graphics g) {
    super.paint(g);

    // Draw the queue rectangles
    g.setColor(Color.decode("#808080")); // Gray
    g.fillRect(750, 930, 600, 20); // Horizontal queue
    g.fillRect(750, 800, 20, 150); // Vertical part

    // Draw students in the queue as circles or images
   // Bigger student circles
    int studentRadius = 50; // Increased size
    int maxStudents = 15;
    int queueWidth = 600;
    // Increase the gap between students
    int gap = (int)(((queueWidth - studentRadius) / (double)(maxStudents - 1)) * 1.5); // 1.5x gap // Dynamically calculate gap
   // int gap = (queueWidth - studentRadius) / (maxStudents - 1); 
   int startX = 760; // Start a bit inside the rectangle
   //  int y = 760;      // Centered vertically in the queue rectangle
    int y = 940 - studentRadius / 2; // Centered vertically in the queue rectangle (930 + 10 - radius/2)


    int i = 0;
   for (Person person : queue) {
      if (i >= maxStudents) break;
      // Set color based on type
      if (person.type == Person.Type.STUDENT) {
         g.setColor(Color.decode("#e64b6d")); // Pink for students
      } else {
         g.setColor(Color.decode("#7bb830")); // Green for staff
      }
      g.fillOval(startX + i * gap, y - studentRadius / 2, studentRadius, studentRadius);

      // Draw the person's initial
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 35));
      String initial = person.name.length() > 0 ? person.name.substring(0, 1).toUpperCase() : "?";
      g.drawString(initial, startX + i * gap + 3, y + 7);

      // Add emoji for staff members
      if (person.type == Person.Type.STAFF) {
         g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
         g.drawString("👨‍🏫", startX + i * gap + 20, y + 35);
      }

      i++;
      if (i >= 15) break;
      
    }
}
   

    //Create a new method to create a dialog box for saving
    //This method creates a dialog box that contains the text "file successfully saved" when the user clicks save
    void SaveDialog(){

      JDialog Savebox = new JDialog(this);

     
      //Add text to the dialog box
      TextArea SaveboxInfo = new TextArea("Save file successfully saved");

      SaveboxInfo.setEditable(false);
      SaveboxInfo.setFont(new Font("Inter", Font.PLAIN, 12));
      SaveboxInfo.setSize(300, 140);

      Savebox.setBounds(600, 800,300,140);
      Savebox.add(SaveboxInfo);
      Savebox.toFront();
      Savebox.setVisible(true);
      Savebox.setTitle("Dialog");
    }
    
    //Create a new method to create a dialog box for opening
    //This method creates a dialog box that contains the text "No file found" when the user clicks open    
   void OpenDialog(){

      JDialog Openbox = new JDialog(this);

     
      //Add text to the dialog box
      TextArea OpenboxInfo = new TextArea("No file found");

      OpenboxInfo.setEditable(false);
      OpenboxInfo.setFont(new Font("Inter", Font.PLAIN, 12));
      OpenboxInfo.setSize(300, 140);

      Openbox.setBounds(600, 800,300,140);
      Openbox.add(OpenboxInfo);
      Openbox.toFront();
      Openbox.setVisible(true);
      Openbox.setTitle("Dialog");
    }
      //Create a new method to create a generic dialog box
      //This method creates a dialog box that takes a string as an argument and displays that text
   void GenericDialog(String text){
      JDialog Genericbox = new JDialog(this);

     
      //Add text to the dialog box
      TextArea GenericboxInfo = new TextArea(text);

      GenericboxInfo.setEditable(false);
      GenericboxInfo.setFont(new Font("Inter", Font.PLAIN, 12));
      GenericboxInfo.setSize(1980, 1080);

      Genericbox.setBounds(600, 800,300,140);
      Genericbox.add(GenericboxInfo);
      Genericbox.toFront();
      Genericbox.setVisible(true);
      Genericbox.setTitle("Dialog");

      //Add necessary methods for mouse listener

      
    }

    //Create a new method to check if the user are old enough to use the program
   //  String bouncer (int age){
   //    if(age > 18){return("Welcome to the program");}
   //    else {return("You are not old enough to use this program");}
   //  }

    public void mouseClicked(MouseEvent e) {System.out.println("Mouse clicked");
   
   int mouseX = e.getX();
   int mouseY = e.getY();
   System.out.printf("Mouse clicked at (%d, %d)\n", mouseX, mouseY);
   System.out.println(e.getButton());
   String mouseButton;


   if (e.getButton() == MouseEvent.BUTTON1) {
         mouseButton = "Left";
   } else if (e.getButton() == MouseEvent.BUTTON3) {
         mouseButton = "Right";
   } else {
         return;
   }

 
   
   

   System.out.printf("%s clicked at (%d, %d)\n", mouseButton, mouseX, mouseY);   
}
   public void mousePressed(MouseEvent e) {System.out.println("Mouse pressed");



   }
   public void mouseReleased(MouseEvent e) {System.out.println("Mouse released");


   }
   public void mouseEntered(MouseEvent e) {System.out.println("Mouse entered");


   }
   public void mouseExited(MouseEvent e) {System.out.println("Mouse exited");
   }

   public void itemStateChanged(ItemEvent e)
   {
      //Triggered when the item is selected
      if (e.getSource() == comboBox) {
            choice = comboBox.getSelectedItem().toString();
         }
}
   private void runSimulation() {
    try {
        CanteenSimulator sim = new CanteenSimulator();
        sim.loadConfig("config.csv"); // Make sure config.csv is in your project folder

        // Run both modes
        CanteenSimulator.Result jump = sim.runSimulation(true);
        CanteenSimulator.Result noJump = sim.runSimulation(false);

        String msg =
            "🧾 ----------- Canteen Simulation Receipt ----------- 🧾\n\n" +
            "🍽️  Staff Jump Queue:\n" +
            "   👩‍🎓 Mean Student Wait: " + String.format("%.2f", jump.meanStudentWait) + " min\n" +
            "   👨‍🏫 Mean Staff Wait: " + String.format("%.2f", jump.meanStaffWait) + " min\n" +
            "   😢 Hungry Students: " + jump.hungryStudents + "\n" +
            "   😬 Hungry Staff: " + jump.hungryStaff + "\n\n" +
            "---------------------------------------------\n\n" +
            "🍽️  Staff Wait Normally:\n" +
            "   👩‍🎓 Mean Student Wait: " + String.format("%.2f", noJump.meanStudentWait) + " min\n" +
            "   👨‍🏫 Mean Staff Wait: " + String.format("%.2f", noJump.meanStaffWait) + " min\n" +
            "   😢 Hungry Students: " + noJump.hungryStudents + "\n" +
            "   😬 Hungry Staff: " + noJump.hungryStaff + "\n" +
            "🧾 --------------------------------------------- 🧾";

        JOptionPane.showMessageDialog(this, msg, "Simulation Results", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}


}

