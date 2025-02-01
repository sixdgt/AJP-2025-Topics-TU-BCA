package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Graphics2DExample extends JFrame{
    MainPanel mp;
    public Graphics2DExample(){
        setTitle("Grpahics2d Example");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mp = new MainPanel();
        add(mp);
//        pack(); // will set JPanel width & height same as JFrame
        setVisible(true);
    }
    
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(Graphics2DExample::new);
        new Graphics2DExample();
    }
}
