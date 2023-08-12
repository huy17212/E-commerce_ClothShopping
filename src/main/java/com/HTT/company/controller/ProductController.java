package com.HTT.company.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HTT.company.entity.Product;
import com.HTT.company.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("showInfomation")
	public String getDetailProduct(@RequestParam("productId") String productId, Model model) {
		Product product = productService.findByProductId(productId);
		model.addAttribute("productDetail", product);
		return "views/another_view/shop-details";
	}

	// add to cart and return showAllProduct.
	@PostMapping("/addToCart1")
	public ResponseEntity<?> addToCard(@RequestBody String thing, HttpServletResponse response,
			HttpServletRequest request) {
		// ListConstaint.USER_CART.add(productId);
		
		// -1 amount product;
		
		productService.findByProductId(thing);
		
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			response.addCookie(new Cookie(thing, "1"));
			return ResponseEntity.ok(thing);
		}
		for (Cookie item : cookies) {
			if (item.getName().equalsIgnoreCase(thing)) {
				response.addCookie(new Cookie(item.getName(), 1 + Integer.parseInt(item.getValue()) + ""));
				return ResponseEntity.ok(thing);
			}
		}

		response.addCookie(new Cookie(thing, "1"));
		return ResponseEntity.ok(thing);

	}

	@GetMapping("/addToCart2")
	public String addToCard2(@RequestParam(name = "productId") String productId, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/shop-details?productId=" + productId;
	}

	@GetMapping("/showCart")
	public String viewCard(Model model, HttpServletRequest request, HttpServletResponse response) {

		Map<Product, Integer> mapProduct = new LinkedHashMap<>();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie item : cookies) {
				if (item.getName().contains("product")) {
					mapProduct.put(productService.findByProductId(item.getName()), Integer.parseInt(item.getValue()));
				}
			}
			model.addAttribute("mapProduct", mapProduct);
			return "views/another_view/shopping-cart";
		}
		model.addAttribute("mapProduct", new ArrayList());
		return "views/another_view/shopping-cart";
	}

	@PostMapping("ChangeToAmount")
	public ResponseEntity<?> ChangeToAmount(@RequestBody String productIdAndAmount, HttpServletRequest request,
			HttpServletResponse response) {

		String productId = productIdAndAmount.split(",")[0];
		String amount = productIdAndAmount.split(",")[1];

		Cookie[] cookies = request.getCookies();

		for (Cookie item : cookies) {
			if (item.getName().equalsIgnoreCase(productId)) {
				response.addCookie(new Cookie(productId, amount));
				return ResponseEntity.ok(productService.findByProductId(productId));
			}
		}
		return ResponseEntity.ok(productService.findByProductId(productId));
	}
}
