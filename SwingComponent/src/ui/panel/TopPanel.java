package ui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
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
        // to fetch image from source
        ImageIcon add_icon = new ImageIcon(TopPanel.class.getResource("/icons/add-user.png"));
        ImageIcon show_icon = new ImageIcon(TopPanel.class.getResource("/icons/group.png"));
        ImageIcon signout_icon = new ImageIcon(TopPanel.class.getResource("/icons/logout.png"));
        ImageIcon user_icon = new ImageIcon(TopPanel.class.getResource("/icons/user.png"));
        // to resize image
        Image resize_add = add_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image resize_show = show_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image resize_signout = signout_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image resize_user = user_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        user_list = new JMenuItem("Show User", new ImageIcon(resize_show));
        user_add = new JMenuItem("Add User", new ImageIcon(resize_add)); // adding image icon
        profile = new JMenuItem("Profile", new ImageIcon(resize_user));
        logout = new JMenuItem("Logout", new ImageIcon(resize_signout));
        
        user.add(user_list, 0);
        user.add(user_add, 1);
        setting.add(profile, 0);
        setting.add(logout, 1);
        
        jmb.add(user);
        jmb.add(setting);
        add(jmb, new BorderLayout().NORTH);
    }
}
