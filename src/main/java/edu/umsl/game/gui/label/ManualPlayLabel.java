package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;


public class ManualPlayLabel extends PlayLabel {
    JButton headsBtn = new JButton("H");
    JButton tailsBtn = new JButton("T");


    public ManualPlayLabel(){
        super("images/manual.png");

        headsBtn.setFocusable(false);
        headsBtn.setFont(new Font("Minerva", Font.PLAIN, 90));
        headsBtn.setForeground(Color.black);
        headsBtn.setBackground(new Color(230, 100, 100));
        headsBtn.setBounds(465, 320, 127, 133);
        headsBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(headsBtn);

        tailsBtn.setFocusable(false);
        tailsBtn.setFont(new Font("Minerva", Font.PLAIN, 90));
        tailsBtn.setForeground(Color.black);
        tailsBtn.setBackground(new Color(230, 100, 100));
        tailsBtn.setBounds(685, 320, 127, 133);
        tailsBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(tailsBtn);
    }

    public JButton getHeadButton(){
        return headsBtn;
    }

    public JButton getTailsBtn(){
        return tailsBtn;
    }

}