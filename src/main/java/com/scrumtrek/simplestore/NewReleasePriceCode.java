package com.scrumtrek.simplestore;

public class NewReleasePriceCode extends PriceCode {

    public NewReleasePriceCode(String name, double constPrice, int days, double multiplier) {
        super(name, constPrice, days, multiplier);
    }

    @Override
    public double countAmount(Rental rental) {
        return rental.getDaysRented() * getMultiplier();
    }
    
}
