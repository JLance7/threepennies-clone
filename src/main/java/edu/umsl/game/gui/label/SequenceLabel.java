package edu.umsl.game.gui.label;

//import swing and awt wildcard for GUI development
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
        ImageIcon image = new ImageIcon("assets/images/enterSequenceDraft.png");
        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);

        //Set text value of buttons and labels
        btnSubmit.setText("Submit");
        btnFlip1.setText("FLIP");
        btnFlip2.setText("FLIP");
        btnFlip3.setText("FLIP");
        lblSequence1.setText("H");
        lblSequence2.setText("H");
        lblSequence3.setText("H");
        //set font and size for button and label text
        btnSubmit.setFont(new Font("Minerva", Font.PLAIN, 50));
        btnFlip1.setFont(new Font("Minerva", Font.PLAIN, 30));
        btnFlip2.setFont(new Font("Minerva", Font.PLAIN, 30));
        btnFlip3.setFont(new Font("Minerva", Font.PLAIN, 30));
        lblSequence1.setFont(new Font("Minerva", Font.PLAIN, 150));
        lblSequence2.setFont(new Font("Minerva", Font.PLAIN, 150));
        lblSequence3.setFont(new Font("Minerva", Font.PLAIN, 150));
        //set text color of buttons and labels
        btnSubmit.setForeground(Color.BLACK);
        btnFlip1.setForeground(Color.BLACK);
        btnFlip2.setForeground(Color.BLACK);
        btnFlip3.setForeground(Color.BLACK);
        lblSequence1.setForeground(Color.BLACK);
        lblSequence2.setForeground(Color.BLACK);
        lblSequence3.setForeground(Color.BLACK);
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
        //set bounds for the buttons and labels, also giving its location on the sequence label
        btnSubmit.setBounds(540, 570, 200, 60);
        btnFlip1.setBounds(433, 440, 90, 40);
        btnFlip2.setBounds(593, 440, 90, 40);
        btnFlip3.setBounds(753, 440, 90, 40);
        lblSequence1.setBounds(443, 270, 200, 120);
        lblSequence2.setBounds(603, 270, 200, 120);
        lblSequence3.setBounds(763, 270, 200, 120);
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
        if (label.getText().equals("H"))
        {
            label.setText("T");
        }
        else
        {
            label.setText("H");
        }
    }
}
