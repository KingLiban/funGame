package main;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    public GamePanel(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillArc(30,40,50,60,30, 40);
    }
}
