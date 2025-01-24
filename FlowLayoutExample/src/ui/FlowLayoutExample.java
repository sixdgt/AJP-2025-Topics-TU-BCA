package ui;
// importing the required libraries
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

// here FlowLayoutExample class will extends all the properties of JFrame
public class FlowLayoutExample extends JFrame{
    // constructor name must be same as class name
    public FlowLayoutExample() {
        // lets create some buttons
        JButton b1 = new JButton("ONE");
        JButton b2 = new JButton("TWO");
        JButton b3 = new JButton("THREE");
        JButton b4 = new JButton("FOUR");
        JButton b5 = new JButton("FIVE");
        // adding components to frame 
        // `add()` method is use to add component in frame
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        
        // setting frame layout
        setLayout(new FlowLayout());
        // setting frame size
        setSize(300, 400);
        // displaying frame - pass `true`
        setVisible(true);
        // will close the program while the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // main method
    public static void main(String[] args) {
        // creating object
        new FlowLayoutExample();
    }
}
