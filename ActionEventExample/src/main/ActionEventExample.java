package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class ActionEventExample extends JFrame{
    JButton click;
    public ActionEventExample(){
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // to put the frame in center
        setLocationRelativeTo(null);
        click = new JButton();
        click.setText("Click on Me");
        click.setBounds(50, 200, 100, 100);
        click.setBackground(Color.red);
        click.setBorder(new BevelBorder(HEIGHT));
        
        add(click);
        // passing inner class inside the method
        click.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                click.setBackground(Color.gray);
                click.setForeground(Color.white);
                click.setText("Wow! I am clicked");
                setBackground(Color.red);
            }
        });
        setVisible(true);
    }
    
    public static void main(String args[]){
        // to make the GUI look & feel attractive
        // method one
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ActionEventExample();
            }
        });
        // creating object by method reference
        // method two: here instead of method, constructor will
        // be invoked
        SwingUtilities.invokeLater(ActionEventExample::new);
        
    }
}
