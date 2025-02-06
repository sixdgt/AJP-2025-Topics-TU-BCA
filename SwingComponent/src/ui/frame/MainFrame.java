package ui.frame;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.panel.BottomPanel;
import ui.panel.MainPanel;
import ui.panel.TopPanel;

public class MainFrame extends JFrame{
    MainPanel mp;
    BorderLayout bl;
    TopPanel tp;
    BottomPanel bp;
    public MainFrame(){
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Dashboard");
        bl = new BorderLayout();
        setLayout(bl);
        // adding main panel
        tp = new TopPanel();
        mp = new MainPanel();
        bp = new BottomPanel();
        add(tp, bl.NORTH); // tp is a JPanel
        add(mp, bl.CENTER); // mp is a JDesktopPane
        add(bp, bl.SOUTH); // bp is a JPanel
        /** here 'tp' is a TopPanel's object
        * it can access to all public attributes of TopPanel
        * so here we are accessing public JMenuItem 'user_add'
        */
        tp.user_add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                AddUser au = new AddUser(); // is a JInternalFrame
                au.setVisible(true);
                mp.add(au);
            }
        });
        setVisible(true);
    }
}
