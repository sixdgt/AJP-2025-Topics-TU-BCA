package example;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RandomNumberChecker extends JFrame implements MouseListener{
    JButton b1, b2, b3, b4, b5, b6, check;
   public RandomNumberChecker(){
       b1 = new JButton("1");
       b2 = new JButton("2");
       b3 = new JButton("3");
       b4 = new JButton("4");
       b5 = new JButton("5");
       b6 = new JButton("6");
       check = new JButton("CHECK");
       
       add(b1);
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       add(check);
       this.setButtonDefaultColor();
       
       check.addMouseListener(this);
       
       setLayout(new GridLayout(3, 3, 20, 20));
       setSize(400, 400);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   }
   
    public static void main(String[] args) {
        new RandomNumberChecker();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setButtonDefaultColor(); // value default
        Random random = new Random();
        int randomNum = random.nextInt(1, 7); // random int
        System.out.println(randomNum);
        this.setButtonColor(randomNum + ""); // setting color
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void setButtonDefaultColor(){
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
       
        check.setBackground(Color.black);
        check.setForeground(Color.white);
    }
    
    public void setButtonColor(String randomNum){
        if(randomNum.equals("1")){
            this.b1.setBackground(Color.green);
            this.b1.setForeground(Color.white);
        } else if(randomNum.equals("2")){
            this.b2.setBackground(Color.green);
            this.b2.setForeground(Color.white);
        }else if(randomNum.equals("3")){
            this.b3.setBackground(Color.green);
            this.b3.setForeground(Color.white);
        }else if(randomNum.equals("4")){
            this.b4.setBackground(Color.green);
            this.b4.setForeground(Color.white);
        }else if(randomNum.equals("5")){
            this.b5.setBackground(Color.green);
            this.b5.setForeground(Color.white);
        }else if(randomNum.equals("6")){
            this.b6.setBackground(Color.green);
            this.b6.setForeground(Color.white);
        } 
    }
}
