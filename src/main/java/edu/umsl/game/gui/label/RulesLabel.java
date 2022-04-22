package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import javax.swing.*;

public class RulesLabel extends JLabel
{
    //declare button outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();

    //use default constructor to create instance of the rules screen with standard settings
    public RulesLabel()
    {
        //set up background image of RulesLabel
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/RulesLabelImages/how_to_playv2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set both images for buttons
        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/RulesLabelImages/rulesMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/RulesLabelImages/rulesMenuBtnPressed.png"));

        //set attributes for button images
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        //remove focusability of button
        btnMenu.setFocusable(false);
        //set bounds for the button, also giving its location on the rules label
        btnMenu.setBounds(1025, 550, 200, 55);

        //add button to the rules label
        this.add(btnMenu);
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }
    //getter for button to be used in GameFrame

}
