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
    public List<VisualPianoNote> playingNoteList = new ArrayList();
    Timer tm = new Timer(1, this);
    int height = 10;
    int i = 0;
    int tick = 0;
    
    
    
    public void setTimer(int time) {
        tm = new Timer(time, this);
    }
    
    public PianoGraphics() {
        tm.start();
    }
    
    public void addNote (VisualPianoNote vpn) {
        noteList.add(vpn);
    }

   /* public void init(long tempo, boolean isWhiteKey) {
        VisualPianoNote note = new VisualPianoNote(tempo, height, isWhiteKey);
        
    }*/
    
    public void addToPlayingNoteList() {
        playingNoteList.add(noteList.get(i));
        i++;
    }
    
    public void updateTick() {
        tick = tick+192;
        System.out.println(tick);
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (VisualPianoNote note : playingNoteList) {
            if (note.getYpos() < (635 + note.getHeight())) {
                note.drawNote(g);
            }
            //Add else statement that safely removes object from list
        }
    } 
    
    public void actionPerformed(ActionEvent e){
        for (VisualPianoNote note : playingNoteList) {
            note.animate();
        }
        updateTick();
        repaint();
    } 
}