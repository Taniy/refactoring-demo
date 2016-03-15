package com.scrumtrek.simplestore;

/**
 * Created by tan on 15.03.16.
 */
public class PriceCode {
    private String name;
    private int days;
    private double oneTimePrice;
    private double koef;
    private double freqeuntBonus = 0;

    PriceCode(String name, int days, double oneTimePrice, double koef, int freqeuntBonus)  {
        this.name = name;
        this.days = days;
        this.koef = koef;
        this.oneTimePrice = oneTimePrice;
        this.freqeuntBonus=freqeuntBonus;
    }

    public double count(int daysRented) {
        double thisAmount = oneTimePrice;
        if (daysRented > days)
        {
            thisAmount += (daysRented - days) * koef;
        }
        return thisAmount;
    }

    public double getFreqeuntBonus(int daysRented) {
        if  (daysRented > 1)
        {
            return freqeuntBonus;
        }
        return 0;
    }
}
