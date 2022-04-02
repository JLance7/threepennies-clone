package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;


public class PlayLabel extends JLabel  {
    JButton btnMenu = new JButton("MENU");
    JLabel playerSequenceLabel = new JLabel();
    JLabel computerSequenceLabel = new JLabel();
    JLabel roundsLabel = new JLabel();
    JLabel ribbonHistory = new JLabel();
    JLabel playerWins = new JLabel();
    JLabel computerWins = new JLabel();
    JLabel playerChecks = new JLabel();
    JLabel computerChecks = new JLabel();


    public PlayLabel(String backgroundFile){
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource(backgroundFile));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        btnMenu.setFocusable(false);
        btnMenu.setFont(new Font("Minerva", Font.PLAIN, 20));
        btnMenu.setForeground(Color.black);
        btnMenu.setBackground(new Color(230, 100, 100));
        btnMenu.setBounds(0, 0, 70, 40);
        btnMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(btnMenu);

        Font sequenceFont = new Font("Minerva", Font.PLAIN, 65);
        playerSequenceLabel.setFont(sequenceFont);
        playerSequenceLabel.setForeground(Color.black);
        playerSequenceLabel.setBounds(90, 15, 200, 200);
        this.add(playerSequenceLabel);

        computerSequenceLabel.setFont(sequenceFont);
        computerSequenceLabel.setForeground(Color.black);
        computerSequenceLabel.setBounds(1085, 15, 200, 200);
        this.add(computerSequenceLabel);

        roundsLabel.setFont(new Font("Minerva", Font.PLAIN, 48));
        roundsLabel.setForeground(Color.black);
        roundsLabel.setBounds(692, 135, 100, 100);
        this.add(roundsLabel);

        ribbonHistory.setFont(new Font("Minerva", Font.PLAIN, 48));
        ribbonHistory.setForeground(Color.black);
        ribbonHistory.setBounds(0, 590, 1280, 100);
        ribbonHistory.setHorizontalAlignment(JLabel.CENTER);
        this.add(ribbonHistory);

        playerWins.setText("Wins: ");
        playerWins.setFont(new Font("Minerva", Font.PLAIN, 32));
        playerWins.setForeground(Color.black);
        playerWins.setBounds(30, 175, 200, 100);
        this.add(playerWins);

        computerWins.setText("Wins: ");
        computerWins.setFont(new Font("Minerva", Font.PLAIN, 32));
        computerWins.setForeground(Color.black);
        computerWins.setBounds(1032, 175, 200, 100);
        this.add(computerWins);

        playerChecks.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 40));
        playerChecks.setForeground(Color.green);
        playerChecks.setBounds(90, 87, 200, 200);
        this.add(playerChecks);

        computerChecks.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 40));
        computerChecks.setForeground(Color.red);
        computerChecks.setBounds(1085, 87, 200, 200);
        this.add(computerChecks);
    }

    public JButton getBtnMenu() { return btnMenu; }

    public JLabel getPlayerLabel(){ return playerSequenceLabel; }

    public JLabel getComputerLabel(){ return computerSequenceLabel; }

    public JLabel getRoundsLabel(){ return roundsLabel; }

    public JLabel getRibbonLabel(){ return ribbonHistory; }

    public JLabel getPlayerWinsLabel(){ return playerWins; }

    public JLabel getComputerWinsLabel(){ return computerWins; }

    public JLabel getPlayerChecks() { return playerChecks; }

    public JLabel getComputerChecks() { return computerChecks; }

}
