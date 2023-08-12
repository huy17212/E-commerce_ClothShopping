package com.HTT.company.dto;

import java.util.Map;

import com.HTT.company.entity.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CheckoutDto {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String address;
	
	private String townCity;
	
	private String countryState;
	
	private String postcodeZip;
	
	private String phone;
	
	private String email;
	
	private String sendMail;		
	
	private String payment;
	
	private Map<Product, Integer> mapProduct;
	private String coupon;
	private Double subTotal;
	private Double total;

}
