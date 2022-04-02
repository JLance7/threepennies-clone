package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;


public class StandardPlayLabel extends PlayLabel {
    JButton flipButton;

    public StandardPlayLabel() {
        super("images/standard.png");

        btnMenu.setBackground(Color.blue);
        flipButton = new JButton("H");
        flipButton.setFont(new Font("Minerva", Font.PLAIN, 90));
        flipButton.setForeground(Color.black);
        flipButton.setFocusable(false);
        flipButton.setBackground(new Color(39, 120, 232));
        flipButton.setBounds(560, 320, 127, 133);
        flipButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(flipButton);
    }

    public JButton getFlipButton(){ return flipButton; }
}
