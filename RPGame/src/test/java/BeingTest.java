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
import rpgame.Being;

/**
 *
 * @author nate
 */
public class BeingTest {
    private Being model;
    public BeingTest() {
    }
    @Test
    public void hpWhenBornIsHundred() {
        assertEquals(100, model.getHitpoints());
    }
    @Test
    public void takingDamageLowersHp() {
        model.takeDamage(75);
        assertEquals(25, model.getHitpoints());
    }
    @Test
    public void hpIsNeverNegative() {
        model.takeDamage(75);
        model.takeDamage(150);
        assertEquals(0, model.getHitpoints());
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        model = new Being();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
