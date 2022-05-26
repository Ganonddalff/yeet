package fr.isika.cda.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.repositories.ProductRepository;
import fr.isika.cda.viewmodels.ProductCreateForm;


@Stateless
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	
	public ProductService() {
		
	}
	
	public Product createProduct(ProductCreateForm productCreateForm) {
        return productRepository.create(productCreateForm);
    }

}
