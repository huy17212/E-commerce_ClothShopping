package com.HTT.company.service;

import java.util.Map;

import com.HTT.company.dto.CheckoutDto;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;

public interface PaypalService {
	
	Map<String, String> paypalSdkConfig();
	
	OAuthTokenCredential oAuthTokenCredential();
	
	APIContext apiContext();
	
	Payment createPayment(CheckoutDto dto);

}
