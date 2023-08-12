package com.HTT.company.enumeration;

import java.util.Arrays;
import java.util.List;

public enum PaymentMethod {
	
	PaymentOffline("Checkout Payment", Arrays.asList("At Store")),
	
	PaymentOnline("Checkout Paypal", Arrays.asList("Paypal"));
	
	private String PaymentMethodInfomation;
	
	private List<String> PaymentApply;

	private PaymentMethod(String paymentMethodInfomation, List<String> paymentApply) {
		PaymentMethodInfomation = paymentMethodInfomation;
		PaymentApply = paymentApply;
	}

	public String getPaymentMethodInfomation() {
		return PaymentMethodInfomation;
	}

	public List<String> getPaymentApply() {
		return PaymentApply;
	}

	public void setPaymentMethodInfomation(String paymentMethodInfomation) {
		PaymentMethodInfomation = paymentMethodInfomation;
	}

	public void setPaymentApply(List<String> paymentApply) {
		PaymentApply = paymentApply;
	}
}
