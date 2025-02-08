package ui.frame;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUser extends JInternalFrame implements ActionListener{
    private final JLabel lbl_full_name, lbl_email, lbl_contact, lbl_user_profile;
    private final JTextField txt_full_name, txt_email, txt_contact;
    private final JButton btn_add, btn_reset, btn_select;
    public AddUser(){
        lbl_full_name = new JLabel("Enter Fullname: ");
        lbl_email = new JLabel("Enter Email: ");
        lbl_contact = new JLabel("Enter Contact");
        lbl_user_profile = new JLabel("No image selected");
        txt_full_name = new JTextField();
        txt_email = new JTextField();
        txt_contact = new JTextField();
        btn_add = new JButton("Add User");
        btn_reset = new JButton("Reset");
        btn_select = new JButton("Select User Profile");
        // adding actionlistener event to buttons
        btn_select.addActionListener(this); 
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
        add(btn_select);
        add(lbl_user_profile);
        add(btn_add);
        add(btn_reset);
        setMaximizable(true);
        setClosable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btn_select){
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // will allow files
            int data = chooser.showOpenDialog(this);
            if(data == JFileChooser.APPROVE_OPTION){
                File selected_file = chooser.getSelectedFile();
                ImageIcon icon = new ImageIcon(selected_file.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                this.lbl_user_profile.setIcon(new ImageIcon(img));
                this.lbl_user_profile.setText(selected_file.getName());
            }
        }
    }
}
