package com.HTT.company.enumeration;

public enum SortingByPrice {

	lowToHigh("Low to high", "DES"),

	highToLow("High to low", "ASC");

	private String nameSortingMethod;

	private String moreInfomation;

	SortingByPrice(String nameSortingMethod, String moreInfomation) {
		this.nameSortingMethod = nameSortingMethod;
		this.moreInfomation = moreInfomation;
	}

	public String getNameSortingMethod() {
		return nameSortingMethod;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}
	
}
