package com.HTT.company.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HTT.company.dto.CheckoutDto;
import com.HTT.company.entity.Product;
import com.HTT.company.service.PaypalService;
import com.HTT.company.service.ProductService;
import com.HTT.company.util.CheckoutDtoUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;

@Controller
public class CheckoutController {

	@Autowired
	ProductService productService;
	
	@Autowired
	PaypalService paypalService;

	@PostMapping("checkOutCart")
	public String showCheckOut(@RequestParam(defaultValue = "0.0", name = "true_total") Double toltal,
			@RequestParam(defaultValue = "0.0", name = "true_subTotal") Double subTotal, Model model,
			HttpServletRequest request, HttpServletResponse respone) {
		// get all products in cookies
		Map<Product, Integer> mapProduct = new LinkedHashMap<>();
		Cookie[] cookies = request.getCookies();

		model.addAttribute("true_total", toltal);
		model.addAttribute("true_subTotal", subTotal);

		if (cookies != null) {
			for (Cookie item : cookies) {
				if (item.getName().contains("product")) {
					mapProduct.put(productService.findByProductId(item.getName()), Integer.parseInt(item.getValue()));
				}
			}
			model.addAttribute("mapProduct", mapProduct);
			return "views/another_view/checkout";
		}
		model.addAttribute("mapProduct", new ArrayList());
		return "views/another_view/checkout";
	}

	@PostMapping("checkOrder")
	public String checkOrder(@RequestParam Map<String, String> data) {
		
//		ObjectMapper mapper = new ObjectMapper();
//		CheckoutDto checkoutDTO = mapper.convertValue(data, CheckoutDto.class);
		
//		System.out.print("Kaka is goat " + data.toString());
//		CheckoutDto billWillBePay = new Gson().fromJson(data, CheckoutDto.class);
//		
		CheckoutDtoUtils.MapStringStringparseToCheckoutDto(data);
		
		

		// store in DB

		// decrease amount

		// clear cookie

		if (data.get("paymethod").equals("Payment")) {

			// check if them has confirm in mail
			
			
			// return view success
		}
		else {
			// check if them has confirm in mail
			
			// handle in api palpay

				Payment payment = paypalService.createPayment(new CheckoutDto());
				for(Links link : payment.getLinks()) {
					if(link.getRel().equals("approval_url")) {
						return "redirect:"+link.getHref();
					}
				}
			return "redirect:/";
			// return view sucess
		}

		return "redirect:/";
	}

}
