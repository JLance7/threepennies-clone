package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import javax.swing.*;
import java.io.IOException;

//extend JPanel for use of java super class
public class ExampleLabel extends JLabel
{
    //declare button outside of constructor for use in GameFrame
    private final JButton btnMenu = new JButton();
    private final JButton btnLearn = new JButton();

    //use default constructor to create instance of the example screen with standard settings
    public ExampleLabel()
    {
        //set up background image of ExampleLabel
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/examplev2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //set both images for buttons
        ImageIcon menuImage = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/exampleMenuBtn.png"));
        ImageIcon menuImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/exampleMenuBtnPressed.png"));
        ImageIcon learnImage = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/learnMoreBtn.png"));
        ImageIcon learnImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/ExampleLabelImages/learnMoreBtnPressed.png"));

        //set attributes for button images
        btnMenu.setIcon(menuImage);
        btnMenu.setRolloverIcon(menuImagePressed);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnLearn.setIcon(learnImage);
        btnLearn.setRolloverIcon(learnImagePressed);
        btnLearn.setContentAreaFilled(false);
        btnLearn.setBorderPainted(false);

        //action listener to point learnmore button to numberphile video
        String url = "https://youtu.be/Sa9jLWKrX0c";
        btnLearn.addActionListener(e -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //remove possible focus from button to remove selection box around button
        btnMenu.setFocusable(false);
        btnLearn.setFocusable(false);
        //set bounds for the button, also giving its location on the example label
        btnMenu.setBounds(850, 475, 250, 75);
        btnLearn.setBounds(850, 575, 250, 75);
        //add button to the example label
        this.add(btnMenu);
        this.add(btnLearn);
    }
    //getter for button to be used in GameFrame
    public JButton getBtnMenu()
    {
        return btnMenu;
    }
}