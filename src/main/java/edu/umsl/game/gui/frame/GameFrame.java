package edu.umsl.game.gui.frame;

//import MainMenuPanel access and swing wildcard for GUI development
import edu.umsl.game.Main;
import edu.umsl.game.gui.label.ExampleLabel;
import edu.umsl.game.gui.label.MainMenuLabel;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;

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
        //set visibility of all labels other than mainMenuLabel to false until needed
        exampleLabel.setVisible(false);

        //set visibility to true at end to avoid potential conflicts
        this.setVisible(true);

        //add lambdas to every button in GUI for transfer between labels
        mainMenuLabel.getBtnExample().addActionListener(e -> menuToExample(mainMenuLabel, exampleLabel));
        exampleLabel.getBtnMenu().addActionListener(e -> exampleToMenu(exampleLabel, mainMenuLabel));
    }
    //function to transfer visibility from the main menu to the example label
    public void menuToExample(MainMenuLabel menu, ExampleLabel example)
    {
        menu.setVisible(false);
        example.setVisible(true);
    }
    //function to transfer visibility from the main menu to the example label
    public void exampleToMenu(ExampleLabel example, MainMenuLabel menu)
    {
        example.setVisible(false);
        menu.setVisible(true);
    }

}
