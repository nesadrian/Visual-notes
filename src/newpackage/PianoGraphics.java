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
public class PianoGraphics extends JPanel { 
    
    public List<VisualPianoNote> noteList = new ArrayList();
    
    public void addNoteToList (VisualPianoNote vpn) {
        super.add(vpn);
        
    }

    
   /* public void init(long tempo, boolean isWhiteKey) {
        VisualPianoNote note = new VisualPianoNote(tempo, height, isWhiteKey);
        
    }*/
    
    

}