import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class FileReaderGUI extends JFrame {

    // Declare the components
    private JLabel label;
    private JButton button;
    private JList<String> list;

 public FileReaderGUI() {
     // Set the title of the frame
     setTitle("Filereader GUI");
     // Create the label
     label = new JLabel("Click the button to display the file contents");
     label.setBounds(10, 10, 200, 20);

     // Create the button
     button = new JButton("Display File Contents");
     button.setBounds(10, 40, 120, 20);

 }//end of constructor

}// end of class