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
import javax.sound.midi.Sequence;

/**
 *
 * @author adria_000
 */
public class checkSequenceValidity {
    
    public static Sequence createNewSequence (File file) throws InvalidMidiDataException, IOException {
        checkFile(file);
        Sequence seq = MidiSystem.getSequence(file);
        checkSequenceType(seq);
        return seq;
    }
    
    public static File checkFile(File file) {
        if (file.isDirectory()) {
            System.out.println("You have selected a directory. Try again.");
            return null;
        }
        else if (file == null) {
            System.out.println("The file you have selected are not valid or does not exist");
            return null;
        }
        return file;
    }
    
    public static void checkSequenceType(Sequence seq) {
        if (seq.getDivisionType() != Sequence.PPQ) {
            throw new UnsupportedOperationException("SMPTE not supported. Try new file");
        }
    }
} 
