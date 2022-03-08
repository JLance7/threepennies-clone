package edu.umsl.game.gui.frame;

//import MainMenuPanel access and swing wildcard for GUI development
import edu.umsl.game.gui.label.MainMenuLabel;
import javax.swing.*;

//extend JFrame for use of java super class
public class GameFrame extends JFrame
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

        //Create instance of MainMenuLabel and add it to instance of GameFrame
        MainMenuLabel mainMenuLabel = new MainMenuLabel();
        this.add(mainMenuLabel);

        //set visibility to true at end to avoid potential conflicts
        this.setVisible(true);
    }
}
