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
    
    
    
    File file = new File("C:\\Users\\adria_000\\Desktop\\Super Mario 64 - Medley.midi");
    
    File dir = new File("C:\\Users");

    public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException, Exception {
        //VirtualPiano piano = new VirtualPiano();
        //piano.setVisible(true);
        
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filepath:");
        //String filepath = scanner.nextLine();
        //File file = new File(filepath);
        
        File slowMidi = new File("C:\\Users\\adria_000\\Desktop\\easynslo.midi");
        File arhhh = new File("C:\\Users\\adria_000\\Desktop\\MIDI files\\Hes A Pirate (Easy Version).mid");
        File fileScuffed = new File("C:\\Users\\adria_000\\Desktop\\projects\\Pokémon Essentials original\\Audio\\BGM\\Battle Gym Leader.mid");
        File mac = new File("/Users/adriannesvik/Downloads/Pokemon - Oracion.mid");
        
        midiSequencer newSequenceAndSequencer = new midiSequencer();
        MidiController sendRec = new MidiController();
        
        Sequence newSequence = newSequenceAndSequencer.createSequence(arhhh);
        Sequencer newSequencer = newSequenceAndSequencer.createSequencer(newSequence);
        
        newSequencer.getSequence();
        
        Sequence dsa = MidiSystem.getSequence(arhhh);
        Sequencer asd = MidiSystem.getSequencer();
        asd.setSequence(dsa);
        //sendRec.insertAndSendReceiver(newSequencer, receiver);
        
        // Obtains the default Sequencer connected to a default device.
        
        System.out.println("Microseconds: " + newSequence.getMicrosecondLength()); //2.7 minutes
        System.out.println("PPQ: " + newSequence.getResolution());
        System.out.println("Tick length: " + newSequence.getTickLength());
        
        //piano.displayNote();
        
        // Opens the device, indicating that it should now acquire any
        // system resources it requires and become operational.
        //newSequencer.open();
        
        sendRec.addNotesToTrack(newSequence);
        //sendRec.d(dsa);
        // create a stream from a file
        /*InputStream is = new BufferedInputStream(new FileInputStream(mac));
 
        // Sets the current sequence on which the sequencer operates.
        // The stream must point to MIDI file data.
        newSequencer.setSequence(is);
 ControllerEventListener controllerEventListener = new ControllerEventListener() {
   public void controlChange(ShortMessage event) {
      // TODO convert the event into a readable/desired output
      System.out.println(event);
      System.out.println("Fs");
   }
};
        newSequencer.addMetaEventListener(new MetaEventListener() {
            public void meta(MetaMessage event) {
                byte[] data = event.getData();
                        int tempo = (data[0] & 0xff) << 16 | (data[1] & 0xff) << 8 | (data[2] & 0xff);
int bpm = 60000000 / tempo;
System.out.println(bpm + " " + tempo);
                if (event.getType() == 88) {
                    System.out.println("Sequencer started playing");
                }
                else if (event.getType() == 47) {
                    System.out.println("Sequencer finished playing");
                }
            }
        });
        int[] controllersOfInterest = { 1, 2, 4 };
        newSequencer.addControllerEventListener(controllerEventListener, controllersOfInterest);
        // Starts playback of the MIDI data in the currently loaded sequence.
        newSequencer.start();
 */
    }
    
}