/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author adria_000
 */
public class PianoPlayer {
    
    int counter = 0;
    PianoGUI piano;
    public static final int SET_TEMPO = 0x51;
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final int OTHER = -1;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    

    public PianoPlayer() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        this.piano = new PianoGUI();
        piano.setVisible(true);
        piano.setSize(1325, 815);
    }
    public void startSequencer(Sequence seq) throws Exception {
        PianoFallingNotesConstruct pfnc = new PianoFallingNotesConstruct(seq, piano);
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setSequence(pfnc.getSequence());
        sequencer.open();
        sequencer.addMetaEventListener(mel);
        sequencer.start();
    }
     
    MetaEventListener mel = new MetaEventListener() {

        @Override
        public void meta(MetaMessage meta) {
        final int command = meta.getType();
        byte type = meta.getData()[1];
        int key = (int) (type & 0xFF);
        int octave = ((key / 12)-1);
        int note = (key % 12);
        String noteName = NOTE_NAMES[note];
            if (command == 1) {
                //int velocity = sm.getData2();

                //System.out.println("ON , " + noteName + octave + " key=" + key);
                keyDisplayNote(key, noteName, 1);
                //piano.setTempo(ticksList.get(counter));
                counter++;
            } 
            else if (command == 2) {
                //int velocity = meta.getData2();
                //System.out.println("OFF, " + noteName + octave + " key=" + key);
                keyDisplayNote(key, noteName, 2);
            }
            else if (command == SET_TEMPO) {
                //setTempo(meta);
            }
        }
    };

    public void keyDisplayNote (int key, String note, int noteState) {
        
        //System.out.println("Note state " + noteState);
        if (noteState == 1) {
                //System.out.println("Note on " + i);
            if (key < 87) {
                try {
                    //System.out.println("ONBOIIIIIIIIIIIIIIIIIII");
                    piano.colorKey(key, true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            else if (key > 87) {
                System.out.println("S");
            }
        }
            else if (noteState == 2) {
                
                //int velocity = sm.getData2();
                //System.out.println("Note off " + o);
                if (key < 87) {
                    try {
                        piano.colorKey(key, false);
                        //System.out.println("OFF");
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else if (key > 87) {
                    System.out.println("S");
                }
            } 
            else {
                //System.out.println("Command:" + sm.getCommand());
            }
    }
    
}

