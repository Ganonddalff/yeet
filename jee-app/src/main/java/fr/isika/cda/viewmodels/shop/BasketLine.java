package fr.isika.cda.viewmodels.shop;

import fr.isika.cda.model.entities.Product;

public class BasketLine {

	private Long productId;
	private String productName;
	private double productPrice;
	private Integer quantity;
	private Product product;
	
	public BasketLine(Product product, Integer quantity) {
		this.productId = product.getId();
		this.productName = product.getNameProduct();
		this.productPrice = product.getPrice();
		this.quantity = quantity;
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
