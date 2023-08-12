package com.HTT.company.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HTT.company.entity.Product;
import com.HTT.company.enumeration.FilterPrice;
import com.HTT.company.repository.ProductRepository;
import com.HTT.company.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAllUsers();
	}

	@Override
	public Product findByProductId(String productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public List<Product> loadProductByConstaint(String CATEGORIES_CODE, String BRANDING_CODE, String SIZE_CODE,
			String FILTER_PRICE, String COLOR_CODE, String TAG_CODE, String SORT_CODE, String SEARCH_CODE) {
		
		
		List<Product> listProduct = getAllProduct();

		System.out.print(listProduct);
		
		FilterPrice enumFilterPrice = Arrays.asList(FilterPrice.values()).stream()
				.filter(item -> item.toString().equalsIgnoreCase(FILTER_PRICE)).toList().get(0);

		listProduct = listProduct.stream()
				.filter(item -> item.getProductCategory().contains(CATEGORIES_CODE)
						&& item.getProductBrand().contains(BRANDING_CODE.toLowerCase())
						&& (item.getProductPrice() >= enumFilterPrice.getStart())
						&& (item.getProductPrice() <= enumFilterPrice.getEnd())
						&& item.getProductSize().contains(SIZE_CODE) 
						&& item.getProductColor().contains(COLOR_CODE)
						&& item.getProductTag().contains(TAG_CODE.toLowerCase())
						&& (item.getProductName().toLowerCase().contains(SEARCH_CODE.toLowerCase()) || SEARCH_CODE.isBlank())
				).toList();
		

		
		List<Product> tempTingListProduct = new ArrayList<>(listProduct);
		
		Collections.sort(tempTingListProduct, (o1, o2) -> {
			return o1.getProductPrice().compareTo(o2.getProductPrice());
		});
		
		if(SORT_CODE.equalsIgnoreCase("highToLow")) {
			Collections.reverse(tempTingListProduct);
		}

		return tempTingListProduct;
	}
}
