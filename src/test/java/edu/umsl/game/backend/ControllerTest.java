package edu.umsl.game.backend;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    //test computer sequence method from controller
    @Test //TODO add test to "Tests Performed" doc, add what date josh performed it as a comment here as well
    public void testAllSequences(){
        //get returned list of two values, expected computer sequence response and actual computer sequence response
        String results[] = testComputerSequence("HHH");
        //expected, actual
        assertEquals(results[0], results[1]);

        String results2[] = testComputerSequence("THH"); //TODO the results of these tests don't compare anything
        assertEquals(results[0], results[1]);

        String results3[] =testComputerSequence("HHT");
        assertEquals(results[0], results[1]);

        String results4[] = testComputerSequence("HTH");
        assertEquals(results[0], results[1]);

        String results5[] = testComputerSequence("HTT");
        assertEquals(results[0], results[1]);

        String results6[] = testComputerSequence("TTT");
        assertEquals(results[0], results[1]);

        String results7[] = testComputerSequence("TTH");
        assertEquals(results[0], results[1]);

        String results8[] = testComputerSequence("THT");
        assertEquals(results[0], results[1]);
    }
    //TODO add test to "Tests Performed" doc, add what date josh performed it as a comment here as well
    //TODO Check if this needs '@Test' added to it, it doesn't currently
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
