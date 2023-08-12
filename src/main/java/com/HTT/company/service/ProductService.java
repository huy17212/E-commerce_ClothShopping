package com.HTT.company.service;

import java.util.List;

import com.HTT.company.entity.Product;

public interface ProductService {

	List<Product> getAllProduct();

	Product findByProductId(String productId);

	List<Product> loadProductByConstaint(String CATEGORIES_CODE, String BRANDING_CODE, String SIZE_CODE,
			String FILTER_PRICE, String COLOR_CODE, String TAG_CODE, String SORT_CODE, String SEARCH_CODE);

}
