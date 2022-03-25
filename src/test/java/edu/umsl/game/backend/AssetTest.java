package edu.umsl.game.backend;

import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;

public class AssetTest {
    
    @Test
    public void testGameIcon(){
        ImageIcon image = new ImageIcon("assets/images/gameIcon.png");
        assertNotNull(image);
    }
    @Test
    public void testSequencePageBackground(){
        ImageIcon image = new ImageIcon("assets/images/enterSequenceDraft.png");
        assertNotNull(image);
    }
    @Test
    public void testMainMenuBackground(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuDraft.png");
        assertNotNull(image);
    }
    @Test
    public void testExamplePageBackground(){
        ImageIcon image = new ImageIcon("assets/images/exampleDraft.png");
        assertNotNull(image);
    }
    @Test
    public void testManualPlayBackground(){
        ImageIcon image = new ImageIcon("assets/images/manual.png");
        assertNotNull(image);
    }
    @Test
    public void testRulesPageBackground(){
        ImageIcon image = new ImageIcon("assets/images/rulesDraft.png");
        assertNotNull(image);
    }
    @Test
    public void testReadMeThumbnail(){
        ImageIcon image = new ImageIcon("assets/images/thumbnail.png");
        assertNotNull(image);
    }
}
