package com.scrumtrek.simplestore;

public class RegularPriceCode extends PriceCode {

    public RegularPriceCode(String name, double constPrice, int days, double multiplier) {
        super(name, constPrice, days, multiplier);
    }

    @Override
    public double countAmount(Rental rental) {
        double amount = 0;
        amount += getConstPrice();
        if (rental.getDaysRented() > getDays()) {
            amount += (rental.getDaysRented() - getDays()) * getMultiplier();
        }
        return amount;
    }
    
}
