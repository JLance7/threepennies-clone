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

Source 2 - This video was the inspiration for the project and gave us many of our ideas for the game.
<https://youtu.be/Sa9jLWKrX0c>

Asset Credit:
The background music was provided by the Royalty Free Musician, Kevin Mcleod. The name of the song
used is "Local Forecast - Elevator" by Kevin Mcleod. The links for the song and his website follow.
<https://youtu.be/FgXYzF5-Yiw>
<https://incompetech.com/music/royalty-free/>

"Nice" Sound Effect was created by Michael Rosen. All credit for the sound goes to said named
individual.

"Bruh" Sound Effect was created by the vine user, Headgraphix. All credit for the sound goes
to said named individual.

Both "Coin Flip" and "Button Click" sound effects were provided by FreeSound.org under the Creative
Commons 0 license.

Multiple "Among Us" images are used in this creation for purely educational and nondistributive
purposes. "Among Us" © was created Innersloth LLC. The Unhandles Exception Team claims no ownership
over the "Among Us" IP.
----------------------------------------------------------------------------------------------------------*/

package edu.umsl.game;

//import for access to GameFrame
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