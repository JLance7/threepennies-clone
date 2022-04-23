package edu.umsl.game.backend;

import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;

public class AssetTest {
    @Test //created by Avery Johnson - 3/24/2022
    public void testReadMeThumbnail(){
        ImageIcon image = new ImageIcon("assets/images/thumbnail.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testAboutUs(){
        ImageIcon image = new ImageIcon("assets/images/AboutUsLabelImages/AboutUs.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testWallpaper(){
        ImageIcon image = new ImageIcon("assets/images/BackgroundLabelImages/wallpaper.gif");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testDefeatV2(){
        ImageIcon image = new ImageIcon("assets/images/DefeatLabelImages/Defeatv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testExampleMenuBtn(){
        ImageIcon image = new ImageIcon("assets/images/ExampleLabelImages/exampleMenuBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testExampleMenuBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/ExampleLabelImages/exampleMenuBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testExampleV2(){
        ImageIcon image = new ImageIcon("assets/images/ExampleLabelImages/examplev2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testLearnMoreBtn(){
        ImageIcon image = new ImageIcon("assets/images/ExampleLabelImages/learnMoreBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testLearnMoreBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/ExampleLabelImages/learnMoreBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testAboutUsBtn(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/aboutUsBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testAboutUsBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/aboutUsBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testExamplePlayBtn(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/examplePlayBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testExamplePlayBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/examplePlayBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testMainMenuV2(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/main_menu_v2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testManPlayBtn(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/manPlayBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testManPlayBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/manPlayBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testRulesBtn(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/rulesBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testRulesBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/rulesBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testStdPlayBtn(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/stdPlayBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testStdPlayBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/MainMenuImages/stdPlayBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testContinueBtn(){
        ImageIcon image = new ImageIcon("assets/images/MidRoundLabelImages/continueBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testContinueBtnPressed(){
        ImageIcon image = new ImageIcon("continueBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testMidroundV2(){
        ImageIcon image = new ImageIcon("assets/images/MidRoundLabelImages/midroundv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testManualV2(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/ManualLabelImages/manualv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testStandardV2(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/StandardLabelImages/Standardv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testPlayHowToBtn(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/playHowToBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testPlayHowToBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/playHowToBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testPlayMenuBtn(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/playMenuBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testPlayMenuBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/PlayLabelImages/playMenuBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testHowToPlayV2(){
        ImageIcon image = new ImageIcon("assets/images/RulesLabelImages/how_to_playv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testRulesMenuBtn(){
        ImageIcon image = new ImageIcon("assets/images/RulesLabelImages/rulesMenuBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testRulesMenuBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/RulesLabelImages/rulesMenuBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testSequenceFlipBtn(){
        ImageIcon image = new ImageIcon("assets/images/SequenceLabelImages/sequenceFlipBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testSequenceFlipBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/SequenceLabelImages/sequenceFlipBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testSequenceV2(){
        ImageIcon image = new ImageIcon("assets/images/SequenceLabelImages/sequencev2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testSubmitBtn(){
        ImageIcon image = new ImageIcon("assets/images/SequenceLabelImages/submitBtn.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testSubmitBtnPressed(){
        ImageIcon image = new ImageIcon("assets/images/SequenceLabelImages/submitBtnPressed.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testVictoryV2(){
        ImageIcon image = new ImageIcon("assets/images/VictoryLabelImages/victoryv2.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testHeadsToTails(){
        ImageIcon image = new ImageIcon("assets/images/H to T.gif");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testHeads(){
        ImageIcon image = new ImageIcon("assets/images/heads.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testIconRedo(){
        ImageIcon image = new ImageIcon("assets/images/iconredo.png");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testTailsToHeads(){
        ImageIcon image = new ImageIcon("assets/images/T to H.gif");
        assertNotNull(image);
    }
    @Test //created by Avery Johnson - 4/23/2022
    public void testTails(){
        ImageIcon image = new ImageIcon("assets/images/tails.png");
        assertNotNull(image);
    }
}
