package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class MainMenuLabel extends JLabel
{
    //declare buttons outside of constructor for use in GameFrame
    private final JButton btnStandard = new JButton();
    private final JButton btnManual = new JButton();
    private final JButton btnExample = new JButton();
    private final JButton btnRules = new JButton();

    //use default constructor to create instance of the main menu with standard settings
    public MainMenuLabel()
    {
        //set up background image of MainMenuLabel
        ImageIcon image = new ImageIcon("assets/images/MainMenuDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of buttons
        btnStandard.setText("STANDARD PLAY");
        btnManual.setText("MANUAL PLAY");
        btnExample.setText("HOW IT WORKS");
        btnRules.setText("HOW TO PLAY");
        //set font and size for button text
        btnStandard.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnManual.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnExample.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnRules.setFont(new Font("Minerva", Font.PLAIN, 50));
        //set text color of buttons
        btnStandard.setForeground(Color.BLACK);
        btnManual.setForeground(Color.BLACK);
        btnExample.setForeground(Color.BLACK);
        btnRules.setForeground(Color.BLACK);
        //set border for buttons to make them more visually appealing
        btnStandard.setBorder(BorderFactory.createRaisedBevelBorder());
        btnManual.setBorder(BorderFactory.createRaisedBevelBorder());
        btnExample.setBorder(BorderFactory.createRaisedBevelBorder());
        btnRules.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of buttons
        btnStandard.setBackground(new Color(200, 0, 0));
        btnManual.setBackground(new Color(200, 0, 0));
        btnExample.setBackground(new Color(200, 0, 0));
        btnRules.setBackground(new Color(200, 0, 0));
        //remove possible focus from buttons to remove selection box around buttons
        btnStandard.setFocusable(false);
        btnManual.setFocusable(false);
        btnExample.setFocusable(false);
        btnRules.setFocusable(false);
        //set bounds for the buttons, also giving their location on the main menu label
        btnStandard.setBounds(50, 300, 400, 100);
        btnManual.setBounds(50, 425, 400, 100);
        btnExample.setBounds(815, 425, 400, 100);
        btnRules.setBounds(815, 300, 400, 100);
        //add buttons to the main menu label
        this.add(btnStandard);
        this.add(btnManual);
        this.add(btnExample);
        this.add(btnRules);
    }
    //getters for all buttons to be used in GameFrame

    public JButton getBtnStandard()
    {
        return btnStandard;
    }
    public JButton getBtnManual()
    {
        return btnManual;
    }
    public JButton getBtnExample()
    {
        return btnExample;
    }
    public JButton getBtnRules()
    {
        return btnRules;
    }
}