package com.scrumtrek.simplestore.test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCode;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;

/**
 * Created by tan on 15.03.16.
 */
public class TestPrice {
    @Test(expected = RuntimeException.class)
    public void TestGustPrice() {

        PriceCode	 childrens = new PriceCode("child", 3, 3, -5, 0);

        // Create movies
        Movie movCinderella = new Movie("Cinderella", childrens);



        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 4);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        String statement = custMickeyMouse.Statement();

        // Print the statement
        System.out.println(statement);
    }

}
