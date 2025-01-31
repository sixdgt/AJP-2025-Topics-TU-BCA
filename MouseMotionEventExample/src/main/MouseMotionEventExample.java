package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MouseMotionEventExample extends JFrame implements MouseMotionListener{
    JLabel content;
    public MouseMotionEventExample(){
        setTitle("Mouse Motion Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setBackground(Color.GRAY);
        
        content = new JLabel("Move or Drag the mouse inside the Frame");
        content.setHorizontalAlignment(SwingConstants.CENTER);
        content.addMouseMotionListener(this);
        add(content);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        content.setText("Mouse Dragged at Position, X: " + e.getX() +
                " Y: " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        content.setText("I am moved. My position X: " + e.getX() + 
                " Y: " + e.getY());
        if(e.getX() <= 200 && e.getY() <= 200){
            JOptionPane.showMessageDialog(rootPane, "Opps! you found me");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseMotionEventExample::new);
    }
}
