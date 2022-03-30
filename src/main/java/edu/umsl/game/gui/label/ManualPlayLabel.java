package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;


public class ManualPlayLabel extends JLabel  {
    JButton btnMenu = new JButton("MENU");
    JButton headsBtn = new JButton("H");
    JButton tailsBtn = new JButton("T");
    JLabel playerSequenceLabel = new JLabel();
    JLabel computerSequenceLabel = new JLabel();
    JLabel roundsLabel = new JLabel();
    JLabel ribbonHistory = new JLabel();
    JLabel playerWins = new JLabel();
    JLabel computerWins = new JLabel();
    

    public ManualPlayLabel(){
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/manual.png"));
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

        headsBtn.setFocusable(false);
        headsBtn.setFont(new Font("Minerva", Font.PLAIN, 90));
        headsBtn.setForeground(Color.black);
        headsBtn.setBackground(new Color(230, 100, 100));
        headsBtn.setBounds(465, 335, 127, 133);
        headsBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(headsBtn);

        tailsBtn.setFocusable(false);
        tailsBtn.setFont(new Font("Minerva", Font.PLAIN, 90));
        tailsBtn.setForeground(Color.black);
        tailsBtn.setBackground(new Color(230, 100, 100));
        tailsBtn.setBounds(685, 335, 127, 133);
        tailsBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(tailsBtn);

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
    }



    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getHeadButton(){
        return headsBtn;
    }

    public JButton getTailsBtn(){
        return tailsBtn;
    }

    public JLabel getPlayerLabel(){
        return playerSequenceLabel;
    }

    public JLabel getComputerLabel(){
        return computerSequenceLabel;
    }

    public JLabel getRoundsLabel(){
        return roundsLabel;
    }

    public JLabel getRibbonLabel(){
        return ribbonHistory;
    }

    public JLabel getPlayerWinsLabel(){
        return playerWins;
    }

    public JLabel getComputerWinsLabel(){
        return computerWins;
    }


}
