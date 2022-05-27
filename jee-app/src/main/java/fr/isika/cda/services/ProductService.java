package fr.isika.cda.services;

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
	//Avant de faire appel au repo récupérer la session du compte association
	//service responsable de la règle métier 
	public Product createProduct(ProductCreateForm productCreateForm, Association association) {
		Product product = productCreateForm.getProduct();
		product.setAssociation(association);
        return productRepository.create(product);
    }
	
	//Récuperer tous les produits de la boutique
	/*public List<Product> finAllProduct(){
		
	}
	
	//Récupérer la liste des produits par association
	public List<Product> findAllProductByAssociation(Long id){
		
	}
	
	public Product findProduct() {
		
	}
	
	
	public Product updateProduct(ProductCreateForm productUpdateForm) {
		Product updateProduct = productUpdateForm.getProduct();
		updateProduct.setManufacturingCountry(productUpdateForm.getProduct().getManufacturingCountry());
		updateProduct.setNameProduct(productUpdateForm.getProduct().getNameProduct());
		updateProduct.setStock(productUpdateForm.getProduct().getStock());
		updateProduct.setPrice(productUpdateForm.getProduct().getPrice());
		updateProduct.setCategory(productUpdateForm.getProduct().getCategory());
		return updateProduct;
		
	}*/

}
