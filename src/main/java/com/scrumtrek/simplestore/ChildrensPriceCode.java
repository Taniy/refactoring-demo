/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore;

/**
 *
 * @author ann
 */
public class ChildrensPriceCode extends PriceCode {

    public ChildrensPriceCode(String name, double constPrice, int days, double multiplier) {
        super(name, constPrice, days, multiplier);
    }

    @Override
    public double countAmount(Rental rental) {
        double amount = 0;
        amount += getConstPrice();
        if (rental.getDaysRented() > getDays()) {
            amount = (rental.getDaysRented() - getDays()) * getMultiplier();
        }
        return amount;
    }
    
}
