/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore.test;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCode;
import com.scrumtrek.simplestore.Rental;
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
public class TestRental {
    
    public TestRental() {
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
    public void testCtor() {
        PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);
        Movie movie = new Movie("movie", regular);
        Rental rental = new Rental(movie,5);
        assertEquals(movie, rental.getMovie());
        assertEquals(5, rental.getDaysRented());
    }
}
