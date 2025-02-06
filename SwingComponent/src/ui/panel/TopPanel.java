package ui.panel;

import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
    JMenuBar jmb;
    JMenu user, setting;
    public JMenuItem user_list, user_add, profile, logout;
    public TopPanel(){
        jmb = new JMenuBar();
        user = new JMenu("Users", true);
        setting = new JMenu("Settings", true);
        
        user_list = new JMenuItem("Show User");
        user_add = new JMenuItem("Add User");
        profile = new JMenuItem("Profile");
        logout = new JMenuItem("Logout");
        
        user.add(user_list, 0);
        user.add(user_add, 1);
        setting.add(profile, 0);
        setting.add(logout, 1);
        
        jmb.add(user);
        jmb.add(setting);
        add(jmb, new BorderLayout().NORTH);
    }
}
