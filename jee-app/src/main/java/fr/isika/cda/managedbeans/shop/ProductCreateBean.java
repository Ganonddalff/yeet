package fr.isika.cda.managedbeans.shop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.form.shop.ProductCreateForm;

@ManagedBean
@ViewScoped
public class ProductCreateBean implements Serializable {
	
	private ProductCreateForm productCreateForm;
	private Part uploadedProductImage;
	private String imagePath;
	
	@Inject
	private ProductService productService;
	
	@Inject
    private AccountService accountService;
	
	
	public ProductCreateBean() {
		this.productCreateForm = new ProductCreateForm();
	}
	
	public void create(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//on recupère l'idenfiant de l'utilisation courante en session
		String currentUserIdentifier = (String) session.getAttribute("identifier");
		
		//vérifier que l'utilisateur est connecté
		if (currentUserIdentifier != null) {
			Optional<Account> optional = accountService.findByIdentifier(currentUserIdentifier);
	        if (optional.isPresent()) {
	            Account account = optional.get();
	      
	            Product product = productService.createProduct(this.productCreateForm, account.getAssociation());
	            
	            String fileName = "productImage_" + product.getId() + "." +
	                    uploadedProductImage.getSubmittedFileName().substring(uploadedProductImage.getSubmittedFileName().lastIndexOf('.') + 1);
	            try {
	                InputStream myInputStream = uploadedProductImage.getInputStream();
	                ServletContext servletContext = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
	                File newFile = new File(servletContext.getRealPath("/resources/images/produits"), fileName);
	                newFile.createNewFile();
	                Path newPath = newFile.toPath();
	                Files.copy(myInputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            product.setImage("/resources/images/produits/" + fileName);
	            productService.updateProduct(product); 
	            
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

	public Part getUploadedProductImage() {
		return uploadedProductImage;
		
	}

	public void setUploadedProductImage(Part uploadedProductImage) {
		this.uploadedProductImage = uploadedProductImage;
		
	}

	public String getImagePath() {
		return imagePath;
		
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		
	}

}
