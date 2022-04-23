package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;

public class DefeatLabel extends JLabel
{
    //declare buttons outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();

    //use default constructor to create instance of the main menu with standard settings
    public DefeatLabel()
    {
        //set up background image of VictoryDefeat
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/DefeatLabelImages/Defeatv2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/PlayLabelImages/playMenuBtnPressed.png"));
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        //remove possible focus from buttons to remove selection box around buttons
        btnMenu.setFocusable(false);
        //set bounds for the buttons, also giving their location on the main menu label
        btnMenu.setBounds(850, 450, 300, 75);
        //add buttons to the main menu label
        this.add(btnMenu);
    }
    //getters for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}
