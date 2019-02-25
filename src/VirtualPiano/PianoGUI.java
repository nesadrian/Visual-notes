/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;
import static VirtualPiano.PianoFallingNotesConstruct.safeLongToInt;
import static VirtualPiano.PianoPlayer.NOTE_NAMES;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import newpackage.PianoGraphics;
import newpackage.VisualPianoNote;

/**
 *
 * @author adria_000
 */
public class PianoGUI extends javax.swing.JFrame {
    int o = 0;
    int i = 0;
    //initiateProgram initProgram = new initiateProgram();
    List<JPanel> keyList = new ArrayList();
    List<PianoGraphics> noteList = new ArrayList();
    
    Color orangeWhiteKey = new Color(255, 191, 0);
    Color orangeBlackKey = new Color(239, 130, 13);
    Color orangeWhiteKeyText = new Color(191, 105, 24);
    Color orangeBlackKeyText = new Color(191, 105, 24);
    Color blueWhiteKey = new Color(26, 62, 204);
    Color blueBlackKey = new Color(17, 46, 160);
    Color blueWhiteKeyText = new Color(26, 62, 204);
    Color blueBlackKeyText = new Color(17, 46, 160);

    long tempo;
    
    /**
     * Creates new form VirtualPiano
     */
    public PianoGUI() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        initComponents();
        initializeKeyList();
        initializeNoteList();
    }
    
    public boolean checkKeyWhite(int key) {
        String name = NOTE_NAMES[key % 12];
        //System.out.println(key + " yer a fagget " + name);
        if (name.equals("C") || name.equals("D") || name.equals("E") || name.equals("F")
                || name.equals("G") || name.equals("A") || name.equals("B")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /*public void playNoteAnimation (int key) {
        Object fallingNote = noteList.get(key -21);
        
    }*/
    
    public void setTempo(long t) {
        tempo = t;
    }
    
    public PianoGraphics getPG (int key) {
        PianoGraphics pg = noteList.get(key);
        return pg;
    }
    
    public JLayeredPane getJLP() {
        return jLayeredPane2;
    }
    
    public void setPanelHeights (int height) {
        jLayeredPane2.setSize(this.getWidth(), height);
        jLayeredPane2.setLocation(this.getX(), -height + 635);
        for (PianoGraphics pg : noteList) {
            pg.setSize(this.getWidth(), height);
            pg.setLocation(this.getX(), 0);
            System.out.println(this.getY());
        }
    }
    
    public void colorKey (int key, boolean keyOn) {
        JPanel panel = keyList.get(key - 21);
        JLabel panelLabel = (JLabel)panel.getComponent(0);
        PianoGraphics fallingNote = noteList.get(key -21);

        if(keyOn) {
            if(checkKeyWhite(key)) {
                panel.setBackground(orangeWhiteKey);
                panelLabel.setBackground(orangeWhiteKeyText);
            }
            else if(!checkKeyWhite(key)) {
                panel.setBackground(orangeBlackKey);
                panelLabel.setBackground(orangeBlackKeyText);
            }
        }
        else if(!keyOn) {
            if(checkKeyWhite(key)) {
                //keyboardPanel.setComponentZOrder(panel, -1);
                panel.setBackground(Color.white);
                panelLabel.setBackground(Color.black);
            }
            else if(!checkKeyWhite(key)) {
                panel.setBackground(Color.black);
                panelLabel.setBackground(Color.white);
            }
        }
    }
    
    public void addVisualNoteToNoteList (VisualPianoNote vpn, int key) {
        PianoGraphics pg = noteList.get(key);
        pg.addNoteToList(vpn);
    }
    
    public void initializeKeyList() {
        keyList.add(a0);
        keyList.add(a0s);
        keyList.add(b0);
        
        keyList.add(c1);
        keyList.add(c1s);
        keyList.add(d1);
        keyList.add(d1s);
        keyList.add(e1);
        keyList.add(f1);
        keyList.add(f1s);
        keyList.add(g1);
        keyList.add(g1s);
        keyList.add(a1);
        keyList.add(a1s);
        keyList.add(b1);
        
        keyList.add(c2);
        keyList.add(c2s);
        keyList.add(d2);
        keyList.add(d2s);
        keyList.add(e2);
        keyList.add(f2);
        keyList.add(f2s);
        keyList.add(g2);
        keyList.add(g2s);
        keyList.add(a2);
        keyList.add(a2s);
        keyList.add(b2);
        
        keyList.add(c3);
        keyList.add(c3s);
        keyList.add(d3);
        keyList.add(d3s);
        keyList.add(e3);
        keyList.add(f3);
        keyList.add(f3s);
        keyList.add(g3);
        keyList.add(g3s);
        keyList. add(a3);
        keyList.add(a3s);
        keyList.add(b3);
        
        keyList.add(c4);
        keyList.add(c4s);
        keyList.add(d4);
        keyList.add(d4s);
        keyList.add(e4);
        keyList.add(f4);
        keyList.add(f4s);
        keyList.add(g4);
        keyList.add(g4s);
        keyList.add(a4);
        keyList.add(a4s);
        keyList.add(b4);

        keyList.add(c5);
        keyList.add(c5s);
        keyList.add(d5);
        keyList.add(d5s);
        keyList.add(e5);
        keyList.add(f5);
        keyList.add(f5s);
        keyList.add(g5);
        keyList.add(g5s);
        keyList.add(a5);
        keyList.add(a5s);
        keyList.add(b5);

        keyList.add(c6);
        keyList.add(c6s);
        keyList.add(d6);
        keyList.add(d6s);
        keyList.add(e6);
        keyList.add(f6);
        keyList.add(f6s);
        keyList.add(g6);
        keyList.add(g6s);
        keyList.add(a6);
        keyList.add(a6s);
        keyList.add(b6);

        keyList.add(c7);
        keyList.add(c7s);
        keyList.add(d7);
        keyList.add(d7s);
        keyList.add(e7);
        keyList.add(f7);
        keyList.add(f7s);
        keyList.add(g7);
        keyList.add(g7s);
        keyList.add(a7);
        keyList.add(a7s);
        keyList.add(b7);

        keyList.add(c8);
    }
    
    public void initializeNoteList() {
        noteList.add(noteAnimWhite1);
        noteList.add(noteAnimBlack1);
        noteList.add(noteAnimWhite2);
        
        noteList.add(noteAnimWhite3);
        noteList.add(noteAnimBlack1);
        noteList.add(noteAnimWhite4);
        noteList.add(noteAnimBlack2);
        noteList.add(noteAnimWhite5);
        noteList.add(noteAnimWhite6);
        noteList.add(noteAnimBlack3);
        noteList.add(noteAnimWhite7);
        noteList.add(noteAnimBlack4);
        noteList.add(noteAnimWhite8);
        noteList.add(noteAnimBlack5);
        noteList.add(noteAnimWhite9);
        
        noteList.add(noteAnimWhite10);
        noteList.add(noteAnimBlack6);
        noteList.add(noteAnimWhite11);
        noteList.add(noteAnimBlack7);
        noteList.add(noteAnimWhite12);
        noteList.add(noteAnimWhite13);
        noteList.add(noteAnimBlack8);
        noteList.add(noteAnimWhite14);
        noteList.add(noteAnimBlack9);
        noteList.add(noteAnimWhite15);
        noteList.add(noteAnimBlack10);
        noteList.add(noteAnimWhite16);
        
        noteList.add(noteAnimWhite17);
        noteList.add(noteAnimBlack11);
        noteList.add(noteAnimWhite18);
        noteList.add(noteAnimBlack12);
        noteList.add(noteAnimWhite19);
        noteList.add(noteAnimWhite20);
        noteList.add(noteAnimBlack13);
        noteList.add(noteAnimWhite21);
        noteList.add(noteAnimBlack14);
        noteList.add(noteAnimWhite22);
        noteList.add(noteAnimBlack15);
        noteList.add(noteAnimWhite23);
        
        noteList.add(noteAnimWhite24);
        noteList.add(noteAnimBlack16);
        noteList.add(noteAnimWhite25);
        noteList.add(noteAnimBlack17);
        noteList.add(noteAnimWhite26);
        noteList.add(noteAnimWhite27);
        noteList.add(noteAnimBlack18);
        noteList.add(noteAnimWhite28);
        noteList.add(noteAnimBlack19);
        noteList.add(noteAnimWhite29);
        noteList.add(noteAnimBlack20);
        noteList.add(noteAnimWhite30);
        
        noteList.add(noteAnimWhite31);
        noteList.add(noteAnimBlack21);
        noteList.add(noteAnimWhite32);
        noteList.add(noteAnimBlack22);
        noteList.add(noteAnimWhite33);
        noteList.add(noteAnimWhite34);
        noteList.add(noteAnimBlack23);
        noteList.add(noteAnimWhite35);
        noteList.add(noteAnimBlack24);
        noteList.add(noteAnimWhite36);
        noteList.add(noteAnimBlack25);
        noteList.add(noteAnimWhite37);
        
        noteList.add(noteAnimWhite38);
        noteList.add(noteAnimBlack26);
        noteList.add(noteAnimWhite39);
        noteList.add(noteAnimBlack27);
        noteList.add(noteAnimWhite40);
        noteList.add(noteAnimWhite41);
        noteList.add(noteAnimBlack28);
        noteList.add(noteAnimWhite42);
        noteList.add(noteAnimBlack29);
        noteList.add(noteAnimWhite43);
        noteList.add(noteAnimBlack30);
        noteList.add(noteAnimWhite44);
        
        noteList.add(noteAnimWhite45);
        noteList.add(noteAnimBlack31);
        noteList.add(noteAnimWhite46);
        noteList.add(noteAnimBlack32);
        noteList.add(noteAnimWhite47);
        noteList.add(noteAnimWhite48);
        noteList.add(noteAnimBlack33);
        noteList.add(noteAnimWhite49);
        noteList.add(noteAnimBlack34);
        noteList.add(noteAnimWhite50);
        noteList.add(noteAnimBlack35);
        noteList.add(noteAnimWhite51);
        
        noteList.add(noteAnimWhite52);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLayeredPane1 = new javax.swing.JLayeredPane();
        d3 = new javax.swing.JPanel();
        a1text16 = new javax.swing.JLabel();
        b0 = new javax.swing.JPanel();
        a1text17 = new javax.swing.JLabel();
        c2 = new javax.swing.JPanel();
        a1text18 = new javax.swing.JLabel();
        c3 = new javax.swing.JPanel();
        a1text19 = new javax.swing.JLabel();
        c4 = new javax.swing.JPanel();
        a1text20 = new javax.swing.JLabel();
        c5 = new javax.swing.JPanel();
        a1text21 = new javax.swing.JLabel();
        c6 = new javax.swing.JPanel();
        a1text22 = new javax.swing.JLabel();
        c7 = new javax.swing.JPanel();
        a1text23 = new javax.swing.JLabel();
        c8 = new javax.swing.JPanel();
        a1text24 = new javax.swing.JLabel();
        c1s = new javax.swing.JPanel();
        c1sharpText18 = new javax.swing.JLabel();
        c2s = new javax.swing.JPanel();
        c1sharpText19 = new javax.swing.JLabel();
        c3s = new javax.swing.JPanel();
        c1sharpText20 = new javax.swing.JLabel();
        c4s = new javax.swing.JPanel();
        c1sharpText21 = new javax.swing.JLabel();
        c5s = new javax.swing.JPanel();
        c1sharpText22 = new javax.swing.JLabel();
        c6s = new javax.swing.JPanel();
        c1sharpText23 = new javax.swing.JLabel();
        c7s = new javax.swing.JPanel();
        c1sharpText24 = new javax.swing.JLabel();
        b1 = new javax.swing.JPanel();
        a1text27 = new javax.swing.JLabel();
        b2 = new javax.swing.JPanel();
        a1text29 = new javax.swing.JLabel();
        b3 = new javax.swing.JPanel();
        a1text30 = new javax.swing.JLabel();
        b4 = new javax.swing.JPanel();
        a1text31 = new javax.swing.JLabel();
        b5 = new javax.swing.JPanel();
        a1text32 = new javax.swing.JLabel();
        e6 = new javax.swing.JPanel();
        a1text33 = new javax.swing.JLabel();
        b7 = new javax.swing.JPanel();
        a1text25 = new javax.swing.JLabel();
        d4 = new javax.swing.JPanel();
        a1text34 = new javax.swing.JLabel();
        d1 = new javax.swing.JPanel();
        a1text40 = new javax.swing.JLabel();
        a1text26 = new javax.swing.JLabel();
        d5 = new javax.swing.JPanel();
        a1text41 = new javax.swing.JLabel();
        d6 = new javax.swing.JPanel();
        a1text42 = new javax.swing.JLabel();
        d7 = new javax.swing.JPanel();
        a1text43 = new javax.swing.JLabel();
        d2 = new javax.swing.JPanel();
        a1text48 = new javax.swing.JLabel();
        d7s = new javax.swing.JPanel();
        c1sharpText28 = new javax.swing.JLabel();
        d2s = new javax.swing.JPanel();
        c1sharpText29 = new javax.swing.JLabel();
        d3s = new javax.swing.JPanel();
        c1sharpText30 = new javax.swing.JLabel();
        d4s = new javax.swing.JPanel();
        c1sharpText31 = new javax.swing.JLabel();
        d5s = new javax.swing.JPanel();
        c1sharpText32 = new javax.swing.JLabel();
        f1s = new javax.swing.JPanel();
        c1sharpText34 = new javax.swing.JLabel();
        d6s = new javax.swing.JPanel();
        c1sharpText35 = new javax.swing.JLabel();
        c10 = new javax.swing.JPanel();
        a1text35 = new javax.swing.JLabel();
        b18 = new javax.swing.JPanel();
        a1text44 = new javax.swing.JLabel();
        b19 = new javax.swing.JPanel();
        a1text45 = new javax.swing.JLabel();
        b6 = new javax.swing.JPanel();
        a1text36 = new javax.swing.JLabel();
        e5 = new javax.swing.JPanel();
        a1text37 = new javax.swing.JLabel();
        e2 = new javax.swing.JPanel();
        a1text38 = new javax.swing.JLabel();
        e3 = new javax.swing.JPanel();
        a1text39 = new javax.swing.JLabel();
        e4 = new javax.swing.JPanel();
        a1text46 = new javax.swing.JLabel();
        e1 = new javax.swing.JPanel();
        a1text47 = new javax.swing.JLabel();
        e7 = new javax.swing.JPanel();
        a1text49 = new javax.swing.JLabel();
        f3 = new javax.swing.JPanel();
        a1text50 = new javax.swing.JLabel();
        f1 = new javax.swing.JPanel();
        a1text52 = new javax.swing.JLabel();
        f4 = new javax.swing.JPanel();
        a1text53 = new javax.swing.JLabel();
        f5 = new javax.swing.JPanel();
        a1text54 = new javax.swing.JLabel();
        f6 = new javax.swing.JPanel();
        a1text55 = new javax.swing.JLabel();
        g6 = new javax.swing.JPanel();
        a1text56 = new javax.swing.JLabel();
        f2 = new javax.swing.JPanel();
        a1text57 = new javax.swing.JLabel();
        d1s = new javax.swing.JPanel();
        d1sharpText1 = new javax.swing.JLabel();
        f2s = new javax.swing.JPanel();
        c1sharpText37 = new javax.swing.JLabel();
        f3s = new javax.swing.JPanel();
        c1sharpText38 = new javax.swing.JLabel();
        f4s = new javax.swing.JPanel();
        c1sharpText39 = new javax.swing.JLabel();
        g1s = new javax.swing.JPanel();
        c1sharpText40 = new javax.swing.JLabel();
        f6s = new javax.swing.JPanel();
        c1sharpText41 = new javax.swing.JLabel();
        f7s = new javax.swing.JPanel();
        c1sharpText42 = new javax.swing.JLabel();
        f7 = new javax.swing.JPanel();
        a1text58 = new javax.swing.JLabel();
        g1 = new javax.swing.JPanel();
        a1text59 = new javax.swing.JLabel();
        g2 = new javax.swing.JPanel();
        a1text60 = new javax.swing.JLabel();
        g3 = new javax.swing.JPanel();
        a1text61 = new javax.swing.JLabel();
        g4 = new javax.swing.JPanel();
        a1text62 = new javax.swing.JLabel();
        g5 = new javax.swing.JPanel();
        a1text63 = new javax.swing.JLabel();
        a7 = new javax.swing.JPanel();
        a1text64 = new javax.swing.JLabel();
        f5s = new javax.swing.JPanel();
        c1sharpText43 = new javax.swing.JLabel();
        g2s = new javax.swing.JPanel();
        c1sharpText44 = new javax.swing.JLabel();
        g3s = new javax.swing.JPanel();
        c1sharpText45 = new javax.swing.JLabel();
        g4s = new javax.swing.JPanel();
        c1sharpText46 = new javax.swing.JLabel();
        g5s = new javax.swing.JPanel();
        c1sharpText47 = new javax.swing.JLabel();
        g6s = new javax.swing.JPanel();
        c1sharpText48 = new javax.swing.JLabel();
        a7s = new javax.swing.JPanel();
        c1sharpText49 = new javax.swing.JLabel();
        g7 = new javax.swing.JPanel();
        a1text65 = new javax.swing.JLabel();
        a1 = new javax.swing.JPanel();
        a1text66 = new javax.swing.JLabel();
        a2 = new javax.swing.JPanel();
        a1text67 = new javax.swing.JLabel();
        a3 = new javax.swing.JPanel();
        a1text68 = new javax.swing.JLabel();
        a4 = new javax.swing.JPanel();
        a1text69 = new javax.swing.JLabel();
        a5 = new javax.swing.JPanel();
        a1text70 = new javax.swing.JLabel();
        a6 = new javax.swing.JPanel();
        a1text71 = new javax.swing.JLabel();
        g7s = new javax.swing.JPanel();
        c1sharpText51 = new javax.swing.JLabel();
        a1s = new javax.swing.JPanel();
        c1sharpText52 = new javax.swing.JLabel();
        a2s = new javax.swing.JPanel();
        c1sharpText53 = new javax.swing.JLabel();
        a3s = new javax.swing.JPanel();
        c1sharpText54 = new javax.swing.JLabel();
        a4s = new javax.swing.JPanel();
        c1sharpText55 = new javax.swing.JLabel();
        a5s = new javax.swing.JPanel();
        c1sharpText56 = new javax.swing.JLabel();
        a6s = new javax.swing.JPanel();
        c1sharpText57 = new javax.swing.JLabel();
        a0 = new javax.swing.JPanel();
        a0Text = new javax.swing.JLabel();
        c1 = new javax.swing.JPanel();
        a1text51 = new javax.swing.JLabel();
        a0s = new javax.swing.JPanel();
        c1sharpText26 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        noteAnimWhite1 = new newpackage.PianoGraphics();
        noteAnimWhite2 = new newpackage.PianoGraphics();
        noteAnimWhite3 = new newpackage.PianoGraphics();
        noteAnimWhite4 = new newpackage.PianoGraphics();
        noteAnimWhite5 = new newpackage.PianoGraphics();
        noteAnimWhite6 = new newpackage.PianoGraphics();
        noteAnimWhite7 = new newpackage.PianoGraphics();
        noteAnimWhite8 = new newpackage.PianoGraphics();
        noteAnimWhite9 = new newpackage.PianoGraphics();
        noteAnimWhite10 = new newpackage.PianoGraphics();
        noteAnimWhite11 = new newpackage.PianoGraphics();
        noteAnimWhite12 = new newpackage.PianoGraphics();
        noteAnimWhite13 = new newpackage.PianoGraphics();
        noteAnimWhite14 = new newpackage.PianoGraphics();
        noteAnimWhite15 = new newpackage.PianoGraphics();
        noteAnimWhite16 = new newpackage.PianoGraphics();
        noteAnimWhite17 = new newpackage.PianoGraphics();
        noteAnimWhite18 = new newpackage.PianoGraphics();
        noteAnimWhite19 = new newpackage.PianoGraphics();
        noteAnimWhite20 = new newpackage.PianoGraphics();
        noteAnimWhite21 = new newpackage.PianoGraphics();
        noteAnimWhite22 = new newpackage.PianoGraphics();
        noteAnimWhite23 = new newpackage.PianoGraphics();
        noteAnimWhite24 = new newpackage.PianoGraphics();
        noteAnimWhite25 = new newpackage.PianoGraphics();
        noteAnimWhite26 = new newpackage.PianoGraphics();
        noteAnimWhite27 = new newpackage.PianoGraphics();
        noteAnimWhite28 = new newpackage.PianoGraphics();
        noteAnimWhite29 = new newpackage.PianoGraphics();
        noteAnimWhite30 = new newpackage.PianoGraphics();
        noteAnimWhite31 = new newpackage.PianoGraphics();
        noteAnimWhite32 = new newpackage.PianoGraphics();
        noteAnimWhite33 = new newpackage.PianoGraphics();
        noteAnimWhite34 = new newpackage.PianoGraphics();
        noteAnimWhite35 = new newpackage.PianoGraphics();
        noteAnimWhite36 = new newpackage.PianoGraphics();
        noteAnimWhite37 = new newpackage.PianoGraphics();
        noteAnimWhite38 = new newpackage.PianoGraphics();
        noteAnimWhite39 = new newpackage.PianoGraphics();
        noteAnimWhite40 = new newpackage.PianoGraphics();
        noteAnimWhite41 = new newpackage.PianoGraphics();
        noteAnimWhite42 = new newpackage.PianoGraphics();
        noteAnimWhite43 = new newpackage.PianoGraphics();
        noteAnimWhite44 = new newpackage.PianoGraphics();
        noteAnimWhite45 = new newpackage.PianoGraphics();
        noteAnimWhite46 = new newpackage.PianoGraphics();
        noteAnimWhite47 = new newpackage.PianoGraphics();
        noteAnimWhite48 = new newpackage.PianoGraphics();
        noteAnimWhite49 = new newpackage.PianoGraphics();
        noteAnimWhite50 = new newpackage.PianoGraphics();
        noteAnimWhite51 = new newpackage.PianoGraphics();
        noteAnimWhite52 = new newpackage.PianoGraphics();
        noteAnimBlack1 = new newpackage.PianoGraphics();
        noteAnimBlack2 = new newpackage.PianoGraphics();
        noteAnimBlack3 = new newpackage.PianoGraphics();
        noteAnimBlack4 = new newpackage.PianoGraphics();
        noteAnimBlack5 = new newpackage.PianoGraphics();
        noteAnimBlack6 = new newpackage.PianoGraphics();
        noteAnimBlack7 = new newpackage.PianoGraphics();
        noteAnimBlack8 = new newpackage.PianoGraphics();
        noteAnimBlack9 = new newpackage.PianoGraphics();
        noteAnimBlack10 = new newpackage.PianoGraphics();
        noteAnimBlack11 = new newpackage.PianoGraphics();
        noteAnimBlack12 = new newpackage.PianoGraphics();
        noteAnimBlack13 = new newpackage.PianoGraphics();
        noteAnimBlack14 = new newpackage.PianoGraphics();
        noteAnimBlack15 = new newpackage.PianoGraphics();
        noteAnimBlack16 = new newpackage.PianoGraphics();
        noteAnimBlack17 = new newpackage.PianoGraphics();
        noteAnimBlack18 = new newpackage.PianoGraphics();
        noteAnimBlack19 = new newpackage.PianoGraphics();
        noteAnimBlack20 = new newpackage.PianoGraphics();
        noteAnimBlack21 = new newpackage.PianoGraphics();
        noteAnimBlack22 = new newpackage.PianoGraphics();
        noteAnimBlack23 = new newpackage.PianoGraphics();
        noteAnimBlack24 = new newpackage.PianoGraphics();
        noteAnimBlack25 = new newpackage.PianoGraphics();
        noteAnimBlack26 = new newpackage.PianoGraphics();
        noteAnimBlack27 = new newpackage.PianoGraphics();
        noteAnimBlack28 = new newpackage.PianoGraphics();
        noteAnimBlack29 = new newpackage.PianoGraphics();
        noteAnimBlack30 = new newpackage.PianoGraphics();
        noteAnimBlack31 = new newpackage.PianoGraphics();
        noteAnimBlack32 = new newpackage.PianoGraphics();
        noteAnimBlack33 = new newpackage.PianoGraphics();
        noteAnimBlack34 = new newpackage.PianoGraphics();
        noteAnimBlack35 = new newpackage.PianoGraphics();
        noteAnimBlack36 = new newpackage.PianoGraphics();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 1500));
        getContentPane().setLayout(null);

        jLayeredPane1.setBackground(new java.awt.Color(255, 51, 51));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(215, 150));
        jLayeredPane1.setLayout(new java.awt.GridBagLayout());

        d3.setBackground(new java.awt.Color(252, 252, 252));
        d3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text16.setForeground(new java.awt.Color(212, 212, 212));
        a1text16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text16.setLabelFor(b0);
        a1text16.setText("D");
        a1text16.setAlignmentX(1.0F);
        a1text16.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d3Layout = new javax.swing.GroupLayout(d3);
        d3.setLayout(d3Layout);
        d3Layout.setHorizontalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text16, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d3Layout.setVerticalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d3, gridBagConstraints);

        b0.setBackground(new java.awt.Color(252, 252, 252));
        b0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b0.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text17.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text17.setForeground(new java.awt.Color(150, 150, 150));
        a1text17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text17.setLabelFor(b0);
        a1text17.setText("B");
        a1text17.setAlignmentX(1.0F);
        a1text17.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b0Layout = new javax.swing.GroupLayout(b0);
        b0.setLayout(b0Layout);
        b0Layout.setHorizontalGroup(
            b0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text17, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b0Layout.setVerticalGroup(
            b0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b0Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b0, gridBagConstraints);

        c2.setBackground(new java.awt.Color(252, 252, 252));
        c2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text18.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text18.setForeground(new java.awt.Color(150, 150, 150));
        a1text18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text18.setLabelFor(b0);
        a1text18.setText("C");
        a1text18.setAlignmentX(1.0F);
        a1text18.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text18, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c2Layout.setVerticalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c2, gridBagConstraints);

        c3.setBackground(new java.awt.Color(252, 252, 252));
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text19.setForeground(new java.awt.Color(150, 150, 150));
        a1text19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text19.setLabelFor(b0);
        a1text19.setText("C");
        a1text19.setAlignmentX(1.0F);
        a1text19.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c3Layout = new javax.swing.GroupLayout(c3);
        c3.setLayout(c3Layout);
        c3Layout.setHorizontalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text19, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c3Layout.setVerticalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c3, gridBagConstraints);

        c4.setBackground(new java.awt.Color(252, 252, 252));
        c4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text20.setForeground(new java.awt.Color(150, 150, 150));
        a1text20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text20.setLabelFor(b0);
        a1text20.setText("C");
        a1text20.setAlignmentX(1.0F);
        a1text20.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text20, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c4Layout.setVerticalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c4, gridBagConstraints);

        c5.setBackground(new java.awt.Color(252, 252, 252));
        c5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text21.setForeground(new java.awt.Color(150, 150, 150));
        a1text21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text21.setLabelFor(b0);
        a1text21.setText("C");
        a1text21.setAlignmentX(1.0F);
        a1text21.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text21, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c5Layout.setVerticalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c5, gridBagConstraints);

        c6.setBackground(new java.awt.Color(252, 252, 252));
        c6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text22.setForeground(new java.awt.Color(150, 150, 150));
        a1text22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text22.setLabelFor(b0);
        a1text22.setText("C");
        a1text22.setAlignmentX(1.0F);
        a1text22.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
        c6.setLayout(c6Layout);
        c6Layout.setHorizontalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text22, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c6Layout.setVerticalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c6, gridBagConstraints);

        c7.setBackground(new java.awt.Color(252, 252, 252));
        c7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text23.setForeground(new java.awt.Color(150, 150, 150));
        a1text23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text23.setLabelFor(b0);
        a1text23.setText("C");
        a1text23.setAlignmentX(1.0F);
        a1text23.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c7Layout = new javax.swing.GroupLayout(c7);
        c7.setLayout(c7Layout);
        c7Layout.setHorizontalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text23, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c7Layout.setVerticalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c7, gridBagConstraints);

        c8.setBackground(new java.awt.Color(252, 252, 252));
        c8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c8.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text24.setForeground(new java.awt.Color(150, 150, 150));
        a1text24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text24.setLabelFor(b0);
        a1text24.setText("C");
        a1text24.setAlignmentX(1.0F);
        a1text24.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c8Layout = new javax.swing.GroupLayout(c8);
        c8.setLayout(c8Layout);
        c8Layout.setHorizontalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        c8Layout.setVerticalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c8, gridBagConstraints);

        c1s.setBackground(new java.awt.Color(21, 21, 21));
        c1s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText18.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText18.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText18.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText18.setText("C#");
        c1sharpText18.setAlignmentX(1.0F);
        c1sharpText18.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c1sLayout = new javax.swing.GroupLayout(c1s);
        c1s.setLayout(c1sLayout);
        c1sLayout.setHorizontalGroup(
            c1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText18, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c1sLayout.setVerticalGroup(
            c1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText18)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c1s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c1s, gridBagConstraints);

        c2s.setBackground(new java.awt.Color(21, 21, 21));
        c2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText19.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText19.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText19.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText19.setText("C#");
        c1sharpText19.setAlignmentX(1.0F);
        c1sharpText19.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c2sLayout = new javax.swing.GroupLayout(c2s);
        c2s.setLayout(c2sLayout);
        c2sLayout.setHorizontalGroup(
            c2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText19, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c2sLayout.setVerticalGroup(
            c2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText19)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c2s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c2s, gridBagConstraints);

        c3s.setBackground(new java.awt.Color(21, 21, 21));
        c3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText20.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText20.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText20.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText20.setText("C#");
        c1sharpText20.setAlignmentX(1.0F);
        c1sharpText20.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c3sLayout = new javax.swing.GroupLayout(c3s);
        c3s.setLayout(c3sLayout);
        c3sLayout.setHorizontalGroup(
            c3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText20, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c3sLayout.setVerticalGroup(
            c3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c3sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText20)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c3s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c3s, gridBagConstraints);

        c4s.setBackground(new java.awt.Color(21, 21, 21));
        c4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText21.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText21.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText21.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText21.setText("C#");
        c1sharpText21.setAlignmentX(1.0F);
        c1sharpText21.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c4sLayout = new javax.swing.GroupLayout(c4s);
        c4s.setLayout(c4sLayout);
        c4sLayout.setHorizontalGroup(
            c4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText21, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c4sLayout.setVerticalGroup(
            c4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c4sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText21)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c4s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c4s, gridBagConstraints);

        c5s.setBackground(new java.awt.Color(21, 21, 21));
        c5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText22.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText22.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText22.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText22.setText("C#");
        c1sharpText22.setAlignmentX(1.0F);
        c1sharpText22.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c5sLayout = new javax.swing.GroupLayout(c5s);
        c5s.setLayout(c5sLayout);
        c5sLayout.setHorizontalGroup(
            c5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText22, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c5sLayout.setVerticalGroup(
            c5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c5sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText22)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c5s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c5s, gridBagConstraints);

        c6s.setBackground(new java.awt.Color(21, 21, 21));
        c6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText23.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText23.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText23.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText23.setText("C#");
        c1sharpText23.setAlignmentX(1.0F);
        c1sharpText23.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c6sLayout = new javax.swing.GroupLayout(c6s);
        c6s.setLayout(c6sLayout);
        c6sLayout.setHorizontalGroup(
            c6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText23, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c6sLayout.setVerticalGroup(
            c6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c6sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText23)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c6s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c6s, gridBagConstraints);

        c7s.setBackground(new java.awt.Color(21, 21, 21));
        c7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText24.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText24.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText24.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText24.setText("C#");
        c1sharpText24.setAlignmentX(1.0F);
        c1sharpText24.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c7sLayout = new javax.swing.GroupLayout(c7s);
        c7s.setLayout(c7sLayout);
        c7sLayout.setHorizontalGroup(
            c7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText24, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c7sLayout.setVerticalGroup(
            c7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c7sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText24)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(c7s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(c7s, gridBagConstraints);

        b1.setBackground(new java.awt.Color(252, 252, 252));
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text27.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text27.setForeground(new java.awt.Color(212, 212, 212));
        a1text27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text27.setLabelFor(b0);
        a1text27.setText("B");
        a1text27.setAlignmentX(1.0F);
        a1text27.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text27, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b1, gridBagConstraints);

        b2.setBackground(new java.awt.Color(252, 252, 252));
        b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text29.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text29.setForeground(new java.awt.Color(212, 212, 212));
        a1text29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text29.setLabelFor(b0);
        a1text29.setText("B");
        a1text29.setAlignmentX(1.0F);
        a1text29.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text29, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b2Layout.setVerticalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b2, gridBagConstraints);

        b3.setBackground(new java.awt.Color(252, 252, 252));
        b3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text30.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text30.setForeground(new java.awt.Color(212, 212, 212));
        a1text30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text30.setLabelFor(b0);
        a1text30.setText("B");
        a1text30.setAlignmentX(1.0F);
        a1text30.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text30, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b3, gridBagConstraints);

        b4.setBackground(new java.awt.Color(252, 252, 252));
        b4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text31.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text31.setForeground(new java.awt.Color(212, 212, 212));
        a1text31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text31.setLabelFor(b0);
        a1text31.setText("B");
        a1text31.setAlignmentX(1.0F);
        a1text31.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text31, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b4Layout.setVerticalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b4Layout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addComponent(a1text31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b4, gridBagConstraints);

        b5.setBackground(new java.awt.Color(252, 252, 252));
        b5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text32.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text32.setForeground(new java.awt.Color(212, 212, 212));
        a1text32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text32.setLabelFor(b0);
        a1text32.setText("B");
        a1text32.setAlignmentX(1.0F);
        a1text32.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
        b5.setLayout(b5Layout);
        b5Layout.setHorizontalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text32, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b5Layout.setVerticalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b5, gridBagConstraints);

        e6.setBackground(new java.awt.Color(252, 252, 252));
        e6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text33.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text33.setForeground(new java.awt.Color(212, 212, 212));
        a1text33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text33.setLabelFor(b0);
        a1text33.setText("E");
        a1text33.setAlignmentX(1.0F);
        a1text33.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e6Layout = new javax.swing.GroupLayout(e6);
        e6.setLayout(e6Layout);
        e6Layout.setHorizontalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text33, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e6Layout.setVerticalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 39;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e6, gridBagConstraints);

        b7.setBackground(new java.awt.Color(252, 252, 252));
        b7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text25.setForeground(new java.awt.Color(212, 212, 212));
        a1text25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text25.setLabelFor(b0);
        a1text25.setText("B");
        a1text25.setAlignmentX(1.0F);
        a1text25.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b7Layout = new javax.swing.GroupLayout(b7);
        b7.setLayout(b7Layout);
        b7Layout.setHorizontalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text25, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b7Layout.setVerticalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 50;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b7, gridBagConstraints);

        d4.setBackground(new java.awt.Color(252, 252, 252));
        d4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text34.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text34.setForeground(new java.awt.Color(212, 212, 212));
        a1text34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text34.setLabelFor(b0);
        a1text34.setText("D");
        a1text34.setAlignmentX(1.0F);
        a1text34.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d4Layout = new javax.swing.GroupLayout(d4);
        d4.setLayout(d4Layout);
        d4Layout.setHorizontalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text34, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d4Layout.setVerticalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d4, gridBagConstraints);

        d1.setBackground(new java.awt.Color(252, 252, 252));
        d1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text40.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text40.setForeground(new java.awt.Color(212, 212, 212));
        a1text40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text40.setLabelFor(b0);
        a1text40.setText("D");
        a1text40.setAlignmentX(1.0F);
        a1text40.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a1text26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text26.setForeground(new java.awt.Color(150, 150, 150));
        a1text26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text26.setLabelFor(b0);
        a1text26.setText("D");
        a1text26.setAlignmentX(1.0F);
        a1text26.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d1Layout.createSequentialGroup()
                .addComponent(a1text26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(a1text40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        d1Layout.setVerticalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a1text40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a1text26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);
        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d1, gridBagConstraints);

        d5.setBackground(new java.awt.Color(252, 252, 252));
        d5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text41.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text41.setForeground(new java.awt.Color(212, 212, 212));
        a1text41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text41.setLabelFor(b0);
        a1text41.setText("D");
        a1text41.setAlignmentX(1.0F);
        a1text41.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
        d5.setLayout(d5Layout);
        d5Layout.setHorizontalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text41, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d5Layout.setVerticalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d5, gridBagConstraints);

        d6.setBackground(new java.awt.Color(252, 252, 252));
        d6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text42.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text42.setForeground(new java.awt.Color(212, 212, 212));
        a1text42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text42.setLabelFor(b0);
        a1text42.setText("D");
        a1text42.setAlignmentX(1.0F);
        a1text42.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d6Layout = new javax.swing.GroupLayout(d6);
        d6.setLayout(d6Layout);
        d6Layout.setHorizontalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text42, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d6Layout.setVerticalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 38;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d6, gridBagConstraints);

        d7.setBackground(new java.awt.Color(252, 252, 252));
        d7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text43.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text43.setForeground(new java.awt.Color(212, 212, 212));
        a1text43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text43.setLabelFor(b0);
        a1text43.setText("D");
        a1text43.setAlignmentX(1.0F);
        a1text43.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d7Layout = new javax.swing.GroupLayout(d7);
        d7.setLayout(d7Layout);
        d7Layout.setHorizontalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text43, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d7Layout.setVerticalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d7, gridBagConstraints);

        d2.setBackground(new java.awt.Color(252, 252, 252));
        d2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text48.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text48.setForeground(new java.awt.Color(212, 212, 212));
        a1text48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text48.setLabelFor(b0);
        a1text48.setText("D");
        a1text48.setAlignmentX(1.0F);
        a1text48.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text48, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d2Layout.setVerticalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text48, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(d2, gridBagConstraints);

        d7s.setBackground(new java.awt.Color(21, 21, 21));
        d7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText28.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText28.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText28.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText28.setText("D#");
        c1sharpText28.setAlignmentX(1.0F);
        c1sharpText28.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d7sLayout = new javax.swing.GroupLayout(d7s);
        d7s.setLayout(d7sLayout);
        d7sLayout.setHorizontalGroup(
            d7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText28, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d7sLayout.setVerticalGroup(
            d7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d7sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText28)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d7s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d7s, gridBagConstraints);

        d2s.setBackground(new java.awt.Color(21, 21, 21));
        d2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText29.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText29.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText29.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText29.setText("D#");
        c1sharpText29.setAlignmentX(1.0F);
        c1sharpText29.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d2sLayout = new javax.swing.GroupLayout(d2s);
        d2s.setLayout(d2sLayout);
        d2sLayout.setHorizontalGroup(
            d2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText29, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d2sLayout.setVerticalGroup(
            d2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText29)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d2s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d2s, gridBagConstraints);

        d3s.setBackground(new java.awt.Color(21, 21, 21));
        d3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText30.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText30.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText30.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText30.setText("D#");
        c1sharpText30.setAlignmentX(1.0F);
        c1sharpText30.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d3sLayout = new javax.swing.GroupLayout(d3s);
        d3s.setLayout(d3sLayout);
        d3sLayout.setHorizontalGroup(
            d3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText30, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d3sLayout.setVerticalGroup(
            d3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d3sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText30)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d3s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d3s, gridBagConstraints);

        d4s.setBackground(new java.awt.Color(21, 21, 21));
        d4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText31.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText31.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText31.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText31.setText("D#");
        c1sharpText31.setAlignmentX(1.0F);
        c1sharpText31.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d4sLayout = new javax.swing.GroupLayout(d4s);
        d4s.setLayout(d4sLayout);
        d4sLayout.setHorizontalGroup(
            d4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText31, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d4sLayout.setVerticalGroup(
            d4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d4sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText31)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d4s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d4s, gridBagConstraints);

        d5s.setBackground(new java.awt.Color(21, 21, 21));
        d5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText32.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText32.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText32.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText32.setText("D#");
        c1sharpText32.setAlignmentX(1.0F);
        c1sharpText32.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d5sLayout = new javax.swing.GroupLayout(d5s);
        d5s.setLayout(d5sLayout);
        d5sLayout.setHorizontalGroup(
            d5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText32, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d5sLayout.setVerticalGroup(
            d5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d5sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText32)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d5s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d5s, gridBagConstraints);

        f1s.setBackground(new java.awt.Color(21, 21, 21));
        f1s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText34.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText34.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText34.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText34.setText("F#");
        c1sharpText34.setAlignmentX(1.0F);
        c1sharpText34.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f1sLayout = new javax.swing.GroupLayout(f1s);
        f1s.setLayout(f1sLayout);
        f1sLayout.setHorizontalGroup(
            f1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText34, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f1sLayout.setVerticalGroup(
            f1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText34)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f1s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f1s, gridBagConstraints);

        d6s.setBackground(new java.awt.Color(21, 21, 21));
        d6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText35.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText35.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText35.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText35.setText("D#");
        c1sharpText35.setAlignmentX(1.0F);
        c1sharpText35.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d6sLayout = new javax.swing.GroupLayout(d6s);
        d6s.setLayout(d6sLayout);
        d6sLayout.setHorizontalGroup(
            d6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText35, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d6sLayout.setVerticalGroup(
            d6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d6sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText35)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(d6s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 38;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d6s, gridBagConstraints);

        c10.setBackground(new java.awt.Color(252, 252, 252));
        c10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c10.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text35.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text35.setForeground(new java.awt.Color(150, 150, 150));
        a1text35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text35.setLabelFor(b0);
        a1text35.setText("C");
        a1text35.setAlignmentX(1.0F);
        a1text35.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c10Layout = new javax.swing.GroupLayout(c10);
        c10.setLayout(c10Layout);
        c10Layout.setHorizontalGroup(
            c10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text35, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c10Layout.setVerticalGroup(
            c10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c10, gridBagConstraints);

        b18.setBackground(new java.awt.Color(252, 252, 252));
        b18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b18.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text44.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text44.setForeground(new java.awt.Color(212, 212, 212));
        a1text44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text44.setLabelFor(b0);
        a1text44.setText("D");
        a1text44.setAlignmentX(1.0F);
        a1text44.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b18Layout = new javax.swing.GroupLayout(b18);
        b18.setLayout(b18Layout);
        b18Layout.setHorizontalGroup(
            b18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text44, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b18Layout.setVerticalGroup(
            b18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b18, gridBagConstraints);

        b19.setBackground(new java.awt.Color(252, 252, 252));
        b19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b19.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text45.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text45.setForeground(new java.awt.Color(212, 212, 212));
        a1text45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text45.setLabelFor(b0);
        a1text45.setText("D");
        a1text45.setAlignmentX(1.0F);
        a1text45.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b19Layout = new javax.swing.GroupLayout(b19);
        b19.setLayout(b19Layout);
        b19Layout.setHorizontalGroup(
            b19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b19Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(a1text45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        b19Layout.setVerticalGroup(
            b19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text45, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b19, gridBagConstraints);

        b6.setBackground(new java.awt.Color(252, 252, 252));
        b6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text36.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text36.setForeground(new java.awt.Color(212, 212, 212));
        a1text36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text36.setLabelFor(b0);
        a1text36.setText("B");
        a1text36.setAlignmentX(1.0F);
        a1text36.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout b6Layout = new javax.swing.GroupLayout(b6);
        b6.setLayout(b6Layout);
        b6Layout.setHorizontalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text36, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b6Layout.setVerticalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 43;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(b6, gridBagConstraints);

        e5.setBackground(new java.awt.Color(252, 252, 252));
        e5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text37.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text37.setForeground(new java.awt.Color(212, 212, 212));
        a1text37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text37.setLabelFor(b0);
        a1text37.setText("E");
        a1text37.setAlignmentX(1.0F);
        a1text37.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
        e5.setLayout(e5Layout);
        e5Layout.setHorizontalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text37, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e5Layout.setVerticalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e5, gridBagConstraints);

        e2.setBackground(new java.awt.Color(252, 252, 252));
        e2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text38.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text38.setForeground(new java.awt.Color(212, 212, 212));
        a1text38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text38.setLabelFor(b0);
        a1text38.setText("E");
        a1text38.setAlignmentX(1.0F);
        a1text38.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e2Layout = new javax.swing.GroupLayout(e2);
        e2.setLayout(e2Layout);
        e2Layout.setHorizontalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text38, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e2Layout.setVerticalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e2, gridBagConstraints);

        e3.setBackground(new java.awt.Color(252, 252, 252));
        e3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text39.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text39.setForeground(new java.awt.Color(212, 212, 212));
        a1text39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text39.setLabelFor(b0);
        a1text39.setText("E");
        a1text39.setAlignmentX(1.0F);
        a1text39.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e3Layout = new javax.swing.GroupLayout(e3);
        e3.setLayout(e3Layout);
        e3Layout.setHorizontalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text39, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e3Layout.setVerticalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e3, gridBagConstraints);

        e4.setBackground(new java.awt.Color(252, 252, 252));
        e4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text46.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text46.setForeground(new java.awt.Color(212, 212, 212));
        a1text46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text46.setLabelFor(b0);
        a1text46.setText("E");
        a1text46.setAlignmentX(1.0F);
        a1text46.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e4Layout = new javax.swing.GroupLayout(e4);
        e4.setLayout(e4Layout);
        e4Layout.setHorizontalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text46, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e4Layout.setVerticalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text46, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e4, gridBagConstraints);

        e1.setBackground(new java.awt.Color(252, 252, 252));
        e1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text47.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text47.setForeground(new java.awt.Color(212, 212, 212));
        a1text47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text47.setLabelFor(b0);
        a1text47.setText("E");
        a1text47.setAlignmentX(1.0F);
        a1text47.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e1Layout = new javax.swing.GroupLayout(e1);
        e1.setLayout(e1Layout);
        e1Layout.setHorizontalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text47, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e1Layout.setVerticalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text47, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e1, gridBagConstraints);

        e7.setBackground(new java.awt.Color(252, 252, 252));
        e7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text49.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text49.setForeground(new java.awt.Color(212, 212, 212));
        a1text49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text49.setLabelFor(b0);
        a1text49.setText("E");
        a1text49.setAlignmentX(1.0F);
        a1text49.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout e7Layout = new javax.swing.GroupLayout(e7);
        e7.setLayout(e7Layout);
        e7Layout.setHorizontalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text49, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e7Layout.setVerticalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text49, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 46;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(e7, gridBagConstraints);

        f3.setBackground(new java.awt.Color(252, 252, 252));
        f3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text50.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text50.setForeground(new java.awt.Color(212, 212, 212));
        a1text50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text50.setLabelFor(b0);
        a1text50.setText("F");
        a1text50.setAlignmentX(1.0F);
        a1text50.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f3Layout = new javax.swing.GroupLayout(f3);
        f3.setLayout(f3Layout);
        f3Layout.setHorizontalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text50, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f3Layout.setVerticalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f3, gridBagConstraints);

        f1.setBackground(new java.awt.Color(252, 252, 252));
        f1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text52.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text52.setForeground(new java.awt.Color(212, 212, 212));
        a1text52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text52.setLabelFor(b0);
        a1text52.setText("F");
        a1text52.setAlignmentX(1.0F);
        a1text52.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1);
        f1.setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text52, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f1Layout.setVerticalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f1, gridBagConstraints);

        f4.setBackground(new java.awt.Color(252, 252, 252));
        f4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text53.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text53.setForeground(new java.awt.Color(212, 212, 212));
        a1text53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text53.setLabelFor(b0);
        a1text53.setText("F");
        a1text53.setAlignmentX(1.0F);
        a1text53.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f4Layout = new javax.swing.GroupLayout(f4);
        f4.setLayout(f4Layout);
        f4Layout.setHorizontalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text53, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f4Layout.setVerticalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text53, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f4, gridBagConstraints);

        f5.setBackground(new java.awt.Color(252, 252, 252));
        f5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text54.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text54.setForeground(new java.awt.Color(212, 212, 212));
        a1text54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text54.setLabelFor(b0);
        a1text54.setText("F");
        a1text54.setAlignmentX(1.0F);
        a1text54.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5);
        f5.setLayout(f5Layout);
        f5Layout.setHorizontalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text54, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f5Layout.setVerticalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f5, gridBagConstraints);

        f6.setBackground(new java.awt.Color(252, 252, 252));
        f6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text55.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text55.setForeground(new java.awt.Color(212, 212, 212));
        a1text55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text55.setLabelFor(b0);
        a1text55.setText("F");
        a1text55.setAlignmentX(1.0F);
        a1text55.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6);
        f6.setLayout(f6Layout);
        f6Layout.setHorizontalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text55, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f6Layout.setVerticalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text55, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f6, gridBagConstraints);

        g6.setBackground(new java.awt.Color(252, 252, 252));
        g6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text56.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text56.setForeground(new java.awt.Color(212, 212, 212));
        a1text56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text56.setLabelFor(b0);
        a1text56.setText("G");
        a1text56.setAlignmentX(1.0F);
        a1text56.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g6Layout = new javax.swing.GroupLayout(g6);
        g6.setLayout(g6Layout);
        g6Layout.setHorizontalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text56, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g6Layout.setVerticalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text56, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g6, gridBagConstraints);

        f2.setBackground(new java.awt.Color(252, 252, 252));
        f2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text57.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text57.setForeground(new java.awt.Color(212, 212, 212));
        a1text57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text57.setLabelFor(b0);
        a1text57.setText("F");
        a1text57.setAlignmentX(1.0F);
        a1text57.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2);
        f2.setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text57, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f2Layout.setVerticalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text57, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f2, gridBagConstraints);

        d1s.setBackground(new java.awt.Color(21, 21, 21));

        d1sharpText1.setBackground(new java.awt.Color(0, 0, 0));
        d1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText1.setForeground(new java.awt.Color(70, 70, 70));
        d1sharpText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d1sharpText1.setText("D#");
        d1sharpText1.setAlignmentX(1.0F);
        d1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout d1sLayout = new javax.swing.GroupLayout(d1s);
        d1s.setLayout(d1sLayout);
        d1sLayout.setHorizontalGroup(
            d1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        d1sLayout.setVerticalGroup(
            d1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText1)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(d1s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(d1s, gridBagConstraints);

        f2s.setBackground(new java.awt.Color(21, 21, 21));
        f2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText37.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText37.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText37.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText37.setText("F#");
        c1sharpText37.setAlignmentX(1.0F);
        c1sharpText37.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f2sLayout = new javax.swing.GroupLayout(f2s);
        f2s.setLayout(f2sLayout);
        f2sLayout.setHorizontalGroup(
            f2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText37, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f2sLayout.setVerticalGroup(
            f2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText37)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f2s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f2s, gridBagConstraints);

        f3s.setBackground(new java.awt.Color(21, 21, 21));
        f3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText38.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText38.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText38.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText38.setText("F#");
        c1sharpText38.setAlignmentX(1.0F);
        c1sharpText38.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f3sLayout = new javax.swing.GroupLayout(f3s);
        f3s.setLayout(f3sLayout);
        f3sLayout.setHorizontalGroup(
            f3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText38, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f3sLayout.setVerticalGroup(
            f3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText38)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f3s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f3s, gridBagConstraints);

        f4s.setBackground(new java.awt.Color(21, 21, 21));
        f4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText39.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText39.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText39.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText39.setText("F#");
        c1sharpText39.setAlignmentX(1.0F);
        c1sharpText39.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f4sLayout = new javax.swing.GroupLayout(f4s);
        f4s.setLayout(f4sLayout);
        f4sLayout.setHorizontalGroup(
            f4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText39, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f4sLayout.setVerticalGroup(
            f4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText39)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f4s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f4s, gridBagConstraints);

        g1s.setBackground(new java.awt.Color(21, 21, 21));
        g1s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText40.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText40.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText40.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText40.setText("G#");
        c1sharpText40.setAlignmentX(1.0F);
        c1sharpText40.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g1sLayout = new javax.swing.GroupLayout(g1s);
        g1s.setLayout(g1sLayout);
        g1sLayout.setHorizontalGroup(
            g1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText40, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g1sLayout.setVerticalGroup(
            g1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText40)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g1s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g1s, gridBagConstraints);

        f6s.setBackground(new java.awt.Color(21, 21, 21));
        f6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText41.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText41.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText41.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText41.setText("F#");
        c1sharpText41.setAlignmentX(1.0F);
        c1sharpText41.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f6sLayout = new javax.swing.GroupLayout(f6s);
        f6s.setLayout(f6sLayout);
        f6sLayout.setHorizontalGroup(
            f6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText41, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f6sLayout.setVerticalGroup(
            f6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText41)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f6s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f6s, gridBagConstraints);

        f7s.setBackground(new java.awt.Color(21, 21, 21));
        f7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText42.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText42.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText42.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText42.setText("F#");
        c1sharpText42.setAlignmentX(1.0F);
        c1sharpText42.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f7sLayout = new javax.swing.GroupLayout(f7s);
        f7s.setLayout(f7sLayout);
        f7sLayout.setHorizontalGroup(
            f7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText42, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f7sLayout.setVerticalGroup(
            f7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText42)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f7s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f7s, gridBagConstraints);

        f7.setBackground(new java.awt.Color(252, 252, 252));
        f7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text58.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text58.setForeground(new java.awt.Color(212, 212, 212));
        a1text58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text58.setLabelFor(b0);
        a1text58.setText("F");
        a1text58.setAlignmentX(1.0F);
        a1text58.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7);
        f7.setLayout(f7Layout);
        f7Layout.setHorizontalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text58, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f7Layout.setVerticalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text58, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(f7, gridBagConstraints);

        g1.setBackground(new java.awt.Color(252, 252, 252));
        g1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text59.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text59.setForeground(new java.awt.Color(212, 212, 212));
        a1text59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text59.setLabelFor(b0);
        a1text59.setText("G");
        a1text59.setAlignmentX(1.0F);
        a1text59.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g1Layout = new javax.swing.GroupLayout(g1);
        g1.setLayout(g1Layout);
        g1Layout.setHorizontalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text59, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g1Layout.setVerticalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text59, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g1, gridBagConstraints);

        g2.setBackground(new java.awt.Color(252, 252, 252));
        g2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text60.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text60.setForeground(new java.awt.Color(212, 212, 212));
        a1text60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text60.setLabelFor(b0);
        a1text60.setText("G");
        a1text60.setAlignmentX(1.0F);
        a1text60.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g2Layout = new javax.swing.GroupLayout(g2);
        g2.setLayout(g2Layout);
        g2Layout.setHorizontalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text60, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g2Layout.setVerticalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text60, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g2, gridBagConstraints);

        g3.setBackground(new java.awt.Color(252, 252, 252));
        g3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text61.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text61.setForeground(new java.awt.Color(212, 212, 212));
        a1text61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text61.setLabelFor(b0);
        a1text61.setText("G");
        a1text61.setAlignmentX(1.0F);
        a1text61.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g3Layout = new javax.swing.GroupLayout(g3);
        g3.setLayout(g3Layout);
        g3Layout.setHorizontalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text61, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g3Layout.setVerticalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text61, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g3, gridBagConstraints);

        g4.setBackground(new java.awt.Color(252, 252, 252));
        g4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text62.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text62.setForeground(new java.awt.Color(212, 212, 212));
        a1text62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text62.setLabelFor(b0);
        a1text62.setText("G");
        a1text62.setAlignmentX(1.0F);
        a1text62.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g4Layout = new javax.swing.GroupLayout(g4);
        g4.setLayout(g4Layout);
        g4Layout.setHorizontalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text62, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g4Layout.setVerticalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text62, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g4, gridBagConstraints);

        g5.setBackground(new java.awt.Color(252, 252, 252));
        g5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text63.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text63.setForeground(new java.awt.Color(212, 212, 212));
        a1text63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text63.setLabelFor(b0);
        a1text63.setText("G");
        a1text63.setAlignmentX(1.0F);
        a1text63.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g5Layout = new javax.swing.GroupLayout(g5);
        g5.setLayout(g5Layout);
        g5Layout.setHorizontalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text63, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g5Layout.setVerticalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text63, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g5, gridBagConstraints);

        a7.setBackground(new java.awt.Color(252, 252, 252));
        a7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text64.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text64.setForeground(new java.awt.Color(212, 212, 212));
        a1text64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text64.setLabelFor(b0);
        a1text64.setText("A");
        a1text64.setAlignmentX(1.0F);
        a1text64.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a7Layout = new javax.swing.GroupLayout(a7);
        a7.setLayout(a7Layout);
        a7Layout.setHorizontalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text64, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a7Layout.setVerticalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text64, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 49;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a7, gridBagConstraints);

        f5s.setBackground(new java.awt.Color(21, 21, 21));
        f5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText43.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText43.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText43.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText43.setText("F#");
        c1sharpText43.setAlignmentX(1.0F);
        c1sharpText43.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout f5sLayout = new javax.swing.GroupLayout(f5s);
        f5s.setLayout(f5sLayout);
        f5sLayout.setHorizontalGroup(
            f5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText43, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f5sLayout.setVerticalGroup(
            f5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText43)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(f5s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(f5s, gridBagConstraints);

        g2s.setBackground(new java.awt.Color(21, 21, 21));
        g2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText44.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText44.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText44.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText44.setText("G#");
        c1sharpText44.setAlignmentX(1.0F);
        c1sharpText44.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g2sLayout = new javax.swing.GroupLayout(g2s);
        g2s.setLayout(g2sLayout);
        g2sLayout.setHorizontalGroup(
            g2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText44, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g2sLayout.setVerticalGroup(
            g2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText44)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g2s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g2s, gridBagConstraints);

        g3s.setBackground(new java.awt.Color(21, 21, 21));
        g3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText45.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText45.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText45.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText45.setText("G#");
        c1sharpText45.setAlignmentX(1.0F);
        c1sharpText45.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g3sLayout = new javax.swing.GroupLayout(g3s);
        g3s.setLayout(g3sLayout);
        g3sLayout.setHorizontalGroup(
            g3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText45, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g3sLayout.setVerticalGroup(
            g3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText45)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g3s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g3s, gridBagConstraints);

        g4s.setBackground(new java.awt.Color(21, 21, 21));
        g4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText46.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText46.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText46.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText46.setText("G#");
        c1sharpText46.setAlignmentX(1.0F);
        c1sharpText46.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g4sLayout = new javax.swing.GroupLayout(g4s);
        g4s.setLayout(g4sLayout);
        g4sLayout.setHorizontalGroup(
            g4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText46, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g4sLayout.setVerticalGroup(
            g4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText46)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g4s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g4s, gridBagConstraints);

        g5s.setBackground(new java.awt.Color(21, 21, 21));
        g5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText47.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText47.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText47.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText47.setText("G#");
        c1sharpText47.setAlignmentX(1.0F);
        c1sharpText47.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g5sLayout = new javax.swing.GroupLayout(g5s);
        g5s.setLayout(g5sLayout);
        g5sLayout.setHorizontalGroup(
            g5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText47, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g5sLayout.setVerticalGroup(
            g5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText47)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g5s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g5s, gridBagConstraints);

        g6s.setBackground(new java.awt.Color(21, 21, 21));
        g6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText48.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText48.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText48.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText48.setText("G#");
        c1sharpText48.setAlignmentX(1.0F);
        c1sharpText48.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g6sLayout = new javax.swing.GroupLayout(g6s);
        g6s.setLayout(g6sLayout);
        g6sLayout.setHorizontalGroup(
            g6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText48, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g6sLayout.setVerticalGroup(
            g6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText48)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g6s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g6s, gridBagConstraints);

        a7s.setBackground(new java.awt.Color(21, 21, 21));
        a7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText49.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText49.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText49.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText49.setText("A#");
        c1sharpText49.setAlignmentX(1.0F);
        c1sharpText49.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a7sLayout = new javax.swing.GroupLayout(a7s);
        a7s.setLayout(a7sLayout);
        a7sLayout.setHorizontalGroup(
            a7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText49, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a7sLayout.setVerticalGroup(
            a7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText49)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a7s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 49;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a7s, gridBagConstraints);

        g7.setBackground(new java.awt.Color(252, 252, 252));
        g7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g7.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text65.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text65.setForeground(new java.awt.Color(212, 212, 212));
        a1text65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text65.setLabelFor(b0);
        a1text65.setText("G");
        a1text65.setAlignmentX(1.0F);
        a1text65.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g7Layout = new javax.swing.GroupLayout(g7);
        g7.setLayout(g7Layout);
        g7Layout.setHorizontalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text65, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g7Layout.setVerticalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text65, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(g7, gridBagConstraints);

        a1.setBackground(new java.awt.Color(252, 252, 252));
        a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text66.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text66.setForeground(new java.awt.Color(212, 212, 212));
        a1text66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text66.setLabelFor(b0);
        a1text66.setText("A");
        a1text66.setAlignmentX(1.0F);
        a1text66.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a1Layout = new javax.swing.GroupLayout(a1);
        a1.setLayout(a1Layout);
        a1Layout.setHorizontalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text66, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a1Layout.setVerticalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text66, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a1, gridBagConstraints);

        a2.setBackground(new java.awt.Color(252, 252, 252));
        a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a2.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text67.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text67.setForeground(new java.awt.Color(212, 212, 212));
        a1text67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text67.setLabelFor(b0);
        a1text67.setText("A");
        a1text67.setAlignmentX(1.0F);
        a1text67.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text67, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a2Layout.setVerticalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text67, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a2, gridBagConstraints);

        a3.setBackground(new java.awt.Color(252, 252, 252));
        a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a3.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text68.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text68.setForeground(new java.awt.Color(212, 212, 212));
        a1text68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text68.setLabelFor(b0);
        a1text68.setText("A");
        a1text68.setAlignmentX(1.0F);
        a1text68.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a3Layout = new javax.swing.GroupLayout(a3);
        a3.setLayout(a3Layout);
        a3Layout.setHorizontalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text68, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a3Layout.setVerticalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text68, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a3, gridBagConstraints);

        a4.setBackground(new java.awt.Color(252, 252, 252));
        a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a4.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text69.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text69.setForeground(new java.awt.Color(212, 212, 212));
        a1text69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text69.setLabelFor(b0);
        a1text69.setText("A");
        a1text69.setAlignmentX(1.0F);
        a1text69.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a4Layout = new javax.swing.GroupLayout(a4);
        a4.setLayout(a4Layout);
        a4Layout.setHorizontalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text69, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a4Layout.setVerticalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text69, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a4, gridBagConstraints);

        a5.setBackground(new java.awt.Color(252, 252, 252));
        a5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a5.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text70.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text70.setForeground(new java.awt.Color(212, 212, 212));
        a1text70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text70.setLabelFor(b0);
        a1text70.setText("A");
        a1text70.setAlignmentX(1.0F);
        a1text70.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a5Layout = new javax.swing.GroupLayout(a5);
        a5.setLayout(a5Layout);
        a5Layout.setHorizontalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text70, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a5Layout.setVerticalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text70, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a5, gridBagConstraints);

        a6.setBackground(new java.awt.Color(252, 252, 252));
        a6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a6.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text71.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text71.setForeground(new java.awt.Color(212, 212, 212));
        a1text71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text71.setLabelFor(b0);
        a1text71.setText("A");
        a1text71.setAlignmentX(1.0F);
        a1text71.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a6Layout = new javax.swing.GroupLayout(a6);
        a6.setLayout(a6Layout);
        a6Layout.setHorizontalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text71, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text71, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 42;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a6, gridBagConstraints);

        g7s.setBackground(new java.awt.Color(21, 21, 21));
        g7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText51.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText51.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText51.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText51.setText("G#");
        c1sharpText51.setAlignmentX(1.0F);
        c1sharpText51.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout g7sLayout = new javax.swing.GroupLayout(g7s);
        g7s.setLayout(g7sLayout);
        g7sLayout.setHorizontalGroup(
            g7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText51, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g7sLayout.setVerticalGroup(
            g7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText51)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(g7s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(g7s, gridBagConstraints);

        a1s.setBackground(new java.awt.Color(21, 21, 21));
        a1s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText52.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText52.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText52.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText52.setText("A#");
        c1sharpText52.setAlignmentX(1.0F);
        c1sharpText52.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a1sLayout = new javax.swing.GroupLayout(a1s);
        a1s.setLayout(a1sLayout);
        a1sLayout.setHorizontalGroup(
            a1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText52, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a1sLayout.setVerticalGroup(
            a1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText52)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a1s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a1s, gridBagConstraints);

        a2s.setBackground(new java.awt.Color(21, 21, 21));
        a2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText53.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText53.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText53.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText53.setText("A#");
        c1sharpText53.setAlignmentX(1.0F);
        c1sharpText53.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a2sLayout = new javax.swing.GroupLayout(a2s);
        a2s.setLayout(a2sLayout);
        a2sLayout.setHorizontalGroup(
            a2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText53, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a2sLayout.setVerticalGroup(
            a2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText53)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a2s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a2s, gridBagConstraints);

        a3s.setBackground(new java.awt.Color(21, 21, 21));
        a3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText54.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText54.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText54.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText54.setText("A#");
        c1sharpText54.setAlignmentX(1.0F);
        c1sharpText54.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a3sLayout = new javax.swing.GroupLayout(a3s);
        a3s.setLayout(a3sLayout);
        a3sLayout.setHorizontalGroup(
            a3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText54, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a3sLayout.setVerticalGroup(
            a3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText54)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a3s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a3s, gridBagConstraints);

        a4s.setBackground(new java.awt.Color(21, 21, 21));
        a4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText55.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText55.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText55.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText55.setText("A#");
        c1sharpText55.setAlignmentX(1.0F);
        c1sharpText55.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a4sLayout = new javax.swing.GroupLayout(a4s);
        a4s.setLayout(a4sLayout);
        a4sLayout.setHorizontalGroup(
            a4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText55, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a4sLayout.setVerticalGroup(
            a4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText55)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a4s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a4s, gridBagConstraints);

        a5s.setBackground(new java.awt.Color(21, 21, 21));
        a5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText56.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText56.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText56.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText56.setText("A#");
        c1sharpText56.setAlignmentX(1.0F);
        c1sharpText56.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a5sLayout = new javax.swing.GroupLayout(a5s);
        a5s.setLayout(a5sLayout);
        a5sLayout.setHorizontalGroup(
            a5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText56, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a5sLayout.setVerticalGroup(
            a5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText56)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a5s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a5s, gridBagConstraints);

        a6s.setBackground(new java.awt.Color(21, 21, 21));
        a6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText57.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText57.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText57.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText57.setText("A#");
        c1sharpText57.setAlignmentX(1.0F);
        c1sharpText57.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a6sLayout = new javax.swing.GroupLayout(a6s);
        a6s.setLayout(a6sLayout);
        a6sLayout.setHorizontalGroup(
            a6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText57, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a6sLayout.setVerticalGroup(
            a6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText57)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a6s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 42;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a6s, gridBagConstraints);

        a0.setBackground(new java.awt.Color(252, 252, 252));
        a0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a0.setPreferredSize(new java.awt.Dimension(25, 150));

        a0Text.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a0Text.setForeground(new java.awt.Color(150, 150, 150));
        a0Text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a0Text.setLabelFor(b0);
        a0Text.setText("A");
        a0Text.setAlignmentX(1.0F);
        a0Text.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a0Layout = new javax.swing.GroupLayout(a0);
        a0.setLayout(a0Layout);
        a0Layout.setHorizontalGroup(
            a0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a0Text, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a0Layout.setVerticalGroup(
            a0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a0Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a0Text, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(a0, gridBagConstraints);

        c1.setBackground(new java.awt.Color(252, 252, 252));
        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c1.setPreferredSize(new java.awt.Dimension(25, 150));

        a1text51.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        a1text51.setForeground(new java.awt.Color(150, 150, 150));
        a1text51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1text51.setLabelFor(b0);
        a1text51.setText("C");
        a1text51.setAlignmentX(1.0F);
        a1text51.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text51, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c1Layout.setVerticalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(a1text51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jLayeredPane1.add(c1, gridBagConstraints);

        a0s.setBackground(new java.awt.Color(21, 21, 21));
        a0s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText26.setBackground(new java.awt.Color(0, 0, 0));
        c1sharpText26.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText26.setForeground(new java.awt.Color(70, 70, 70));
        c1sharpText26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1sharpText26.setText("C#");
        c1sharpText26.setAlignmentX(1.0F);
        c1sharpText26.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout a0sLayout = new javax.swing.GroupLayout(a0s);
        a0s.setLayout(a0sLayout);
        a0sLayout.setHorizontalGroup(
            a0sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText26, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a0sLayout.setVerticalGroup(
            a0sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a0sLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1sharpText26)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        jLayeredPane1.setLayer(a0s, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jLayeredPane1.add(a0s, gridBagConstraints);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 640, 1320, 150);

        jLayeredPane2.setBackground(new java.awt.Color(51, 255, 102));
        jLayeredPane2.setOpaque(true);
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(1320, 635));
        jLayeredPane2.setLayout(new java.awt.GridBagLayout());

        noteAnimWhite1.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite1.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite1.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite1Layout = new javax.swing.GroupLayout(noteAnimWhite1);
        noteAnimWhite1.setLayout(noteAnimWhite1Layout);
        noteAnimWhite1Layout.setHorizontalGroup(
            noteAnimWhite1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite1Layout.setVerticalGroup(
            noteAnimWhite1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite1, gridBagConstraints);

        noteAnimWhite2.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite2.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite2.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite2Layout = new javax.swing.GroupLayout(noteAnimWhite2);
        noteAnimWhite2.setLayout(noteAnimWhite2Layout);
        noteAnimWhite2Layout.setHorizontalGroup(
            noteAnimWhite2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite2Layout.setVerticalGroup(
            noteAnimWhite2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite2, gridBagConstraints);

        noteAnimWhite3.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite3.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite3.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite3Layout = new javax.swing.GroupLayout(noteAnimWhite3);
        noteAnimWhite3.setLayout(noteAnimWhite3Layout);
        noteAnimWhite3Layout.setHorizontalGroup(
            noteAnimWhite3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite3Layout.setVerticalGroup(
            noteAnimWhite3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite3, gridBagConstraints);

        noteAnimWhite4.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite4.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite4.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite4Layout = new javax.swing.GroupLayout(noteAnimWhite4);
        noteAnimWhite4.setLayout(noteAnimWhite4Layout);
        noteAnimWhite4Layout.setHorizontalGroup(
            noteAnimWhite4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite4Layout.setVerticalGroup(
            noteAnimWhite4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite4, gridBagConstraints);

        noteAnimWhite5.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite5.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite5.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite5Layout = new javax.swing.GroupLayout(noteAnimWhite5);
        noteAnimWhite5.setLayout(noteAnimWhite5Layout);
        noteAnimWhite5Layout.setHorizontalGroup(
            noteAnimWhite5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite5Layout.setVerticalGroup(
            noteAnimWhite5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite5, gridBagConstraints);

        noteAnimWhite6.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite6.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite6.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite6Layout = new javax.swing.GroupLayout(noteAnimWhite6);
        noteAnimWhite6.setLayout(noteAnimWhite6Layout);
        noteAnimWhite6Layout.setHorizontalGroup(
            noteAnimWhite6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite6Layout.setVerticalGroup(
            noteAnimWhite6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite6, gridBagConstraints);

        noteAnimWhite7.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite7.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite7.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite7Layout = new javax.swing.GroupLayout(noteAnimWhite7);
        noteAnimWhite7.setLayout(noteAnimWhite7Layout);
        noteAnimWhite7Layout.setHorizontalGroup(
            noteAnimWhite7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite7Layout.setVerticalGroup(
            noteAnimWhite7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite7, gridBagConstraints);

        noteAnimWhite8.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite8.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite8.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite8Layout = new javax.swing.GroupLayout(noteAnimWhite8);
        noteAnimWhite8.setLayout(noteAnimWhite8Layout);
        noteAnimWhite8Layout.setHorizontalGroup(
            noteAnimWhite8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite8Layout.setVerticalGroup(
            noteAnimWhite8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite8, gridBagConstraints);

        noteAnimWhite9.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite9.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite9.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite9Layout = new javax.swing.GroupLayout(noteAnimWhite9);
        noteAnimWhite9.setLayout(noteAnimWhite9Layout);
        noteAnimWhite9Layout.setHorizontalGroup(
            noteAnimWhite9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite9Layout.setVerticalGroup(
            noteAnimWhite9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite9, gridBagConstraints);

        noteAnimWhite10.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite10.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite10.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite10Layout = new javax.swing.GroupLayout(noteAnimWhite10);
        noteAnimWhite10.setLayout(noteAnimWhite10Layout);
        noteAnimWhite10Layout.setHorizontalGroup(
            noteAnimWhite10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite10Layout.setVerticalGroup(
            noteAnimWhite10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite10, gridBagConstraints);

        noteAnimWhite11.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite11.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite11.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite11Layout = new javax.swing.GroupLayout(noteAnimWhite11);
        noteAnimWhite11.setLayout(noteAnimWhite11Layout);
        noteAnimWhite11Layout.setHorizontalGroup(
            noteAnimWhite11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite11Layout.setVerticalGroup(
            noteAnimWhite11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite11, gridBagConstraints);

        noteAnimWhite12.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite12.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite12.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite12Layout = new javax.swing.GroupLayout(noteAnimWhite12);
        noteAnimWhite12.setLayout(noteAnimWhite12Layout);
        noteAnimWhite12Layout.setHorizontalGroup(
            noteAnimWhite12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite12Layout.setVerticalGroup(
            noteAnimWhite12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite12, gridBagConstraints);

        noteAnimWhite13.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite13.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite13.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite13Layout = new javax.swing.GroupLayout(noteAnimWhite13);
        noteAnimWhite13.setLayout(noteAnimWhite13Layout);
        noteAnimWhite13Layout.setHorizontalGroup(
            noteAnimWhite13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite13Layout.setVerticalGroup(
            noteAnimWhite13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite13, gridBagConstraints);

        noteAnimWhite14.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite14.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite14.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite14Layout = new javax.swing.GroupLayout(noteAnimWhite14);
        noteAnimWhite14.setLayout(noteAnimWhite14Layout);
        noteAnimWhite14Layout.setHorizontalGroup(
            noteAnimWhite14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite14Layout.setVerticalGroup(
            noteAnimWhite14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite14, gridBagConstraints);

        noteAnimWhite15.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite15.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite15.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite15Layout = new javax.swing.GroupLayout(noteAnimWhite15);
        noteAnimWhite15.setLayout(noteAnimWhite15Layout);
        noteAnimWhite15Layout.setHorizontalGroup(
            noteAnimWhite15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite15Layout.setVerticalGroup(
            noteAnimWhite15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite15, gridBagConstraints);

        noteAnimWhite16.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite16.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite16.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite16Layout = new javax.swing.GroupLayout(noteAnimWhite16);
        noteAnimWhite16.setLayout(noteAnimWhite16Layout);
        noteAnimWhite16Layout.setHorizontalGroup(
            noteAnimWhite16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite16Layout.setVerticalGroup(
            noteAnimWhite16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite16, gridBagConstraints);

        noteAnimWhite17.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite17.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite17.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite17Layout = new javax.swing.GroupLayout(noteAnimWhite17);
        noteAnimWhite17.setLayout(noteAnimWhite17Layout);
        noteAnimWhite17Layout.setHorizontalGroup(
            noteAnimWhite17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite17Layout.setVerticalGroup(
            noteAnimWhite17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite17, gridBagConstraints);

        noteAnimWhite18.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite18.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite18.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite18Layout = new javax.swing.GroupLayout(noteAnimWhite18);
        noteAnimWhite18.setLayout(noteAnimWhite18Layout);
        noteAnimWhite18Layout.setHorizontalGroup(
            noteAnimWhite18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite18Layout.setVerticalGroup(
            noteAnimWhite18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite18, gridBagConstraints);

        noteAnimWhite19.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite19.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite19.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite19Layout = new javax.swing.GroupLayout(noteAnimWhite19);
        noteAnimWhite19.setLayout(noteAnimWhite19Layout);
        noteAnimWhite19Layout.setHorizontalGroup(
            noteAnimWhite19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite19Layout.setVerticalGroup(
            noteAnimWhite19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite19, gridBagConstraints);

        noteAnimWhite20.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite20.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite20.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite20Layout = new javax.swing.GroupLayout(noteAnimWhite20);
        noteAnimWhite20.setLayout(noteAnimWhite20Layout);
        noteAnimWhite20Layout.setHorizontalGroup(
            noteAnimWhite20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite20Layout.setVerticalGroup(
            noteAnimWhite20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite20, gridBagConstraints);

        noteAnimWhite21.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite21.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite21.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite21Layout = new javax.swing.GroupLayout(noteAnimWhite21);
        noteAnimWhite21.setLayout(noteAnimWhite21Layout);
        noteAnimWhite21Layout.setHorizontalGroup(
            noteAnimWhite21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite21Layout.setVerticalGroup(
            noteAnimWhite21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite21, gridBagConstraints);

        noteAnimWhite22.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite22.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite22.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite22Layout = new javax.swing.GroupLayout(noteAnimWhite22);
        noteAnimWhite22.setLayout(noteAnimWhite22Layout);
        noteAnimWhite22Layout.setHorizontalGroup(
            noteAnimWhite22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite22Layout.setVerticalGroup(
            noteAnimWhite22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite22, gridBagConstraints);

        noteAnimWhite23.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite23.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite23.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite23Layout = new javax.swing.GroupLayout(noteAnimWhite23);
        noteAnimWhite23.setLayout(noteAnimWhite23Layout);
        noteAnimWhite23Layout.setHorizontalGroup(
            noteAnimWhite23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite23Layout.setVerticalGroup(
            noteAnimWhite23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite23, gridBagConstraints);

        noteAnimWhite24.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite24.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite24.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite24Layout = new javax.swing.GroupLayout(noteAnimWhite24);
        noteAnimWhite24.setLayout(noteAnimWhite24Layout);
        noteAnimWhite24Layout.setHorizontalGroup(
            noteAnimWhite24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite24Layout.setVerticalGroup(
            noteAnimWhite24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite24, gridBagConstraints);

        noteAnimWhite25.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite25.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite25.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite25Layout = new javax.swing.GroupLayout(noteAnimWhite25);
        noteAnimWhite25.setLayout(noteAnimWhite25Layout);
        noteAnimWhite25Layout.setHorizontalGroup(
            noteAnimWhite25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite25Layout.setVerticalGroup(
            noteAnimWhite25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite25, gridBagConstraints);

        noteAnimWhite26.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite26.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite26.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite26Layout = new javax.swing.GroupLayout(noteAnimWhite26);
        noteAnimWhite26.setLayout(noteAnimWhite26Layout);
        noteAnimWhite26Layout.setHorizontalGroup(
            noteAnimWhite26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite26Layout.setVerticalGroup(
            noteAnimWhite26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite26, gridBagConstraints);

        noteAnimWhite27.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite27.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite27.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite27Layout = new javax.swing.GroupLayout(noteAnimWhite27);
        noteAnimWhite27.setLayout(noteAnimWhite27Layout);
        noteAnimWhite27Layout.setHorizontalGroup(
            noteAnimWhite27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite27Layout.setVerticalGroup(
            noteAnimWhite27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite27, gridBagConstraints);

        noteAnimWhite28.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite28.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite28.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite28Layout = new javax.swing.GroupLayout(noteAnimWhite28);
        noteAnimWhite28.setLayout(noteAnimWhite28Layout);
        noteAnimWhite28Layout.setHorizontalGroup(
            noteAnimWhite28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite28Layout.setVerticalGroup(
            noteAnimWhite28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite28, gridBagConstraints);

        noteAnimWhite29.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite29.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite29.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite29Layout = new javax.swing.GroupLayout(noteAnimWhite29);
        noteAnimWhite29.setLayout(noteAnimWhite29Layout);
        noteAnimWhite29Layout.setHorizontalGroup(
            noteAnimWhite29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite29Layout.setVerticalGroup(
            noteAnimWhite29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite29, gridBagConstraints);

        noteAnimWhite30.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite30.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite30.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite30Layout = new javax.swing.GroupLayout(noteAnimWhite30);
        noteAnimWhite30.setLayout(noteAnimWhite30Layout);
        noteAnimWhite30Layout.setHorizontalGroup(
            noteAnimWhite30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite30Layout.setVerticalGroup(
            noteAnimWhite30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite30, gridBagConstraints);

        noteAnimWhite31.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite31.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite31.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite31Layout = new javax.swing.GroupLayout(noteAnimWhite31);
        noteAnimWhite31.setLayout(noteAnimWhite31Layout);
        noteAnimWhite31Layout.setHorizontalGroup(
            noteAnimWhite31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite31Layout.setVerticalGroup(
            noteAnimWhite31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite31, gridBagConstraints);

        noteAnimWhite32.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite32.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite32.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite32Layout = new javax.swing.GroupLayout(noteAnimWhite32);
        noteAnimWhite32.setLayout(noteAnimWhite32Layout);
        noteAnimWhite32Layout.setHorizontalGroup(
            noteAnimWhite32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite32Layout.setVerticalGroup(
            noteAnimWhite32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite32, gridBagConstraints);

        noteAnimWhite33.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite33.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite33.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite33Layout = new javax.swing.GroupLayout(noteAnimWhite33);
        noteAnimWhite33.setLayout(noteAnimWhite33Layout);
        noteAnimWhite33Layout.setHorizontalGroup(
            noteAnimWhite33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite33Layout.setVerticalGroup(
            noteAnimWhite33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite33, gridBagConstraints);

        noteAnimWhite34.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite34.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite34.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite34Layout = new javax.swing.GroupLayout(noteAnimWhite34);
        noteAnimWhite34.setLayout(noteAnimWhite34Layout);
        noteAnimWhite34Layout.setHorizontalGroup(
            noteAnimWhite34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite34Layout.setVerticalGroup(
            noteAnimWhite34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite34, gridBagConstraints);

        noteAnimWhite35.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite35.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite35.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite35Layout = new javax.swing.GroupLayout(noteAnimWhite35);
        noteAnimWhite35.setLayout(noteAnimWhite35Layout);
        noteAnimWhite35Layout.setHorizontalGroup(
            noteAnimWhite35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite35Layout.setVerticalGroup(
            noteAnimWhite35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite35, gridBagConstraints);

        noteAnimWhite36.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite36.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite36.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite36Layout = new javax.swing.GroupLayout(noteAnimWhite36);
        noteAnimWhite36.setLayout(noteAnimWhite36Layout);
        noteAnimWhite36Layout.setHorizontalGroup(
            noteAnimWhite36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite36Layout.setVerticalGroup(
            noteAnimWhite36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite36, gridBagConstraints);

        noteAnimWhite37.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite37.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite37.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite37Layout = new javax.swing.GroupLayout(noteAnimWhite37);
        noteAnimWhite37.setLayout(noteAnimWhite37Layout);
        noteAnimWhite37Layout.setHorizontalGroup(
            noteAnimWhite37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite37Layout.setVerticalGroup(
            noteAnimWhite37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite37, gridBagConstraints);

        noteAnimWhite38.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite38.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite38.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite38Layout = new javax.swing.GroupLayout(noteAnimWhite38);
        noteAnimWhite38.setLayout(noteAnimWhite38Layout);
        noteAnimWhite38Layout.setHorizontalGroup(
            noteAnimWhite38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite38Layout.setVerticalGroup(
            noteAnimWhite38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite38, gridBagConstraints);

        noteAnimWhite39.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite39.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite39.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite39Layout = new javax.swing.GroupLayout(noteAnimWhite39);
        noteAnimWhite39.setLayout(noteAnimWhite39Layout);
        noteAnimWhite39Layout.setHorizontalGroup(
            noteAnimWhite39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite39Layout.setVerticalGroup(
            noteAnimWhite39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite39, gridBagConstraints);

        noteAnimWhite40.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite40.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite40.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite40Layout = new javax.swing.GroupLayout(noteAnimWhite40);
        noteAnimWhite40.setLayout(noteAnimWhite40Layout);
        noteAnimWhite40Layout.setHorizontalGroup(
            noteAnimWhite40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite40Layout.setVerticalGroup(
            noteAnimWhite40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite40, gridBagConstraints);

        noteAnimWhite41.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite41.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite41.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite41Layout = new javax.swing.GroupLayout(noteAnimWhite41);
        noteAnimWhite41.setLayout(noteAnimWhite41Layout);
        noteAnimWhite41Layout.setHorizontalGroup(
            noteAnimWhite41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite41Layout.setVerticalGroup(
            noteAnimWhite41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite41, gridBagConstraints);

        noteAnimWhite42.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite42.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite42.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite42Layout = new javax.swing.GroupLayout(noteAnimWhite42);
        noteAnimWhite42.setLayout(noteAnimWhite42Layout);
        noteAnimWhite42Layout.setHorizontalGroup(
            noteAnimWhite42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite42Layout.setVerticalGroup(
            noteAnimWhite42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite42, gridBagConstraints);

        noteAnimWhite43.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite43.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite43.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite43Layout = new javax.swing.GroupLayout(noteAnimWhite43);
        noteAnimWhite43.setLayout(noteAnimWhite43Layout);
        noteAnimWhite43Layout.setHorizontalGroup(
            noteAnimWhite43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite43Layout.setVerticalGroup(
            noteAnimWhite43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite43, gridBagConstraints);

        noteAnimWhite44.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite44.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite44.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite44Layout = new javax.swing.GroupLayout(noteAnimWhite44);
        noteAnimWhite44.setLayout(noteAnimWhite44Layout);
        noteAnimWhite44Layout.setHorizontalGroup(
            noteAnimWhite44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite44Layout.setVerticalGroup(
            noteAnimWhite44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite44, gridBagConstraints);

        noteAnimWhite45.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite45.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite45.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite45Layout = new javax.swing.GroupLayout(noteAnimWhite45);
        noteAnimWhite45.setLayout(noteAnimWhite45Layout);
        noteAnimWhite45Layout.setHorizontalGroup(
            noteAnimWhite45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite45Layout.setVerticalGroup(
            noteAnimWhite45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite45, gridBagConstraints);

        noteAnimWhite46.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite46.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite46.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite46Layout = new javax.swing.GroupLayout(noteAnimWhite46);
        noteAnimWhite46.setLayout(noteAnimWhite46Layout);
        noteAnimWhite46Layout.setHorizontalGroup(
            noteAnimWhite46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite46Layout.setVerticalGroup(
            noteAnimWhite46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite46, gridBagConstraints);

        noteAnimWhite47.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite47.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite47.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite47Layout = new javax.swing.GroupLayout(noteAnimWhite47);
        noteAnimWhite47.setLayout(noteAnimWhite47Layout);
        noteAnimWhite47Layout.setHorizontalGroup(
            noteAnimWhite47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite47Layout.setVerticalGroup(
            noteAnimWhite47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite47, gridBagConstraints);

        noteAnimWhite48.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite48.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite48.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite48Layout = new javax.swing.GroupLayout(noteAnimWhite48);
        noteAnimWhite48.setLayout(noteAnimWhite48Layout);
        noteAnimWhite48Layout.setHorizontalGroup(
            noteAnimWhite48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite48Layout.setVerticalGroup(
            noteAnimWhite48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite48, gridBagConstraints);

        noteAnimWhite49.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite49.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite49.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite49Layout = new javax.swing.GroupLayout(noteAnimWhite49);
        noteAnimWhite49.setLayout(noteAnimWhite49Layout);
        noteAnimWhite49Layout.setHorizontalGroup(
            noteAnimWhite49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite49Layout.setVerticalGroup(
            noteAnimWhite49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite49, gridBagConstraints);

        noteAnimWhite50.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite50.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite50.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite50Layout = new javax.swing.GroupLayout(noteAnimWhite50);
        noteAnimWhite50.setLayout(noteAnimWhite50Layout);
        noteAnimWhite50Layout.setHorizontalGroup(
            noteAnimWhite50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite50Layout.setVerticalGroup(
            noteAnimWhite50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite50, gridBagConstraints);

        noteAnimWhite51.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite51.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite51.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite51Layout = new javax.swing.GroupLayout(noteAnimWhite51);
        noteAnimWhite51.setLayout(noteAnimWhite51Layout);
        noteAnimWhite51Layout.setHorizontalGroup(
            noteAnimWhite51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite51Layout.setVerticalGroup(
            noteAnimWhite51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite51, gridBagConstraints);

        noteAnimWhite52.setBackground(new java.awt.Color(50, 50, 50));
        noteAnimWhite52.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimWhite52.setPreferredSize(new java.awt.Dimension(25, 635));

        javax.swing.GroupLayout noteAnimWhite52Layout = new javax.swing.GroupLayout(noteAnimWhite52);
        noteAnimWhite52.setLayout(noteAnimWhite52Layout);
        noteAnimWhite52Layout.setHorizontalGroup(
            noteAnimWhite52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        noteAnimWhite52Layout.setVerticalGroup(
            noteAnimWhite52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimWhite52, gridBagConstraints);

        noteAnimBlack1.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack1.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack1.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack1Layout = new javax.swing.GroupLayout(noteAnimBlack1);
        noteAnimBlack1.setLayout(noteAnimBlack1Layout);
        noteAnimBlack1Layout.setHorizontalGroup(
            noteAnimBlack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack1Layout.setVerticalGroup(
            noteAnimBlack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack1, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack1, gridBagConstraints);

        noteAnimBlack2.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack2.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack2.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack2Layout = new javax.swing.GroupLayout(noteAnimBlack2);
        noteAnimBlack2.setLayout(noteAnimBlack2Layout);
        noteAnimBlack2Layout.setHorizontalGroup(
            noteAnimBlack2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack2Layout.setVerticalGroup(
            noteAnimBlack2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack2, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack2, gridBagConstraints);

        noteAnimBlack3.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack3.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack3.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack3Layout = new javax.swing.GroupLayout(noteAnimBlack3);
        noteAnimBlack3.setLayout(noteAnimBlack3Layout);
        noteAnimBlack3Layout.setHorizontalGroup(
            noteAnimBlack3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack3Layout.setVerticalGroup(
            noteAnimBlack3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack3, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack3, gridBagConstraints);

        noteAnimBlack4.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack4.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack4.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack4Layout = new javax.swing.GroupLayout(noteAnimBlack4);
        noteAnimBlack4.setLayout(noteAnimBlack4Layout);
        noteAnimBlack4Layout.setHorizontalGroup(
            noteAnimBlack4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack4Layout.setVerticalGroup(
            noteAnimBlack4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack4, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack4, gridBagConstraints);

        noteAnimBlack5.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack5.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack5.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack5Layout = new javax.swing.GroupLayout(noteAnimBlack5);
        noteAnimBlack5.setLayout(noteAnimBlack5Layout);
        noteAnimBlack5Layout.setHorizontalGroup(
            noteAnimBlack5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack5Layout.setVerticalGroup(
            noteAnimBlack5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack5, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack5, gridBagConstraints);

        noteAnimBlack6.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack6.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack6.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack6Layout = new javax.swing.GroupLayout(noteAnimBlack6);
        noteAnimBlack6.setLayout(noteAnimBlack6Layout);
        noteAnimBlack6Layout.setHorizontalGroup(
            noteAnimBlack6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack6Layout.setVerticalGroup(
            noteAnimBlack6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack6, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack6, gridBagConstraints);

        noteAnimBlack7.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack7.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack7.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack7Layout = new javax.swing.GroupLayout(noteAnimBlack7);
        noteAnimBlack7.setLayout(noteAnimBlack7Layout);
        noteAnimBlack7Layout.setHorizontalGroup(
            noteAnimBlack7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack7Layout.setVerticalGroup(
            noteAnimBlack7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack7, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack7, gridBagConstraints);

        noteAnimBlack8.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack8.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack8.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack8Layout = new javax.swing.GroupLayout(noteAnimBlack8);
        noteAnimBlack8.setLayout(noteAnimBlack8Layout);
        noteAnimBlack8Layout.setHorizontalGroup(
            noteAnimBlack8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack8Layout.setVerticalGroup(
            noteAnimBlack8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack8, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack8, gridBagConstraints);

        noteAnimBlack9.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack9.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack9.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack9Layout = new javax.swing.GroupLayout(noteAnimBlack9);
        noteAnimBlack9.setLayout(noteAnimBlack9Layout);
        noteAnimBlack9Layout.setHorizontalGroup(
            noteAnimBlack9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack9Layout.setVerticalGroup(
            noteAnimBlack9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack9, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack9, gridBagConstraints);

        noteAnimBlack10.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack10.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack10.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack10Layout = new javax.swing.GroupLayout(noteAnimBlack10);
        noteAnimBlack10.setLayout(noteAnimBlack10Layout);
        noteAnimBlack10Layout.setHorizontalGroup(
            noteAnimBlack10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack10Layout.setVerticalGroup(
            noteAnimBlack10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack10, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack10, gridBagConstraints);

        noteAnimBlack11.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack11.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack11.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack11Layout = new javax.swing.GroupLayout(noteAnimBlack11);
        noteAnimBlack11.setLayout(noteAnimBlack11Layout);
        noteAnimBlack11Layout.setHorizontalGroup(
            noteAnimBlack11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack11Layout.setVerticalGroup(
            noteAnimBlack11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack11, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack11, gridBagConstraints);

        noteAnimBlack12.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack12.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack12.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack12Layout = new javax.swing.GroupLayout(noteAnimBlack12);
        noteAnimBlack12.setLayout(noteAnimBlack12Layout);
        noteAnimBlack12Layout.setHorizontalGroup(
            noteAnimBlack12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack12Layout.setVerticalGroup(
            noteAnimBlack12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack12, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack12, gridBagConstraints);

        noteAnimBlack13.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack13.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack13.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack13Layout = new javax.swing.GroupLayout(noteAnimBlack13);
        noteAnimBlack13.setLayout(noteAnimBlack13Layout);
        noteAnimBlack13Layout.setHorizontalGroup(
            noteAnimBlack13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack13Layout.setVerticalGroup(
            noteAnimBlack13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack13, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack13, gridBagConstraints);

        noteAnimBlack14.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack14.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack14.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack14Layout = new javax.swing.GroupLayout(noteAnimBlack14);
        noteAnimBlack14.setLayout(noteAnimBlack14Layout);
        noteAnimBlack14Layout.setHorizontalGroup(
            noteAnimBlack14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack14Layout.setVerticalGroup(
            noteAnimBlack14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack14, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack14, gridBagConstraints);

        noteAnimBlack15.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack15.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack15.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack15Layout = new javax.swing.GroupLayout(noteAnimBlack15);
        noteAnimBlack15.setLayout(noteAnimBlack15Layout);
        noteAnimBlack15Layout.setHorizontalGroup(
            noteAnimBlack15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack15Layout.setVerticalGroup(
            noteAnimBlack15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack15, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack15, gridBagConstraints);

        noteAnimBlack16.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack16.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack16.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack16Layout = new javax.swing.GroupLayout(noteAnimBlack16);
        noteAnimBlack16.setLayout(noteAnimBlack16Layout);
        noteAnimBlack16Layout.setHorizontalGroup(
            noteAnimBlack16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack16Layout.setVerticalGroup(
            noteAnimBlack16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack16, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack16, gridBagConstraints);

        noteAnimBlack17.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack17.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack17.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack17Layout = new javax.swing.GroupLayout(noteAnimBlack17);
        noteAnimBlack17.setLayout(noteAnimBlack17Layout);
        noteAnimBlack17Layout.setHorizontalGroup(
            noteAnimBlack17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack17Layout.setVerticalGroup(
            noteAnimBlack17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack17, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack17, gridBagConstraints);

        noteAnimBlack18.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack18.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack18.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack18Layout = new javax.swing.GroupLayout(noteAnimBlack18);
        noteAnimBlack18.setLayout(noteAnimBlack18Layout);
        noteAnimBlack18Layout.setHorizontalGroup(
            noteAnimBlack18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack18Layout.setVerticalGroup(
            noteAnimBlack18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack18, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack18, gridBagConstraints);

        noteAnimBlack19.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack19.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack19.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack19Layout = new javax.swing.GroupLayout(noteAnimBlack19);
        noteAnimBlack19.setLayout(noteAnimBlack19Layout);
        noteAnimBlack19Layout.setHorizontalGroup(
            noteAnimBlack19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack19Layout.setVerticalGroup(
            noteAnimBlack19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack19, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack19, gridBagConstraints);

        noteAnimBlack20.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack20.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack20.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack20Layout = new javax.swing.GroupLayout(noteAnimBlack20);
        noteAnimBlack20.setLayout(noteAnimBlack20Layout);
        noteAnimBlack20Layout.setHorizontalGroup(
            noteAnimBlack20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack20Layout.setVerticalGroup(
            noteAnimBlack20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack20, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack20, gridBagConstraints);

        noteAnimBlack21.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack21.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack21.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack21Layout = new javax.swing.GroupLayout(noteAnimBlack21);
        noteAnimBlack21.setLayout(noteAnimBlack21Layout);
        noteAnimBlack21Layout.setHorizontalGroup(
            noteAnimBlack21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack21Layout.setVerticalGroup(
            noteAnimBlack21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack21, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack21, gridBagConstraints);

        noteAnimBlack22.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack22.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack22.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack22Layout = new javax.swing.GroupLayout(noteAnimBlack22);
        noteAnimBlack22.setLayout(noteAnimBlack22Layout);
        noteAnimBlack22Layout.setHorizontalGroup(
            noteAnimBlack22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack22Layout.setVerticalGroup(
            noteAnimBlack22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack22, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack22, gridBagConstraints);

        noteAnimBlack23.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack23.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack23.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack23Layout = new javax.swing.GroupLayout(noteAnimBlack23);
        noteAnimBlack23.setLayout(noteAnimBlack23Layout);
        noteAnimBlack23Layout.setHorizontalGroup(
            noteAnimBlack23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack23Layout.setVerticalGroup(
            noteAnimBlack23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack23, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack23, gridBagConstraints);

        noteAnimBlack24.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack24.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack24.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack24Layout = new javax.swing.GroupLayout(noteAnimBlack24);
        noteAnimBlack24.setLayout(noteAnimBlack24Layout);
        noteAnimBlack24Layout.setHorizontalGroup(
            noteAnimBlack24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack24Layout.setVerticalGroup(
            noteAnimBlack24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack24, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack24, gridBagConstraints);

        noteAnimBlack25.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack25.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack25.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack25Layout = new javax.swing.GroupLayout(noteAnimBlack25);
        noteAnimBlack25.setLayout(noteAnimBlack25Layout);
        noteAnimBlack25Layout.setHorizontalGroup(
            noteAnimBlack25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack25Layout.setVerticalGroup(
            noteAnimBlack25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack25, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack25, gridBagConstraints);

        noteAnimBlack26.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack26.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack26.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack26Layout = new javax.swing.GroupLayout(noteAnimBlack26);
        noteAnimBlack26.setLayout(noteAnimBlack26Layout);
        noteAnimBlack26Layout.setHorizontalGroup(
            noteAnimBlack26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack26Layout.setVerticalGroup(
            noteAnimBlack26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack26, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack26, gridBagConstraints);

        noteAnimBlack27.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack27.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack27.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack27Layout = new javax.swing.GroupLayout(noteAnimBlack27);
        noteAnimBlack27.setLayout(noteAnimBlack27Layout);
        noteAnimBlack27Layout.setHorizontalGroup(
            noteAnimBlack27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack27Layout.setVerticalGroup(
            noteAnimBlack27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack27, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack27, gridBagConstraints);

        noteAnimBlack28.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack28.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack28.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack28Layout = new javax.swing.GroupLayout(noteAnimBlack28);
        noteAnimBlack28.setLayout(noteAnimBlack28Layout);
        noteAnimBlack28Layout.setHorizontalGroup(
            noteAnimBlack28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack28Layout.setVerticalGroup(
            noteAnimBlack28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack28, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 38;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack28, gridBagConstraints);

        noteAnimBlack29.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack29.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack29.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack29Layout = new javax.swing.GroupLayout(noteAnimBlack29);
        noteAnimBlack29.setLayout(noteAnimBlack29Layout);
        noteAnimBlack29Layout.setHorizontalGroup(
            noteAnimBlack29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack29Layout.setVerticalGroup(
            noteAnimBlack29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack29, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack29, gridBagConstraints);

        noteAnimBlack30.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack30.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack30.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack30Layout = new javax.swing.GroupLayout(noteAnimBlack30);
        noteAnimBlack30.setLayout(noteAnimBlack30Layout);
        noteAnimBlack30Layout.setHorizontalGroup(
            noteAnimBlack30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack30Layout.setVerticalGroup(
            noteAnimBlack30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack30, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack30, gridBagConstraints);

        noteAnimBlack31.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack31.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack31.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack31Layout = new javax.swing.GroupLayout(noteAnimBlack31);
        noteAnimBlack31.setLayout(noteAnimBlack31Layout);
        noteAnimBlack31Layout.setHorizontalGroup(
            noteAnimBlack31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack31Layout.setVerticalGroup(
            noteAnimBlack31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack31, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 42;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack31, gridBagConstraints);

        noteAnimBlack32.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack32.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack32.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack32Layout = new javax.swing.GroupLayout(noteAnimBlack32);
        noteAnimBlack32.setLayout(noteAnimBlack32Layout);
        noteAnimBlack32Layout.setHorizontalGroup(
            noteAnimBlack32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack32Layout.setVerticalGroup(
            noteAnimBlack32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack32, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack32, gridBagConstraints);

        noteAnimBlack33.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack33.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack33.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack33Layout = new javax.swing.GroupLayout(noteAnimBlack33);
        noteAnimBlack33.setLayout(noteAnimBlack33Layout);
        noteAnimBlack33Layout.setHorizontalGroup(
            noteAnimBlack33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack33Layout.setVerticalGroup(
            noteAnimBlack33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack33, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack33, gridBagConstraints);

        noteAnimBlack34.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack34.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack34.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack34Layout = new javax.swing.GroupLayout(noteAnimBlack34);
        noteAnimBlack34.setLayout(noteAnimBlack34Layout);
        noteAnimBlack34Layout.setHorizontalGroup(
            noteAnimBlack34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack34Layout.setVerticalGroup(
            noteAnimBlack34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack34, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack34, gridBagConstraints);

        noteAnimBlack35.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack35.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack35.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack35Layout = new javax.swing.GroupLayout(noteAnimBlack35);
        noteAnimBlack35.setLayout(noteAnimBlack35Layout);
        noteAnimBlack35Layout.setHorizontalGroup(
            noteAnimBlack35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack35Layout.setVerticalGroup(
            noteAnimBlack35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack35, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack35, gridBagConstraints);

        noteAnimBlack36.setBackground(new java.awt.Color(38, 38, 38));
        noteAnimBlack36.setMaximumSize(new java.awt.Dimension(32767, 100000));
        noteAnimBlack36.setPreferredSize(new java.awt.Dimension(15, 635));

        javax.swing.GroupLayout noteAnimBlack36Layout = new javax.swing.GroupLayout(noteAnimBlack36);
        noteAnimBlack36.setLayout(noteAnimBlack36Layout);
        noteAnimBlack36Layout.setHorizontalGroup(
            noteAnimBlack36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        noteAnimBlack36Layout.setVerticalGroup(
            noteAnimBlack36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(noteAnimBlack36, javax.swing.JLayeredPane.MODAL_LAYER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 49;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        jLayeredPane2.add(noteAnimBlack36, gridBagConstraints);

        getContentPane().add(jLayeredPane2);
        jLayeredPane2.setBounds(0, -15, 1320, 650);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(1320, 5));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1320, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 635, 1320, 5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PianoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PianoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PianoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PianoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PianoGUI piano;
                try {
                    piano = new PianoGUI();
                    
                    piano.setVisible(true);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(PianoGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PianoGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(PianoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a0;
    private javax.swing.JLabel a0Text;
    private javax.swing.JPanel a0s;
    private javax.swing.JPanel a1;
    private javax.swing.JPanel a1s;
    private javax.swing.JLabel a1text16;
    private javax.swing.JLabel a1text17;
    private javax.swing.JLabel a1text18;
    private javax.swing.JLabel a1text19;
    private javax.swing.JLabel a1text20;
    private javax.swing.JLabel a1text21;
    private javax.swing.JLabel a1text22;
    private javax.swing.JLabel a1text23;
    private javax.swing.JLabel a1text24;
    private javax.swing.JLabel a1text25;
    private javax.swing.JLabel a1text26;
    private javax.swing.JLabel a1text27;
    private javax.swing.JLabel a1text29;
    private javax.swing.JLabel a1text30;
    private javax.swing.JLabel a1text31;
    private javax.swing.JLabel a1text32;
    private javax.swing.JLabel a1text33;
    private javax.swing.JLabel a1text34;
    private javax.swing.JLabel a1text35;
    private javax.swing.JLabel a1text36;
    private javax.swing.JLabel a1text37;
    private javax.swing.JLabel a1text38;
    private javax.swing.JLabel a1text39;
    private javax.swing.JLabel a1text40;
    private javax.swing.JLabel a1text41;
    private javax.swing.JLabel a1text42;
    private javax.swing.JLabel a1text43;
    private javax.swing.JLabel a1text44;
    private javax.swing.JLabel a1text45;
    private javax.swing.JLabel a1text46;
    private javax.swing.JLabel a1text47;
    private javax.swing.JLabel a1text48;
    private javax.swing.JLabel a1text49;
    private javax.swing.JLabel a1text50;
    private javax.swing.JLabel a1text51;
    private javax.swing.JLabel a1text52;
    private javax.swing.JLabel a1text53;
    private javax.swing.JLabel a1text54;
    private javax.swing.JLabel a1text55;
    private javax.swing.JLabel a1text56;
    private javax.swing.JLabel a1text57;
    private javax.swing.JLabel a1text58;
    private javax.swing.JLabel a1text59;
    private javax.swing.JLabel a1text60;
    private javax.swing.JLabel a1text61;
    private javax.swing.JLabel a1text62;
    private javax.swing.JLabel a1text63;
    private javax.swing.JLabel a1text64;
    private javax.swing.JLabel a1text65;
    private javax.swing.JLabel a1text66;
    private javax.swing.JLabel a1text67;
    private javax.swing.JLabel a1text68;
    private javax.swing.JLabel a1text69;
    private javax.swing.JLabel a1text70;
    private javax.swing.JLabel a1text71;
    private javax.swing.JPanel a2;
    private javax.swing.JPanel a2s;
    private javax.swing.JPanel a3;
    private javax.swing.JPanel a3s;
    private javax.swing.JPanel a4;
    private javax.swing.JPanel a4s;
    private javax.swing.JPanel a5;
    private javax.swing.JPanel a5s;
    private javax.swing.JPanel a6;
    private javax.swing.JPanel a6s;
    private javax.swing.JPanel a7;
    private javax.swing.JPanel a7s;
    private javax.swing.JPanel b0;
    private javax.swing.JPanel b1;
    private javax.swing.JPanel b18;
    private javax.swing.JPanel b19;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JPanel b5;
    private javax.swing.JPanel b6;
    private javax.swing.JPanel b7;
    private javax.swing.JPanel c1;
    private javax.swing.JPanel c10;
    private javax.swing.JPanel c1s;
    private javax.swing.JLabel c1sharpText18;
    private javax.swing.JLabel c1sharpText19;
    private javax.swing.JLabel c1sharpText20;
    private javax.swing.JLabel c1sharpText21;
    private javax.swing.JLabel c1sharpText22;
    private javax.swing.JLabel c1sharpText23;
    private javax.swing.JLabel c1sharpText24;
    private javax.swing.JLabel c1sharpText26;
    private javax.swing.JLabel c1sharpText28;
    private javax.swing.JLabel c1sharpText29;
    private javax.swing.JLabel c1sharpText30;
    private javax.swing.JLabel c1sharpText31;
    private javax.swing.JLabel c1sharpText32;
    private javax.swing.JLabel c1sharpText34;
    private javax.swing.JLabel c1sharpText35;
    private javax.swing.JLabel c1sharpText37;
    private javax.swing.JLabel c1sharpText38;
    private javax.swing.JLabel c1sharpText39;
    private javax.swing.JLabel c1sharpText40;
    private javax.swing.JLabel c1sharpText41;
    private javax.swing.JLabel c1sharpText42;
    private javax.swing.JLabel c1sharpText43;
    private javax.swing.JLabel c1sharpText44;
    private javax.swing.JLabel c1sharpText45;
    private javax.swing.JLabel c1sharpText46;
    private javax.swing.JLabel c1sharpText47;
    private javax.swing.JLabel c1sharpText48;
    private javax.swing.JLabel c1sharpText49;
    private javax.swing.JLabel c1sharpText51;
    private javax.swing.JLabel c1sharpText52;
    private javax.swing.JLabel c1sharpText53;
    private javax.swing.JLabel c1sharpText54;
    private javax.swing.JLabel c1sharpText55;
    private javax.swing.JLabel c1sharpText56;
    private javax.swing.JLabel c1sharpText57;
    private javax.swing.JPanel c2;
    private javax.swing.JPanel c2s;
    private javax.swing.JPanel c3;
    private javax.swing.JPanel c3s;
    private javax.swing.JPanel c4;
    private javax.swing.JPanel c4s;
    private javax.swing.JPanel c5;
    private javax.swing.JPanel c5s;
    private javax.swing.JPanel c6;
    private javax.swing.JPanel c6s;
    private javax.swing.JPanel c7;
    private javax.swing.JPanel c7s;
    private javax.swing.JPanel c8;
    private javax.swing.JPanel d1;
    private javax.swing.JPanel d1s;
    private javax.swing.JLabel d1sharpText1;
    private javax.swing.JPanel d2;
    private javax.swing.JPanel d2s;
    private javax.swing.JPanel d3;
    private javax.swing.JPanel d3s;
    private javax.swing.JPanel d4;
    private javax.swing.JPanel d4s;
    private javax.swing.JPanel d5;
    private javax.swing.JPanel d5s;
    private javax.swing.JPanel d6;
    private javax.swing.JPanel d6s;
    private javax.swing.JPanel d7;
    private javax.swing.JPanel d7s;
    private javax.swing.JPanel e1;
    private javax.swing.JPanel e2;
    private javax.swing.JPanel e3;
    private javax.swing.JPanel e4;
    private javax.swing.JPanel e5;
    private javax.swing.JPanel e6;
    private javax.swing.JPanel e7;
    private javax.swing.JPanel f1;
    private javax.swing.JPanel f1s;
    private javax.swing.JPanel f2;
    private javax.swing.JPanel f2s;
    private javax.swing.JPanel f3;
    private javax.swing.JPanel f3s;
    private javax.swing.JPanel f4;
    private javax.swing.JPanel f4s;
    private javax.swing.JPanel f5;
    private javax.swing.JPanel f5s;
    private javax.swing.JPanel f6;
    private javax.swing.JPanel f6s;
    private javax.swing.JPanel f7;
    private javax.swing.JPanel f7s;
    private javax.swing.JPanel g1;
    private javax.swing.JPanel g1s;
    private javax.swing.JPanel g2;
    private javax.swing.JPanel g2s;
    private javax.swing.JPanel g3;
    private javax.swing.JPanel g3s;
    private javax.swing.JPanel g4;
    private javax.swing.JPanel g4s;
    private javax.swing.JPanel g5;
    private javax.swing.JPanel g5s;
    private javax.swing.JPanel g6;
    private javax.swing.JPanel g6s;
    private javax.swing.JPanel g7;
    private javax.swing.JPanel g7s;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private newpackage.PianoGraphics noteAnimBlack1;
    private newpackage.PianoGraphics noteAnimBlack10;
    private newpackage.PianoGraphics noteAnimBlack11;
    private newpackage.PianoGraphics noteAnimBlack12;
    private newpackage.PianoGraphics noteAnimBlack13;
    private newpackage.PianoGraphics noteAnimBlack14;
    private newpackage.PianoGraphics noteAnimBlack15;
    private newpackage.PianoGraphics noteAnimBlack16;
    private newpackage.PianoGraphics noteAnimBlack17;
    private newpackage.PianoGraphics noteAnimBlack18;
    private newpackage.PianoGraphics noteAnimBlack19;
    private newpackage.PianoGraphics noteAnimBlack2;
    private newpackage.PianoGraphics noteAnimBlack20;
    private newpackage.PianoGraphics noteAnimBlack21;
    private newpackage.PianoGraphics noteAnimBlack22;
    private newpackage.PianoGraphics noteAnimBlack23;
    private newpackage.PianoGraphics noteAnimBlack24;
    private newpackage.PianoGraphics noteAnimBlack25;
    private newpackage.PianoGraphics noteAnimBlack26;
    private newpackage.PianoGraphics noteAnimBlack27;
    private newpackage.PianoGraphics noteAnimBlack28;
    private newpackage.PianoGraphics noteAnimBlack29;
    private newpackage.PianoGraphics noteAnimBlack3;
    private newpackage.PianoGraphics noteAnimBlack30;
    private newpackage.PianoGraphics noteAnimBlack31;
    private newpackage.PianoGraphics noteAnimBlack32;
    private newpackage.PianoGraphics noteAnimBlack33;
    private newpackage.PianoGraphics noteAnimBlack34;
    private newpackage.PianoGraphics noteAnimBlack35;
    private newpackage.PianoGraphics noteAnimBlack36;
    private newpackage.PianoGraphics noteAnimBlack4;
    private newpackage.PianoGraphics noteAnimBlack5;
    private newpackage.PianoGraphics noteAnimBlack6;
    private newpackage.PianoGraphics noteAnimBlack7;
    private newpackage.PianoGraphics noteAnimBlack8;
    private newpackage.PianoGraphics noteAnimBlack9;
    private newpackage.PianoGraphics noteAnimWhite1;
    private newpackage.PianoGraphics noteAnimWhite10;
    private newpackage.PianoGraphics noteAnimWhite11;
    private newpackage.PianoGraphics noteAnimWhite12;
    private newpackage.PianoGraphics noteAnimWhite13;
    private newpackage.PianoGraphics noteAnimWhite14;
    private newpackage.PianoGraphics noteAnimWhite15;
    private newpackage.PianoGraphics noteAnimWhite16;
    private newpackage.PianoGraphics noteAnimWhite17;
    private newpackage.PianoGraphics noteAnimWhite18;
    private newpackage.PianoGraphics noteAnimWhite19;
    private newpackage.PianoGraphics noteAnimWhite2;
    private newpackage.PianoGraphics noteAnimWhite20;
    private newpackage.PianoGraphics noteAnimWhite21;
    private newpackage.PianoGraphics noteAnimWhite22;
    private newpackage.PianoGraphics noteAnimWhite23;
    private newpackage.PianoGraphics noteAnimWhite24;
    private newpackage.PianoGraphics noteAnimWhite25;
    private newpackage.PianoGraphics noteAnimWhite26;
    private newpackage.PianoGraphics noteAnimWhite27;
    private newpackage.PianoGraphics noteAnimWhite28;
    private newpackage.PianoGraphics noteAnimWhite29;
    private newpackage.PianoGraphics noteAnimWhite3;
    private newpackage.PianoGraphics noteAnimWhite30;
    private newpackage.PianoGraphics noteAnimWhite31;
    private newpackage.PianoGraphics noteAnimWhite32;
    private newpackage.PianoGraphics noteAnimWhite33;
    private newpackage.PianoGraphics noteAnimWhite34;
    private newpackage.PianoGraphics noteAnimWhite35;
    private newpackage.PianoGraphics noteAnimWhite36;
    private newpackage.PianoGraphics noteAnimWhite37;
    private newpackage.PianoGraphics noteAnimWhite38;
    private newpackage.PianoGraphics noteAnimWhite39;
    private newpackage.PianoGraphics noteAnimWhite4;
    private newpackage.PianoGraphics noteAnimWhite40;
    private newpackage.PianoGraphics noteAnimWhite41;
    private newpackage.PianoGraphics noteAnimWhite42;
    private newpackage.PianoGraphics noteAnimWhite43;
    private newpackage.PianoGraphics noteAnimWhite44;
    private newpackage.PianoGraphics noteAnimWhite45;
    private newpackage.PianoGraphics noteAnimWhite46;
    private newpackage.PianoGraphics noteAnimWhite47;
    private newpackage.PianoGraphics noteAnimWhite48;
    private newpackage.PianoGraphics noteAnimWhite49;
    private newpackage.PianoGraphics noteAnimWhite5;
    private newpackage.PianoGraphics noteAnimWhite50;
    private newpackage.PianoGraphics noteAnimWhite51;
    private newpackage.PianoGraphics noteAnimWhite52;
    private newpackage.PianoGraphics noteAnimWhite6;
    private newpackage.PianoGraphics noteAnimWhite7;
    private newpackage.PianoGraphics noteAnimWhite8;
    private newpackage.PianoGraphics noteAnimWhite9;
    // End of variables declaration//GEN-END:variables
}
