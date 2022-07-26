
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

@SuppressWarnings("serial")
public class Panel extends JPanel {
    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 400;
    public static final int SQUARE_SIZE = 50;
    public static final int SINGLE_STEP = 10;
    public static final int MEGA_STEP = 20;
    public static final Color PANEL_COLOR = Color.WHITE;

    public static BufferedImage image;

    private int xPos = 0;
    private int yPos = 0;

    public Panel() {
        super();

        try{
            image = ImageIO.read(new File("src/11.png"));
        }
        catch(Exception e){}

        this.setBackground(PANEL_COLOR);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                switch ( ke.getKeyCode() ) {
                    case KeyEvent.VK_W :
                    case KeyEvent.VK_UP :
                        yPos -= ( ke.isShiftDown() ) ? MEGA_STEP : SINGLE_STEP;
                        if ( yPos < 0 )
                            yPos = 0;
                        repaint();
                        break;
                    case KeyEvent.VK_A :
                    case KeyEvent.VK_LEFT :
                        xPos -= ( ke.isShiftDown() ) ? MEGA_STEP : SINGLE_STEP;
                        if ( xPos < 0 )
                            xPos = 0;
                        repaint();
                        break;
                    case KeyEvent.VK_S :
                    case KeyEvent.VK_DOWN :
                        yPos += ( ke.isShiftDown() ) ? MEGA_STEP : SINGLE_STEP;
                        if ( ( yPos + SQUARE_SIZE ) > PANEL_HEIGHT )
                          //  yPos = PANEL_HEIGHT - SQUARE_SIZE;
                            yPos = 0;
                        repaint();
                        break;
                    case KeyEvent.VK_D :
                    case KeyEvent.VK_RIGHT :
                        xPos += ( ke.isShiftDown() ) ? MEGA_STEP : SINGLE_STEP;
                        if ( ( xPos + SQUARE_SIZE ) > PANEL_WIDTH )
                        //    xPos = PANEL_WIDTH - SQUARE_SIZE;
                            xPos = 0;
                        repaint();
                        break;
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image,xPos,yPos,this);
    }
}