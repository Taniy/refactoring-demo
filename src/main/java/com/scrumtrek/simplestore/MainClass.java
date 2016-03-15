package com.scrumtrek.simplestore;

import java.util.HashMap;

class MainClass {
	 static void Main(String[] args) {
		 PriceCode regular = new PriceCode("regular", 2, 2, 1.5,0);
		 PriceCode	 newRelease = new PriceCode("NewRelease", 3, 0, 0,1);
		 PriceCode	 childrens = new PriceCode("child", 3, 3, 1.5,0);
		 PriceCode	 advent  = new PriceCode("advent", 3, 3, 1.5,0);

		// Create movies
		Movie movCinderella = new Movie("Cinderella", childrens);
		Movie movStarWars = new Movie("Star Wars", regular);
		Movie movGladiator = new Movie("Gladiator", newRelease);


		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		// Create rentals
		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		// Generate invoice
		String statement = custMickeyMouse.Statement();

		// Print the statement
		System.out.println(statement);		
	}
}

