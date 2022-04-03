package edu.umsl.game.backend;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    //test computer sequence method from controller
    @Test //performed 3/30/22
    public void testAllSequences(){
        //get returned list of two values, expected computer sequence response and actual computer sequence response
        String results[] = testComputerSequence("HHH");
        //expected, actual
        assertEquals(results[0], results[1]);

        String results2[] = testComputerSequence("THH");
        assertEquals(results2[0], results2[1]);

        String results3[] =testComputerSequence("HHT");
        assertEquals(results3[0], results3[1]);

        String results4[] = testComputerSequence("HTH");
        assertEquals(results4[0], results4[1]);

        String results5[] = testComputerSequence("HTT");
        assertEquals(results5[0], results5[1]);

        String results6[] = testComputerSequence("TTT");
        assertEquals(results6[0], results6[1]);

        String results7[] = testComputerSequence("TTH");
        assertEquals(results7[0], results7[1]);

        String results8[] = testComputerSequence("THT");
        assertEquals(results8[0], results8[1]);
    }

    //tests the ComputerSequence class in backend package which determines the higher probability sequence for the computer given the user's sequence
    public String[] testComputerSequence(String testString){
        Controller sequence = new Controller();
        sequence.setUserSequence(testString);
        //flip middle and add to beginning, remove last
        String userSequence = sequence.getUserSequence();
        char middle = userSequence.charAt(1);
        char first;
        if (middle == 'H')
            first = 'T';
        else
            first = 'H';

        //add flipped middle to beginning
        String expectedComputerSequence = first + userSequence;

        //remove last char
        expectedComputerSequence = expectedComputerSequence.substring(0, 3);
        String actualComputerSequence = sequence.getComputerSequence();

        System.out.println("User sequence is: " + userSequence);
        System.out.println("Expected Computer Sequence is: " + expectedComputerSequence);

        String[] results = new String[2];
        results[0] = expectedComputerSequence;
        results[1] = actualComputerSequence;
        return results;
    }
}
