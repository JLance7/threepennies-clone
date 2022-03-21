package edu.umsl.game.gui.label;

import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class SequenceLabel extends JLabel
{
    //declare button outside of constructor for use in GameFrame
    private final JButton btnSubmit = new JButton();

    //use default constructor to create instance of the example screen with standard settings
    public SequenceLabel()
    {
        //set up background image of ExampleLabel
        ImageIcon image = new ImageIcon("assets/images/exampleDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of buttons
        btnSubmit.setText("Submit");
        //set font and size for button text
        btnSubmit.setFont(new Font("Minerva", Font.PLAIN, 50));
        //set text color of buttons
        btnSubmit.setForeground(Color.BLACK);
        //set border for buttons to make them more visually appealing
        btnSubmit.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of buttons
        btnSubmit.setBackground(new Color(80, 156, 190));
        //remove possible focus from buttons to remove selection box around buttons
        btnSubmit.setFocusable(false);
        //set bounds for the buttons, also giving its location on the sequence label
        btnSubmit.setBounds(880, 475, 300, 100);
        //add buttons to the example label
        this.add(btnSubmit);
    }
    //getter for button to be used in GameFrame
    public JButton getBtnSubmit()
    {
        return btnSubmit;
    }
}
