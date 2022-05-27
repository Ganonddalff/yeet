package fr.isika.cda.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.repositories.ProductRepository;
import fr.isika.cda.viewmodels.ProductCreateForm;


@Stateless
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	
	public ProductService() {
		
	}
	//Avant de faire appel au repo récupérer la session du compte association
	//service responsable de la règle métier 
	public Product createProduct(ProductCreateForm productCreateForm, Association association) {
		Product product = productCreateForm.getProduct();
		product.setAssociation(association);
        return productRepository.create(product);
    }

}
