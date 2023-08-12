package com.HTT.company.enumeration;

public enum Categories {

	All("all", "All the items", 120),

	Bags("bags", "All the Bags items", 20),

	Clothing("clothing", "All the Clothing items", 20),

	Shoes("shoes", "All the Shoes items", 20),

	Accessories("accessories", "All the Accessories items", 20),

	Kids("kids", "All the Kids items", 20),

	Adult("adult", "All the Adult items", 20),

	Teen("teen", "All the Teen items", 20);

	private String nameCategory;

	private String moreInfomation;

	private Integer amount;

	Categories(String nameCategory, String moreInfomation, Integer amount) {
		this.nameCategory = nameCategory;
		this.moreInfomation = moreInfomation;
		this.amount = amount;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Integer getAmount() {
		return amount;
	}

}
