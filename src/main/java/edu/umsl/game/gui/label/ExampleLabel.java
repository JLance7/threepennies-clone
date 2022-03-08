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
        ImageIcon image = new ImageIcon("assets/images/exampleDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of button
        btnMenu.setText("MENU");
        //set font and size for button text
        btnMenu.setFont(new Font("Minerva", Font.PLAIN, 50));
        //set text color of button
        btnMenu.setForeground(Color.BLACK);
        //set border for button to make it more visually appealing
        btnMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of button
        btnMenu.setBackground(new Color(80, 156, 190));
        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        //set bounds for the button, also giving its location on the example label
        btnMenu.setBounds(880, 475, 300, 100);
        //add button to the example label
        this.add(btnMenu);
    }
    //getter for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}