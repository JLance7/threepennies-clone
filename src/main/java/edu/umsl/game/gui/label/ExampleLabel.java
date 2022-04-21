package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class ExampleLabel extends JLabel
{
    //declare button outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();

    //use default constructor to create instance of the example screen with standard settings
    public ExampleLabel()
    {
        //set up background image of ExampleLabel
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/examplev2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set both images for buttons
        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/exampleMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/exampleMenuBtnPressed.png"));

        //set attributes for button images
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);



        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        //set bounds for the button, also giving its location on the example label
        btnMenu.setBounds(850, 475, 250, 75);
        //add button to the example label
        this.add(btnMenu);

        //
    }
    //getter for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}