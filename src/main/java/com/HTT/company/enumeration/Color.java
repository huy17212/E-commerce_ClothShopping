package com.HTT.company.enumeration;

public enum Color {
	
	all("all", "All the color items", 180),
	
	black("black", "All the black items", 20), 
	
	blue("blue", "All the blue items", 20), 
	
	yellow("yellow", "All the yellow items", 20), 
	
	gray("gray", "All the gray items", 20), 
	
	navi("navi", "All the navi items", 20), 
	
	pink("pink", "All the pink items", 20), 
	
	purple("purple", "All the purple items", 20), 
	
	red("red", "All the red items", 20), 
	
	white("white", "All the white items", 20);

	private String nameColor;

	private String moreInfomation;

	private Integer amount;

	Color(String nameColor, String moreInfomation, Integer amount) {
		this.nameColor = nameColor;
		this.moreInfomation = moreInfomation;
		this.amount = amount;
	}

	public String getNameColor() {
		return nameColor;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Integer getAmount() {
		return amount;
	}
}
