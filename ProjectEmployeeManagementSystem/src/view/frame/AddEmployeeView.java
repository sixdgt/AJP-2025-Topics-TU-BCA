package view.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddEmployeeView extends JInternalFrame implements ActionListener{
    private final JLabel lbl_first_name, lbl_middle_name, lbl_last_name, 
            lbl_gender, lbl_join_date, lbl_dob, lbl_department, lbl_designation;
    private final JTextField txt_first_name, txt_middle_name, txt_last_name, 
            txt_join_date, txt_dob, txt_designation;
    private final JButton btn_add, btn_reset;
    private final JComboBox cmb_gender, cmb_department;
    public AddEmployeeView(){
        lbl_first_name = new JLabel("Enter First Name: ");
        lbl_middle_name = new JLabel("Enter Middle Name: ");
        lbl_last_name = new JLabel("Enter Last Name: ");
        lbl_gender = new JLabel("Enter Gender: ");
        lbl_join_date = new JLabel("Enter Join Date: ");
        lbl_dob = new JLabel("Enter Date of Birth: ");
        lbl_department = new JLabel("Select Department: ");
        lbl_designation = new JLabel("Enter Designation: ");
        txt_first_name = new JTextField();
        txt_middle_name = new JTextField();
        txt_last_name = new JTextField();
        txt_dob = new JTextField();
        String gender[] = {"Male", "Female", "Others"};
        cmb_gender = new JComboBox();
        for (String data : gender) {
            cmb_gender.addItem(data);
        }
        
        txt_join_date = new JTextField();
        Object department[][] = {{1, "IT Department"}, {2, "Admin"}, {3, "HR"}};
        cmb_department = new JComboBox(department);
        txt_designation = new JTextField();
        btn_add = new JButton("Add User");
        btn_reset = new JButton("Reset");
        setSize(500, 800);
        setTitle("Add User");
        GridLayout gl = new GridLayout(9, 2, 50, 50);
        setLayout(gl);
        add(lbl_first_name);
        add(txt_first_name);
        add(lbl_middle_name);
        add(txt_middle_name);
        add(lbl_last_name);
        add(txt_last_name);
        add(lbl_gender);
        add(cmb_gender);
        add(lbl_join_date);
        add(txt_join_date);
        add(lbl_dob);
        add(txt_dob);
        add(lbl_department);
        add(cmb_department);
        add(lbl_designation);
        add(txt_designation);
        add(btn_add);
        add(btn_reset);
        setMaximizable(true);
        setClosable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
