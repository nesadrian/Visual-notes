/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

/**
 *
 * @author adria_000
 */
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.MIDI_TIME_CODE;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import static javax.sound.midi.ShortMessage.START;
import static javax.sound.midi.ShortMessage.STOP;
import static javax.sound.midi.ShortMessage.TIMING_CLOCK;

public class CustomReceiver implements Receiver {
    
    VirtualPiano piano;

    public CustomReceiver() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        this.piano = new VirtualPiano();
        piano.setVisible(true);
    }
    
    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage) {
           
           long i = message.getStatus();
           long y = message.getLength();
           int t = START;
           int e = STOP;
            int time2 = TIMING_CLOCK;
            int time = MIDI_TIME_CODE;
            
            piano.keyDisplayNote(message);
            //System.out.println(time + " " + time2);
            //System.out.println(timeStamp);
        }
    }

    @Override
    public void close() {

    }
}
