    package main;
    import Inputs.KeyboardInputs;
    import Inputs.MouseInputs;

    import java.awt.Graphics;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import javax.swing.JPanel;

    public class GamePanel extends JPanel{
        MouseInputs mouseInputs = new MouseInputs(this);
        KeyboardInputs keyboardInputs = new KeyboardInputs(this);
        private int xDelta = 100;
        private int yDelta = 100;
        public GamePanel(){
            setFocusable(true);
            requestFocus(true);
            addKeyListener(keyboardInputs);
            addMouseListener(mouseInputs);
            addMouseMotionListener(mouseInputs);

        }

        public void changeXDelta(int value) {
            this.xDelta += value;
            repaint();
        }

        public void changeYDelta(int value) {
            this.yDelta += value;
            repaint();
        }

        public void newRecPos(int x, int y){
            this.xDelta = x;
            this.yDelta = y;
            repaint();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.fillRect(xDelta, yDelta,50,60);
        }
    }
