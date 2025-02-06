package ui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel{
    public BottomPanel(){
        JLabel copyright = new JLabel();
        copyright.setText("Copyright @DAV College | 2025");
        add(copyright);
    }
}
