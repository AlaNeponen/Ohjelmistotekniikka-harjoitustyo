/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nate
 */
public class MaksukorttiTest {
    Maksukortti kortti;
    public MaksukorttiTest() {
    }
    @Test 
    public void Saldo() {
        assertEquals(100, kortti.saldo());
    }
    @Test
    public void lataus() {
        kortti.lataaRahaa(200);
        assertEquals("saldo: 3.0", kortti.toString());
    }
    @Test 
    public void otaTarpeeksi() {
        kortti.otaRahaa(50);
        assertEquals("saldo: 0.50", kortti.toString());
    }
    @Test
    public void alaOta() {
        kortti.otaRahaa(500);
        assertEquals("saldo: 1.0", kortti.toString());
        
    }
    @Test
    public void palauttaaTrue() {
        assertTrue(kortti.otaRahaa(15));
    }
    @Test
    public void palauttaaFalse() {
        assertTrue(!kortti.otaRahaa(1000));
    }
    @Test
    public void luotu() {
        assertTrue(!(kortti==null));
    }
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(100);
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
