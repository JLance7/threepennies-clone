package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import javax.swing.*;

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
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/main_menu_v2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //add all images for buttons
        ImageIcon stdImage = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/stdPlayBtn.png"));
        ImageIcon manImage = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/manPlayBtn.png"));
        ImageIcon rulesImage = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/rulesBtn.png"));
        ImageIcon exampleImage = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/examplePlayBtn.png"));
        //add depressed images for buttons
        ImageIcon stdImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/stdPlayBtnPressed.png"));
        ImageIcon manImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/manPlayBtnPressed.png"));
        ImageIcon rulesImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/rulesBtnPressed.png"));
        ImageIcon exampleImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuImages/examplePlayBtnPressed.png"));

        //set buttons images
        btnStandard.setIcon(stdImage);
        btnManual.setIcon(manImage);
        btnRules.setIcon(rulesImage);
        btnExample.setIcon(exampleImage);
        //remove possible focus from buttons to remove selection box around buttons
        btnStandard.setFocusable(false);
        btnManual.setFocusable(false);
        btnExample.setFocusable(false);
        btnRules.setFocusable(false);
        //set bounds for the buttons, also giving their location on the main menu label
        btnStandard.setBounds(45, 300, 375, 125);
        btnManual.setBounds(45, 494, 375, 125);
        btnExample.setBounds(600, 494, 375, 125);
        btnRules.setBounds(600, 300, 375, 125);
        //setup button image attributes
        btnStandard.setBorderPainted(false);
        btnStandard.setContentAreaFilled(false);
        btnManual.setBorderPainted(false);
        btnManual.setContentAreaFilled(false);
        btnRules.setBorderPainted(false);
        btnRules.setContentAreaFilled(false);
        btnExample.setBorderPainted(false);
        btnExample.setContentAreaFilled(false);
        //add rollover to all buttons
        btnStandard.setRolloverIcon(stdImagePressed);
        btnManual.setRolloverIcon(manImagePressed);
        btnRules.setRolloverIcon(rulesImagePressed);
        btnExample.setRolloverIcon(exampleImagePressed);
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