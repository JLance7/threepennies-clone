package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;

public class StandardPlayLabel extends PlayLabel {
    JButton flipButton;
    ImageIcon headImg = new ImageIcon(getClass().getClassLoader().getResource("images/heads.png"));
    ImageIcon tailsImg = new ImageIcon(getClass().getClassLoader().getResource("images/tails.png"));
    Image tailsScaled = tailsImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    Image headScaled = headImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

    ImageIcon headScaledIcon = new ImageIcon(headScaled);
    ImageIcon tailsScaledIcon = new ImageIcon(tailsScaled);
    String side = "H";

    public StandardPlayLabel(String backgroundLocation, String howToString) {
        super(backgroundLocation, howToString);

        flipButton = new JButton();
        Color blue = new Color(39, 120, 232);
        btnMenu.setBackground(blue);
        explanation.setBackground(blue);

        flipButton.setIcon(headScaledIcon);
        flipButton.setFocusable(false);
        flipButton.setBorderPainted(false);
        flipButton.setContentAreaFilled(false);
        flipButton.setFocusPainted(false);
        flipButton.setOpaque(false);
        flipButton.setBackground(new Color(39, 120, 232));
        flipButton.setBounds(530, 220, 220, 220);
        this.add(flipButton);
    }

    public JButton getFlipButton(){ return flipButton; }

    public String getSide(){ return side; }

    public void setSide(String side){ this.side = side; }
}
