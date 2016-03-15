package com.scrumtrek.simplestore.test;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCode;
import com.scrumtrek.simplestore.PriceCodes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paul
 */
public class TestMovie {
    
    public TestMovie() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCtor()
    {
        PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);
        final Movie regularMovie=new Movie("regular", regular);
        assertEquals(regular, regularMovie.getPriceCode());
        assertEquals("regular", regularMovie.getTitle());
        
    }
    
    @Test
    public void testChangePriceCode()
    {
        PriceCode childrens = new PriceCode("child", -3, 3, 1.5, 0);
        PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);
        final Movie changePriceCodeMoview=new Movie("pricechanged", childrens);
        assertEquals(childrens, changePriceCodeMoview.getPriceCode());
        changePriceCodeMoview.setPriceCode(regular);
        assertEquals(regular, changePriceCodeMoview.getPriceCode());
    }
}
