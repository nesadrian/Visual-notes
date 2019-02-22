/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author adria_000
 */
public class midiSequencer {
        
    checkSequenceValidity checkFile = new checkSequenceValidity();
    
    public Sequence createSequence(File file) throws InvalidMidiDataException, IOException {
        checkSequenceValidity.checkFile(file);
        Sequence sequence = MidiSystem.getSequence(file);
        return sequence;
    }
    
    public Sequencer createSequencer(Sequence sequence) throws MidiUnavailableException, InvalidMidiDataException {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setSequence(sequence);
        return sequencer;
    }
    
    public void playSequence (Sequencer sequencer) throws MidiUnavailableException {
        sequencer.open();
        sequencer.start();
    }
}
