package com.scrumtrek.simplestore;

public class Movie {
	private String m_Title;
	private String priceCodeName;

	public Movie(String title, String priceCodeName) {
		m_Title = title;
		this.priceCodeName = priceCodeName;
	}

    public String getM_Title() {
        return m_Title;
    }

    public void setM_Title(String m_Title) {
        this.m_Title = m_Title;
    }

    public String getPriceCodeName() {
        return priceCodeName;
    }

    public void setPriceCodeName(String priceCodeName) {
        this.priceCodeName = priceCodeName;
    }

	public String getTitle() {
		return m_Title;
	}
}

