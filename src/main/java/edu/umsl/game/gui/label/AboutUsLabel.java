package edu.umsl.game.gui.label;

import javax.swing.*;
import java.io.IOException;

public class AboutUsLabel extends JLabel
{
    //declare button outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();

    //use default constructor to create instance of the about us screen with standard settings
    public AboutUsLabel()
    {
        //set up background image of ExampleLabel
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/AboutUsLabelImages/AboutUs.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set both images for buttons
        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/exampleMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/exampleMenuBtnPressed.png"));

        //set attributes for button images
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        //set bounds for the button, also giving its location on the example label
        btnMenu.setBounds(900, 550, 250, 75);
        //add button to the example label
        this.add(btnMenu);
    }
    //getter for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}

