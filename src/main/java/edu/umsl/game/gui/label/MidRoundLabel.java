package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class MidRoundLabel extends JLabel {
    //declare button outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();
    private final JButton btnContinue = new JButton();
    JLabel playerWinLabel = new JLabel();
    JLabel computerWinLabel = new JLabel();

    //use default constructor to create instance of the midround screen with standard settings
    public MidRoundLabel() {
        //set up background image of midround screen
        ImageIcon image = null;
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("images/MidRoundLabelImages/midroundv2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set attributes for player/computer win labels
        playerWinLabel.setText("0");
        computerWinLabel.setText("0");
        playerWinLabel.setFont(new Font("", Font.PLAIN, 80));
        computerWinLabel.setFont(new Font("", Font.PLAIN, 80));
        playerWinLabel.setForeground(Color.white);
        computerWinLabel.setForeground(Color.white);
        playerWinLabel.setFocusable(false);
        computerWinLabel.setFocusable(false);
        playerWinLabel.setBounds(258, 369, 100, 100);
        computerWinLabel.setBounds(913, 369, 100, 100);
        playerWinLabel.setHorizontalAlignment(JLabel.CENTER);
        computerWinLabel.setHorizontalAlignment(JLabel.CENTER);

        //add button images and attributes
        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtnPressed.png"));
        ImageIcon continueImage = new ImageIcon(getClass().getClassLoader().getResource("images/MidRoundLabelImages/continueBtn.png"));
        ImageIcon continueImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/MidRoundLabelImages/continueBtnPressed.png"));
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnContinue.setIcon(continueImage);
        btnContinue.setRolloverIcon(continueImagePressed);
        btnContinue.setContentAreaFilled(false);
        btnContinue.setBorderPainted(false);
        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        btnContinue.setFocusable(false);
        //set bounds for the button, also giving its location on the midround label
        btnMenu.setBounds(302, 550, 300, 75);
        btnContinue.setBounds(700, 550, 300, 75);
        //add buttons and labels to the midround label
        this.add(btnMenu);
        this.add(btnContinue);
        this.add(computerWinLabel);
        this.add(playerWinLabel);


    }

    //getter for button to be used in GameFrame
    public JButton getBtnMenu() {
        return btnMenu;
    }
    public JButton getBtnContinue() {
        return btnContinue;
    }
    public JLabel getComputerWinLabel() {
        return computerWinLabel;
    }
    public JLabel getPlayerWinLabel() {
        return playerWinLabel;
    }
}
