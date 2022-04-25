package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
import edu.umsl.game.backend.MusicPlayer;

import javax.swing.*;
import java.awt.*;

//extend JPanel for use of java super class
public class SequenceLabel extends JLabel
{
    //declare button and labels outside of constructor for use in GameFrame
    private final JButton btnSubmit = new JButton();
    private final JLabel lblSequence1 = new JLabel();
    private final JLabel lblSequence2 = new JLabel();
    private final JLabel lblSequence3 = new JLabel();


    //use default constructor to create instance of the example screen with standard settings
    public SequenceLabel()
    {
        //add internal buttons that aren't referenced by GameFrame
        JButton btnFlip1 = new JButton();
        JButton btnFlip2 = new JButton();
        JButton btnFlip3 = new JButton();

        //set up background image of ExampleLabel
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/SequenceLabelImages/sequencev2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
        this.setIcon(image);
        this.setBounds(150, 69, 1280, 720);

        //add all images for buttons
        ImageIcon submitImage = new ImageIcon(getClass().getClassLoader().getResource("images/SequenceLabelImages/submitBtn.png"));
        ImageIcon flipImage = new ImageIcon(getClass().getClassLoader().getResource("images/SequenceLabelImages/sequenceFlipBtn.png"));
        //add depressed images for buttons
        ImageIcon submitImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/SequenceLabelImages/submitBtnPressed.png"));
        ImageIcon flipImagePressed = new ImageIcon(getClass().getClassLoader().getResource("images/SequenceLabelImages/sequenceFlipBtnPressed.png"));

        //set attributes for button images
        btnFlip1.setIcon(flipImage);
        btnFlip1.setRolloverIcon(flipImagePressed);
        btnFlip1.setContentAreaFilled(false);
        btnFlip1.setBorderPainted(false);
        btnFlip2.setIcon(flipImage);
        btnFlip2.setRolloverIcon(flipImagePressed);
        btnFlip2.setContentAreaFilled(false);
        btnFlip2.setBorderPainted(false);
        btnFlip3.setIcon(flipImage);
        btnFlip3.setRolloverIcon(flipImagePressed);
        btnFlip3.setContentAreaFilled(false);
        btnFlip3.setBorderPainted(false);
        btnSubmit.setIcon(submitImage);
        btnSubmit.setRolloverIcon(submitImagePressed);
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setBorderPainted(false);

        //Set text value of buttons and labels
        lblSequence1.setText("H");
        lblSequence2.setText("H");
        lblSequence3.setText("H");
        //set font and size for button and label text
        lblSequence1.setFont(new Font("", Font.PLAIN, 150));
        lblSequence2.setFont(new Font("", Font.PLAIN, 150));
        lblSequence3.setFont(new Font("", Font.PLAIN, 150));
        //set text color of buttons and labels
        lblSequence1.setForeground(Color.BLACK);
        lblSequence2.setForeground(Color.BLACK);
        lblSequence3.setForeground(Color.BLACK);
        //remove possible focus from buttons to remove selection box around buttons
        btnSubmit.setFocusable(false);
        btnFlip1.setFocusable(false);
        btnFlip2.setFocusable(false);
        btnFlip3.setFocusable(false);
        //set bounds for the buttons and labels, also giving its location on the sequence label
        btnSubmit.setBounds(790, 500, 200, 60);
        btnFlip1.setBounds(645, 423, 90, 40);
        btnFlip2.setBounds(845, 423, 90, 40);
        btnFlip3.setBounds(1040, 423, 90, 40);
        lblSequence1.setBounds(636, 240, 200, 120);
        lblSequence2.setBounds(835, 240, 200, 120);
        lblSequence3.setBounds(1030, 240, 200, 120);
        //add buttons and labels to the example label
        this.add(btnSubmit);
        this.add(btnFlip1);
        this.add(btnFlip2);
        this.add(btnFlip3);
        this.add(lblSequence1);
        this.add(lblSequence2);
        this.add(lblSequence3);


        //add listeners to flip buttons in order to change sequence
        btnFlip1.addActionListener(e -> flipLabel(lblSequence1));
        btnFlip2.addActionListener(e -> flipLabel(lblSequence2));
        btnFlip3.addActionListener(e -> flipLabel(lblSequence3));
    }
    //getter for button to be used in GameFrame
    public JButton getBtnSubmit()
    {
        return btnSubmit;
    }
    //private function to be used in lambda from actionListener of the flip buttons
    private void flipLabel(JLabel label)
    {
        String fileName = "sounds/buttonClick.wav";
        MusicPlayer music = new MusicPlayer();
        music.playMusic(fileName, false);
        if (label.getText().equals("H"))
        {
            label.setText("T");
        }
        else
        {
            label.setText("H");
        }
    }


    public String getSequence(){
        String sequence = lblSequence1.getText() + lblSequence2.getText() + lblSequence3.getText();
        return sequence;
    }

    public JLabel getLblSequence1(){
        return lblSequence1;
    }

    public JLabel getLblSequence2(){
        return lblSequence2;
    }

    public JLabel getLblSequence3(){
        return lblSequence3;
    }
}
