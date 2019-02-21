package newpackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adria_000
 */


    /**
     * @param args the command line arguments
     */
public class PianoGraphics extends JPanel implements ActionListener { 
    
    public List<VisualPianoNote> noteList = new ArrayList();
    Timer tm = new Timer(0, this);
    int height = 10;
    
    public void setTimer(int time) {
        tm = new Timer(time, this);
    }
    
    public PianoGraphics() {
        tm.start();
    }

    public void init(long tempo, boolean isWhiteKey) {
        VisualPianoNote note = new VisualPianoNote(tempo, height, isWhiteKey);
        noteList.add(note);
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (VisualPianoNote note : noteList) {
            if (note.getYpos() < (635 + note.getHeight())) {
                note.drawNote(g);
            }
            //Add else statement that safely removes object from list
        }
    } 
    
    public void actionPerformed(ActionEvent e){
        for (VisualPianoNote note : noteList) {
            note.animate();
        }
        repaint();
    } 
}