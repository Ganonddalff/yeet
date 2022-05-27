package fr.isika.cda.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.viewmodels.ProductCreateForm;

@Stateless
public class ProductRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductRepository() {
		
	}
	
	public Product create(Product product) {
		entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();
        
        return product;
	}
	
	public Product update(Product product) {
		entityManager.flush();
		return product;
	}
	
	
	

}
