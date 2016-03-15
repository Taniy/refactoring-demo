package com.scrumtrek.simplestore;

public abstract class PriceCode {
    
    public enum TYPE {
        /**
         * Regular
         */
        R,
        
        /**
         * New Release
         */
        N,
        
        /**
         * Children
         */
        C
    }
    
    public abstract double countAmount(Rental rental);
    
    private String name;
    
    /**
     * стоимость ренты, не зависящая от количества дней.
     */
    private double constPrice;
    

    /**
     * количество дней ренты, за превышение которых начисляется доплата
     */
    private int days;
    
    /**
     * коэффициент расчета доплаты за превышение срока ренты <param>days</param>
     */
    private double multiplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConstPrice() {
        return constPrice;
    }

    public void setConstPrice(double constPrice) {
        this.constPrice = constPrice;
    }
    
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public PriceCode(String name, double constPrice, int days, double multiplier) {
        this.name = name;
        this.constPrice = constPrice;
        this.days = days;
        this.multiplier = multiplier;
    }
}
