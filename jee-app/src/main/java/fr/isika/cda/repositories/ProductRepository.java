package fr.isika.cda.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
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
	
	public Product findById(Long idProduct){
		Product product = entityManager.find(Product.class, idProduct);
		entityManager.flush();
		entityManager.clear();
		return product;
	}
	
	public List<Product> findAllProducts() {
		return this.entityManager
                .createQuery("SELECT produit FROM Product produit", Product.class)
                .getResultList();
	}
	
	/*public List<Product> findAllProductsByAssociation(Long idAssociation) {
		return this.entityManager
                .createQuery("SELECT produit FROM Product produit", Product.class)
                .getResultList();
	}*/
	
	public Product update(Product product) {
        return this.entityManager.merge(product);
    }





	
	
	

}
