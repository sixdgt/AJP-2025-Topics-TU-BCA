package example;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MouseEventExample extends JFrame implements MouseListener{
    GridLayout gl;
    JButton submit, close;
    JLabel lbl_username, lbl_password;
    JTextField txt_username;
    JPasswordField txt_password;
    
    public MouseEventExample(){
        close = new JButton("Close");
        submit = new JButton("Submit");
        
        txt_username = new JTextField();
        txt_password = new JPasswordField();
        
        lbl_username = new JLabel("Enter Username:");
        lbl_password = new JLabel("Enter Password:");
        
        gl = new GridLayout(3, 2, 5, 5); // creting gridlayout object
        setLayout(gl); //setting frame layout
        // adding components in frame
        add(lbl_username);
        add(txt_username);
        add(lbl_password);
        add(txt_password);
        add(submit);
        add(close);
        
        // adding eventlistner
        submit.addMouseListener(this);
        this.reset();
        setSize(600, 600); // frame size
        setDefaultCloseOperation(EXIT_ON_CLOSE); // will close program
        setVisible(true);
    }
    public static void main(String[] args) {
        new MouseEventExample();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());
        JOptionPane.showMessageDialog(rootPane,
                "Your username: " + username + " Password: " + password);
        this.success();
    }
    
    public void success(){
        submit.setBackground(Color.green);
        submit.setForeground(Color.white);
    }
    
    public void reset(){
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.reset();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse over Submit");
        submit.setBackground(Color.red);
        submit.setForeground(Color.white);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.reset();
    }
}
