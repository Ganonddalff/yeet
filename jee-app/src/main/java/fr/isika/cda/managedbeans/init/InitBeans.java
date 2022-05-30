package fr.isika.cda.managedbeans.init;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.association.AssociationListViewmodel;
import fr.isika.cda.viewmodels.shop.ProductsListViewModel;

public class InitBeans implements Serializable {
	
	private ProductsListViewModel productsListViewModel;
	private AssociationListViewmodel associationsListViewModel;
	
	@Inject
    private AssociationService associationService;
	
	@Inject
	private ProductService productService;
	
	@PostConstruct
    public void init() {
            this.associationsListViewModel = new AssociationListViewmodel(associationService.findAll());
            this.productsListViewModel = new ProductsListViewModel(productService.findAllProductsShop());
    }

}
