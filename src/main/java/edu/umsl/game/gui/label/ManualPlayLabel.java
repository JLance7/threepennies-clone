package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManualPlayLabel extends PlayLabel {
    JButton headsBtn = new JButton();
    JButton tailsBtn = new JButton();
    ImageIcon headImg = new ImageIcon(getClass().getClassLoader().getResource("images/heads.png"));
    ImageIcon tailsImg = new ImageIcon(getClass().getClassLoader().getResource("images/tails.png"));

    public ManualPlayLabel(String backgroundLocation, String howToString){
        super(backgroundLocation, howToString);


        Image headScaled = headImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon headScaledIcon = new ImageIcon(headScaled);
        Image tailsScaled = tailsImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon tailsScaledIcon = new ImageIcon(tailsScaled);

        //headsBtn.setIcon(headImg);
        headsBtn.setFocusable(false);
        headsBtn.setBounds(420, 240, 200, 200);
        headsBtn.setIcon(headScaledIcon);
        headsBtn.setBorderPainted(false);
        headsBtn.setContentAreaFilled(false);
        headsBtn.setFocusPainted(false);
        headsBtn.setOpaque(false);
        this.add(headsBtn);

        tailsBtn.setFocusable(false);
        tailsBtn.setIcon(tailsScaledIcon);
        tailsBtn.setBounds(670, 240, 200, 200);
        tailsBtn.setBorderPainted(false);
        tailsBtn.setContentAreaFilled(false);
        tailsBtn.setFocusPainted(false);
        tailsBtn.setOpaque(false);
        this.add(tailsBtn);
    }

    public JButton getHeadButton(){ return headsBtn; }

    public JButton getTailsBtn(){ return tailsBtn; }
}