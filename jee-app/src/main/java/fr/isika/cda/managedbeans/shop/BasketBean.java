package fr.isika.cda.managedbeans.shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.viewmodels.shop.Basket;
import fr.isika.cda.viewmodels.shop.BasketLine;

@ManagedBean
@SessionScoped
public class BasketBean {
	
	private Basket basket = new Basket();
	
	public void AddInBasket(Product product, Integer quantity) {
		basket.addProduct(product, quantity);
	}
	
	public void ValidateBasket() {
		// transformer le basket en commande
		
		// transformer chaque basket item en command line
		
		// ajouter les command lines à la commande
		
		
		// persister le tout (avec cascade entre commande et command line)
	}
	
	public void RemoveBasketLine(BasketLine line) {
		basket.removeProduct(line);
	}

	public Basket getBasket() {
		return basket;
	}

}
