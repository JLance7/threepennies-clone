package edu.umsl.game.gui.label;

import javax.swing.*;

public class DummyLabel extends JLabel
{
    public DummyLabel()
    {
        //set up background label for frame
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/tails.png"));
        } catch (Exception e){
            e.printStackTrace();
        }


        this.setIcon(image);
        this.setBounds(0, 0, 1280, 720);
    }
}
