package view.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
    JMenuBar jmb;
    JMenu employee, setting;
    public JMenuItem employee_list, employee_add, profile, logout;
    public TopPanel(){
        jmb = new JMenuBar();
        employee = new JMenu("Employee", true);
        setting = new JMenu("Settings", true);
        employee_list = new JMenuItem("Show Employee", new ImageIcon(loadImage("/icons/group.png", 20, 20)));
        employee_add = new JMenuItem("Add Employee", new ImageIcon(loadImage("/icons/add-user.png", 20, 20))); // adding image icon
        profile = new JMenuItem("Profile", new ImageIcon(loadImage("/icons/user.png", 20, 20)));
        logout = new JMenuItem("Logout", new ImageIcon(loadImage("/icons/logout.png", 20, 20)));
        
        employee.add(employee_list, 0);
        employee.add(employee_add, 1);
        setting.add(profile, 0);
        setting.add(logout, 1);
        
        jmb.add(employee);
        jmb.add(setting);
        add(jmb, new BorderLayout().NORTH);
    }
    // to load the image from specified url
    public final Image loadImage(String url, int width, int height){
        Image img = null;
        try {
            ImageIcon icon = new ImageIcon(TopPanel.class.getResource(url));
            img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("No image found");
        }
        return img;
    }
}
