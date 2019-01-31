/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftosynthesia;

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
public class initiateProgram {
    
    File fileScuffed = new File("C:\\Users\\adria_000\\Desktop\\projects\\Pokémon Essentials original\\Audio\\BGM\\Battle Gym Leader.mid");
    File file = new File("C:\\Users\\adria_000\\Desktop\\Super Mario 64 - Medley.midi");

    public void start() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        createSequenceAndSequencer newSequenceAndSequencer = new createSequenceAndSequencer();
        Sequence newSequence = newSequenceAndSequencer.createSequence(file);
        Sequencer newSequencer = newSequenceAndSequencer.createSequencer(newSequence);
        newSequenceAndSequencer.playSequence(newSequencer);
    }
}
