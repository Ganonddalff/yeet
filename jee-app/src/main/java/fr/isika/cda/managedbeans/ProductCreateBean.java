package fr.isika.cda.managedbeans;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.ProductCreateForm;

@ManagedBean
@ViewScoped
public class ProductCreateBean implements Serializable {
	
	private ProductCreateForm productCreateForm;
	
	@Inject
	private ProductService productService;
	
	public ProductCreateBean() {
		this.productCreateForm = new ProductCreateForm();
	}
	
	public void create(){
        productService.createProduct(this.productCreateForm);
    }

	public ProductService getProductservice() {
		return productService;
		
	}

	public void setProductservice(ProductService productservice) {
		this.productService = productservice;
		
	}

	public ProductCreateForm getProductCreateForm() {
		return productCreateForm;
		
	}

	public void setProductCreateForm(ProductCreateForm productCreateForm) {
		this.productCreateForm = productCreateForm;
		
	}

}
