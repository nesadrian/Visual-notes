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
public class MidiController {
    
    VirtualPiano piano;
    public static final int SET_TEMPO = 0x51;
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final int OTHER = -1;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private static int MIDI_SET_TEMPO;
    public long tempo;
    public long ppq;
    public long bpm;
    List<Long> ticksList = new ArrayList();
    

    public MidiController() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        this.piano = new VirtualPiano();
        piano.setVisible(true);
        piano.setSize(1500, 1500);
    }

    public void insertAndSendReceiver (Sequencer sequencer, Receiver receiver) 
    throws InvalidMidiDataException, IOException, MidiUnavailableException {
        sequencer.open();
        Transmitter transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(receiver);
        sequencer.start();
        
    }  
    
     public final void addNotesToTrack(Sequence seq) throws InvalidMidiDataException, Exception {
        ppq = seq.getResolution();
        Track[] trackList = seq.getTracks();
        Track trk = seq.createTrack();
        for (Track track : trackList) {
        for (int ii = 0; ii < track.size(); ii++) {
            MidiEvent midiEvent = track.get(ii);
            MidiMessage midiMessage = midiEvent.getMessage();
            if (midiMessage instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) midiMessage;
                int command = sm.getCommand();
                int com = -1;
                if (command == ShortMessage.NOTE_ON) {
                    com = 1;
                } else if (command == ShortMessage.NOTE_OFF) {
                    com = 2;
                }
                if (com > 0) {
                    byte[] b = sm.getMessage();
                    int l = (b == null ? 0 : b.length);
                    MetaMessage metaMessage = new MetaMessage(com, b, l);
                    MidiEvent me2 = new MidiEvent(metaMessage, midiEvent.getTick());
                    trk.add(me2);
                }
            }
        }
        
        }

        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setSequence(seq);
        listenmate(sequencer);
    }

    public void setTempo (MetaMessage mm) {
        byte[] data = mm.getData();
        tempo = (data[0] & 0xff) << 16 | (data[1] & 0xff) << 8 | (data[2] & 0xff);
        bpm = 60000000L / tempo;
        System.out.println("BPM: " + bpm);
        System.out.println("Tempo: " + tempo);
    }
    
    public void addMicrosecondsToList (long eventTick) {
        if (tempo == 0) {
            System.out.println("Tempo not initiated");
        }
        if (ppq == 0) {
            System.out.println("PPQ not initiated");
        }
        long microseconds = tempo * eventTick / ppq;
        System.out.println("Seconds: " + microseconds);
    }
    
    public static int getMQP (MetaMessage mm) {
        byte[] data = mm.getData();
        int mpq = ((data[0] & 0x7f) << 14) | ((data[1] & 0x7f) << 7) | (data[2] & 0x7f);
        return mpq;
    }

    public void listenmate(Sequencer sq) throws MidiUnavailableException {
        
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
                        System.out.println("ON , " + noteName + octave + " key=" + key);
                        keyDisplayNote(key, noteName, 1);
                    } 
                    else if (command == 2) {
                        //int velocity = meta.getData2();
                        System.out.println("OFF, " + noteName + octave + " key=" + key);
                        keyDisplayNote(key, noteName, 2);
                    }
                    else if (command == SET_TEMPO) {
                        setTempo(meta);
                    }
            }   
        };
        sq.open();
        sq.addMetaEventListener(mel);
        sq.start();
    }
            
    
    public void d(Sequence sequence) throws Exception {
        int trackNumber = 0;
        long lastEventTick = 0;
        ppq = sequence.getResolution();
        
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());
            System.out.println();
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                long eventTick = event.getTick();
                long realEventTick = eventTick - lastEventTick;
                lastEventTick = eventTick;
                //System.out.print("@" + eventTick + "   ");
                
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    if (sm.getCommand() == NOTE_ON) {
                        ticksList.add(eventTick);
                        addMicrosecondsToList (realEventTick);
                    } 
                }
                if (message instanceof MetaMessage) {
                    MetaMessage mm = (MetaMessage) message;
                    if (mm.getType() == 1) {
                        ticksList.add(eventTick);
                    } 
                    else if (mm.getType() == SET_TEMPO) {
                        setTempo(mm);
                        
                    }
                }
                
                try {
                    //playbackSeconds = (60000L / (bpm * ppq));
                    //System.out.println("Playback seconds: " + playbackSeconds);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        int b=0;
        /*for(long i : ticksList) {
            b++;
            System.out.println("ape" + i + "   " +b);
        }*/
    }
    
    
    
    public void keyDisplayNote (int key, String note, int noteState) {
        
        System.out.println("Note state " + noteState);
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

