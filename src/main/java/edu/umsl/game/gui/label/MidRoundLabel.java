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
            image = new ImageIcon(getClass().getClassLoader().getResource("images/MidRound.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set attributes for player/computer win labels
        playerWinLabel.setText("0");
        computerWinLabel.setText("0");
        playerWinLabel.setFont(new Font("Minerva", Font.PLAIN, 80));
        computerWinLabel.setFont(new Font("Minerva", Font.PLAIN, 80));
        playerWinLabel.setForeground(Color.BLACK);
        computerWinLabel.setForeground(Color.BLACK);
        playerWinLabel.setFocusable(false);
        computerWinLabel.setFocusable(false);
        playerWinLabel.setBounds(540, 310, 100, 100);
        computerWinLabel.setBounds(635, 310, 100, 100);
        playerWinLabel.setHorizontalAlignment(JLabel.CENTER);
        computerWinLabel.setHorizontalAlignment(JLabel.CENTER);


        //Set text value of button
        btnMenu.setText("MENU");
        btnContinue.setText("CONTINUE");
        //set font and size for button text
        btnMenu.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnContinue.setFont(new Font("Minerva", Font.PLAIN, 50));
        //set text color of button
        btnMenu.setForeground(Color.BLACK);
        btnContinue.setForeground(Color.BLACK);
        //set border for button to make it more visually appealing
        btnMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        btnContinue.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of button
        btnMenu.setBackground(new Color(255, 178, 11));
        btnContinue.setBackground(new Color(255, 178, 11));
        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        btnContinue.setFocusable(false);
        //set bounds for the button, also giving its location on the midround label
        btnMenu.setBounds(302, 550, 275, 75);
        btnContinue.setBounds(700, 550, 275, 75);
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
