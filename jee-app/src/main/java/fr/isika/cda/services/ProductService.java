package fr.isika.cda.services;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.repositories.ProductRepository;
import fr.isika.cda.viewmodels.form.shop.ProductCreateForm;


@Stateless
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	
	public ProductService() {
		
	}

	public Product createProduct(ProductCreateForm productCreateForm, Association association) {
		Product product = productCreateForm.getProduct();
		product.setAssociation(association);
        return productRepository.create(product);
    }
	
	public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllProductsShop() {
        return productRepository.findAllProducts();
    }
    
    public Product updateProduct(Product product){
        return productRepository.update(product);
    }

}
