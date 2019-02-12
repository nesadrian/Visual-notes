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
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;


/**
 *
 * @author adria_000
 */
public class MidiController {
    
    public static final int SET_TEMPO = 0x51;
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private static int MIDI_SET_TEMPO;

    public void insertAndSendReceiver (Sequencer sequencer, Receiver receiver) 
    throws InvalidMidiDataException, IOException, MidiUnavailableException {
        sequencer.open();
        Transmitter transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(receiver);
        sequencer.start();
        
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
            if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("NIBBANote on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } 
                    else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("BBBBBBNote off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    }
        }
    };
        MetaEventListener mel = new MetaEventListener() {

            @Override
            public void meta(MetaMessage meta) {
                final int type = meta.getType();
                System.out.println("MEL - type: " + type);
            }
        };
        sq.addMetaEventListener(mel);
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
                if (message instanceof ShortMessage) {
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
                    }
                }
                else if (message instanceof MetaMessage) {
                    MetaMessage metaMessage = (MetaMessage) message;
                    System.out.println(metaMessage.getType());
                    if(metaMessage.getType() == SET_TEMPO) {
                        //System.out.println(getTempo(metaMessage) + " " + eventTick);
                        //playbackSeconds = (60000L / (getTempo(metaMessage) * eventTick));
                        speed = getTempo(metaMessage);
                        
                    }
                }
                else {
                    //System.out.println("Other message: " + message.getClass());
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
}
