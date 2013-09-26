/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eb113.essen.dto.EssensAuswahl;
import org.eb113.essen.dto.EssensMoeglichkeiten;
import org.eb113.essen.dto.Personen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author koni
 */
public class EssenBeanTest {
    
    EssenBean bean;
    
    @Before
    public void setUp() {
        bean = new EssenBean();
        bean.init();
    }
    
    @After
    public void tearDown() {
        //nothing at the moment
    }
    
    @Test
    public void testBerechneAuswahl2DrittelMehrheitAndBesteller(){
        bean.addAuswahl(Personen.GAMAUF.getPerson(), EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.SCHLAGER.getPerson(), EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.SEIDL.getPerson(), EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.ROHRBOECK.getPerson(), EssensMoeglichkeiten.KELLER.getEssensMoeglichkeit());
        
        bean.berechneAuswahl();
        
        assertNotNull(bean.getActualAuswahl());
        assertNotNull(bean.getBesteller());
        
        assertNotSame("", bean.getActualAuswahl().trim());
        assertNotSame("", bean.getBesteller().trim());
        
        assertNotSame(Personen.RENNER.getPerson().toString(), bean.getBesteller());
        assertNotSame(Personen.ROHRBOECK.getPerson().toString(), bean.getBesteller());
        assertNotSame(Personen.WOHLMUTH.getPerson().toString(), bean.getBesteller());
        assertEquals(EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit().toString(), bean.getActualAuswahl());
    }
    
    @Test
    public void testBerechneRandomAuswahl(){
        bean.addAuswahl(Personen.GAMAUF.getPerson(), EssensMoeglichkeiten.KEBAP.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.SCHLAGER.getPerson(), EssensMoeglichkeiten.LUTZ.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.SEIDL.getPerson(), EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.ROHRBOECK.getPerson(), EssensMoeglichkeiten.KELLER.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.RENNER.getPerson(), EssensMoeglichkeiten.OCONNOR.getEssensMoeglichkeit());
        bean.addAuswahl(Personen.WOHLMUTH.getPerson(), EssensMoeglichkeiten.OLIVIA.getEssensMoeglichkeit());
        
        bean.berechneAuswahl();
        
        assertNotNull(bean.getActualAuswahl());
        assertNotNull(bean.getBesteller());
        
        assertNotSame("", bean.getActualAuswahl().trim());
        
        assertTrue(bean.getActualAuswahl().equals(EssensMoeglichkeiten.KEBAP.toString()) || 
                bean.getActualAuswahl().equals(EssensMoeglichkeiten.LUTZ.toString()) || 
                bean.getActualAuswahl().equals(EssensMoeglichkeiten.BESTELLUNG.toString()) || 
                bean.getActualAuswahl().equals(EssensMoeglichkeiten.KELLER.toString()) || 
                bean.getActualAuswahl().equals(EssensMoeglichkeiten.OCONNOR.toString()) || 
                bean.getActualAuswahl().equals(EssensMoeglichkeiten.OLIVIA.toString()));
        
        if(bean.getActualAuswahl().equals(EssensMoeglichkeiten.BESTELLUNG.toString()) ){
            assertNotSame("", bean.getBesteller().trim());
            assertNotSame(Personen.WOHLMUTH.getPerson().toString(), bean.getBesteller());
        }else{
            assertEquals("", bean.getBesteller().trim());
        }
    }
    
    @Test
    public void testPersonen(){
    	Collection<EssensAuswahl> essensAuswahl = bean.getGewaehlteMoeglichkeiten();
    	for(EssensAuswahl one: essensAuswahl){
    		System.out.println("Nachname: " + one.getPerson().getNachname());
    	}
    }
}
