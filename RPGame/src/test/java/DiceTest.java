/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rpgame.domain.Dice;

/**
 *
 * @author nate
 */
public class DiceTest {
    private Dice dice; 
    
    public DiceTest() {
    
    }
    
    @Test
    public void criticalReturnsTrueWhenResultIsZero() {
        dice.setCurrentResult(0);
        assertTrue(dice.criticalMiss());
    }
    @Test
    public void criticalReturnsFalseWhenResultIsPositive() {
        dice.roll();
        dice.setCurrentResult(dice.getResult()+1);
        assertTrue(!dice.criticalMiss());
    }
    @Test
    public void hitReturnsTrueWhenResultIsOverThree() {
        dice.roll();
        dice.setCurrentResult(dice.getResult()+4);
        assertTrue(dice.hit());
    }
    @Test
    public void hitReturnsFalseWhenResultIsLessOrEqualToThree() {
        dice.roll();
        dice.setCurrentResult(dice.getResult()-3);
        assertTrue(!dice.hit());
    }
    @Before
    public void setUp() {
        dice = new Dice();
    }
   

  

}
