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
 *	Students arriving, staff arriving, customers served.
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
    
    JButton button1;

    JLabel label1;
    JLabel label2;



    JTextField textField1;

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
    this.getContentPane().setPreferredSize(new Dimension(1920,1080));
    //                                                   Width, Heigh  
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    //make the window appear on the screen 
    this.pack();
    this.toFront();
    this.setVisible(true);
    
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
   panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Set layout to BoxLayout with vertical alignment

   //panel1.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns
   panel1.setBackground(Color.decode("#f3f0df")); // Set background color to pink
   this.add(panel1, BorderLayout.NORTH);


   //Add a second panel to the window
   panel2 = new JPanel();
   panel2.setLayout(new FlowLayout(FlowLayout.CENTER  , 10, 5)); // 10 pixels between components, 5 pixels between rows
   panel2.setBackground(Color.decode("#7bb830"));
   this.add(panel2, BorderLayout.CENTER);


   // //Add a third panel to the window
   // JPanel panel3 = new JPanel();
   // panel3.setLayout(new FlowLayout(FlowLayout.CENTER  , 10, 5)); // 10 pixels between components, 5 pixels between rows
   // panel3.setBackground(Color.decode("#00FF00"));
   // this.add(panel3, BorderLayout.SOUTH);

   // //Add a button to the first panel
   // button1 = new JButton("Convert");
   // button1.addActionListener(this);//allowing to create action fot the button
   // panel1.add(button1);
   
   //Add WHS logo to the first panel in the CENTER of label 1 and label 2 e.g: (WHS logo) Wellington High School
   //Class variables for the image WHS logo
   String image1 = "WHS-Logo-Master-Small.png" ; // Address of the image
   JLabel image1Label;
    


   //Declare image
   ImageIcon firstImage = new ImageIcon(image1); // Create an ImageIcon from the image address

   //Add ImageIcon to JLabel we declared earlier
   image1Label = new JLabel(firstImage);

   //Add the image to the first panel
   panel1.add(image1Label);

   // Set the size of the logo
   int width = 100; // Width of the logo
   int height = 100; // Height of the logo
   
   //Move image to the left side of the panel
   image1Label.setAlignmentX(Component.LEFT_ALIGNMENT); // Set horizontal alignment to LEFT
   Image myImage = firstImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Get the image from the ImageIcon
   ImageIcon scaledIcon = new ImageIcon(myImage); // Scale the image to the desired size

   image1Label.setIcon(scaledIcon); // Set the scaled image to the JLabel
   




   //Add a label to the first panel
   label1 = new JLabel("Wellington High School");
   label1.setFont(new Font("Arial", Font.BOLD, 40));
   label1.setForeground(Color.decode("#e64b6d")); // Set font color to #e64b6d

   //move the lebel to the right side of the image
   

   panel1.add(label1);

   //Add a label to the second panel
   label2 = new JLabel("Te Kura Tuarua o Taraika ki Pukeahu");
   label2.setFont(new Font("Arial", Font.BOLD, 40));
   label2.setForeground(Color.decode("#e64b6d")); // Set font color to #e64b6d
   // label2.setAlignmentX(Component.CENTER_ALIGNMENT); //move the lebel to the right side of the image

   panel1.add(label2);

    //Add a text field to the first panel
   textField1 = new JTextField(30); // 30 columns
   panel1.add(textField1);


   JComboBox comboBox;
   String choice = " ";
   }

   boolean command = true;
}

   public static void main(String[] args) {
        Window window = new GUI();
      
   }
   
    //This method is called when a menu item is clicked
    public void actionPerformed(ActionEvent e) {
        //System.out.println("You clicked the " + e.getActionCommand() + " menu item");
        //Using if/else statements to determine which menu item was clicked
        //and print a message to the console
       String command = e.getActionCommand();
       

       switch(command){

            case "Convert":
               System.out.println("Button clicked");
               System.out.println(textField1.getText());
               int input = Integer.parseInt(textField1.getText());//Print whatever is in the text field
               label2= new JLabel(textField1.getText());
  
               System.out.println(bouncer(input));
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
               break;
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
    String bouncer (int age){
      if(age > 18){return("Welcome to the program");}
      else {return("You are not old enough to use this program");}
    }

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
   
}

