package fr.isika.cda.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Product;

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
	
	/*public Product update(Product product) {
		entityManager.find(Product.class, product);
		entityManager.flush();
		entityManager.clear();
		return product;
	}*/
	
	/*public Product findProduct(Long idProduct){
		Product product = entityManager.find(Product.class, idProduct);
		entityManager.flush();
		entityManager.clear();
		return product;
	}
	
	public void findAllProducts() {
			return entityManager.find(Product.class);
	}*/
	
	
	

}
