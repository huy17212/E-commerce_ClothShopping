package com.HTT.company.enumeration;

public enum Size {

	All("all", "All the Size items", 160),

	XS("XS", "All the XS items", 20),

	S("S", "All the XS items", 20),

	M("M", "All the M items", 20),

	XL("XL", "All the XL items", 20),

	XL2("2XL", "All the XL2 items", 20),

	XXL("XXL", "All the XXL items", 20),

	XL3("3XL", "All the XL3 items", 20),

	XL4("4XL", "All the XL4 items", 20);

	private String nameSize;

	private String moreInfomation;

	private Integer amount;

	Size(String nameSize, String moreInfomation, Integer amount) {
		this.nameSize = nameSize;
		this.moreInfomation = moreInfomation;
		this.amount = amount;
	}

	public String getNameSize() {
		return nameSize;
	}

	public String getMoreInfomation() {
		return moreInfomation;
	}

	public Integer getAmount() {
		return amount;
	}

}
