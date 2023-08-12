package com.HTT.company.enumeration;

public enum Tag {

	Product("All", "All the branding items", 100),

	Bags("Bags", "All the branding items", 100),

	Shoes("Shoes", "All the branding items", 100),

	Fashio("Fashio", "All the branding items", 100),

	Clothing("Clothing", "All the branding items", 100),

	Hats("Hats", "All the branding items", 100),

	Accessors("Accessors", "All the branding items", 100);

	private String nameTag;

	private String moreInfomation;

	private Integer amount;

	Tag(String nameTag, String moreInfomation, Integer amount) {
		this.nameTag = nameTag;
		this.moreInfomation = moreInfomation;
		this.amount = amount;
	}

	public String getNameTag() {
		return nameTag;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Integer getAmount() {
		return amount;
	}

}
