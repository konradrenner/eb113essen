/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.ejb;

import java.util.Collection;
import org.eb113.essen.dto.EssensAuswahl;
import org.eb113.essen.dto.EssensMoeglichkeit;
import org.eb113.essen.dto.EssensMoeglichkeitFactory;
import org.eb113.essen.dto.PersonFactory;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
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
		// nothing at the moment
	}

	@Test
	public void testBerechneAuswahl2DrittelMehrheitAndBesteller() {
		bean.addAuswahl(PersonFactory.getGamauf(0),
				EssensMoeglichkeitFactory.getBestellung());
		bean.addAuswahl(PersonFactory.getSeidl(2),
				EssensMoeglichkeitFactory.getBestellung());
		bean.addAuswahl(PersonFactory.getRohrboeck(3),
				EssensMoeglichkeitFactory.getBilla());

		bean.berechneAuswahl();

		assertNotNull(bean.getActualAuswahl());
		assertNotNull(bean.getBesteller());

		assertNotSame("", bean.getActualAuswahl().trim());
		System.out.println("asdf: " + bean.getActualAuswahl());
		System.out.println("asdf: " + bean.getBesteller());
		assertNotSame("", bean.getBesteller().trim());

		assertNotSame(PersonFactory.getRenner(0).toString(),
				bean.getBesteller());
		assertNotSame(PersonFactory.getRohrboeck(0).toString(),
				bean.getBesteller());
		assertNotSame(PersonFactory.getWohlmuth(0).toString(),
				bean.getBesteller());
		assertEquals(EssensMoeglichkeitFactory.getBestellung().toString(),
				bean.getActualAuswahl());
	}

	@Test
    public void testBerechneRandomAuswahl(){
        bean.addAuswahl(PersonFactory.getGamauf(0), EssensMoeglichkeitFactory.getBestellung());
        bean.addAuswahl(PersonFactory.getSeidl(0), EssensMoeglichkeitFactory.getBestellung());
        bean.addAuswahl(PersonFactory.getRohrboeck(0), EssensMoeglichkeitFactory.getBilla());
        bean.addAuswahl(PersonFactory.getRenner(0), EssensMoeglichkeitFactory.getBilla());
        bean.addAuswahl(PersonFactory.getWohlmuth(0), EssensMoeglichkeitFactory.getLutz());
        
        bean.berechneAuswahl();
        
        assertNotNull(bean.getActualAuswahl());
        assertNotNull(bean.getBesteller());
        
        assertNotSame("", bean.getActualAuswahl().trim());
        
        assertTrue(bean.getActualAuswahl().startsWith("1") || 
                bean.getActualAuswahl().startsWith("2") || 
                bean.getActualAuswahl().startsWith("3"));
        
        if(EssensMoeglichkeit.checkIsBestellung(bean.getActualAuswahl()) ){
            assertNotSame("", bean.getBesteller().trim());
            assertEquals(PersonFactory.getGamauf(0).toString(), bean.getBesteller());
            assertEquals(PersonFactory.getSeidl(0).toString(), bean.getBesteller());
        }else{
            assertEquals("", bean.getBesteller().trim());
        }
    }

	@Test
	public void testPersonen() {
		Collection<EssensAuswahl> essensAuswahl = bean
				.getGewaehlteMoeglichkeiten();
		for (EssensAuswahl one : essensAuswahl) {
			System.out.println("Nachname: " + one.getPerson().getNachname());
		}
	}
}
