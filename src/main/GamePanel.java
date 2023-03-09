    package main;
    import Inputs.KeyboardInputs;

    import java.awt.Graphics;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import javax.swing.JPanel;

    public class GamePanel extends JPanel{
        public GamePanel(){
            addKeyListener(new KeyboardInputs());

        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.fillArc(300,40,50,60,30, 40);
        }
    }
