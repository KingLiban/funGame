    package main;
    import Inputs.KeyboardInputs;
    import Inputs.MouseInputs;

    import java.awt.*;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.Random;
    import javax.imageio.ImageIO;
    import javax.swing.JPanel;

    public class GamePanel extends JPanel{
        MouseInputs mouseInputs = new MouseInputs(this);
        KeyboardInputs keyboardInputs = new KeyboardInputs(this);
        private BufferedImage image, subImage;

        private float xDelta = 100;
        private float yDelta = 100;
        private float xDir = 0.03f;
        private float yDir = 0.03f;
        private int frames = 0;
        private long lastCheck = 0;

        public GamePanel(){
            setFocusable(true);
            requestFocus(true);
            importImg();
            setPanelSize();
            addKeyListener(keyboardInputs);
            addMouseListener(mouseInputs);
            addMouseMotionListener(mouseInputs);

        }

        private void importImg() {
            InputStream is = getClass().getResourceAsStream("/SpriteZoro.png");
            if (is == null) {
                System.err.println("Could not find or open image file.");
                return;
            }
            try {
                image = ImageIO.read(is);
            } catch (IOException e){
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.err.println("Input stream is null.");
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void setPanelSize() {
            Dimension size = new Dimension(1280, 800);
            setMinimumSize(size);
            setPreferredSize(size);
            setMaximumSize(size);
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
            subImage = image.getSubimage(1*64, 8*40, 64, 40);
            g.drawImage(subImage, 0 , 0, 128, 80, null);
            Toolkit.getDefaultToolkit().sync();
        }
        
    }
