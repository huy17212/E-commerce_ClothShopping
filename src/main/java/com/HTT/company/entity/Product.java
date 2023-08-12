package com.HTT.company.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 5738479777950684186L;

	@Id
	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_color")
	private String productColor;

	@Column(name = "product_size")
	private String productSize;

	@Column(name = "product_amount")
	private Integer productAmount;

	@Column(name = "product_tag")
	private String productTag;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_brand")
	private String productBrand;

	@Column(name = "product_price")
	private Double productPrice;

	@Column(name = "product_rate_star")
	private Double productRateStar;

	@Column(name = "product_video")
	private String productVideo;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "product_thumnail")
	private String productThumnail;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "additional_infomation")
	private String additionalInfomation;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_time")
	private Date discountTime;

	@Column(name = "date_update")
	private Date dateUpdate;

	@Column(name = "date_create")
	private Date dateCreate;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<String> getProductColor() {
		return Arrays.asList(productColor.split(","));
	}

	public void setProductColor(List<String> listColor) {
		String temp = listColor.get(0);
		listColor.stream().map(item -> temp + "," + item).toString();
		this.productColor = temp;
	}

	public List<String> getProductSize() {
		return Arrays.asList(productSize.split(","));
	}

	public void setProductSize(List<String> listSize) {
		String temp = listSize.get(0);
		listSize.stream().map(item -> temp + "," + item).toString();
		this.productSize = temp;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public List<String> getProductTag() {
		return Arrays.asList(productTag.split(","));
	}

	public void setProducTag(List<String> listTag) {
		String temp = listTag.get(0);
		listTag.stream().map(item -> temp + "," + item).toString();
		this.productTag = temp;
	}

	public List<String> getProductCategory() {
		return Arrays.asList(productCategory.split(","));
	}

	public void setProductCategory(List<String> listCategory) {
		String temp = listCategory.get(0);
		listCategory.stream().map(item -> temp + "," + item).toString();
		this.productCategory = temp;
	}

	public List<String> getProductBrand() {
		return Arrays.asList(productBrand.split(","));
	}

	public void setProductBrand(List<String> listProductBrand) {
		String temp = listProductBrand.get(0);
		listProductBrand.stream().map(item -> temp + "," + item).toString();
		this.productBrand = temp;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductRateStar() {
		return productRateStar;
	}

	public void setProductRateStar(Double productRateStar) {
		this.productRateStar = productRateStar;
	}

	public String getProductVideo() {
		return productVideo;
	}

	public void setProductVideo(String productVideo) {
		this.productVideo = productVideo;
	}

	public List<String> getProductImage() {
		return Arrays.asList(productImage.split(","));
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductThumnail() {
		return productThumnail;
	}

	public void setProductThumnail(String productThumnail) {
		this.productThumnail = productThumnail;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getAdditionalInfomation() {
		return additionalInfomation;
	}

	public void setAdditionalInfomation(String additionalInfomation) {
		this.additionalInfomation = additionalInfomation;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getDiscountTime() {
		return discountTime;
	}

	public void setDiscountTime(Date discountTime) {
		this.discountTime = discountTime;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public void setProducTag(String producTag) {
		this.productTag = producTag;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public static Product parse(String input) throws Exception {
        Pattern pattern = Pattern.compile("(\\w+)=(\\w+)");
        Matcher matcher = pattern.matcher(input);
        Product product = new Product();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            Field field = Product.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(product, value);
        }
        return product;
    }
}
