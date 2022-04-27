/*----------------------------------------------------------------------------------------------------------
Team Name: The Unhandled Exceptions
Team Leader: Johnson, Avery
Team Members:
    -Akinjiyan, Divine
    -Bihorac, Haris
    -Cherry, Nick
    -Johnson, Avery
    -Lanctot, Joshua

Project Name: Three Pennies
Project Language: Java
Project Description: A game that allows the user to select a sequence of three coins.
The program then creates its own sequence based on the user's sequence. Coins are
then "flipped" in a sequence until one of the aforementioned sequences are found.
This process is repeated 10 times. Afterwards, either a winner is declared, or a draw
is declared. The user will have the option to flip the coin manually. A module exists
in tandem to the game that will explain the process behind the gameplay loop to
the user.

Sources:
Source 1 - This is an expansive tutorial on Swing. It was instrumental in the development of the GUI
that is used in this program. The knowledge provided by this source was utilized while developing
the entirety of the front-end of this program.
<https://youtu.be/Kmgo00avvEw>
----------------------------------------------------------------------------------------------------------*/

package edu.umsl.game;

//import for access to GameFrame

//bruh and nice sounds taken from youtube
//buttonClick and coinFlip sounds taken from Freesound.org
//Elevator by Kevin Macleod song used
import edu.umsl.game.gui.frame.GameFrame;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //makes JOptionpane look nicer
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        //create instance of GameFrame with default constructor
        new GameFrame();
    }
}