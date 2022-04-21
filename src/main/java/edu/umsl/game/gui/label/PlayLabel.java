package edu.umsl.game.gui.label;

import edu.umsl.game.backend.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class PlayLabel extends JLabel  {
    JButton btnMenu = new JButton("MENU");
    JLabel playerSequenceLabel = new JLabel();
    JLabel computerSequenceLabel = new JLabel();
    JLabel roundsLabel = new JLabel();
    JLabel ribbonHistory = new JLabel();
    JLabel playerWins = new JLabel();
    JLabel computerWins = new JLabel();
    JLabel playerChecks = new JLabel();
    JLabel computerChecks = new JLabel();
    JButton explanation = new JButton();


    public PlayLabel(String backgroundFile, String howToPlay){
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
        ribbonHistory.setBounds(-5, 590, 1280, 100);
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

        explanation.setFont(new Font("Minerva", Font.PLAIN, 22));
        explanation.setForeground(Color.black);
        explanation.setFocusable(false);
        explanation.setBackground(new Color(230, 100, 100));
        explanation.setBounds(70, 420, 140, 70);
        explanation.setBorder(BorderFactory.createRaisedBevelBorder());
        explanation.setText("How to play");
        explanation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //play button click music
                MusicPlayer music;
                String fileName = "sounds/buttonClick.wav";
                music = new MusicPlayer();
                music.playMusic(fileName, false);

                JLabel text = new JLabel(howToPlay);
                JOptionPane optionPane = new JOptionPane(text, JOptionPane.PLAIN_MESSAGE)
                {
                    @Override
                    public void selectInitialValue()
                    {
                        text.requestFocus();
                    }
                };
                optionPane.createDialog(null, "How to Play").setVisible(true);
            }
        });
        this.add(explanation);
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

    private static void recursiveUnfocusButtons(Component component) {
        if (component instanceof JButton) {
            component.setFocusable(false);
            return;
        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                recursiveUnfocusButtons(c);
            }
        }
    }

}
