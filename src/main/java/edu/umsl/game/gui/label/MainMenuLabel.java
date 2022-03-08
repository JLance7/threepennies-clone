package edu.umsl.game.gui.label;

//import swing wildcard for GUI development
import javax.swing.*;

//extend JPanel for use of java super class
public class MainMenuLabel extends JLabel
{
    //use default constructor to create instance of the main menu with standard settings
    public MainMenuLabel()
    {
        ImageIcon image = new ImageIcon("assets/images/MainMenuDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);
    }
}