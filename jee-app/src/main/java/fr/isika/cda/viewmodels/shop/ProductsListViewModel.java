package fr.isika.cda.viewmodels.shop;

import java.util.List;

import fr.isika.cda.model.entities.Product;

public class ProductsListViewModel {

	private List<Product> productsList;
	
	public ProductsListViewModel(List<Product> list) {
		this.setProductsList(list);
		
	}

	public List<Product> getProductsList() {
		return productsList;
		
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
		
	}
	
	
	
	
}
