package edu.umsl.game.gui.label;

//import swing wildcard for GUI development
import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class MainMenuLabel extends JLabel
{
    //use default constructor to create instance of the main menu with standard settings
    public MainMenuLabel()
    {
        ImageIcon image = new ImageIcon("assets/images/MainMenuDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //declare buttons for main menu
        JButton btnStandard = new JButton();
        JButton btnManual = new JButton();
        JButton btnExample = new JButton();
        //Set text value of buttons
        btnStandard.setText("STANDARD PLAY");
        btnManual.setText("MANUAL PLAY");
        btnExample.setText("HOW IT WORKS");
        //set font and size for button text
        btnStandard.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnManual.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnExample.setFont(new Font("Minerva", Font.PLAIN, 50));
        //set text color of buttons
        btnStandard.setForeground(Color.BLACK);
        btnManual.setForeground(Color.BLACK);
        btnExample.setForeground(Color.BLACK);
        //set border for buttons to make them more visually appealing
        btnStandard.setBorder(BorderFactory.createRaisedBevelBorder());
        btnManual.setBorder(BorderFactory.createRaisedBevelBorder());
        btnExample.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of buttons
        btnStandard.setBackground(new Color(200, 0, 0));
        btnManual.setBackground(new Color(200, 0, 0));
        btnExample.setBackground(new Color(200, 0, 0));
        //remove possible focus from buttons to remove selection box around buttons
        btnStandard.setFocusable(false);
        btnManual.setFocusable(false);
        btnExample.setFocusable(false);
        //set bounds for the buttons, also giving their location on the main menu label
        btnStandard.setBounds(50, 300, 400, 100);
        btnManual.setBounds(50, 425, 400, 100);
        btnExample.setBounds(830, 425, 400, 100);
        //use lambda expressions to add action listeners to buttons so they can respond to action
        btnStandard.addActionListener(e -> System.out.println("testStandard"));
        btnManual.addActionListener(e -> System.out.println("testManual"));
        btnExample.addActionListener(e -> System.out.println("testExample"));
        //add buttons to the main menu label
        this.add(btnStandard);
        this.add(btnManual);
        this.add(btnExample);
    }
}