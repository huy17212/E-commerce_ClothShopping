package com.HTT.company.enumeration;

public enum Branding {

	All("All", "All the branding items", 100),
	
	LouisVuitton("Louis Vuitton", "All the Louis Vuitton items", 20),

	Chanel("Chanel", "All the Chanel items", 20),

	Hermes("Hermes", "All the Hermes items", 20),

	Gucci("Gucci", "All the Gucci items", 20),

	Polo("Polo", "All the Polo items", 20);

	private String nameBranding;

	private String moreInfomation;

	private Integer amount;

	Branding(String nameBranding, String moreInfomation, Integer amount) {
		this.nameBranding = nameBranding;
		this.moreInfomation = moreInfomation;
		this.amount = amount;
	}

	public String getNameBranding() {
		return nameBranding;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Integer getAmount() {
		return amount;
	}

}
