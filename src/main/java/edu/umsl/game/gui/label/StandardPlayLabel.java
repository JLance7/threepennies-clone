package edu.umsl.game.gui.label;

import edu.umsl.game.backend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardPlayLabel extends JLabel  {
    JButton btnMenu = new JButton("MENU");
    JLabel playerSequenceLabel = new JLabel();
    JLabel computerSequenceLabel = new JLabel();
    JLabel roundsLabel = new JLabel();
    JLabel ribbonHistory = new JLabel();
    JLabel playerWins = new JLabel();
    JLabel computerWins = new JLabel();
    JButton bt1 = new JButton();
    JButton bt2 = new JButton();
    JButton bt3 = new JButton();


    public StandardPlayLabel(){
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/standard.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        btnMenu.setFocusable(false);
        btnMenu.setFont(new Font("Minerva", Font.PLAIN, 20));
        btnMenu.setForeground(Color.black);
        btnMenu.setBackground(new Color(16, 172, 244));
        btnMenu.setBounds(0, 0, 70, 40);
        btnMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(btnMenu);

        bt1.setFocusable(false);
        bt1.setFont(new Font("Minerva", Font.PLAIN, 90));
        bt1.setForeground(Color.black);
        bt1.setBackground(new Color(16, 172, 244));
        bt1.setBounds(394, 335, 127, 133);
        bt1.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(bt1);

        bt2.setFocusable(false);
        bt2.setFont(new Font("Minerva", Font.PLAIN, 90));
        bt2.setForeground(Color.black);
        bt2.setBackground(new Color(16, 172, 244));
        bt2.setBounds(574, 335, 127, 133);
        bt2.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(bt2);

        bt3.setFocusable(false);
        bt3.setFont(new Font("Minerva", Font.PLAIN, 90));
        bt3.setForeground(Color.black);
        bt3.setBackground(new Color(16, 172, 244));
        bt3.setBounds(754, 335, 127, 133);
        bt3.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(bt3);


        Font sequenceFont = new Font("Minerva", Font.PLAIN, 65);
        playerSequenceLabel.setFont(sequenceFont);
        playerSequenceLabel.setForeground(Color.black);
        playerSequenceLabel.setBounds(85, 15, 200, 200);
        this.add(playerSequenceLabel);

        computerSequenceLabel.setFont(sequenceFont);
        computerSequenceLabel.setForeground(Color.black);
        computerSequenceLabel.setBounds(1080, 15, 200, 200);
        this.add(computerSequenceLabel);

        roundsLabel.setFont(new Font("Minerva", Font.PLAIN, 48));
        roundsLabel.setForeground(Color.black);
        roundsLabel.setBounds(692, 135, 100, 100);
        this.add(roundsLabel);

        ribbonHistory.setFont(new Font("Minerva", Font.PLAIN, 48));
        ribbonHistory.setForeground(Color.black);
        ribbonHistory.setBounds(20, 590, 1280, 100);
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

    public JButton getBt1(){
        return bt1;
    }

    public JButton getBt2(){
        return bt2;
    }

    public JButton getBt3(){
        return bt3;
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
    
    public JLabel getRibbonHistory() { return ribbonHistory; }
}
