package fr.isika.cda.managedbeans.shop;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.Index;

import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.association.AssociationListViewmodel;
import fr.isika.cda.viewmodels.shop.ProductsListViewModel;

@ManagedBean
@ViewScoped
public class ProductsListBean implements Serializable {
	
	private ProductsListViewModel viewModel;
	
	@Inject
	private ProductService productService;

	public ProductsListBean() {
		super();
	}
	
	@PostConstruct
    public void init() {
            this.viewModel = new ProductsListViewModel(productService.findAllProductsShop());
    }

	public ProductsListViewModel getViewModel() {
		return viewModel;
		
	}

	public void setViewModel(ProductsListViewModel viewModel) {
		this.viewModel = viewModel;
		
	}
	

}
