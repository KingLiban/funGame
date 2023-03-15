    package main;
    import Inputs.KeyboardInputs;
    import Inputs.MouseInputs;

    import java.awt.*;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.util.Random;
    import javax.swing.JPanel;

    public class GamePanel extends JPanel{
        MouseInputs mouseInputs = new MouseInputs(this);
        KeyboardInputs keyboardInputs = new KeyboardInputs(this);
        private float xDelta = 100;
        private float yDelta = 100;
        private float xDir = 0.03f;
        private float yDir = 0.03f;
        private int frames = 0;
        private long lastCheck = 0;
        private Color color = new Color(100, 25, 40);
        private Random random;
        public GamePanel(){
            setFocusable(true);
            requestFocus(true);
            random = new Random();
            addKeyListener(keyboardInputs);
            addMouseListener(mouseInputs);
            addMouseMotionListener(mouseInputs);

        }

        public void changeXDelta(int value) {
            this.xDelta += value;
        }

        public void changeYDelta(int value) {
            this.yDelta += value;
        }

        public void newRecPos(int x, int y){
            this.xDelta = x;
            this.yDelta = y;
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            updateRectangle();
            g.setColor(color);
            g.fillRect((int) xDelta, (int) yDelta,50,60);
            repaint();
            frames++;
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        private void updateRectangle() {
            xDelta+=xDir;
            if(xDelta > 400 || xDelta < 0){
                xDir*=-1;
                color = getRndColor();
            }
            yDelta+=yDir;
            if(yDelta > 400 || yDelta < 0){
                yDir*=-1;
                color = getRndColor();
            }

        }

        private Color getRndColor() {
            int r = random.nextInt(255);
            int g = random.nextInt(255);;
            int b = random.nextInt(255);;
            return new Color(r, g, b);
        }
    }
