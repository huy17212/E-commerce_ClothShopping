package com.HTT.company.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.HTT.company.constant.ApplicationConstant;
import com.HTT.company.dto.CheckoutDto;
import com.HTT.company.entity.Product;

public class CheckoutDtoUtils {

	public static CheckoutDto MapStringStringparseToCheckoutDto(Map<String, String> checkOutMap) {

		System.out.println("goat kaka " + checkOutMap);
		
		CheckoutDto checkoutDto = (CheckoutDto) ApplicationConstant.APPLICATION_CONTEXT.getBean("getCheckoutDto");
		checkoutDto.setFirstName(checkOutMap.get("firstName"));
		checkoutDto.setLastName(checkOutMap.get("lastName"));
		checkoutDto.setCountry(checkOutMap.get("country"));
		checkoutDto.setTownCity(checkOutMap.get("townCity"));
		checkoutDto.setCountryState(checkOutMap.get("countryState"));
		checkoutDto.setPostcodeZip(checkOutMap.get("postZip"));
		checkoutDto.setPhone(checkOutMap.get("phone"));
		checkoutDto.setEmail(checkOutMap.get("email"));
		checkoutDto.setSendMail(checkOutMap.get("sendMail"));
		checkoutDto.setPayment(checkOutMap.get("payment"));
		checkoutDto.setPostcodeZip(checkOutMap.get("postcodeZip"));

		
		
		Map<Product, Integer> map = new LinkedHashMap<Product, Integer>();
		for (String keyValue : checkOutMap.get("mapProduct").split(" *}, *")) {
			String[] pairs = keyValue.split(" *= *");
			Integer number = Integer.parseInt(keyValue.substring(keyValue.indexOf(")=") + 2, keyValue.indexOf(")=") + 3));
			try {
				map.put(Product.parse(pairs[0]), pairs.length == 1 ? 0 : number);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		checkoutDto.setMapProduct(map);
		System.out.println("king of kaka " + map);

		return null;
	}

}
