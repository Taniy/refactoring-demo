package com.scrumtrek.simplestore.test;

import com.scrumtrek.simplestore.*;

import java.lang.reflect.Field;
import java.util.List;
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
public class TestCustomer {

    public TestCustomer() {
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
    public void testCtor() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Customer mickey = new Customer("mickey");
        assertEquals("mickey", mickey.getName());

        Field rentalsField = mickey.getClass().getDeclaredField("m_Rentals");
        rentalsField.setAccessible(true);
        List<Rental> rentals = (List<Rental>) rentalsField.get(mickey);
        assertEquals(0, rentals.size());
    }

    @Test
    public void testAddRental() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        final Customer mickey = new Customer("mickey");
        assertEquals("mickey", mickey.getName());

        PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);

        final Movie movRegular = new Movie("regular", regular);
        final Rental rental = new Rental(movRegular, 1);
        mickey.addRental(rental);

        Field rentalsField = mickey.getClass().getDeclaredField("m_Rentals");
        rentalsField.setAccessible(true);
        List<Rental> rentals = (List<Rental>) rentalsField.get(mickey);
        assertEquals(1, rentals.size());
    }

    @Test
    public void testStatement() {
        final Customer mickey = new Customer("mickey");
        assertEquals("mickey", mickey.getName());
        PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);

        final Movie movRegularLong = new Movie("regular", regular);
        final Rental rentalRegularLong = new Rental(movRegularLong, 3);
        mickey.addRental(rentalRegularLong);

        final Movie movRegularShort = new Movie("regular", regular);
        final Rental rentalRegularShort = new Rental(movRegularShort, 1);
        mickey.addRental(rentalRegularShort);

        PriceCode	 newRelease = new PriceCode("NewRelease", 3, 0, 0,1);
        final Movie movNewRelease = new Movie("newrelease", newRelease);
        final Rental rentalNewRelease = new Rental(movNewRelease, 2);
        mickey.addRental(rentalNewRelease);

        PriceCode	 newReleaseShortPr = new PriceCode("NewRelease", 3, 0, 0,1);
        final Movie newReleaseShort = new Movie("newreleaseshort", newReleaseShortPr);
        final Rental rentalNewReleaseShort = new Rental(newReleaseShort, 1);
        mickey.addRental(rentalNewReleaseShort);

        PriceCode	 childrens = new PriceCode("child", -3, 3, 1.5, 0);
        final Movie child = new Movie("child", childrens);
        final Rental rentalChild = new Rental(child, 4);
        mickey.addRental(rentalChild);

        final Movie childShort = new Movie("childshort", childrens);
        final Rental rentalChildShort = new Rental(childShort, 1);
        mickey.addRental(rentalChildShort);

        final String invoice = mickey.Statement();
        final String expectedInvoice
                = "Rental record for mickey\n"
        +"\tregular	3.5\n"
        +"\tregular	2.0\n"
        +"\tnewrelease	0.0\n"
        +"\tnewreleaseshort	0.0\n"
        +"\tchild	13.5\n"
        +"\tchildshort	9.0\n"
        +"Amount owed is 28.0\n"
        +"You earned 7 frequent renter points.";
        System.out.println(invoice);
        assertEquals(expectedInvoice, invoice);
    }
}
