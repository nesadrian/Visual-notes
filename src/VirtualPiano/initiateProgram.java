/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author adria_000
 */
public class initiateProgram  {
    
    File file = new File("C:\\Users\\adria_000\\Desktop\\Super Mario 64 - Medley.midi");
    
    File dir = new File("C:\\Users");

    public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException {
        //VirtualPiano piano = new VirtualPiano();
        //piano.setVisible(true);
        
        File slowMidi = new File("C:\\Users\\adria_000\\Desktop\\easynslo.midi");
        File arhhh = new File("C:\\Users\\adria_000\\Desktop\\Hes A Pirate (Easy Version).mid");
        File fileScuffed = new File("C:\\Users\\adria_000\\Desktop\\projects\\Pokémon Essentials original\\Audio\\BGM\\Battle Gym Leader.mid");
        
        CustomReceiver receiver = new CustomReceiver();
        midiSequencer newSequenceAndSequencer = new midiSequencer();
        MidiController sendRec = new MidiController();
        
        Sequence newSequence = newSequenceAndSequencer.createSequence(arhhh);
        Sequencer newSequencer = newSequenceAndSequencer.createSequencer(newSequence);
        
        newSequencer.getSequence();
        
        sendRec.insertAndSendReceiver(newSequencer, receiver);
    }
}