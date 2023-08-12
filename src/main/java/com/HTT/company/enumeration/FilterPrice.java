package com.HTT.company.enumeration;

public enum FilterPrice {

	All("$0.0 - $500.0", "All the Filter Price items", 0.0, 500.0),
	
	State1("$0.0 - $50.0", "All the State 1 Filter Price items", 0.0, 50.0),
	
	State2("$50.0 - $100.0", "All the State 2 Filter Price items", 50.0, 100.0),
	
	State3("$100.0 - $150.0", "All the State 3 Filter Price items", 100.0, 150.0),
	
	State4("$150.0 - $200.0", "All the State 4 Filter Price items", 150.0, 200.0),
	
	State5("$200.0 - $250.0", "All the State 5 Filter Price items", 200.0, 250.0);

	private String nameFilterPrice;

	private String moreInfomation;

	private Double start;

	private Double end;

	FilterPrice(String nameFilterPrice, String moreInfomation, Double start, Double end) {
		this.nameFilterPrice = nameFilterPrice;
		this.moreInfomation = moreInfomation;
		this.start = start;
		this.end = end;
	}

	public String getNameFilterPrice() {
		return nameFilterPrice;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Double getStart() {
		return start;
	}

	public Double getEnd() {
		return end;
	}

}
