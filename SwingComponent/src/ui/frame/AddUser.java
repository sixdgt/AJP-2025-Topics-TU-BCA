package ui.frame;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUser extends JInternalFrame{
    private final JLabel lbl_full_name, lbl_email, lbl_contact;
    private final JTextField txt_full_name, txt_email, txt_contact;
    private final JButton btn_add, btn_reset;
    public AddUser(){
        lbl_full_name = new JLabel("Enter Fullname: ");
        lbl_email = new JLabel("Enter Email: ");
        lbl_contact = new JLabel("Enter Contact");
        txt_full_name = new JTextField();
        txt_email = new JTextField();
        txt_contact = new JTextField();
        btn_add = new JButton("Add User");
        btn_reset = new JButton("Reset");
        setSize(400, 500);
        setTitle("Add User");
        GridLayout gl = new GridLayout(5, 2, 50, 50);
        setLayout(gl);
        add(lbl_full_name);
        add(txt_full_name);
        add(lbl_email);
        add(txt_email);
        add(lbl_contact);
        add(txt_contact);
        add(btn_add);
        add(btn_reset);
        setMaximizable(true);
        setClosable(true);
    }
}
