package edu.umsl.game.gui.frame;

//import MainMenuPanel access and swing wildcard for GUI development
import javax.swing.*;
import edu.umsl.game.backend.Controller;
import edu.umsl.game.backend.MusicPlayer;
import edu.umsl.game.gui.label.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//extend JFrame for use of java super class
public  class GameFrame extends JFrame
{
    MusicPlayer music;
    Controller controller;
    MainMenuLabel mainMenuLabel;
    ManualPlayLabel manualPlayLabel;
    StandardPlayLabel standardPlayLabel;
    SequenceLabel standardSequenceLabel;
    SequenceLabel manualSequenceLabel;
    MidRoundLabel manualMidRoundLabel;
    MidRoundLabel standardMidRoundLabel;


    //default constructor to prepare instance of the GameFrame with standard arrangement
    public GameFrame()
    {
        //play music
        String fileName = "sounds/Elevator-by-Kevin-Macleod.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, true);

        controller = new Controller();
        this.setTitle("Three Pennies");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLayout(null);

        //set border icon for game
        //changed images location format so that they load when jar is created
        ImageIcon icon = null;
        try{
            icon = new ImageIcon(getClass().getClassLoader().getResource("images/gameIcon.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIconImage(icon.getImage());

        //Add instance of every label to be turned on or off depending on need
        mainMenuLabel = new MainMenuLabel();
        this.add(mainMenuLabel);

        ExampleLabel exampleLabel = new ExampleLabel();
        this.add(exampleLabel);

        RulesLabel rulesLabel = new RulesLabel();
        this.add(rulesLabel);

        standardSequenceLabel = new SequenceLabel();
        this.add(standardSequenceLabel);

        manualSequenceLabel = new SequenceLabel();
        this.add(manualSequenceLabel);

        manualPlayLabel = new ManualPlayLabel();
        this.add(manualPlayLabel);

        standardPlayLabel = new StandardPlayLabel();
        this.add(standardPlayLabel);

        standardMidRoundLabel = new MidRoundLabel();
        this.add(standardMidRoundLabel);

        manualMidRoundLabel = new MidRoundLabel();
        this.add(manualMidRoundLabel);


        //set visibility of all labels other than mainMenuLabel to false until needed
        exampleLabel.setVisible(false);
        rulesLabel.setVisible(false);
        standardSequenceLabel.setVisible(false);
        manualSequenceLabel.setVisible(false);
        manualPlayLabel.setVisible(false);
        standardPlayLabel.setVisible(false);
        standardMidRoundLabel.setVisible(false);
        manualMidRoundLabel.setVisible(false);

        //set visibility to true at end to avoid potential conflicts
        this.setVisible(true);
        //center frame
        this.setLocationRelativeTo(null);

        /*
        The following block of code consists of actions being fed to action listeners for every button
        on the frame. The first parameter in the lambda expression is the page that it is coming from,
        the second parameter is the page that it is going to.
        */
        //main menu button changes
        mainMenuLabel.getBtnExample().addActionListener(e -> changeLabel(mainMenuLabel, exampleLabel));
        mainMenuLabel.getBtnStandard().addActionListener(e -> changeLabel(mainMenuLabel, standardSequenceLabel));
        mainMenuLabel.getBtnManual().addActionListener(e -> changeLabel(mainMenuLabel, manualSequenceLabel));
        mainMenuLabel.getBtnRules().addActionListener(e -> changeLabel(mainMenuLabel, rulesLabel));

        //example label (How it works)
        exampleLabel.getBtnMenu().addActionListener(e -> changeLabel(exampleLabel, mainMenuLabel));

        //rules label (How to play)
        rulesLabel.getBtnMenu().addActionListener(e -> changeLabel(rulesLabel, mainMenuLabel));

        //manual sequence (before manual play)
        manualSequenceLabel.getBtnSubmit().addActionListener
                (e -> sequenceLabelChange(manualSequenceLabel, manualPlayLabel, manualSequenceLabel.getSequence(), true));

        //standard sequence (before standard play)
        standardSequenceLabel.getBtnSubmit().addActionListener
                (e -> sequenceLabelChange(standardSequenceLabel, standardPlayLabel, standardSequenceLabel.getSequence(), false));

        //manual play
        manualPlayLabel.getBtnMenu().addActionListener(e -> changeLabel(manualPlayLabel, mainMenuLabel));
        manualPlayLabel.getHeadButton().addActionListener(e -> { handleManualLogic("H"); });
        manualPlayLabel.getTailsBtn().addActionListener(e -> { handleManualLogic("T"); });

        //standard play
        standardPlayLabel.getBtnMenu().addActionListener(e -> changeLabel(standardPlayLabel, mainMenuLabel));
        standardPlayLabel.getFlipButton().addActionListener(e -> handleStandardLogic());

        //MidRound Screen
        manualMidRoundLabel.getBtnMenu().addActionListener(e -> changeLabel(manualMidRoundLabel, mainMenuLabel));
        manualMidRoundLabel.getBtnContinue().addActionListener(e -> changeLabel(manualMidRoundLabel, manualPlayLabel));

        //win/lose screen

    }

    //function to transfer visibility from one label to another
    public void changeLabel(JLabel start, JLabel end)
    {
        //play button click music
        String fileName = "sounds/buttonClick.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, false);
        start.setVisible(false);
        end.setVisible(true);
        //if changing to manualSequence/standardSequence again reset game states
        if (start == mainMenuLabel &&  end == manualSequenceLabel || start == mainMenuLabel && end == standardSequenceLabel){
            controller = new Controller();
            JLabel playerWins = manualPlayLabel.getPlayerWinsLabel();
            JLabel computerWins = manualPlayLabel.getComputerWinsLabel();
            JLabel ribbonHistory = manualPlayLabel.getRibbonLabel();

            playerWins.setText("Wins: 0");
            computerWins.setText("Wins: 0");
            ribbonHistory.setText("");
        }
        if (start == mainMenuLabel){
            //reset sequence page
            standardSequenceLabel.getLblSequence1().setText("H");
            standardSequenceLabel.getLblSequence2().setText("H");
            standardSequenceLabel.getLblSequence3().setText("H");
            manualSequenceLabel.getLblSequence1().setText("H");
            manualSequenceLabel.getLblSequence2().setText("H");
            manualSequenceLabel.getLblSequence3().setText("H");
        }
    }

    //from sequenceLabel to manual/standard play label, gives it the sequence (when submit button is clicked on sequence page)
    public void sequenceLabelChange(JLabel start, JLabel end, String sequence, boolean manualPlay){
        //play button click music
        String fileName = "sounds/buttonClick.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, false);

        JLabel manualPlayer = manualPlayLabel.getPlayerLabel();
        JLabel manualComputer = manualPlayLabel.getComputerLabel();
        JLabel manualRounds = manualPlayLabel.getRoundsLabel();
        JLabel manualRibbon = manualPlayLabel.getRibbonLabel();

        JLabel standardPlayer = standardPlayLabel.getPlayerLabel();
        JLabel standardComputer = standardPlayLabel.getComputerLabel();
        JLabel standardRounds = standardPlayLabel.getRoundsLabel();
        JLabel standardRibbon = standardPlayLabel.getRibbonLabel();

        start.setVisible(false);
        end.setVisible(true);

        controller.setUserSequence(sequence);
        controller.incrementRounds();

        if (manualPlay){
            controller.setGameVersion("manual");
            manualPlayer.setText(sequence);
            manualComputer.setText(controller.getComputerSequence());
            manualRounds.setText(String.valueOf(controller.getRounds()));
            controller.setRibbonText("");
            manualRibbon.setText("");
        }
        else{
            controller.setGameVersion("standard");
            standardPlayer.setText(sequence);
            standardComputer.setText(controller.getComputerSequence());
            standardRounds.setText(String.valueOf(controller.getRounds()));
            controller.setRibbonText("");
            standardRibbon.setText("");
        }
    }

    //when head or tail button is clicked in manual
    public void handleManualLogic(String coin) {
        //play button click music
        String fileName = "sounds/coin flip.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, false);

        JLabel playerWinLabel = manualPlayLabel.getPlayerWinsLabel();
        JLabel computerWinLabel = manualPlayLabel.getComputerWinsLabel();
        JLabel ribbon = manualPlayLabel.getRibbonLabel();
        JLabel roundCount = manualPlayLabel.getRoundsLabel();
        JLabel playerChecksLabel = manualPlayLabel.getPlayerChecks();
        JLabel computerChecksLabel = manualPlayLabel.getComputerChecks();

        String win = controller.coinFlipped(coin);
        ribbon.setText(controller.getRibbonText());

        //set check marks
        int[] indexes = controller.getPlayerAndComputerPosition();
        int playerChecks = indexes[0];
        int computerChecks = indexes[1];
        String playerChecksString = "", computerChecksString = "";

        System.out.println("playerchecks: " + playerChecks);
        System.out.println("computerchecks: " + computerChecks);

        for (int i=0; i<playerChecks; i++){
            playerChecksString += "\u2713";
        }
        for (int i=0; i<computerChecks; i++){
            computerChecksString += "\u2713";
        }
        manualPlayLabel.getPlayerChecks().setText(playerChecksString);
        manualPlayLabel.getComputerChecks().setText(computerChecksString);

        Timer timer;
        if (win == "player"){
            playerWinLabel.setText("Wins: " + String.valueOf(controller.getPlayerWins()));
            controller.setRibbonText("");
            controller.incrementRounds();
            roundCount.setText(String.valueOf(controller.getRounds()));
            ribbon.setText("");
            playerChecksLabel.setText("");
            computerChecksLabel.setText("");
            controller.setComputerChecks(0);
            controller.setPlayerChecks(0);

            //mid win screen
            manualMidRoundLabel.getPlayerWinLabel().setText(String.valueOf(controller.getPlayerWins()));
            manualMidRoundLabel.setVisible(true);
            manualPlayLabel.setVisible(false);

        } else if (win == "computer"){
            computerWinLabel.setText("Wins: " + String.valueOf(controller.getComputerWins()));
            controller.setRibbonText("");
            controller.incrementRounds();
            roundCount.setText(String.valueOf(controller.getRounds()));
            ribbon.setText("");
            playerChecksLabel.setText("");
            computerChecksLabel.setText("");
            controller.setComputerChecks(0);
            controller.setPlayerChecks(0);

            //mid win screen
            manualMidRoundLabel.getPlayerWinLabel().setText(String.valueOf(controller.getPlayerWins()));
            manualMidRoundLabel.setVisible(true);
            manualPlayLabel.setVisible(false);
        }

        //if 10 wins are won go to win or lose screen
        String totalWins = controller.checkTotalWins();
        if (totalWins == "player"){
            changeLabel(manualPlayLabel, mainMenuLabel);
            manualMidRoundLabel.setVisible(false);
        } else if (totalWins == "computer"){
            changeLabel(manualPlayLabel, mainMenuLabel);
            manualMidRoundLabel.setVisible(false);
        }
    }

    //TODO implement this function or take it out
    public void handleStandardLogic(){
        //play button click music
        String fileName = "sounds/coin flip.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, false);
    }
}
