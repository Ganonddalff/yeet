package fr.isika.cda.managedbeans.shop;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.form.shop.ProductCreateForm;

@ManagedBean
@ViewScoped
public class ProductUpdateBean implements Serializable{

	private ProductCreateForm productCreateForm;

	@Inject
	private ProductService productService;

	@Inject
	private AccountService accountService;


	public ProductUpdateBean() {
		this.productCreateForm = new ProductCreateForm();
	}

	public void update(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//on recupère l'idenfiant de l'utilisation courante en session
		String currentUserIdentifier = (String) session.getAttribute("identifier");

		//vérifier que l'utilisateur est connecté
		if (currentUserIdentifier != null) {
			Optional<Account> optional = accountService.findByIdentifier(currentUserIdentifier);
			if (optional.isPresent()) {
				Account account = optional.get();
				productService.updateProduct(null);

			} else {
				// cas utilisateur introuvable
			}
		}

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
