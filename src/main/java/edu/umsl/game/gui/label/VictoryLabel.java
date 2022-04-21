package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;

public class VictoryLabel extends JLabel
{
    //declare buttons outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();

    //use default constructor to create instance of the main menu with standard settings
    public VictoryLabel()
    {
        //set up background image of VictoryDefeat
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/VictoryDraft.png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of buttons
        btnMenu.setText("MENU");
        //set font and size for button text
        btnMenu.setFont(new Font("Minerva", Font.PLAIN, 80));
        //set text color of buttons
        btnMenu.setForeground(Color.BLACK);
        //set border for buttons to make them more visually appealing
        btnMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of buttons
        btnMenu.setBackground(new Color(50, 200, 255));
        //remove possible focus from buttons to remove selection box around buttons
        btnMenu.setFocusable(false);
        //set bounds for the buttons, also giving their location on the main menu label
        btnMenu.setBounds(425, 515, 425, 125);
        //add buttons to the main menu label
        this.add(btnMenu);
    }
    //getters for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}
