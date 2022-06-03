package fr.isika.cda.managedbeans.shop;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.viewmodels.shop.Basket;
import fr.isika.cda.viewmodels.shop.BasketLine;

@ManagedBean
@SessionScoped
public class BasketBean {
	
	private Basket basket = new Basket();
	private Integer quantity = 1;


	public void addInBasket(Product product) {
		basket.addProduct(product, this.quantity);
	}
	
	
	public void validateBasket() {
		basket.validBasket();
		// transformer le basket en commande
		
		// transformer chaque basket item en command line
		
		// ajouter les command lines à la commande
		
		
		// persister le tout (avec cascade entre commande et command line)
	}
	
	public void removeBasketLine(BasketLine line) {
		basket.removeProduct(line);
	}
	
	public void removeALLBasketLines() {
		this.basket = new Basket();
	}

	public Basket getBasket() {
		return basket;
	}

	public Integer getQuantity() {
		return quantity;
		
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		
	}

}
