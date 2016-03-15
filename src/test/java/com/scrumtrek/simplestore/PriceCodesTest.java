package com.scrumtrek.simplestore;

import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriceCodesTest {

    @Test
    public void testCreateCustomer() {
        String name = UUID.randomUUID().toString();
        Customer customer = new Customer(name);
        assertEquals(name, customer.getName());
    }

    @Test
    public void testNewReleaseManyDays() throws Exception {
        String priceCodesSrc = "price_codes.config";

        String name3 = UUID.randomUUID().toString();
// Create movies
        Movie movGladiator = new Movie(name3, "NEW_RELEASE");

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement3 = rb.buildReport(custMinnieMouse);

        System.out.println(statement3);

        assertTrue(statement3.contains(custMinnieMouse.getName()));

        assertTrue(statement3.contains(movGladiator.getTitle()));

        assertTrue(movGladiator.getPriceCodeName().equals("NEW_RELEASE"));

        assertTrue(statement3.contains("You earned 2 frequent renter points"));

        assertTrue(statement3.contains("Amount owed is 15.0"));

    }

    @Test
    public void testChildrensManyDays() throws Exception {
        String priceCodesSrc = "price_codes.config";

        String name1 = UUID.randomUUID().toString();
// Create movies
        Movie movCinderella = new Movie(name1, "CHILDRENS");

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement = rb.buildReport(custMickeyMouse);

        System.out.println(statement);

        assertTrue(statement.contains(custMickeyMouse.getName()));

        assertTrue(statement.contains(movCinderella.getTitle()));

        assertTrue(movCinderella.getPriceCodeName().equals("CHILDRENS"));

        assertTrue(statement.contains("You earned 1 frequent renter points"));

        assertTrue(statement.contains("Amount owed is 3.0"));

    }

    @Test
    public void testRegularManyDays() throws Exception {
        String priceCodesSrc = "price_codes.config";

        String name1 = UUID.randomUUID().toString();
        String name2 = UUID.randomUUID().toString();
        String name3 = UUID.randomUUID().toString();
// Create movies
        Movie movStarWars = new Movie(name2, "REGULAR");

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental(movStarWars, 5);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement2 = rb.buildReport(custDonaldDuck);

        System.out.println(statement2);

        assertTrue(statement2.contains(custDonaldDuck.getName()));

        assertTrue(statement2.contains(movStarWars.getTitle()));

        assertTrue(movStarWars.getPriceCodeName().equals("REGULAR"));

        assertTrue(statement2.contains("You earned 1 frequent renter points"));

        assertTrue(statement2.contains("Amount owed is 6.5"));

    }

    @Test
    public void testLittleDays() throws Exception {
        String priceCodesSrc = "price_codes.config";
        String name1 = UUID.randomUUID().toString();
        String name2 = UUID.randomUUID().toString();
        String name3 = UUID.randomUUID().toString();
// Create movies
        Movie movCinderella = new Movie(name1, "CHILDRENS");
        Movie movStarWars = new Movie(name2, "REGULAR");
        Movie movGladiator = new Movie(name3, "NEW_RELEASE");

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 1);
        Rental rental2 = new Rental(movStarWars, 1);
        Rental rental3 = new Rental(movGladiator, 1);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement = rb.buildReport(custMickeyMouse);

        System.out.println(statement);

        assertTrue(statement.contains(custMickeyMouse.getName()));

        assertTrue(statement.contains(movCinderella.getTitle()));

        assertTrue(movCinderella.getPriceCodeName().equals("CHILDRENS"));
        assertTrue(movStarWars.getPriceCodeName().equals("REGULAR"));
        assertTrue(movGladiator.getPriceCodeName().equals("NEW_RELEASE"));

        assertTrue(statement.contains("Amount owed is 6.5"));
        assertTrue(statement.contains("You earned 3 frequent renter points"));
    }

    // new price code - xxx    
    @Test
    public void testNewPriceCodeManyDays() throws Exception {
        String priceCodesSrc = "price_codes.config";

        String name2 = UUID.randomUUID().toString();
// Create movies
        Movie movStarWars = new Movie(name2, "XXX");

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental(movStarWars, 10);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement2 = rb.buildReport(custDonaldDuck);

        System.out.println(statement2);

        assertTrue(statement2.contains(custDonaldDuck.getName()));

        assertTrue(statement2.contains(movStarWars.getTitle()));

        assertTrue(movStarWars.getPriceCodeName().equals("XXX"));

        assertTrue(statement2.contains("You earned 1 frequent renter points"));

        assertTrue(statement2.contains("Amount owed is 9.5"));

    }

    // new price code - xxx    
    @Test
    public void testNewPriceCodeLittleDays() throws Exception {
        String priceCodesSrc = "price_codes.config";

        String name2 = UUID.randomUUID().toString();
// Create movies
        Movie movStarWars = new Movie(name2, "XXX");

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental(movStarWars, 4);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);
        String statement2 = rb.buildReport(custDonaldDuck);

        System.out.println(statement2);

        assertTrue(statement2.contains(custDonaldDuck.getName()));

        assertTrue(statement2.contains(movStarWars.getTitle()));

        assertTrue(movStarWars.getPriceCodeName().equals("XXX"));

        assertTrue(statement2.contains("You earned 1 frequent renter points"));

        assertTrue(statement2.contains("Amount owed is 2"));

    }

    //amount is < 0 test
    @Test
    public void testNegativeAmount() throws Exception {
        String priceCodesSrc = "price_codes_1.config";

        String name2 = UUID.randomUUID().toString();
// Create movies
        Movie movStarWars = new Movie(name2, "XXX");

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental(movStarWars, 4);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        ReportBuilder rb = new ReportBuilder(priceCodesSrc);

        try {
            String statement2 = rb.buildReport(custDonaldDuck);
        } catch (Exception ee) {
            assertTrue(ee.getMessage().contains("amount is less than 0!"));
        }

    }
}
