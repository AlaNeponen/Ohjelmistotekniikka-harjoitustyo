/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
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
public class KassapaateTest {
    Maksukortti kortti;
    Kassapaate paate;
    
    public KassapaateTest() {
    }
    @Test 
    public void alkuOikein() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kateisostoKunOnVaraaEdulliseen() {
        assertEquals(10, paate.syoEdullisesti(250));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void kateisostoKunOnVaraaMaukkaasti() {
        assertEquals(10, paate.syoMaukkaasti(410));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    @Test public void kateisostoEdullisestiEiVaraa() {
        assertEquals(200, paate.syoEdullisesti(200));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    @Test public void kateisostoMaukkaastiEiVaraa() {
        assertEquals(300, paate.syoMaukkaasti(300));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    @Test public void korttiostoEdullisesti() {
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(260, kortti.saldo());
        assertEquals(1 ,paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        
    }
    @Test public void korttiostoMaukkaasti() {
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Test public void korttiostoEdullisestiEiVaraa() {
        kortti.otaRahaa(450);
        assertTrue(!paate.syoEdullisesti(kortti));
        assertEquals(50, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    @Test public void korttiostoMaukkaastiEivaraa() {
        kortti.otaRahaa(200);
        assertTrue(!paate.syoMaukkaasti(kortti));
        assertEquals(300, kortti.saldo());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        
    }
    @Test public void kortilleLataaminen() {
        paate.lataaRahaaKortille(kortti, 500);
        assertEquals(1000, kortti.saldo());
        assertEquals(100500, paate.kassassaRahaa());
    }
    @Test public void kortilleEiVoiLadataNegatiivistaArvoa() {
        paate.lataaRahaaKortille(kortti, -20);
        assertEquals(500, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
  
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
