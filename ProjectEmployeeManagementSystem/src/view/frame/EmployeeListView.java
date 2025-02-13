package view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class EmployeeListView extends JInternalFrame{
    public EmployeeListView(){
        // for dummy data
        String columns[] = {"ID", "Full Name", "Email", "Contact"};
        Object data[][] = {
            {"1", "Hari Prasad Guragain", "hpg@gmail.com", "987454"},
            {"2", "Sita Thapa", "sita@gmail.com", "89745124"},
            {"3", "Himal Khatri", "himalk@gmail.com", "8742278"},
            {"4", "Pramesh Rai", "prameshr@gmail.com", "9745414"},
            {"5", "Neha Bajracharya", "nehabch@gmail.com", "874214"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        // creating JTable object
        JTable user_list = new JTable(model);
        // to make table scrollable
        JScrollPane scroll_bar = new JScrollPane(user_list);
        add(scroll_bar);
        setMaximizable(true);
        setClosable(true);
        setSize(500, 400);
        setTitle("Add User");
    }
}
