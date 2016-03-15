package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}


	public void addRental(Rental arg){
		m_Rentals.add(arg);
	}

    public List<Rental> getM_Rentals() {
        return m_Rentals;
    }

    public void setM_Rentals(List<Rental> m_Rentals) {
        this.m_Rentals = m_Rentals;
    }
        
        
}

