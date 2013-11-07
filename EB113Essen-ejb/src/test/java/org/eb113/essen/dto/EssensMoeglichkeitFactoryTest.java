/**
 * 
 */
package org.eb113.essen.dto;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Robert
 * 
 */
public class EssensMoeglichkeitFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.eb113.essen.dto.EssensMoeglichkeitFactory#getAllPossibilities()}
	 * .
	 */
    @Test
	public void testGetAllPossibilities() {
        List<EssensMoeglichkeit> allPoss = EssensMoeglichkeitFactory
            				.getAllPossibilities();
        Assert.assertNotNull(allPoss);
		Assert.assertTrue(allPoss.size() > 5);
	}

}
