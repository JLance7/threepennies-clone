package edu.umsl.game.backend;

import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;

public class AssetTest {
    
    @Test //created by Avery Johnson - 3/24/2022
    public void testGameIcon(){
        ImageIcon image = new ImageIcon("assets/images/gameIcon.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testSequencePageBackground(){
        ImageIcon image = new ImageIcon("assets/images/enterSequenceDraft.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testMainMenuBackground(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuDraft.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testExamplePageBackground(){
        ImageIcon image = new ImageIcon("assets/images/exampleDraft.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testManualPlayBackground(){
        ImageIcon image = new ImageIcon("assets/images/manual.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testRulesPageBackground(){
        ImageIcon image = new ImageIcon("assets/images/rulesDraft.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/24/2022
    public void testReadMeThumbnail(){
        ImageIcon image = new ImageIcon("assets/images/thumbnail.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 3/29/2022
    public void testMidRoundBackground(){
        ImageIcon image = new ImageIcon("assets/images/MidRound.png");
        assertNotNull(image);
    }
}
