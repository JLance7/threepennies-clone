package edu.umsl.game.gui.label;

import javax.swing.*;

public class BackgroundLabel extends JLabel
{
    public BackgroundLabel()
    {
        //set up background label for frame
        ImageIcon image = null;
        try{
            image = new ImageIcon(getClass().getClassLoader().getResource("images/BackgroundLabelImages/wallpaper.gif"));
        } catch (Exception e){
            e.printStackTrace();
        }


        this.setIcon(image);
        this.setBounds(0, 0, 1600, 900);
    }
}
