/**
 * 
 *
 * @author Duc Tran Tri
 * 16/06/2025
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener, MouseListener, ItemListener
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
   public Window()
   {
 

    //Create a new window
    super();
    
    //Set the size of the window
    this.setSize(800, 600);
    
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
    this.getContentPane().setPreferredSize(new Dimension(1280,960));
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
   panel1.setLayout(new FlowLayout(FlowLayout.CENTER  , 10, 5)); // 10 pixels between components, 5 pixels between rows

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


   //Add a label to the first panel
   label1 = new JLabel("Wellington High School n/ Te Kura Tuarua o Taraika ki Pukeahu");
   //Change the color of the font "WHS Canteen" to #e64b6d
   label1.setFont(new Font("Arial", Font.BOLD, 40));
   label1.setForeground(Color.decode("#e64b6d")); // Set font color to #e64b6d
   label1.setHorizontalAlignment(SwingConstants.LEFT); // Set horizontal alignment to left
   panel1.add(label1);

   //Add a label to the second panel
   label2 = new JLabel("WHS Canteen");
   label2.setFont(new Font("Arial", Font.BOLD, 80));

   panel2.add(label2);



   //Add a text field to the first panel
   textField1 = new JTextField(30); // 30 columns
   panel1.add(textField1);

   

   JComboBox comboBox;
   String choice = " ";
   }

   boolean command = true;
}

   public static void main(String[] args) {
        Window window = new Window();
      
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

