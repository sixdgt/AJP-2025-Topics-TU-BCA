package ui;
// importing required packages
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

// here ActionListener is an Interface so we must override its abstract method
public class CardLayoutExample extends JFrame implements ActionListener{
    Container mainPanel;
    CardLayout cl;
    // constructor
    CardLayoutExample(){
        mainPanel = getContentPane();
        JButton b1 = new JButton("Button One");
        JButton b2 = new JButton("Button Two");
        JButton b3 = new JButton("Button Three");
        cl = new CardLayout();
        // setting layout
        mainPanel.setLayout(cl);
        // adding action listener to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        mainPanel.add("1", b1);
        mainPanel.add("2", b2);
        mainPanel.add("3", b3);
        
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // abstract method of ActionListener which is being overriden here
    @Override
    public void actionPerformed(ActionEvent e) {
        this.cl.next(mainPanel);
    }  
    
    public static void main(String[] args) {
        new CardLayoutExample().setVisible(true);
    }
}
