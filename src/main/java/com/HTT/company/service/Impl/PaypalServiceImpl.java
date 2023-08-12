package com.HTT.company.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.HTT.company.constant.PaypalTokenConstant;
import com.HTT.company.dto.CheckoutDto;
import com.HTT.company.service.PaypalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaypalServiceImpl implements PaypalService {

	@Override
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> configMap = new HashMap<>();
		configMap.put("mode", PaypalTokenConstant.MODE);
		return configMap;
	}

	@Override
	public OAuthTokenCredential oAuthTokenCredential() {
		return new OAuthTokenCredential(PaypalTokenConstant.CLIENT_ID, PaypalTokenConstant.CLIENT_SECRET,
				paypalSdkConfig());
	}

	@Override
	public APIContext apiContext() {
		APIContext context;
		try {
			context = new APIContext(oAuthTokenCredential().getAccessToken());
			context.setConfigurationMap(paypalSdkConfig());
			return context;
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Payment createPayment(CheckoutDto data) {
		// TODO Auto-generated method stub
		return null;
	}

}
