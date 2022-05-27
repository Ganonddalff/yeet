package fr.isika.cda.viewmodels.form.shop;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.model.factories.implementation.ProductFactoryImpl;


public class ProductCreateForm {
	
	private Product product;

	
	public ProductCreateForm(){
        this.product = ProductFactoryImpl.getInstance().getProduct();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
