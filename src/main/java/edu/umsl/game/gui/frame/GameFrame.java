package edu.umsl.game.gui.frame;

//import MainMenuPanel access and swing wildcard for GUI development
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import edu.umsl.game.backend.Controller;
import edu.umsl.game.backend.MusicPlayer;
import edu.umsl.game.gui.label.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;


//extend JFrame for use of java super class
public  class GameFrame extends JFrame implements ActionListener
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
    Timer timer;


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

        String backgroundLocation = "images/manual.png";
        String howToString = "Flip your own coin in real life and then choose the side you flipped. Be honest :)" +
        "\nThe first person to get a complete sequence of 3 that matches their own sequence wins that round. First to 10 wins the game!";
        manualPlayLabel = new ManualPlayLabel(backgroundLocation, howToString);
        this.add(manualPlayLabel);

        backgroundLocation = "images/standard.png";
        howToString = "Flip the coin for to get a random flip of heads or tails" +
        "\nThe first person to get a complete sequence of 3 that matches their own sequence wins that round. First to 10 wins the game!";
        standardPlayLabel = new StandardPlayLabel(backgroundLocation, howToString);
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
        manualPlayLabel.getHeadButton().addActionListener(this);
        manualPlayLabel.getTailsBtn().addActionListener(this);

        //standard play
        standardPlayLabel.getBtnMenu().addActionListener(e -> changeLabel(standardPlayLabel, mainMenuLabel));
        standardPlayLabel.getFlipButton().addActionListener(this);

        //MidRound Screen
        manualMidRoundLabel.getBtnMenu().addActionListener(e -> changeLabel(manualMidRoundLabel, mainMenuLabel));
        manualMidRoundLabel.getBtnContinue().addActionListener(e -> changeLabel(manualMidRoundLabel, manualPlayLabel));
        standardMidRoundLabel.getBtnMenu().addActionListener(e -> changeLabel(standardMidRoundLabel, mainMenuLabel));
        standardMidRoundLabel.getBtnContinue().addActionListener(e -> changeLabel(standardMidRoundLabel, standardPlayLabel));

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
            JLabel playerWinsStandard = standardPlayLabel.getPlayerWinsLabel();
            JLabel computerWinsStandard = standardPlayLabel.getComputerWinsLabel();
            JLabel ribbonHistoryStandard = standardPlayLabel.getRibbonLabel();

            playerWins.setText("Wins: 0");
            computerWins.setText("Wins: 0");
            ribbonHistory.setText("");
            playerWinsStandard.setText("Wins: 0");
            computerWinsStandard.setText("Wins: 0");
            ribbonHistoryStandard.setText("");
            manualMidRoundLabel.getComputerWinLabel().setText("0");
            manualMidRoundLabel.getPlayerWinLabel().setText("0");
            standardMidRoundLabel.getComputerWinLabel().setText("0");
            standardMidRoundLabel.getPlayerWinLabel().setText("0");

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
        if (start == manualMidRoundLabel ){
            //add action listener back after winning a round
            manualPlayLabel.getHeadButton().addActionListener(this);
            manualPlayLabel.getTailsBtn().addActionListener(this);
        }
        if (start == standardMidRoundLabel){
            standardPlayLabel.getFlipButton().addActionListener(this);
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

        setCheckMarks(true);

        Timer timer;
        if (win == "player" || win == "computer"){
            if (win == "player")
                playerWinLabel.setText("Wins: " + String.valueOf(controller.getPlayerWins()));
            else
                computerWinLabel.setText("Wins: " + String.valueOf(controller.getComputerWins()));

            manualPlayLabel.getHeadButton().removeActionListener(this);
            manualPlayLabel.getTailsBtn().removeActionListener(this);

            //pause screen after win
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.setRibbonText("");
                    controller.incrementRounds();
                    roundCount.setText(String.valueOf(controller.getRounds()));
                    ribbon.setText("");
                    playerChecksLabel.setText("");
                    computerChecksLabel.setText("");
                    controller.setComputerChecks(0);
                    controller.setPlayerChecks(0);

                    //mid win screen
                    if (win == "player")
                        manualMidRoundLabel.getPlayerWinLabel().setText(String.valueOf(controller.getPlayerWins()));
                    else
                        manualMidRoundLabel.getComputerWinLabel().setText(String.valueOf(controller.getComputerWins()));

                    manualMidRoundLabel.setVisible(true);
                    manualPlayLabel.setVisible(false);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

        //TODO use this ifelse to switch to end screen
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

    public void handleStandardLogic() throws InterruptedException {
        //play button click music
        String fileName = "sounds/coin flip.wav";
        music = new MusicPlayer();
        music.playMusic(fileName, false);

        //random number between 1 and 6 for how many flips (flip coin randomly)
        Random random = new Random();
        final int[] flips = {random.nextInt(6 - 1) + 1};
        //System.out.println("Flips is:" + flips[0]);

        ImageIcon headImg = new ImageIcon(getClass().getClassLoader().getResource("images/heads.png"));
        ImageIcon tailsImg = new ImageIcon(getClass().getClassLoader().getResource("images/tails.png"));
        Image tailsScaled = tailsImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Image headScaled = headImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

        ImageIcon headGif = new ImageIcon(getClass().getClassLoader().getResource("images/H to T.gif"));
        ImageIcon tailsGif = new ImageIcon(getClass().getClassLoader().getResource("images/T to H.gif"));
        Image headsGifScaled = headGif.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Image tailsGifScaled = tailsGif.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

        ImageIcon headScaledIcon = new ImageIcon(headScaled);
        ImageIcon tailsScaledIcon = new ImageIcon(tailsScaled);
        ImageIcon headsGifIcon = new ImageIcon(headsGifScaled);
        ImageIcon tailsGifIcon = new ImageIcon(tailsGifScaled);

        //delay half a second (flip coin random number of times)
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char currentSide = standardPlayLabel.getSide().charAt(0);
                if (flips[0] == 0) {
                    timer.stop();
                    continueStandardLogic();
                }
                //System.out.println("Side is: " + standardPlayLabel.getFlipButton().getText().charAt(0));
                else if (currentSide == 'H'){
                    standardPlayLabel.setSide("T");
                    standardPlayLabel.getFlipButton().setIcon(headsGifIcon);
                    Timer newTimer = new Timer(30, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            standardPlayLabel.getFlipButton().setIcon(tailsScaledIcon);
                        }
                    });
                    newTimer.setRepeats(false);
                    newTimer.start();
                } else {
                    standardPlayLabel.setSide("H");
                    standardPlayLabel.getFlipButton().setIcon(tailsGifIcon);
                    Timer newTimer = new Timer(30, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            standardPlayLabel.getFlipButton().setIcon(headScaledIcon);;
                        }
                    });
                    newTimer.setRepeats(false);
                    newTimer.start();
                }
                flips[0]--;
            }
        };
        timer = new Timer(500, action);
        timer.setInitialDelay(0);
        timer.start();
        standardPlayLabel.getFlipButton().removeActionListener(this);
    }

    public void continueStandardLogic(){
        JLabel playerWinLabel = standardPlayLabel.getPlayerWinsLabel();
        JLabel computerWinLabel = standardPlayLabel.getComputerWinsLabel();
        JLabel ribbon = standardPlayLabel.getRibbonLabel();
        JLabel roundCount = standardPlayLabel.getRoundsLabel();
        JLabel playerChecksLabel = standardPlayLabel.getPlayerChecks();
        JLabel computerChecksLabel = standardPlayLabel.getComputerChecks();

        //after flipping coin randomly check win stuff
        String win = controller.coinFlipped(standardPlayLabel.getSide());
        standardPlayLabel.getRibbonLabel().setText(controller.getRibbonText());

        setCheckMarks(false);

        if (win == "player" || win == "computer"){
            if (win == "player")
                playerWinLabel.setText("Wins: " + String.valueOf(controller.getPlayerWins()));
            else
                computerWinLabel.setText("Wins: " + String.valueOf(controller.getComputerWins()));

            //pause screen after win
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.setRibbonText("");
                    controller.incrementRounds();
                    roundCount.setText(String.valueOf(controller.getRounds()));
                    ribbon.setText("");
                    playerChecksLabel.setText("");
                    computerChecksLabel.setText("");
                    controller.setComputerChecks(0);
                    controller.setPlayerChecks(0);

                    //mid win screen
                    if (win == "player")
                        standardMidRoundLabel.getPlayerWinLabel().setText(String.valueOf(controller.getPlayerWins()));
                    else
                        standardMidRoundLabel.getComputerWinLabel().setText(String.valueOf(controller.getComputerWins()));

                    standardMidRoundLabel.setVisible(true);
                    standardPlayLabel.setVisible(false);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

        //if 10 wins are won go to win or lose screen
        String totalWins = controller.checkTotalWins();
        if (totalWins == "player"){
            changeLabel(standardPlayLabel, mainMenuLabel);
            standardMidRoundLabel.setVisible(false);
        } else if (totalWins == "computer"){
            changeLabel(standardPlayLabel, mainMenuLabel);
            standardMidRoundLabel.setVisible(false);
        }

        if (win == "")
            standardPlayLabel.getFlipButton().addActionListener(this);
    }

    //TODO this is not working correctly right now
    public void setCheckMarks(boolean manual){
        //set check marks
        int[] indexes = controller.getPlayerAndComputerPosition();
        int playerChecks = indexes[0];
        int computerChecks = indexes[1];
        String playerChecksString = "", computerChecksString = "";

        //System.out.println("\nplayerchecks: " + playerChecks);
        //System.out.println("computerchecks: " + computerChecks);

        for (int i=0; i<playerChecks; i++){
            playerChecksString += "\u2713";
        }
        for (int i=0; i<computerChecks; i++){
            computerChecksString += "\u2713";
        }
        if(manual){
            manualPlayLabel.getPlayerChecks().setText(playerChecksString);
            manualPlayLabel.getComputerChecks().setText(computerChecksString);
        }
        else{
            standardPlayLabel.getPlayerChecks().setText(playerChecksString);
            standardPlayLabel.getComputerChecks().setText(computerChecksString);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == manualPlayLabel.getHeadButton()){
            handleManualLogic("H");
        }
        if (e.getSource() == manualPlayLabel.getTailsBtn()){
            handleManualLogic("T");
        }
        if (e.getSource() == standardPlayLabel.getFlipButton()){
            try {
                handleStandardLogic();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
