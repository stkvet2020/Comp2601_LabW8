import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class FileReaderGUI extends JFrame {

    // Declare the components
    private JLabel label;
    private JButton button;
    private JList<String> list;
    private File file;
    private JFrame frame;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;


 public FileReaderGUI() {
     // Set the title of the frame
      file = new File("resources/countries.txt");

     //frame = new JFrame("FileReader GUI" );
     setLayout(new BorderLayout());
     //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     topPanel= new JPanel();
     centerPanel = new JPanel();
     //topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
     // Create the label
     label = new JLabel("Click the button to display the file contents");
     //label.setBounds(10, 10, 200, 20);

     // Create the button
     button = new JButton("Display File Contents");
    // button.setBounds(10, 40, 120, 20);
     // button.addActionListener
     button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // readFile(file);
             String[] countries = readFile(file).toArray(new String[0]);
             list.setListData(countries);

         }});
     list = new JList<String>();
    // list.setBounds(100, 70, 150, 150);

     //frame.add(topPanel);
     topPanel.add(label);
     centerPanel.add(button);
     //Add the panel to the top of the frame

     //JScrollPane scrollPane = new JScrollPane(list);
     //scrollPane.setBounds(10, 70, 150, 150);
     //bottomPanel.add(scrollPane);

            //frame.setSize(400,400); --> not necessary. JFrame is being extended n
             setSize(400, 400);
             setLocation(500,500);
             add( topPanel , BorderLayout.NORTH);
             add(centerPanel, BorderLayout.CENTER);
             //frame.add(scrollPane, BorderLayout.SOUTH);
             add(list, BorderLayout.SOUTH);
             //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setVisible(true);


 }//end of constructor
    public List<String>  readFile(File file ) {
        List<String> stringList = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("The file was not found.");
            System.exit(0);
        }

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                stringList.add(fileScanner.nextLine());
            }
        }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        finally{
                if (fileScanner != null) {
                    fileScanner.close();
                }
            }



   return stringList;  }// end of readFile

    public static void main(String[] args) {
        // Create a new instance of the SimpleGUI class
        FileReaderGUI gui = new FileReaderGUI();
    }
}// end of class