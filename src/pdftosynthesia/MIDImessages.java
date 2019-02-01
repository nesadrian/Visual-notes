/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftosynthesia;

import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;


/**
 *
 * @author adria_000
 */
public class MIDImessages {
    
    Receiver receiver = new CustomReceiver();
    Transmitter transmitter;
    
    public void newReceiver (Sequencer sequencer) 
    throws InvalidMidiDataException, IOException, MidiUnavailableException {
        sequencer.open();
        transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(receiver);
        sequencer.start();
    }
    
    
}
