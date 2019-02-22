/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 *
 * @author adria_000
 */
public class initiateProgram  {
    
    checkSequenceValidity checkSupported;
    
    File file = new File("C:\\Users\\adria_000\\Desktop\\Super Mario 64 - Medley.midi");
    
    File dir = new File("C:\\Users");

    public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException, Exception {
        //VirtualPiano piano = new VirtualPiano();
        //piano.setVisible(true);
        
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter filepath:");
        //String filepath = scanner.nextLine();
        //File file = new File(filepath);
        
        File slowMidi = new File("C:\\Users\\adria_000\\Desktop\\easynslo.midi");
        File arhhh = new File("C:\\Users\\adria_000\\Desktop\\MIDI files\\Hes A Pirate (Easy Version).mid");
        File fileScuffed = new File("C:\\Users\\adria_000\\Desktop\\projects\\Pokémon Essentials original\\Audio\\BGM\\Battle Gym Leader.mid");
        File mac = new File("/Users/adriannesvik/Downloads/Pokemon - Oracion.mid");
        
        PianoPlayer player = new PianoPlayer();
        Sequence seq = checkSequenceValidity.createNewSequence(arhhh);
        
        System.out.println("Microseconds: " + seq.getMicrosecondLength()); //2.7 minutes
        System.out.println("PPQ: " + seq.getResolution());
        System.out.println("Tick length: " + seq.getTickLength());
        
        player.startSequencer(seq);
    }
}