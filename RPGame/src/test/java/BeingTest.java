/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rpgame.logics.Being;

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
    @Test
    public void statusSetterAndGetterWorkingAsIntended() {
        model.setStatus();
        StringProperty property = model.getStatus();
        String stats = property.toString();
        assertEquals("StringProperty [value: test Health: 100]", stats);
    }
    @Test
    public void cantSetNegativeHP() {
        model.setHitpoints(-50);
        assertEquals(0, model.getHitpoints());
    }
    @Test
    public void cantSetHPGreaterThanHundred() {
        model.setHitpoints(500);
        assertEquals(100, model.getHitpoints());
    }
    @Test 
    public void setHPToGivenAmount() {
        model.setHitpoints(22);
        assertEquals(22, model.getHitpoints());
    }
    @Before
    public void setUp() {
        model = new Being("test");
    }

}
