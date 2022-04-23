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
    JLabel placeholder = new JLabel();


    public PlayLabel(String backgroundFile, String howToPlay){
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource(backgroundFile));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        ImageIcon menuIcon = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtn.png"));
        ImageIcon menuIconPressed = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtnPressed.png"));
        btnMenu.setIcon(menuIcon);
        btnMenu.setRolloverIcon(menuIconPressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);
        btnMenu.setBounds(910, 420, 300, 75);
        this.add(btnMenu);

        Font sequenceFont = new Font("Orbitron", Font.PLAIN, 65);
        playerSequenceLabel.setFont(sequenceFont);
        playerSequenceLabel.setForeground(Color.white);
        playerSequenceLabel.setBounds(90, 90, 200, 200);
        this.add(playerSequenceLabel);

        computerSequenceLabel.setFont(sequenceFont);
        computerSequenceLabel.setForeground(Color.white);
        computerSequenceLabel.setBounds(1015, 90, 200, 200);
        this.add(computerSequenceLabel);

        roundsLabel.setFont(new Font("Orbitron", Font.PLAIN, 36));
        roundsLabel.setForeground(Color.white);
        roundsLabel.setBounds(700, 115, 100, 100);
        this.add(roundsLabel);

        ribbonHistory.setFont(new Font("Orbitron", Font.PLAIN, 48));
        ribbonHistory.setForeground(Color.white);
        ribbonHistory.setBounds(-5, 552, 1280, 100);
        ribbonHistory.setHorizontalAlignment(JLabel.CENTER);
        this.add(ribbonHistory);

        playerWins.setText("Wins: ");
        playerWins.setFont(new Font("Orbitron", Font.PLAIN, 32));
        playerWins.setForeground(Color.white);
        playerWins.setBounds(90, 250, 200, 100);
        this.add(playerWins);

        computerWins.setText("Wins: ");
        computerWins.setFont(new Font("Orbitron", Font.PLAIN, 32));
        computerWins.setForeground(Color.white);
        computerWins.setBounds(1015, 250, 200, 100);
        this.add(computerWins);

        playerChecks.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 60));
        playerChecks.setForeground(Color.green);
        playerChecks.setBounds(102, 145, 200, 200);
        this.add(playerChecks);

        computerChecks.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 60));
        computerChecks.setForeground(Color.red);
        computerChecks.setBounds(1024, 145, 200, 200);
        this.add(computerChecks);

        ImageIcon rulesIcon = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playHowToBtn.png"));
        ImageIcon rulesIconPressed = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playHowToBtnPressed.png"));
        explanation.setIcon(rulesIcon);
        explanation.setRolloverIcon(rulesIconPressed);
        explanation.setContentAreaFilled(false);
        explanation.setBorderPainted(false);
        explanation.setFocusable(false);
        explanation.setBounds(80, 420, 300, 75);
        explanation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //play button click music
                MusicPlayer music;
                String fileName = "sounds/buttonClick.wav";
                music = new MusicPlayer();
                music.playMusic(fileName, false);
                //placeholder.setText(howToPlay);
                placeholder.setVisible(false);

                //JOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue)
                JLabel text = new JLabel(howToPlay);
                text.setFont(new Font("Orbitron", Font.PLAIN, 22));
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
