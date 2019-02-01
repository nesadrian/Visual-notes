/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftosynthesia;

/**
 *
 * @author adria_000
 */
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;

public class CustomReceiver implements Receiver {
    
    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage) {
            
            ShortMessage sm = (ShortMessage) message;
            
            int channel = sm.getChannel();
            System.out.println(channel);
            
            if (sm.getCommand() == NOTE_ON) {
                int key = sm.getData1();
                int velocity = sm.getData2();
                Note note = new Note(key);
                System.out.println(note + " Velocity: " + velocity);
            } 
            else if (sm.getCommand() == NOTE_OFF) {
                int key = sm.getData1();
                int velocity = sm.getData2();
                Note note = new Note(key);
                System.out.println(note + " " + velocity);
            } 
            else {
                System.out.println("Command:" + sm.getCommand());
            }
        }
    }

    @Override
    public void close() {

    }
}

