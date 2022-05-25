package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Product;


public class ProductCreationForm {
	
	private Product product;
	private Account account;
	
	public ProductCreationForm(){
        this.account = new Account();
        this.product = new Product();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
