package fr.isika.cda.managedbeans.shop;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.services.ProductService;


@ManagedBean
@ViewScoped
public class ProductDetailsBean implements Serializable{
	
	private Long id;
    private Product product;


    @Inject
    private ProductService productService;

    public ProductDetailsBean(){
    }

    public void init(){
        this.product = productService.findProductById(this.id);
    }

	public Product getProduct() {
		return product;
		
	}

	public void setProduct(Product product) {
		this.product = product;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
