/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.io.IOException;
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


/**
 *
 * @author adria_000
 */
public class MidiController {
    
    public static final int SET_TEMPO = 0x51;
    
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private static int MIDI_SET_TEMPO;

    public void insertAndSendReceiver (Sequencer sequencer, Receiver receiver) 
    throws InvalidMidiDataException, IOException, MidiUnavailableException {
        sequencer.open();
        Transmitter transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(receiver);
        sequencer.start();
        
    }  
    
     public final void addNotesToTrack(Sequence seq) throws InvalidMidiDataException, Exception {
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
        //d(seq);
        listenmate(sequencer);
    }

    public static long getTempo (MetaMessage mm) {
        byte[] data = mm.getData();
        long tempo = (data[0] & 0xff) << 16 | (data[1] & 0xff) << 8 | (data[2] & 0xff);
        long bpm = 60000000L / tempo;
        System.out.println("BPM: " + bpm);
	return bpm;	
    }

    public void listenmate(Sequencer sq) throws MidiUnavailableException {
        sq.open();
        
        ControllerEventListener cel = new ControllerEventListener() {
        @Override
        public void controlChange(ShortMessage sm) {
            System.out.println(sm.getCommand() + " dsadsadsa");
            if (sm.getCommand() == NOTE_ON) {
                        /*int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("NIBBANote on, " + noteName + octave + " key=" + key + " velocity: " + velocity);*/
                        System.out.println("dsa");
                    } 
                    else if (sm.getCommand() == NOTE_OFF) {
                        /*int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("BBBBBBNote off, " + noteName + octave + " key=" + key + " velocity: " + velocity);*/
                        System.out.println("dsa");
                    }
        }
    };
        MetaEventListener mel = new MetaEventListener() {

            @Override
            public void meta(MetaMessage meta) {
                final int command = meta.getType();
                byte type = meta.getData()[1];
                int key = (int) (command & 0xFF);
                if (command == NOTE_ON) {
                        
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        //int velocity = sm.getData2();
                        System.out.println("NIBBANote on, " + noteName + octave + " key=" + key);
                    } 
                    else if (command == NOTE_OFF) {
                        
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        //int velocity = meta.getData2();
                        System.out.println("BBBBBBNote off, " + noteName + octave + " key=" + key);
                    }
        }
            
        };
        //sq.addMetaEventListener(mel);
        int[] types = new int[128];
        for (int ii = 0; ii < 128; ii++) {
            types[ii] = ii;
        }
        
        sq.addControllerEventListener(cel, types);
        
        sq.start();
    }
            
    
    public static void d(Sequence sequence) throws Exception {
        int q = 0;
        int p = 0;
        long speed = 0;
        double playbackSeconds;
        int trackNumber = 0;
        int ppq = sequence.getResolution();
        
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());
            System.out.println();
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                long eventTick = event.getTick();
                System.out.print("@" + eventTick + " ");
                
                MidiMessage message = event.getMessage();
                /*if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    System.out.print("Channel: " + sm.getChannel() + " ");
                    if (sm.getCommand() == NOTE_ON) {
                        q++;
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity + "num on: " + q);
                    } 
                    else if (sm.getCommand() == NOTE_OFF) {
                        p++;
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity+ "num off: " + p);
                    }
                    
                    else {
                        //System.out.println("Command:" + sm.getCommand());
                    }*/
                 if (message instanceof MetaMessage) {
                     
                    MetaMessage metaMessage = (MetaMessage) message;
                    final int command = metaMessage.getType();
                int key = (int) (command & 0xFF);
                    //System.out.println(metaMessage.getType());
                    //if(metaMessage.getType() == SET_TEMPO) {
                        //System.out.println(getTempo(metaMessage) + " " + eventTick);
                        //playbackSeconds = (60000L / (getTempo(metaMessage) * eventTick));
                        speed = getTempo(metaMessage);
                        if (metaMessage.getType() == NOTE_ON) {
                        
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        //int velocity = sm.getData2();
                        System.out.println("NIBBANote on, " + noteName + octave + " key=" + key);
                    } 
                    else if (metaMessage.getType() == NOTE_OFF) {
                        
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        //int velocity = meta.getData2();
                        System.out.println("BBBBBBNote off, " + noteName + octave + " key=" + key);
                    //}
                    }
                    else {
                    //System.out.println("Other message: " + message.getClass());
                }
                }
                
                }
                
                try {
                    playbackSeconds = (60000L / (speed * ppq));
                    System.out.println("Playback seconds: " + playbackSeconds);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                //System.out.println("---------" + speed + " ----- " + eventTick);
            }
        }
    }

