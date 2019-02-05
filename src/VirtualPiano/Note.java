/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

/**
 *
 * @author adria_000
 */
public class Note {
    
    private static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private String name;
    private int key;
    private int octave;

    public int findKey (int key) {
        this.key = key;
        this.octave = (key / 12)-1;
        int note = key % 12;
        
        return this.key;
    }
}
