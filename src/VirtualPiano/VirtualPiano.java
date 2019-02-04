/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.awt.Color;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author adria_000
 */
public class VirtualPiano extends javax.swing.JFrame {
    
    
    initiateProgram initProgram = new initiateProgram();
    
    List<JLayeredPane> keyList = new ArrayList();
        
    
    
    /**
     * Creates new form VirtualPiano
     */
    public VirtualPiano() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        initComponents();
        initializeArrayList();
    }

    public JLayeredPane createNotePanel(int key) {
        JLayeredPane panel = keyList.get(key);
        panel.setBackground(Color.green);
        return panel;
    }
    
    public JLayeredPane setKeyColor (int key) {
        JLayeredPane panel = keyList.get(key);
        panel.setBackground(Color.green);
        return panel;
    }
    
    public void colorKey (int key, boolean keyOn) {
        if(keyOn) {
            //if() {
                JLayeredPane panel = keyList.get(key);
                panel.setBackground(Color.green);
            //}
        }
        else if(keyOn == false) {
            //if() {
                JLayeredPane panel = keyList.get(key);
                panel.setBackground(Color.white);
            //}
        }
    }
    
    public void initializeArrayList() {
        
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
        keyList.add(b4);

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
    
    public void keyDisplayNote (MidiMessage message) {
        
        ShortMessage sm = (ShortMessage) message;
        int key = (sm.getData1()-21);
        int channel = sm.getChannel();
        
        if (sm.getCommand() == NOTE_ON) {
            int velocity = sm.getData2();
                
            if (key < 87) {
                try {
                colorKey(key, true);
                System.out.println("Key on: " + key);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            else if (key > 87) {
                System.out.println("S");
            }
                //System.out.println(keyList.get(key) + " Velocity: " + velocity);
        } 
            else if (sm.getCommand() == NOTE_OFF) {
                int velocity = sm.getData2();
                
                if (key < 87) {
                    try {
                        colorKey(key, false);
                        System.out.println("Key off: " + key);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else if (key > 87) {
                    System.out.println("S");
                }
                //System.out.println(key + " " + velocity);
            } 
            else {
                System.out.println("Command:" + sm.getCommand());
            }
    }
    
    private void playNoteAnimation(JPanel panel) {
        
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

        keyboardPanel = new javax.swing.JPanel();
        a0s = new javax.swing.JLayeredPane();
        a1sharpText = new javax.swing.JLabel();
        c8 = new javax.swing.JLayeredPane();
        c1Text = new javax.swing.JLabel();
        a0 = new javax.swing.JLayeredPane();
        a1text = new javax.swing.JLabel();
        b0 = new javax.swing.JLayeredPane();
        b1Text = new javax.swing.JLabel();
        d6s = new javax.swing.JLayeredPane();
        d1sharpText12 = new javax.swing.JLabel();
        c6s = new javax.swing.JLayeredPane();
        c1sharpText1 = new javax.swing.JLabel();
        f6s = new javax.swing.JLayeredPane();
        f1sharpText1 = new javax.swing.JLabel();
        a6s = new javax.swing.JLayeredPane();
        a1sharpText1 = new javax.swing.JLabel();
        g6s = new javax.swing.JLayeredPane();
        g1sharpText1 = new javax.swing.JLabel();
        c6 = new javax.swing.JLayeredPane();
        c1Text1 = new javax.swing.JLabel();
        d6 = new javax.swing.JLayeredPane();
        d1Text1 = new javax.swing.JLabel();
        e6 = new javax.swing.JLayeredPane();
        e1Text1 = new javax.swing.JLabel();
        a6 = new javax.swing.JLayeredPane();
        a1text1 = new javax.swing.JLabel();
        b6 = new javax.swing.JLayeredPane();
        b1Text3 = new javax.swing.JLabel();
        f6 = new javax.swing.JLayeredPane();
        f1Text1 = new javax.swing.JLabel();
        g6 = new javax.swing.JLayeredPane();
        g1Text1 = new javax.swing.JLabel();
        d5s = new javax.swing.JLayeredPane();
        d1sharpText4 = new javax.swing.JLabel();
        c5s = new javax.swing.JLayeredPane();
        c1sharpText4 = new javax.swing.JLabel();
        f5s = new javax.swing.JLayeredPane();
        f1sharpText4 = new javax.swing.JLabel();
        a5s = new javax.swing.JLayeredPane();
        a1sharpText4 = new javax.swing.JLabel();
        g5s = new javax.swing.JLayeredPane();
        g1sharpText4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLayeredPane();
        c1Text4 = new javax.swing.JLabel();
        d5 = new javax.swing.JLayeredPane();
        d1Text4 = new javax.swing.JLabel();
        e5 = new javax.swing.JLayeredPane();
        e1Text4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLayeredPane();
        a1text4 = new javax.swing.JLabel();
        b5 = new javax.swing.JLayeredPane();
        b1Text6 = new javax.swing.JLabel();
        f5 = new javax.swing.JLayeredPane();
        f1Text4 = new javax.swing.JLabel();
        g5 = new javax.swing.JLayeredPane();
        g1Text4 = new javax.swing.JLabel();
        d7s = new javax.swing.JLayeredPane();
        d1sharpText5 = new javax.swing.JLabel();
        c7s = new javax.swing.JLayeredPane();
        c1sharpText5 = new javax.swing.JLabel();
        f7s = new javax.swing.JLayeredPane();
        f1sharpText5 = new javax.swing.JLabel();
        a7s = new javax.swing.JLayeredPane();
        a1sharpText5 = new javax.swing.JLabel();
        g7s = new javax.swing.JLayeredPane();
        g1sharpText5 = new javax.swing.JLabel();
        c7 = new javax.swing.JLayeredPane();
        c1Text5 = new javax.swing.JLabel();
        d7 = new javax.swing.JLayeredPane();
        d1Text5 = new javax.swing.JLabel();
        e7 = new javax.swing.JLayeredPane();
        e1Text5 = new javax.swing.JLabel();
        a7 = new javax.swing.JLayeredPane();
        a1text5 = new javax.swing.JLabel();
        b7 = new javax.swing.JLayeredPane();
        b1Text7 = new javax.swing.JLabel();
        f7 = new javax.swing.JLayeredPane();
        f1Text5 = new javax.swing.JLabel();
        g7 = new javax.swing.JLayeredPane();
        g1Text5 = new javax.swing.JLabel();
        d4s = new javax.swing.JLayeredPane();
        d1sharpText2 = new javax.swing.JLabel();
        c4s = new javax.swing.JLayeredPane();
        c1sharpText2 = new javax.swing.JLabel();
        f4s = new javax.swing.JLayeredPane();
        f1sharpText2 = new javax.swing.JLabel();
        a4s = new javax.swing.JLayeredPane();
        a1sharpText2 = new javax.swing.JLabel();
        g4s = new javax.swing.JLayeredPane();
        g1sharpText2 = new javax.swing.JLabel();
        c4 = new javax.swing.JLayeredPane();
        c1Text2 = new javax.swing.JLabel();
        d4 = new javax.swing.JLayeredPane();
        d1Text2 = new javax.swing.JLabel();
        e4 = new javax.swing.JLayeredPane();
        e1Text2 = new javax.swing.JLabel();
        a4 = new javax.swing.JLayeredPane();
        a1text2 = new javax.swing.JLabel();
        b4 = new javax.swing.JLayeredPane();
        b1Text4 = new javax.swing.JLabel();
        f4 = new javax.swing.JLayeredPane();
        f1Text2 = new javax.swing.JLabel();
        g4 = new javax.swing.JLayeredPane();
        g1Text2 = new javax.swing.JLabel();
        d2s = new javax.swing.JLayeredPane();
        d1sharpText3 = new javax.swing.JLabel();
        c2s = new javax.swing.JLayeredPane();
        c1sharpText3 = new javax.swing.JLabel();
        f2s = new javax.swing.JLayeredPane();
        f1sharpText3 = new javax.swing.JLabel();
        a2s = new javax.swing.JLayeredPane();
        a1sharpText3 = new javax.swing.JLabel();
        g2s = new javax.swing.JLayeredPane();
        g1sharpText3 = new javax.swing.JLabel();
        c2 = new javax.swing.JLayeredPane();
        c1Text3 = new javax.swing.JLabel();
        d2 = new javax.swing.JLayeredPane();
        d1Text3 = new javax.swing.JLabel();
        e2 = new javax.swing.JLayeredPane();
        e1Text3 = new javax.swing.JLabel();
        a2 = new javax.swing.JLayeredPane();
        a1text3 = new javax.swing.JLabel();
        b2 = new javax.swing.JLayeredPane();
        b1Text5 = new javax.swing.JLabel();
        f2 = new javax.swing.JLayeredPane();
        f1Text3 = new javax.swing.JLabel();
        g2 = new javax.swing.JLayeredPane();
        g1Text3 = new javax.swing.JLabel();
        d1s = new javax.swing.JLayeredPane();
        d1sharpText1 = new javax.swing.JLabel();
        c1s = new javax.swing.JLayeredPane();
        c1sharpText7 = new javax.swing.JLabel();
        f1s = new javax.swing.JLayeredPane();
        f1sharpText6 = new javax.swing.JLabel();
        a1s = new javax.swing.JLayeredPane();
        a1sharpText6 = new javax.swing.JLabel();
        g1s = new javax.swing.JLayeredPane();
        g1sharpText6 = new javax.swing.JLabel();
        c1 = new javax.swing.JLayeredPane();
        c1Text6 = new javax.swing.JLabel();
        d1 = new javax.swing.JLayeredPane();
        d1Text6 = new javax.swing.JLabel();
        e1 = new javax.swing.JLayeredPane();
        e1Text6 = new javax.swing.JLabel();
        a1 = new javax.swing.JLayeredPane();
        a1text6 = new javax.swing.JLabel();
        b1 = new javax.swing.JLayeredPane();
        b1Text8 = new javax.swing.JLabel();
        f1 = new javax.swing.JLayeredPane();
        f1Text6 = new javax.swing.JLabel();
        g1 = new javax.swing.JLayeredPane();
        g1Text6 = new javax.swing.JLabel();
        d3s = new javax.swing.JLayeredPane();
        d1sharpText8 = new javax.swing.JLabel();
        c3s = new javax.swing.JLayeredPane();
        c1sharpText8 = new javax.swing.JLabel();
        f3s = new javax.swing.JLayeredPane();
        f1sharpText7 = new javax.swing.JLabel();
        a3s = new javax.swing.JLayeredPane();
        a1sharpText7 = new javax.swing.JLabel();
        g3s = new javax.swing.JLayeredPane();
        g1sharpText7 = new javax.swing.JLabel();
        c3 = new javax.swing.JLayeredPane();
        c1Text7 = new javax.swing.JLabel();
        d3 = new javax.swing.JLayeredPane();
        d1Text7 = new javax.swing.JLabel();
        e3 = new javax.swing.JLayeredPane();
        e1Text7 = new javax.swing.JLabel();
        a3 = new javax.swing.JLayeredPane();
        a1text7 = new javax.swing.JLabel();
        b3 = new javax.swing.JLayeredPane();
        b1Text9 = new javax.swing.JLabel();
        f3 = new javax.swing.JLayeredPane();
        f1Text7 = new javax.swing.JLabel();
        g3 = new javax.swing.JLayeredPane();
        g1Text7 = new javax.swing.JLabel();
        d1sharp9 = new javax.swing.JLayeredPane();
        d1sharpText9 = new javax.swing.JLabel();
        c1sharp9 = new javax.swing.JLayeredPane();
        c1sharpText9 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        backgroundPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        keyboardPanel.setBackground(new java.awt.Color(255, 51, 102));
        keyboardPanel.setLayout(new java.awt.GridBagLayout());

        a0s.setBackground(new java.awt.Color(22, 22, 22));
        a0s.setForeground(new java.awt.Color(255, 255, 255));
        a0s.setOpaque(true);
        a0s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText.setText("A#");
        a1sharpText.setAlignmentX(1.0F);
        a1sharpText.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a0s.setLayer(a1sharpText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a0sLayout = new javax.swing.GroupLayout(a0s);
        a0s.setLayout(a0sLayout);
        a0sLayout.setHorizontalGroup(
            a0sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a0sLayout.setVerticalGroup(
            a0sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a0sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a0s, gridBagConstraints);

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c8.setForeground(new java.awt.Color(255, 255, 255));
        c8.setOpaque(true);
        c8.setPreferredSize(null);

        c1Text.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text.setForeground(new java.awt.Color(150, 150, 150));
        c1Text.setText(" C");
        c1Text.setAlignmentX(1.0F);
        c1Text.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c8.setLayer(c1Text, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c8Layout = new javax.swing.GroupLayout(c8);
        c8.setLayout(c8Layout);
        c8Layout.setHorizontalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c8Layout.setVerticalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c8Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c8, gridBagConstraints);

        a0.setBackground(new java.awt.Color(255, 255, 255));
        a0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a0.setForeground(new java.awt.Color(255, 255, 255));
        a0.setOpaque(true);
        a0.setPreferredSize(null);

        a1text.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text.setForeground(new java.awt.Color(150, 150, 150));
        a1text.setText(" A");
        a1text.setAlignmentX(1.0F);
        a1text.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a0.setLayer(a1text, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a0Layout = new javax.swing.GroupLayout(a0);
        a0.setLayout(a0Layout);
        a0Layout.setHorizontalGroup(
            a0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a0Layout.setVerticalGroup(
            a0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a0Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a0, gridBagConstraints);

        b0.setBackground(new java.awt.Color(255, 255, 255));
        b0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b0.setForeground(new java.awt.Color(255, 255, 255));
        b0.setOpaque(true);
        b0.setPreferredSize(null);

        b1Text.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text.setForeground(new java.awt.Color(150, 150, 150));
        b1Text.setText(" B");
        b1Text.setAlignmentX(1.0F);
        b1Text.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b0.setLayer(b1Text, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b0Layout = new javax.swing.GroupLayout(b0);
        b0.setLayout(b0Layout);
        b0Layout.setHorizontalGroup(
            b0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b0Layout.setVerticalGroup(
            b0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b0Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b0, gridBagConstraints);

        d6s.setBackground(new java.awt.Color(22, 22, 22));
        d6s.setForeground(new java.awt.Color(255, 255, 255));
        d6s.setOpaque(true);
        d6s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText12.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText12.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText12.setText("D#");
        d1sharpText12.setAlignmentX(1.0F);
        d1sharpText12.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d6s.setLayer(d1sharpText12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d6sLayout = new javax.swing.GroupLayout(d6s);
        d6s.setLayout(d6sLayout);
        d6sLayout.setHorizontalGroup(
            d6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText12, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d6sLayout.setVerticalGroup(
            d6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText12)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 38;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d6s, gridBagConstraints);

        c6s.setBackground(new java.awt.Color(22, 22, 22));
        c6s.setForeground(new java.awt.Color(255, 255, 255));
        c6s.setOpaque(true);
        c6s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText1.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText1.setText("C#");
        c1sharpText1.setAlignmentX(1.0F);
        c1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c6s.setLayer(c1sharpText1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c6sLayout = new javax.swing.GroupLayout(c6s);
        c6s.setLayout(c6sLayout);
        c6sLayout.setHorizontalGroup(
            c6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c6sLayout.setVerticalGroup(
            c6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText1)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c6s, gridBagConstraints);

        f6s.setBackground(new java.awt.Color(22, 22, 22));
        f6s.setForeground(new java.awt.Color(255, 255, 255));
        f6s.setOpaque(true);
        f6s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText1.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText1.setText("F#");
        f1sharpText1.setAlignmentX(1.0F);
        f1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f6s.setLayer(f1sharpText1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f6sLayout = new javax.swing.GroupLayout(f6s);
        f6s.setLayout(f6sLayout);
        f6sLayout.setHorizontalGroup(
            f6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f6sLayout.setVerticalGroup(
            f6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText1)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f6s, gridBagConstraints);

        a6s.setBackground(new java.awt.Color(22, 22, 22));
        a6s.setForeground(new java.awt.Color(255, 255, 255));
        a6s.setOpaque(true);
        a6s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText1.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText1.setText("A#");
        a1sharpText1.setAlignmentX(1.0F);
        a1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a6s.setLayer(a1sharpText1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a6sLayout = new javax.swing.GroupLayout(a6s);
        a6s.setLayout(a6sLayout);
        a6sLayout.setHorizontalGroup(
            a6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a6sLayout.setVerticalGroup(
            a6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText1)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 42;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a6s, gridBagConstraints);

        g6s.setBackground(new java.awt.Color(22, 22, 22));
        g6s.setForeground(new java.awt.Color(255, 255, 255));
        g6s.setOpaque(true);
        g6s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText1.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText1.setText("G#");
        g1sharpText1.setAlignmentX(1.0F);
        g1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g6s.setLayer(g1sharpText1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g6sLayout = new javax.swing.GroupLayout(g6s);
        g6s.setLayout(g6sLayout);
        g6sLayout.setHorizontalGroup(
            g6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g6sLayout.setVerticalGroup(
            g6sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g6sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText1)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g6s, gridBagConstraints);

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c6.setForeground(new java.awt.Color(255, 255, 255));
        c6.setOpaque(true);
        c6.setPreferredSize(null);

        c1Text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text1.setForeground(new java.awt.Color(150, 150, 150));
        c1Text1.setText(" C");
        c1Text1.setAlignmentX(1.0F);
        c1Text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c6.setLayer(c1Text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
        c6.setLayout(c6Layout);
        c6Layout.setHorizontalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c6Layout.setVerticalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c6, gridBagConstraints);

        d6.setBackground(new java.awt.Color(255, 255, 255));
        d6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d6.setForeground(new java.awt.Color(255, 255, 255));
        d6.setOpaque(true);
        d6.setPreferredSize(null);

        d1Text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text1.setForeground(new java.awt.Color(150, 150, 150));
        d1Text1.setText(" D");
        d1Text1.setAlignmentX(1.0F);
        d1Text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d6.setLayer(d1Text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d6Layout = new javax.swing.GroupLayout(d6);
        d6.setLayout(d6Layout);
        d6Layout.setHorizontalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d6Layout.setVerticalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 38;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d6, gridBagConstraints);

        e6.setBackground(new java.awt.Color(255, 255, 255));
        e6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e6.setForeground(new java.awt.Color(255, 255, 255));
        e6.setOpaque(true);
        e6.setPreferredSize(null);

        e1Text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text1.setForeground(new java.awt.Color(150, 150, 150));
        e1Text1.setText(" E");
        e1Text1.setAlignmentX(1.0F);
        e1Text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e6.setLayer(e1Text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e6Layout = new javax.swing.GroupLayout(e6);
        e6.setLayout(e6Layout);
        e6Layout.setHorizontalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e6Layout.setVerticalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 39;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e6, gridBagConstraints);

        a6.setBackground(new java.awt.Color(255, 255, 255));
        a6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a6.setForeground(new java.awt.Color(255, 255, 255));
        a6.setOpaque(true);
        a6.setPreferredSize(null);

        a1text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text1.setForeground(new java.awt.Color(150, 150, 150));
        a1text1.setText(" A");
        a1text1.setAlignmentX(1.0F);
        a1text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a6.setLayer(a1text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a6Layout = new javax.swing.GroupLayout(a6);
        a6.setLayout(a6Layout);
        a6Layout.setHorizontalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 42;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a6, gridBagConstraints);

        b6.setBackground(new java.awt.Color(255, 255, 255));
        b6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b6.setForeground(new java.awt.Color(255, 255, 255));
        b6.setOpaque(true);
        b6.setPreferredSize(null);

        b1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text3.setForeground(new java.awt.Color(150, 150, 150));
        b1Text3.setText(" B");
        b1Text3.setAlignmentX(1.0F);
        b1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b6.setLayer(b1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b6Layout = new javax.swing.GroupLayout(b6);
        b6.setLayout(b6Layout);
        b6Layout.setHorizontalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b6Layout.setVerticalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 43;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b6, gridBagConstraints);

        f6.setBackground(new java.awt.Color(255, 255, 255));
        f6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f6.setForeground(new java.awt.Color(255, 255, 255));
        f6.setOpaque(true);
        f6.setPreferredSize(null);

        f1Text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text1.setForeground(new java.awt.Color(150, 150, 150));
        f1Text1.setText(" F");
        f1Text1.setAlignmentX(1.0F);
        f1Text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f6.setLayer(f1Text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6);
        f6.setLayout(f6Layout);
        f6Layout.setHorizontalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f6Layout.setVerticalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f6, gridBagConstraints);

        g6.setBackground(new java.awt.Color(255, 255, 255));
        g6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g6.setForeground(new java.awt.Color(255, 255, 255));
        g6.setOpaque(true);
        g6.setPreferredSize(null);

        g1Text1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text1.setForeground(new java.awt.Color(150, 150, 150));
        g1Text1.setText(" G");
        g1Text1.setAlignmentX(1.0F);
        g1Text1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g6.setLayer(g1Text1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g6Layout = new javax.swing.GroupLayout(g6);
        g6.setLayout(g6Layout);
        g6Layout.setHorizontalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g6Layout.setVerticalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g6Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g6, gridBagConstraints);

        d5s.setBackground(new java.awt.Color(22, 22, 22));
        d5s.setForeground(new java.awt.Color(255, 255, 255));
        d5s.setOpaque(true);
        d5s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText4.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText4.setText("D#");
        d1sharpText4.setAlignmentX(1.0F);
        d1sharpText4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d5s.setLayer(d1sharpText4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d5sLayout = new javax.swing.GroupLayout(d5s);
        d5s.setLayout(d5sLayout);
        d5sLayout.setHorizontalGroup(
            d5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d5sLayout.setVerticalGroup(
            d5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText4)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d5s, gridBagConstraints);

        c5s.setBackground(new java.awt.Color(22, 22, 22));
        c5s.setForeground(new java.awt.Color(255, 255, 255));
        c5s.setOpaque(true);
        c5s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText4.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText4.setText("C#");
        c1sharpText4.setAlignmentX(1.0F);
        c1sharpText4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c5s.setLayer(c1sharpText4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c5sLayout = new javax.swing.GroupLayout(c5s);
        c5s.setLayout(c5sLayout);
        c5sLayout.setHorizontalGroup(
            c5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c5sLayout.setVerticalGroup(
            c5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText4)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c5s, gridBagConstraints);

        f5s.setBackground(new java.awt.Color(22, 22, 22));
        f5s.setForeground(new java.awt.Color(255, 255, 255));
        f5s.setOpaque(true);
        f5s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText4.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText4.setText("F#");
        f1sharpText4.setAlignmentX(1.0F);
        f1sharpText4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f5s.setLayer(f1sharpText4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f5sLayout = new javax.swing.GroupLayout(f5s);
        f5s.setLayout(f5sLayout);
        f5sLayout.setHorizontalGroup(
            f5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f5sLayout.setVerticalGroup(
            f5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText4)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f5s, gridBagConstraints);

        a5s.setBackground(new java.awt.Color(22, 22, 22));
        a5s.setForeground(new java.awt.Color(255, 255, 255));
        a5s.setOpaque(true);
        a5s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText4.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText4.setText("A#");
        a1sharpText4.setAlignmentX(1.0F);
        a1sharpText4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a5s.setLayer(a1sharpText4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a5sLayout = new javax.swing.GroupLayout(a5s);
        a5s.setLayout(a5sLayout);
        a5sLayout.setHorizontalGroup(
            a5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a5sLayout.setVerticalGroup(
            a5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText4)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a5s, gridBagConstraints);

        g5s.setBackground(new java.awt.Color(22, 22, 22));
        g5s.setForeground(new java.awt.Color(255, 255, 255));
        g5s.setOpaque(true);
        g5s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText4.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText4.setText("G#");
        g1sharpText4.setAlignmentX(1.0F);
        g1sharpText4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g5s.setLayer(g1sharpText4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g5sLayout = new javax.swing.GroupLayout(g5s);
        g5s.setLayout(g5sLayout);
        g5sLayout.setHorizontalGroup(
            g5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g5sLayout.setVerticalGroup(
            g5sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g5sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText4)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g5s, gridBagConstraints);

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c5.setForeground(new java.awt.Color(255, 255, 255));
        c5.setOpaque(true);
        c5.setPreferredSize(null);

        c1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text4.setForeground(new java.awt.Color(150, 150, 150));
        c1Text4.setText(" C");
        c1Text4.setAlignmentX(1.0F);
        c1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c5.setLayer(c1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c5Layout.setVerticalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c5, gridBagConstraints);

        d5.setBackground(new java.awt.Color(255, 255, 255));
        d5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d5.setForeground(new java.awt.Color(255, 255, 255));
        d5.setOpaque(true);
        d5.setPreferredSize(null);

        d1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text4.setForeground(new java.awt.Color(150, 150, 150));
        d1Text4.setText(" D");
        d1Text4.setAlignmentX(1.0F);
        d1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d5.setLayer(d1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
        d5.setLayout(d5Layout);
        d5Layout.setHorizontalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d5Layout.setVerticalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d5, gridBagConstraints);

        e5.setBackground(new java.awt.Color(255, 255, 255));
        e5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e5.setForeground(new java.awt.Color(255, 255, 255));
        e5.setOpaque(true);
        e5.setPreferredSize(null);

        e1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text4.setForeground(new java.awt.Color(150, 150, 150));
        e1Text4.setText(" E");
        e1Text4.setAlignmentX(1.0F);
        e1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e5.setLayer(e1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
        e5.setLayout(e5Layout);
        e5Layout.setHorizontalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e5Layout.setVerticalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e5, gridBagConstraints);

        a5.setBackground(new java.awt.Color(255, 255, 255));
        a5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setOpaque(true);
        a5.setPreferredSize(null);

        a1text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text4.setForeground(new java.awt.Color(150, 150, 150));
        a1text4.setText(" A");
        a1text4.setAlignmentX(1.0F);
        a1text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a5.setLayer(a1text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a5Layout = new javax.swing.GroupLayout(a5);
        a5.setLayout(a5Layout);
        a5Layout.setHorizontalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a5Layout.setVerticalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a5, gridBagConstraints);

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b5.setForeground(new java.awt.Color(255, 255, 255));
        b5.setOpaque(true);
        b5.setPreferredSize(null);

        b1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text6.setForeground(new java.awt.Color(150, 150, 150));
        b1Text6.setText(" B");
        b1Text6.setAlignmentX(1.0F);
        b1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b5.setLayer(b1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
        b5.setLayout(b5Layout);
        b5Layout.setHorizontalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b5Layout.setVerticalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b5, gridBagConstraints);

        f5.setBackground(new java.awt.Color(255, 255, 255));
        f5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f5.setForeground(new java.awt.Color(255, 255, 255));
        f5.setOpaque(true);
        f5.setPreferredSize(null);

        f1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text4.setForeground(new java.awt.Color(150, 150, 150));
        f1Text4.setText(" F");
        f1Text4.setAlignmentX(1.0F);
        f1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f5.setLayer(f1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5);
        f5.setLayout(f5Layout);
        f5Layout.setHorizontalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f5Layout.setVerticalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f5, gridBagConstraints);

        g5.setBackground(new java.awt.Color(255, 255, 255));
        g5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g5.setForeground(new java.awt.Color(255, 255, 255));
        g5.setOpaque(true);
        g5.setPreferredSize(null);

        g1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text4.setForeground(new java.awt.Color(150, 150, 150));
        g1Text4.setText(" G");
        g1Text4.setAlignmentX(1.0F);
        g1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g5.setLayer(g1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g5Layout = new javax.swing.GroupLayout(g5);
        g5.setLayout(g5Layout);
        g5Layout.setHorizontalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g5Layout.setVerticalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g5Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g5, gridBagConstraints);

        d7s.setBackground(new java.awt.Color(22, 22, 22));
        d7s.setForeground(new java.awt.Color(255, 255, 255));
        d7s.setOpaque(true);
        d7s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText5.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText5.setText("D#");
        d1sharpText5.setAlignmentX(1.0F);
        d1sharpText5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d7s.setLayer(d1sharpText5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d7sLayout = new javax.swing.GroupLayout(d7s);
        d7s.setLayout(d7sLayout);
        d7sLayout.setHorizontalGroup(
            d7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d7sLayout.setVerticalGroup(
            d7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText5)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d7s, gridBagConstraints);

        c7s.setBackground(new java.awt.Color(22, 22, 22));
        c7s.setForeground(new java.awt.Color(255, 255, 255));
        c7s.setOpaque(true);
        c7s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText5.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText5.setText("C#");
        c1sharpText5.setAlignmentX(1.0F);
        c1sharpText5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c7s.setLayer(c1sharpText5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c7sLayout = new javax.swing.GroupLayout(c7s);
        c7s.setLayout(c7sLayout);
        c7sLayout.setHorizontalGroup(
            c7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c7sLayout.setVerticalGroup(
            c7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText5)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c7s, gridBagConstraints);

        f7s.setBackground(new java.awt.Color(22, 22, 22));
        f7s.setForeground(new java.awt.Color(255, 255, 255));
        f7s.setOpaque(true);
        f7s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText5.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText5.setText("F#");
        f1sharpText5.setAlignmentX(1.0F);
        f1sharpText5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f7s.setLayer(f1sharpText5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f7sLayout = new javax.swing.GroupLayout(f7s);
        f7s.setLayout(f7sLayout);
        f7sLayout.setHorizontalGroup(
            f7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f7sLayout.setVerticalGroup(
            f7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText5)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f7s, gridBagConstraints);

        a7s.setBackground(new java.awt.Color(22, 22, 22));
        a7s.setForeground(new java.awt.Color(255, 255, 255));
        a7s.setOpaque(true);
        a7s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText5.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText5.setText("A#");
        a1sharpText5.setAlignmentX(1.0F);
        a1sharpText5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a7s.setLayer(a1sharpText5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a7sLayout = new javax.swing.GroupLayout(a7s);
        a7s.setLayout(a7sLayout);
        a7sLayout.setHorizontalGroup(
            a7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a7sLayout.setVerticalGroup(
            a7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText5)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 49;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a7s, gridBagConstraints);

        g7s.setBackground(new java.awt.Color(22, 22, 22));
        g7s.setForeground(new java.awt.Color(255, 255, 255));
        g7s.setOpaque(true);
        g7s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText5.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText5.setText("G#");
        g1sharpText5.setAlignmentX(1.0F);
        g1sharpText5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g7s.setLayer(g1sharpText5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g7sLayout = new javax.swing.GroupLayout(g7s);
        g7s.setLayout(g7sLayout);
        g7sLayout.setHorizontalGroup(
            g7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g7sLayout.setVerticalGroup(
            g7sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g7sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText5)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g7s, gridBagConstraints);

        c7.setBackground(new java.awt.Color(255, 255, 255));
        c7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c7.setForeground(new java.awt.Color(255, 255, 255));
        c7.setOpaque(true);
        c7.setPreferredSize(null);

        c1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text5.setForeground(new java.awt.Color(150, 150, 150));
        c1Text5.setText(" C");
        c1Text5.setAlignmentX(1.0F);
        c1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c7.setLayer(c1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c7Layout = new javax.swing.GroupLayout(c7);
        c7.setLayout(c7Layout);
        c7Layout.setHorizontalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c7Layout.setVerticalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 44;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c7, gridBagConstraints);

        d7.setBackground(new java.awt.Color(255, 255, 255));
        d7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d7.setForeground(new java.awt.Color(255, 255, 255));
        d7.setOpaque(true);
        d7.setPreferredSize(null);

        d1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text5.setForeground(new java.awt.Color(150, 150, 150));
        d1Text5.setText(" D");
        d1Text5.setAlignmentX(1.0F);
        d1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d7.setLayer(d1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d7Layout = new javax.swing.GroupLayout(d7);
        d7.setLayout(d7Layout);
        d7Layout.setHorizontalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d7Layout.setVerticalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d7, gridBagConstraints);

        e7.setBackground(new java.awt.Color(255, 255, 255));
        e7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e7.setForeground(new java.awt.Color(255, 255, 255));
        e7.setOpaque(true);
        e7.setPreferredSize(null);

        e1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text5.setForeground(new java.awt.Color(150, 150, 150));
        e1Text5.setText(" E");
        e1Text5.setAlignmentX(1.0F);
        e1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e7.setLayer(e1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e7Layout = new javax.swing.GroupLayout(e7);
        e7.setLayout(e7Layout);
        e7Layout.setHorizontalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e7Layout.setVerticalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 46;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e7, gridBagConstraints);

        a7.setBackground(new java.awt.Color(255, 255, 255));
        a7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setOpaque(true);
        a7.setPreferredSize(null);

        a1text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text5.setForeground(new java.awt.Color(150, 150, 150));
        a1text5.setText(" A");
        a1text5.setAlignmentX(1.0F);
        a1text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a7.setLayer(a1text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a7Layout = new javax.swing.GroupLayout(a7);
        a7.setLayout(a7Layout);
        a7Layout.setHorizontalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a7Layout.setVerticalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 49;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a7, gridBagConstraints);

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b7.setForeground(new java.awt.Color(255, 255, 255));
        b7.setOpaque(true);
        b7.setPreferredSize(null);

        b1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text7.setForeground(new java.awt.Color(150, 150, 150));
        b1Text7.setText(" B");
        b1Text7.setAlignmentX(1.0F);
        b1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b7.setLayer(b1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b7Layout = new javax.swing.GroupLayout(b7);
        b7.setLayout(b7Layout);
        b7Layout.setHorizontalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b7Layout.setVerticalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 50;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b7, gridBagConstraints);

        f7.setBackground(new java.awt.Color(255, 255, 255));
        f7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f7.setForeground(new java.awt.Color(255, 255, 255));
        f7.setOpaque(true);
        f7.setPreferredSize(null);

        f1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text5.setForeground(new java.awt.Color(150, 150, 150));
        f1Text5.setText(" F");
        f1Text5.setAlignmentX(1.0F);
        f1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f7.setLayer(f1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7);
        f7.setLayout(f7Layout);
        f7Layout.setHorizontalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f7Layout.setVerticalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f7, gridBagConstraints);

        g7.setBackground(new java.awt.Color(255, 255, 255));
        g7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g7.setForeground(new java.awt.Color(255, 255, 255));
        g7.setOpaque(true);
        g7.setPreferredSize(null);

        g1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text5.setForeground(new java.awt.Color(150, 150, 150));
        g1Text5.setText(" G");
        g1Text5.setAlignmentX(1.0F);
        g1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g7.setLayer(g1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g7Layout = new javax.swing.GroupLayout(g7);
        g7.setLayout(g7Layout);
        g7Layout.setHorizontalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g7Layout.setVerticalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g7Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g7, gridBagConstraints);

        d4s.setBackground(new java.awt.Color(22, 22, 22));
        d4s.setForeground(new java.awt.Color(255, 255, 255));
        d4s.setOpaque(true);
        d4s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText2.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText2.setText("D#");
        d1sharpText2.setAlignmentX(1.0F);
        d1sharpText2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d4s.setLayer(d1sharpText2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d4sLayout = new javax.swing.GroupLayout(d4s);
        d4s.setLayout(d4sLayout);
        d4sLayout.setHorizontalGroup(
            d4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d4sLayout.setVerticalGroup(
            d4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText2)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d4s, gridBagConstraints);

        c4s.setBackground(new java.awt.Color(22, 22, 22));
        c4s.setForeground(new java.awt.Color(255, 255, 255));
        c4s.setOpaque(true);
        c4s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText2.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText2.setText("C#");
        c1sharpText2.setAlignmentX(1.0F);
        c1sharpText2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c4s.setLayer(c1sharpText2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c4sLayout = new javax.swing.GroupLayout(c4s);
        c4s.setLayout(c4sLayout);
        c4sLayout.setHorizontalGroup(
            c4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c4sLayout.setVerticalGroup(
            c4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText2)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c4s, gridBagConstraints);

        f4s.setBackground(new java.awt.Color(22, 22, 22));
        f4s.setForeground(new java.awt.Color(255, 255, 255));
        f4s.setOpaque(true);
        f4s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText2.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText2.setText("F#");
        f1sharpText2.setAlignmentX(1.0F);
        f1sharpText2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f4s.setLayer(f1sharpText2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f4sLayout = new javax.swing.GroupLayout(f4s);
        f4s.setLayout(f4sLayout);
        f4sLayout.setHorizontalGroup(
            f4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f4sLayout.setVerticalGroup(
            f4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText2)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f4s, gridBagConstraints);

        a4s.setBackground(new java.awt.Color(22, 22, 22));
        a4s.setForeground(new java.awt.Color(255, 255, 255));
        a4s.setOpaque(true);
        a4s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText2.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText2.setText("A#");
        a1sharpText2.setAlignmentX(1.0F);
        a1sharpText2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a4s.setLayer(a1sharpText2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a4sLayout = new javax.swing.GroupLayout(a4s);
        a4s.setLayout(a4sLayout);
        a4sLayout.setHorizontalGroup(
            a4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a4sLayout.setVerticalGroup(
            a4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText2)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a4s, gridBagConstraints);

        g4s.setBackground(new java.awt.Color(22, 22, 22));
        g4s.setForeground(new java.awt.Color(255, 255, 255));
        g4s.setOpaque(true);
        g4s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText2.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText2.setText("G#");
        g1sharpText2.setAlignmentX(1.0F);
        g1sharpText2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g4s.setLayer(g1sharpText2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g4sLayout = new javax.swing.GroupLayout(g4s);
        g4s.setLayout(g4sLayout);
        g4sLayout.setHorizontalGroup(
            g4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g4sLayout.setVerticalGroup(
            g4sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g4sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText2)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g4s, gridBagConstraints);

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c4.setForeground(new java.awt.Color(255, 255, 255));
        c4.setOpaque(true);
        c4.setPreferredSize(null);

        c1Text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text2.setForeground(new java.awt.Color(150, 150, 150));
        c1Text2.setText(" C");
        c1Text2.setAlignmentX(1.0F);
        c1Text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c4.setLayer(c1Text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c4Layout.setVerticalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c4, gridBagConstraints);

        d4.setBackground(new java.awt.Color(255, 255, 255));
        d4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d4.setForeground(new java.awt.Color(255, 255, 255));
        d4.setOpaque(true);
        d4.setPreferredSize(null);

        d1Text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text2.setForeground(new java.awt.Color(150, 150, 150));
        d1Text2.setText(" D");
        d1Text2.setAlignmentX(1.0F);
        d1Text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d4.setLayer(d1Text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d4Layout = new javax.swing.GroupLayout(d4);
        d4.setLayout(d4Layout);
        d4Layout.setHorizontalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d4Layout.setVerticalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d4, gridBagConstraints);

        e4.setBackground(new java.awt.Color(255, 255, 255));
        e4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e4.setForeground(new java.awt.Color(255, 255, 255));
        e4.setOpaque(true);
        e4.setPreferredSize(null);

        e1Text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text2.setForeground(new java.awt.Color(150, 150, 150));
        e1Text2.setText(" E");
        e1Text2.setAlignmentX(1.0F);
        e1Text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e4.setLayer(e1Text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e4Layout = new javax.swing.GroupLayout(e4);
        e4.setLayout(e4Layout);
        e4Layout.setHorizontalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e4Layout.setVerticalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e4, gridBagConstraints);

        a4.setBackground(new java.awt.Color(255, 255, 255));
        a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setOpaque(true);
        a4.setPreferredSize(null);

        a1text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text2.setForeground(new java.awt.Color(150, 150, 150));
        a1text2.setText(" A");
        a1text2.setAlignmentX(1.0F);
        a1text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a4.setLayer(a1text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a4Layout = new javax.swing.GroupLayout(a4);
        a4.setLayout(a4Layout);
        a4Layout.setHorizontalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a4Layout.setVerticalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a4, gridBagConstraints);

        b4.setBackground(new java.awt.Color(255, 255, 255));
        b4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setOpaque(true);
        b4.setPreferredSize(null);

        b1Text4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text4.setForeground(new java.awt.Color(150, 150, 150));
        b1Text4.setText(" B");
        b1Text4.setAlignmentX(1.0F);
        b1Text4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b4.setLayer(b1Text4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b4Layout.setVerticalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b4, gridBagConstraints);

        f4.setBackground(new java.awt.Color(255, 255, 255));
        f4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f4.setForeground(new java.awt.Color(255, 255, 255));
        f4.setOpaque(true);
        f4.setPreferredSize(null);

        f1Text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text2.setForeground(new java.awt.Color(150, 150, 150));
        f1Text2.setText(" F");
        f1Text2.setAlignmentX(1.0F);
        f1Text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f4.setLayer(f1Text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f4Layout = new javax.swing.GroupLayout(f4);
        f4.setLayout(f4Layout);
        f4Layout.setHorizontalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f4Layout.setVerticalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f4, gridBagConstraints);

        g4.setBackground(new java.awt.Color(255, 255, 255));
        g4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g4.setForeground(new java.awt.Color(255, 255, 255));
        g4.setOpaque(true);
        g4.setPreferredSize(null);

        g1Text2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text2.setForeground(new java.awt.Color(150, 150, 150));
        g1Text2.setText(" G");
        g1Text2.setAlignmentX(1.0F);
        g1Text2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g4.setLayer(g1Text2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g4Layout = new javax.swing.GroupLayout(g4);
        g4.setLayout(g4Layout);
        g4Layout.setHorizontalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g4Layout.setVerticalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g4Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g4, gridBagConstraints);

        d2s.setBackground(new java.awt.Color(22, 22, 22));
        d2s.setForeground(new java.awt.Color(255, 255, 255));
        d2s.setOpaque(true);
        d2s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText3.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText3.setText("D#");
        d1sharpText3.setAlignmentX(1.0F);
        d1sharpText3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d2s.setLayer(d1sharpText3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d2sLayout = new javax.swing.GroupLayout(d2s);
        d2s.setLayout(d2sLayout);
        d2sLayout.setHorizontalGroup(
            d2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d2sLayout.setVerticalGroup(
            d2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText3)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d2s, gridBagConstraints);

        c2s.setBackground(new java.awt.Color(22, 22, 22));
        c2s.setForeground(new java.awt.Color(255, 255, 255));
        c2s.setOpaque(true);
        c2s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText3.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText3.setText("C#");
        c1sharpText3.setAlignmentX(1.0F);
        c1sharpText3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c2s.setLayer(c1sharpText3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c2sLayout = new javax.swing.GroupLayout(c2s);
        c2s.setLayout(c2sLayout);
        c2sLayout.setHorizontalGroup(
            c2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c2sLayout.setVerticalGroup(
            c2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText3)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c2s, gridBagConstraints);

        f2s.setBackground(new java.awt.Color(22, 22, 22));
        f2s.setForeground(new java.awt.Color(255, 255, 255));
        f2s.setOpaque(true);
        f2s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText3.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText3.setText("F#");
        f1sharpText3.setAlignmentX(1.0F);
        f1sharpText3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f2s.setLayer(f1sharpText3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f2sLayout = new javax.swing.GroupLayout(f2s);
        f2s.setLayout(f2sLayout);
        f2sLayout.setHorizontalGroup(
            f2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f2sLayout.setVerticalGroup(
            f2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText3)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f2s, gridBagConstraints);

        a2s.setBackground(new java.awt.Color(22, 22, 22));
        a2s.setForeground(new java.awt.Color(255, 255, 255));
        a2s.setOpaque(true);
        a2s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText3.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText3.setText("A#");
        a1sharpText3.setAlignmentX(1.0F);
        a1sharpText3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a2s.setLayer(a1sharpText3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a2sLayout = new javax.swing.GroupLayout(a2s);
        a2s.setLayout(a2sLayout);
        a2sLayout.setHorizontalGroup(
            a2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a2sLayout.setVerticalGroup(
            a2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText3)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a2s, gridBagConstraints);

        g2s.setBackground(new java.awt.Color(22, 22, 22));
        g2s.setForeground(new java.awt.Color(255, 255, 255));
        g2s.setOpaque(true);
        g2s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText3.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText3.setText("G#");
        g1sharpText3.setAlignmentX(1.0F);
        g1sharpText3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g2s.setLayer(g1sharpText3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g2sLayout = new javax.swing.GroupLayout(g2s);
        g2s.setLayout(g2sLayout);
        g2sLayout.setHorizontalGroup(
            g2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g2sLayout.setVerticalGroup(
            g2sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText3)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g2s, gridBagConstraints);

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c2.setForeground(new java.awt.Color(255, 255, 255));
        c2.setOpaque(true);
        c2.setPreferredSize(null);

        c1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text3.setForeground(new java.awt.Color(150, 150, 150));
        c1Text3.setText(" C");
        c1Text3.setAlignmentX(1.0F);
        c1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c2.setLayer(c1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c2Layout.setVerticalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c2, gridBagConstraints);

        d2.setBackground(new java.awt.Color(255, 255, 255));
        d2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2.setForeground(new java.awt.Color(255, 255, 255));
        d2.setOpaque(true);
        d2.setPreferredSize(null);

        d1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text3.setForeground(new java.awt.Color(150, 150, 150));
        d1Text3.setText(" D");
        d1Text3.setAlignmentX(1.0F);
        d1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d2.setLayer(d1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d2Layout.setVerticalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d2, gridBagConstraints);

        e2.setBackground(new java.awt.Color(255, 255, 255));
        e2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e2.setForeground(new java.awt.Color(255, 255, 255));
        e2.setOpaque(true);
        e2.setPreferredSize(null);

        e1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text3.setForeground(new java.awt.Color(150, 150, 150));
        e1Text3.setText(" E");
        e1Text3.setAlignmentX(1.0F);
        e1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e2.setLayer(e1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e2Layout = new javax.swing.GroupLayout(e2);
        e2.setLayout(e2Layout);
        e2Layout.setHorizontalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e2Layout.setVerticalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e2, gridBagConstraints);

        a2.setBackground(new java.awt.Color(255, 255, 255));
        a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setOpaque(true);
        a2.setPreferredSize(null);

        a1text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text3.setForeground(new java.awt.Color(150, 150, 150));
        a1text3.setText(" A");
        a1text3.setAlignmentX(1.0F);
        a1text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a2.setLayer(a1text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a2Layout.setVerticalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a2, gridBagConstraints);

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setOpaque(true);
        b2.setPreferredSize(null);

        b1Text5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text5.setForeground(new java.awt.Color(150, 150, 150));
        b1Text5.setText(" B");
        b1Text5.setAlignmentX(1.0F);
        b1Text5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b2.setLayer(b1Text5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b2Layout.setVerticalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b2, gridBagConstraints);

        f2.setBackground(new java.awt.Color(255, 255, 255));
        f2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f2.setForeground(new java.awt.Color(255, 255, 255));
        f2.setOpaque(true);
        f2.setPreferredSize(null);

        f1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text3.setForeground(new java.awt.Color(150, 150, 150));
        f1Text3.setText(" F");
        f1Text3.setAlignmentX(1.0F);
        f1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f2.setLayer(f1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2);
        f2.setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f2Layout.setVerticalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f2, gridBagConstraints);

        g2.setBackground(new java.awt.Color(255, 255, 255));
        g2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g2.setForeground(new java.awt.Color(255, 255, 255));
        g2.setOpaque(true);
        g2.setPreferredSize(null);

        g1Text3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text3.setForeground(new java.awt.Color(150, 150, 150));
        g1Text3.setText(" G");
        g1Text3.setAlignmentX(1.0F);
        g1Text3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g2.setLayer(g1Text3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g2Layout = new javax.swing.GroupLayout(g2);
        g2.setLayout(g2Layout);
        g2Layout.setHorizontalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g2Layout.setVerticalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g2, gridBagConstraints);

        d1s.setBackground(new java.awt.Color(22, 22, 22));
        d1s.setForeground(new java.awt.Color(255, 255, 255));
        d1s.setOpaque(true);
        d1s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText1.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText1.setText("D#");
        d1sharpText1.setAlignmentX(1.0F);
        d1sharpText1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d1s.setLayer(d1sharpText1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d1sLayout = new javax.swing.GroupLayout(d1s);
        d1s.setLayout(d1sLayout);
        d1sLayout.setHorizontalGroup(
            d1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d1sLayout.setVerticalGroup(
            d1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText1)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d1s, gridBagConstraints);

        c1s.setBackground(new java.awt.Color(22, 22, 22));
        c1s.setForeground(new java.awt.Color(255, 255, 255));
        c1s.setOpaque(true);
        c1s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText7.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText7.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText7.setText("C#");
        c1sharpText7.setAlignmentX(1.0F);
        c1sharpText7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c1s.setLayer(c1sharpText7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c1sLayout = new javax.swing.GroupLayout(c1s);
        c1s.setLayout(c1sLayout);
        c1sLayout.setHorizontalGroup(
            c1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText7, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c1sLayout.setVerticalGroup(
            c1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText7)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c1s, gridBagConstraints);

        f1s.setBackground(new java.awt.Color(22, 22, 22));
        f1s.setForeground(new java.awt.Color(255, 255, 255));
        f1s.setOpaque(true);
        f1s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText6.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText6.setText("F#");
        f1sharpText6.setAlignmentX(1.0F);
        f1sharpText6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f1s.setLayer(f1sharpText6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f1sLayout = new javax.swing.GroupLayout(f1s);
        f1s.setLayout(f1sLayout);
        f1sLayout.setHorizontalGroup(
            f1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText6, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f1sLayout.setVerticalGroup(
            f1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText6)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f1s, gridBagConstraints);

        a1s.setBackground(new java.awt.Color(22, 22, 22));
        a1s.setForeground(new java.awt.Color(255, 255, 255));
        a1s.setOpaque(true);
        a1s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText6.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText6.setText("A#");
        a1sharpText6.setAlignmentX(1.0F);
        a1sharpText6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a1s.setLayer(a1sharpText6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a1sLayout = new javax.swing.GroupLayout(a1s);
        a1s.setLayout(a1sLayout);
        a1sLayout.setHorizontalGroup(
            a1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText6, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a1sLayout.setVerticalGroup(
            a1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText6)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a1s, gridBagConstraints);

        g1s.setBackground(new java.awt.Color(22, 22, 22));
        g1s.setForeground(new java.awt.Color(255, 255, 255));
        g1s.setOpaque(true);
        g1s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText6.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText6.setText("G#");
        g1sharpText6.setAlignmentX(1.0F);
        g1sharpText6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g1s.setLayer(g1sharpText6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g1sLayout = new javax.swing.GroupLayout(g1s);
        g1s.setLayout(g1sLayout);
        g1sLayout.setHorizontalGroup(
            g1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText6, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g1sLayout.setVerticalGroup(
            g1sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g1sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText6)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g1s, gridBagConstraints);

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c1.setForeground(new java.awt.Color(255, 255, 255));
        c1.setOpaque(true);
        c1.setPreferredSize(null);

        c1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text6.setForeground(new java.awt.Color(150, 150, 150));
        c1Text6.setText(" C");
        c1Text6.setAlignmentX(1.0F);
        c1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c1.setLayer(c1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c1Layout.setVerticalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c1, gridBagConstraints);

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d1.setForeground(new java.awt.Color(255, 255, 255));
        d1.setOpaque(true);
        d1.setPreferredSize(null);

        d1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text6.setForeground(new java.awt.Color(150, 150, 150));
        d1Text6.setText(" D");
        d1Text6.setAlignmentX(1.0F);
        d1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d1.setLayer(d1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d1Layout.setVerticalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d1, gridBagConstraints);

        e1.setBackground(new java.awt.Color(255, 255, 255));
        e1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e1.setForeground(new java.awt.Color(255, 255, 255));
        e1.setOpaque(true);
        e1.setPreferredSize(null);

        e1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text6.setForeground(new java.awt.Color(150, 150, 150));
        e1Text6.setText(" E");
        e1Text6.setAlignmentX(1.0F);
        e1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e1.setLayer(e1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e1Layout = new javax.swing.GroupLayout(e1);
        e1.setLayout(e1Layout);
        e1Layout.setHorizontalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e1Layout.setVerticalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e1, gridBagConstraints);

        a1.setBackground(new java.awt.Color(255, 255, 255));
        a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setOpaque(true);
        a1.setPreferredSize(null);

        a1text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text6.setForeground(new java.awt.Color(150, 150, 150));
        a1text6.setText(" A");
        a1text6.setAlignmentX(1.0F);
        a1text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a1.setLayer(a1text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a1Layout = new javax.swing.GroupLayout(a1);
        a1.setLayout(a1Layout);
        a1Layout.setHorizontalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a1Layout.setVerticalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a1, gridBagConstraints);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setOpaque(true);
        b1.setPreferredSize(null);

        b1Text8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text8.setForeground(new java.awt.Color(150, 150, 150));
        b1Text8.setText(" B");
        b1Text8.setAlignmentX(1.0F);
        b1Text8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b1.setLayer(b1Text8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text8, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b1, gridBagConstraints);

        f1.setBackground(new java.awt.Color(255, 255, 255));
        f1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f1.setForeground(new java.awt.Color(255, 255, 255));
        f1.setOpaque(true);
        f1.setPreferredSize(null);

        f1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text6.setForeground(new java.awt.Color(150, 150, 150));
        f1Text6.setText(" F");
        f1Text6.setAlignmentX(1.0F);
        f1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f1.setLayer(f1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1);
        f1.setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f1Layout.setVerticalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f1, gridBagConstraints);

        g1.setBackground(new java.awt.Color(255, 255, 255));
        g1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g1.setForeground(new java.awt.Color(255, 255, 255));
        g1.setOpaque(true);
        g1.setPreferredSize(null);

        g1Text6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text6.setForeground(new java.awt.Color(150, 150, 150));
        g1Text6.setText(" G");
        g1Text6.setAlignmentX(1.0F);
        g1Text6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g1.setLayer(g1Text6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g1Layout = new javax.swing.GroupLayout(g1);
        g1.setLayout(g1Layout);
        g1Layout.setHorizontalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g1Layout.setVerticalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g1Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g1, gridBagConstraints);

        d3s.setBackground(new java.awt.Color(22, 22, 22));
        d3s.setForeground(new java.awt.Color(255, 255, 255));
        d3s.setOpaque(true);
        d3s.setPreferredSize(new java.awt.Dimension(15, 90));

        d1sharpText8.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText8.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText8.setText("D#");
        d1sharpText8.setAlignmentX(1.0F);
        d1sharpText8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d3s.setLayer(d1sharpText8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d3sLayout = new javax.swing.GroupLayout(d3s);
        d3s.setLayout(d3sLayout);
        d3sLayout.setHorizontalGroup(
            d3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText8, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d3sLayout.setVerticalGroup(
            d3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText8)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(d3s, gridBagConstraints);

        c3s.setBackground(new java.awt.Color(22, 22, 22));
        c3s.setForeground(new java.awt.Color(255, 255, 255));
        c3s.setOpaque(true);
        c3s.setPreferredSize(new java.awt.Dimension(15, 90));

        c1sharpText8.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText8.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText8.setText("C#");
        c1sharpText8.setAlignmentX(1.0F);
        c1sharpText8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c3s.setLayer(c1sharpText8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c3sLayout = new javax.swing.GroupLayout(c3s);
        c3s.setLayout(c3sLayout);
        c3sLayout.setHorizontalGroup(
            c3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText8, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c3sLayout.setVerticalGroup(
            c3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText8)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(c3s, gridBagConstraints);

        f3s.setBackground(new java.awt.Color(22, 22, 22));
        f3s.setForeground(new java.awt.Color(255, 255, 255));
        f3s.setOpaque(true);
        f3s.setPreferredSize(new java.awt.Dimension(15, 90));

        f1sharpText7.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        f1sharpText7.setForeground(new java.awt.Color(150, 150, 150));
        f1sharpText7.setText("F#");
        f1sharpText7.setAlignmentX(1.0F);
        f1sharpText7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f3s.setLayer(f1sharpText7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f3sLayout = new javax.swing.GroupLayout(f3s);
        f3s.setLayout(f3sLayout);
        f3sLayout.setHorizontalGroup(
            f3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1sharpText7, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        f3sLayout.setVerticalGroup(
            f3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(f1sharpText7)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(f3s, gridBagConstraints);

        a3s.setBackground(new java.awt.Color(22, 22, 22));
        a3s.setForeground(new java.awt.Color(255, 255, 255));
        a3s.setOpaque(true);
        a3s.setPreferredSize(new java.awt.Dimension(15, 90));

        a1sharpText7.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        a1sharpText7.setForeground(new java.awt.Color(150, 150, 150));
        a1sharpText7.setText("A#");
        a1sharpText7.setAlignmentX(1.0F);
        a1sharpText7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a3s.setLayer(a1sharpText7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a3sLayout = new javax.swing.GroupLayout(a3s);
        a3s.setLayout(a3sLayout);
        a3sLayout.setHorizontalGroup(
            a3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1sharpText7, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        a3sLayout.setVerticalGroup(
            a3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(a1sharpText7)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(a3s, gridBagConstraints);

        g3s.setBackground(new java.awt.Color(22, 22, 22));
        g3s.setForeground(new java.awt.Color(255, 255, 255));
        g3s.setOpaque(true);
        g3s.setPreferredSize(new java.awt.Dimension(15, 90));

        g1sharpText7.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        g1sharpText7.setForeground(new java.awt.Color(150, 150, 150));
        g1sharpText7.setText("G#");
        g1sharpText7.setAlignmentX(1.0F);
        g1sharpText7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g3s.setLayer(g1sharpText7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g3sLayout = new javax.swing.GroupLayout(g3s);
        g3s.setLayout(g3sLayout);
        g3sLayout.setHorizontalGroup(
            g3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1sharpText7, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        g3sLayout.setVerticalGroup(
            g3sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g3sLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(g1sharpText7)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        keyboardPanel.add(g3s, gridBagConstraints);

        c3.setBackground(new java.awt.Color(255, 255, 255));
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c3.setForeground(new java.awt.Color(255, 255, 255));
        c3.setOpaque(true);
        c3.setPreferredSize(null);

        c1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        c1Text7.setForeground(new java.awt.Color(150, 150, 150));
        c1Text7.setText(" C");
        c1Text7.setAlignmentX(1.0F);
        c1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c3.setLayer(c1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c3Layout = new javax.swing.GroupLayout(c3);
        c3.setLayout(c3Layout);
        c3Layout.setHorizontalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        c3Layout.setVerticalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(c1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c3, gridBagConstraints);

        d3.setBackground(new java.awt.Color(255, 255, 255));
        d3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d3.setForeground(new java.awt.Color(255, 255, 255));
        d3.setOpaque(true);
        d3.setPreferredSize(null);

        d1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        d1Text7.setForeground(new java.awt.Color(150, 150, 150));
        d1Text7.setText(" D");
        d1Text7.setAlignmentX(1.0F);
        d1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d3.setLayer(d1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d3Layout = new javax.swing.GroupLayout(d3);
        d3.setLayout(d3Layout);
        d3Layout.setHorizontalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        d3Layout.setVerticalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(d1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d3, gridBagConstraints);

        e3.setBackground(new java.awt.Color(255, 255, 255));
        e3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        e3.setForeground(new java.awt.Color(255, 255, 255));
        e3.setOpaque(true);
        e3.setPreferredSize(null);

        e1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        e1Text7.setForeground(new java.awt.Color(150, 150, 150));
        e1Text7.setText(" E");
        e1Text7.setAlignmentX(1.0F);
        e1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        e3.setLayer(e1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout e3Layout = new javax.swing.GroupLayout(e3);
        e3.setLayout(e3Layout);
        e3Layout.setHorizontalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(e1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        e3Layout.setVerticalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(e1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(e3, gridBagConstraints);

        a3.setBackground(new java.awt.Color(255, 255, 255));
        a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setOpaque(true);
        a3.setPreferredSize(null);

        a1text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        a1text7.setForeground(new java.awt.Color(150, 150, 150));
        a1text7.setText(" A");
        a1text7.setAlignmentX(1.0F);
        a1text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        a3.setLayer(a1text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout a3Layout = new javax.swing.GroupLayout(a3);
        a3.setLayout(a3Layout);
        a3Layout.setHorizontalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        a3Layout.setVerticalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(a1text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(a3, gridBagConstraints);

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setOpaque(true);
        b3.setPreferredSize(null);

        b1Text9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        b1Text9.setForeground(new java.awt.Color(150, 150, 150));
        b1Text9.setText(" B");
        b1Text9.setAlignmentX(1.0F);
        b1Text9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        b3.setLayer(b1Text9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b1Text9, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(b1Text9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(b3, gridBagConstraints);

        f3.setBackground(new java.awt.Color(255, 255, 255));
        f3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        f3.setForeground(new java.awt.Color(255, 255, 255));
        f3.setOpaque(true);
        f3.setPreferredSize(null);

        f1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        f1Text7.setForeground(new java.awt.Color(150, 150, 150));
        f1Text7.setText(" F");
        f1Text7.setAlignmentX(1.0F);
        f1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        f3.setLayer(f1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout f3Layout = new javax.swing.GroupLayout(f3);
        f3.setLayout(f3Layout);
        f3Layout.setHorizontalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(f1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        f3Layout.setVerticalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(f1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(f3, gridBagConstraints);

        g3.setBackground(new java.awt.Color(255, 255, 255));
        g3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g3.setForeground(new java.awt.Color(255, 255, 255));
        g3.setOpaque(true);
        g3.setPreferredSize(null);

        g1Text7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g1Text7.setForeground(new java.awt.Color(150, 150, 150));
        g1Text7.setText(" G");
        g1Text7.setAlignmentX(1.0F);
        g1Text7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        g3.setLayer(g1Text7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout g3Layout = new javax.swing.GroupLayout(g3);
        g3.setLayout(g3Layout);
        g3Layout.setHorizontalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(g1Text7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        g3Layout.setVerticalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g3Layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addComponent(g1Text7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(g3, gridBagConstraints);

        d1sharp9.setBackground(new java.awt.Color(22, 22, 22));
        d1sharp9.setForeground(new java.awt.Color(255, 255, 255));
        d1sharp9.setOpaque(true);
        d1sharp9.setPreferredSize(null);

        d1sharpText9.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        d1sharpText9.setForeground(new java.awt.Color(150, 150, 150));
        d1sharpText9.setText("D#");
        d1sharpText9.setAlignmentX(1.0F);
        d1sharpText9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        d1sharp9.setLayer(d1sharpText9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout d1sharp9Layout = new javax.swing.GroupLayout(d1sharp9);
        d1sharp9.setLayout(d1sharp9Layout);
        d1sharp9Layout.setHorizontalGroup(
            d1sharp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d1sharpText9, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        d1sharp9Layout.setVerticalGroup(
            d1sharp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1sharp9Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(d1sharpText9)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(d1sharp9, gridBagConstraints);

        c1sharp9.setBackground(new java.awt.Color(22, 22, 22));
        c1sharp9.setForeground(new java.awt.Color(255, 255, 255));
        c1sharp9.setOpaque(true);
        c1sharp9.setPreferredSize(null);

        c1sharpText9.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        c1sharpText9.setForeground(new java.awt.Color(150, 150, 150));
        c1sharpText9.setText("C#");
        c1sharpText9.setAlignmentX(1.0F);
        c1sharpText9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        c1sharp9.setLayer(c1sharpText9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c1sharp9Layout = new javax.swing.GroupLayout(c1sharp9);
        c1sharp9.setLayout(c1sharp9Layout);
        c1sharp9Layout.setHorizontalGroup(
            c1sharp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1sharpText9, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );
        c1sharp9Layout.setVerticalGroup(
            c1sharp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1sharp9Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(c1sharpText9)
                .addContainerGap())
        );

        d1sharpText1.setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 0;
        keyboardPanel.add(c1sharp9, gridBagConstraints);

        getContentPane().add(keyboardPanel);
        keyboardPanel.setBounds(0, 640, 1300, 150);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel47);
        jPanel47.setBounds(30, 500, 0, 0);

        backgroundPanel.setBackground(new java.awt.Color(0, 0, 0));
        backgroundPanel.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(backgroundPanel);
        backgroundPanel.setBounds(0, 0, 1300, 640);

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
            java.util.logging.Logger.getLogger(VirtualPiano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VirtualPiano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VirtualPiano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VirtualPiano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VirtualPiano piano;
                try {
                    piano = new VirtualPiano();
                    piano.setVisible(true);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(VirtualPiano.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VirtualPiano.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(VirtualPiano.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane a0;
    private javax.swing.JLayeredPane a0s;
    private javax.swing.JLayeredPane a1;
    private javax.swing.JLayeredPane a1s;
    private javax.swing.JLabel a1sharpText;
    private javax.swing.JLabel a1sharpText1;
    private javax.swing.JLabel a1sharpText2;
    private javax.swing.JLabel a1sharpText3;
    private javax.swing.JLabel a1sharpText4;
    private javax.swing.JLabel a1sharpText5;
    private javax.swing.JLabel a1sharpText6;
    private javax.swing.JLabel a1sharpText7;
    private javax.swing.JLabel a1text;
    private javax.swing.JLabel a1text1;
    private javax.swing.JLabel a1text2;
    private javax.swing.JLabel a1text3;
    private javax.swing.JLabel a1text4;
    private javax.swing.JLabel a1text5;
    private javax.swing.JLabel a1text6;
    private javax.swing.JLabel a1text7;
    private javax.swing.JLayeredPane a2;
    private javax.swing.JLayeredPane a2s;
    private javax.swing.JLayeredPane a3;
    private javax.swing.JLayeredPane a3s;
    private javax.swing.JLayeredPane a4;
    private javax.swing.JLayeredPane a4s;
    private javax.swing.JLayeredPane a5;
    private javax.swing.JLayeredPane a5s;
    private javax.swing.JLayeredPane a6;
    private javax.swing.JLayeredPane a6s;
    private javax.swing.JLayeredPane a7;
    private javax.swing.JLayeredPane a7s;
    private javax.swing.JLayeredPane b0;
    private javax.swing.JLayeredPane b1;
    private javax.swing.JLabel b1Text;
    private javax.swing.JLabel b1Text3;
    private javax.swing.JLabel b1Text4;
    private javax.swing.JLabel b1Text5;
    private javax.swing.JLabel b1Text6;
    private javax.swing.JLabel b1Text7;
    private javax.swing.JLabel b1Text8;
    private javax.swing.JLabel b1Text9;
    private javax.swing.JLayeredPane b2;
    private javax.swing.JLayeredPane b3;
    private javax.swing.JLayeredPane b4;
    private javax.swing.JLayeredPane b5;
    private javax.swing.JLayeredPane b6;
    private javax.swing.JLayeredPane b7;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLayeredPane c1;
    private javax.swing.JLabel c1Text;
    private javax.swing.JLabel c1Text1;
    private javax.swing.JLabel c1Text2;
    private javax.swing.JLabel c1Text3;
    private javax.swing.JLabel c1Text4;
    private javax.swing.JLabel c1Text5;
    private javax.swing.JLabel c1Text6;
    private javax.swing.JLabel c1Text7;
    private javax.swing.JLayeredPane c1s;
    private javax.swing.JLayeredPane c1sharp9;
    private javax.swing.JLabel c1sharpText1;
    private javax.swing.JLabel c1sharpText2;
    private javax.swing.JLabel c1sharpText3;
    private javax.swing.JLabel c1sharpText4;
    private javax.swing.JLabel c1sharpText5;
    private javax.swing.JLabel c1sharpText7;
    private javax.swing.JLabel c1sharpText8;
    private javax.swing.JLabel c1sharpText9;
    private javax.swing.JLayeredPane c2;
    private javax.swing.JLayeredPane c2s;
    private javax.swing.JLayeredPane c3;
    private javax.swing.JLayeredPane c3s;
    private javax.swing.JLayeredPane c4;
    private javax.swing.JLayeredPane c4s;
    private javax.swing.JLayeredPane c5;
    private javax.swing.JLayeredPane c5s;
    private javax.swing.JLayeredPane c6;
    private javax.swing.JLayeredPane c6s;
    private javax.swing.JLayeredPane c7;
    private javax.swing.JLayeredPane c7s;
    private javax.swing.JLayeredPane c8;
    private javax.swing.JLayeredPane d1;
    private javax.swing.JLabel d1Text1;
    private javax.swing.JLabel d1Text2;
    private javax.swing.JLabel d1Text3;
    private javax.swing.JLabel d1Text4;
    private javax.swing.JLabel d1Text5;
    private javax.swing.JLabel d1Text6;
    private javax.swing.JLabel d1Text7;
    private javax.swing.JLayeredPane d1s;
    private javax.swing.JLayeredPane d1sharp9;
    private javax.swing.JLabel d1sharpText1;
    private javax.swing.JLabel d1sharpText12;
    private javax.swing.JLabel d1sharpText2;
    private javax.swing.JLabel d1sharpText3;
    private javax.swing.JLabel d1sharpText4;
    private javax.swing.JLabel d1sharpText5;
    private javax.swing.JLabel d1sharpText8;
    private javax.swing.JLabel d1sharpText9;
    private javax.swing.JLayeredPane d2;
    private javax.swing.JLayeredPane d2s;
    private javax.swing.JLayeredPane d3;
    private javax.swing.JLayeredPane d3s;
    private javax.swing.JLayeredPane d4;
    private javax.swing.JLayeredPane d4s;
    private javax.swing.JLayeredPane d5;
    private javax.swing.JLayeredPane d5s;
    private javax.swing.JLayeredPane d6;
    private javax.swing.JLayeredPane d6s;
    private javax.swing.JLayeredPane d7;
    private javax.swing.JLayeredPane d7s;
    private javax.swing.JLayeredPane e1;
    private javax.swing.JLabel e1Text1;
    private javax.swing.JLabel e1Text2;
    private javax.swing.JLabel e1Text3;
    private javax.swing.JLabel e1Text4;
    private javax.swing.JLabel e1Text5;
    private javax.swing.JLabel e1Text6;
    private javax.swing.JLabel e1Text7;
    private javax.swing.JLayeredPane e2;
    private javax.swing.JLayeredPane e3;
    private javax.swing.JLayeredPane e4;
    private javax.swing.JLayeredPane e5;
    private javax.swing.JLayeredPane e6;
    private javax.swing.JLayeredPane e7;
    private javax.swing.JLayeredPane f1;
    private javax.swing.JLabel f1Text1;
    private javax.swing.JLabel f1Text2;
    private javax.swing.JLabel f1Text3;
    private javax.swing.JLabel f1Text4;
    private javax.swing.JLabel f1Text5;
    private javax.swing.JLabel f1Text6;
    private javax.swing.JLabel f1Text7;
    private javax.swing.JLayeredPane f1s;
    private javax.swing.JLabel f1sharpText1;
    private javax.swing.JLabel f1sharpText2;
    private javax.swing.JLabel f1sharpText3;
    private javax.swing.JLabel f1sharpText4;
    private javax.swing.JLabel f1sharpText5;
    private javax.swing.JLabel f1sharpText6;
    private javax.swing.JLabel f1sharpText7;
    private javax.swing.JLayeredPane f2;
    private javax.swing.JLayeredPane f2s;
    private javax.swing.JLayeredPane f3;
    private javax.swing.JLayeredPane f3s;
    private javax.swing.JLayeredPane f4;
    private javax.swing.JLayeredPane f4s;
    private javax.swing.JLayeredPane f5;
    private javax.swing.JLayeredPane f5s;
    private javax.swing.JLayeredPane f6;
    private javax.swing.JLayeredPane f6s;
    private javax.swing.JLayeredPane f7;
    private javax.swing.JLayeredPane f7s;
    private javax.swing.JLayeredPane g1;
    private javax.swing.JLabel g1Text1;
    private javax.swing.JLabel g1Text2;
    private javax.swing.JLabel g1Text3;
    private javax.swing.JLabel g1Text4;
    private javax.swing.JLabel g1Text5;
    private javax.swing.JLabel g1Text6;
    private javax.swing.JLabel g1Text7;
    private javax.swing.JLayeredPane g1s;
    private javax.swing.JLabel g1sharpText1;
    private javax.swing.JLabel g1sharpText2;
    private javax.swing.JLabel g1sharpText3;
    private javax.swing.JLabel g1sharpText4;
    private javax.swing.JLabel g1sharpText5;
    private javax.swing.JLabel g1sharpText6;
    private javax.swing.JLabel g1sharpText7;
    private javax.swing.JLayeredPane g2;
    private javax.swing.JLayeredPane g2s;
    private javax.swing.JLayeredPane g3;
    private javax.swing.JLayeredPane g3s;
    private javax.swing.JLayeredPane g4;
    private javax.swing.JLayeredPane g4s;
    private javax.swing.JLayeredPane g5;
    private javax.swing.JLayeredPane g5s;
    private javax.swing.JLayeredPane g6;
    private javax.swing.JLayeredPane g6s;
    private javax.swing.JLayeredPane g7;
    private javax.swing.JLayeredPane g7s;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel keyboardPanel;
    // End of variables declaration//GEN-END:variables
}
