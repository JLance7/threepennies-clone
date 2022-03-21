package edu.umsl.game.gui.frame;

//import MainMenuPanel access and swing wildcard for GUI development
import javax.swing.*;
import edu.umsl.game.gui.label.ExampleLabel;
import edu.umsl.game.gui.label.MainMenuLabel;
import edu.umsl.game.gui.label.RulesLabel;
import edu.umsl.game.gui.label.SequenceLabel;

//extend JFrame for use of java super class
public  class GameFrame extends JFrame
{
    //default constructor to prepare instance of the GameFrame with standard arrangement
    public GameFrame()
    {
        this.setTitle("Three Pennies");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLayout(null);

        //set border icon for game
        ImageIcon icon = new ImageIcon("assets/images/gameIcon.png");
        this.setIconImage(icon.getImage());

        //Add instance of every label to be turned on or off depending on need
        MainMenuLabel mainMenuLabel = new MainMenuLabel();
        this.add(mainMenuLabel);
        ExampleLabel exampleLabel = new ExampleLabel();
        this.add(exampleLabel);
        RulesLabel rulesLabel = new RulesLabel();
        this.add(rulesLabel);
        SequenceLabel standardSequenceLabel = new SequenceLabel();
        this.add(standardSequenceLabel);
        SequenceLabel manualSequenceLabel = new SequenceLabel();
        this.add(manualSequenceLabel);

        //set visibility of all labels other than mainMenuLabel to false until needed
        exampleLabel.setVisible(false);
        rulesLabel.setVisible(false);
        standardSequenceLabel.setVisible(false);
        manualSequenceLabel.setVisible(false);

        //set visibility to true at end to avoid potential conflicts
        this.setVisible(true);

        /*
        The following block of code consists of actions being fed to action listeners for every button
        on the frame. The first parameter in the lambda expression is the page that it is coming from,
        the second parameter is the page that it is going to.
        */
        mainMenuLabel.getBtnExample().addActionListener(e -> changeLabel(mainMenuLabel, exampleLabel));
        mainMenuLabel.getBtnStandard().addActionListener(e -> changeLabel(mainMenuLabel, standardSequenceLabel));
        mainMenuLabel.getBtnManual().addActionListener(e -> changeLabel(mainMenuLabel, manualSequenceLabel));
        exampleLabel.getBtnMenu().addActionListener(e -> changeLabel(exampleLabel, mainMenuLabel));
        mainMenuLabel.getBtnRules().addActionListener(e -> changeLabel(mainMenuLabel, rulesLabel));
        rulesLabel.getBtnMenu().addActionListener(e -> changeLabel(rulesLabel, mainMenuLabel));
    }
    //function to transfer visibility from one label to another
    public void changeLabel(JLabel start, JLabel end)
    {
        start.setVisible(false);
        end.setVisible(true);
    }
}
