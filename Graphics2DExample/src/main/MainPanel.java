package main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        // drawing reactangle
        g2.fillRect(50, 50, 400, 100);
        g2.setColor(Color.red);
        
        g2.fillOval(50, 150, 250, 150);
        g2.setColor(Color.green);
        
        g2.drawLine(50, 380, 400, 20);
        g2.setColor(Color.black);
        
        // to set gradient color in shape
        GradientPaint gp = new GradientPaint(80, 600, Color.cyan, 
                108, 100, Color.magenta);
        
        g2.setPaint(gp);
        g2.fillOval(50, 400, 400, 250);
    }
}
