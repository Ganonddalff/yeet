package fr.isika.cda.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.viewmodels.ProductCreationForm;

@Stateless

public class ProductRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductRepository() {
		
	}
	
	public Product ProductCreation(ProductCreationForm form) {
		Product product = form.getProduct();
		Account account = form.getAccount();
		
		entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();
        
        return product;
	}
	
	

}
