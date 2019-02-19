package newpackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
/**
 *
 * @author adria_000
 */


    /**
     * @param args the command line arguments
     */
public class PianoGraphics extends JPanel implements ActionListener{ 
    
    Timer tm = new Timer(10, this);
    Color color;
    int width;
    int height = 10;
    
    public void setTimer(int time) {
        tm = new Timer(time, this);
    }
    
    public void init(boolean isWhiteKey) {
        if (isWhiteKey) {
            width = 25;
            color = new Color(255, 191, 0);
        }
        else if (!isWhiteKey) {
            width = 15;
            color = new Color(239, 130, 13);
        }
        tm.start();
    }
    
    int x = 0, velX = 0; int y = -height, velY = 1; 
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, width, height);
    } 
    
    public void actionPerformed(ActionEvent e){
        if(x < 0) velX = -velX; 
        if(y == 640 + height) {
            System.out.println("Reached end");
        }
    y = y + velY;
    repaint(); 
    } 
}