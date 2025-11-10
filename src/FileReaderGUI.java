import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * A GUI application that reads a file and displays its contents in a JList.
 @author stephan knappstein A01208242
 @version 1.0
 */
public class FileReaderGUI extends JFrame {

    /** The label to display instructions. */
    private JLabel label;
    /** The button to trigger file reading. */
    private JButton button;
    /** The list to display the file contents. */
    private JList<String> list;
    /** The file to be read. */
    private File file;
    /** The main frame of the application. */
    private JFrame frame;
    /** The top panel containing the label. */
    private JPanel topPanel;
    /** The center panel containing the button. */
    private JPanel centerPanel;
    /** The bottom panel. */
    private JPanel bottomPanel;


    /**
     * Constructs the FileReaderGUI, initializing the GUI components and setting up the frame.
     */
    public FileReaderGUI() {
        // Set the title of the frame
        file = new File("resources/countries.txt");


        setLayout(new BorderLayout());

        topPanel= new JPanel();
        centerPanel = new JPanel();

        // Create the label
        label = new JLabel("Click the button to display the file contents");


        // Create the button
        button = new JButton("Display File Contents");

        // button.addActionListener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String[] countries = readFile(file).toArray(new String[0]);
                list.setListData(countries);

            }});
        list = new JList<String>();



        topPanel.add(label);
        centerPanel.add(button);
        //Add the panel to the top of the frame



        //frame.setSize(400,400); --> not necessary. JFrame is being extended n
        setSize(400, 400);
        setLocation(500,500);
        add( topPanel , BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        add(list, BorderLayout.SOUTH);
        setVisible(true);


    }//end of constructor

    /**
     * Reads the contents of a file and returns them as a list of strings.
     *
     * @param file The file to read.
     * @return A list of strings, where each string is a line from the file.
     */
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

    /**
     * The main method to run the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new instance of the SimpleGUI class
        FileReaderGUI gui = new FileReaderGUI();
    }
}// end of class