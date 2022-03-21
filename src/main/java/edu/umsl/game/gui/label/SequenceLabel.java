package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
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
        //add internal buttons and labels that aren't referenced by GameFrame
        JButton btnFlip1 = new JButton();
        JButton btnFlip2 = new JButton();
        JButton btnFlip3 = new JButton();
        JLabel lblSequence1 = new JLabel();
        JLabel lblSequence2 = new JLabel();
        JLabel lblSequence3 = new JLabel();

        //set up background image of ExampleLabel
        ImageIcon image = new ImageIcon("assets/images/enterSequenceDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of buttons
        btnSubmit.setText("Submit");
        btnFlip1.setText("FLIP");
        btnFlip2.setText("FLIP");
        btnFlip3.setText("FLIP");
        //set font and size for button text
        btnSubmit.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnFlip1.setFont(new Font("Minerva", Font.PLAIN, 30));
        btnFlip2.setFont(new Font("Minerva", Font.PLAIN, 30));
        btnFlip3.setFont(new Font("Minerva", Font.PLAIN, 30));
        //set text color of buttons
        btnSubmit.setForeground(Color.BLACK);
        btnFlip1.setForeground(Color.BLACK);
        btnFlip2.setForeground(Color.BLACK);
        btnFlip3.setForeground(Color.BLACK);
        //set border for buttons to make them more visually appealing
        btnSubmit.setBorder(BorderFactory.createRaisedBevelBorder());
        btnFlip1.setBorder(BorderFactory.createRaisedBevelBorder());
        btnFlip2.setBorder(BorderFactory.createRaisedBevelBorder());
        btnFlip3.setBorder(BorderFactory.createRaisedBevelBorder());
        //set background color of buttons
        btnSubmit.setBackground(new Color(230, 0, 0));
        btnFlip1.setBackground(new Color(230, 100, 100));
        btnFlip2.setBackground(new Color(230, 100, 100));
        btnFlip3.setBackground(new Color(230, 100, 100));
        //remove possible focus from buttons to remove selection box around buttons
        btnSubmit.setFocusable(false);
        btnFlip1.setFocusable(false);
        btnFlip2.setFocusable(false);
        btnFlip3.setFocusable(false);
        //set bounds for the buttons, also giving its location on the sequence label
        btnSubmit.setBounds(540, 570, 200, 60);
        btnFlip1.setBounds(433, 440, 90, 40);
        btnFlip2.setBounds(593, 440, 90, 40);
        btnFlip3.setBounds(753, 440, 90, 40);
        //add buttons to the example label
        this.add(btnSubmit);
        this.add(btnFlip1);
        this.add(btnFlip2);
        this.add(btnFlip3);
    }
    //getter for button to be used in GameFrame
    public JButton getBtnSubmit()
    {
        return btnSubmit;
    }
}
