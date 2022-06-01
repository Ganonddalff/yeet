package fr.isika.cda.viewmodels.shop;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import fr.isika.cda.model.entities.Command;
import fr.isika.cda.model.entities.CommandLine;
import fr.isika.cda.model.entities.Product;

public class Basket {

	private Date creatingDate;
	private List<BasketLine> basketLines;

	public Date getCreatingDate() {
		return creatingDate;
	}

	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}
	
	public void addProduct(Product product, Integer quantity) {
		
		// TODO : plus "intelligent" si le produit est déjà dans liste il faut
		// incrémenter la quantité
		//on verifie si le produit existe dejà dans le panier
		boolean productExisteInBasket = false;
		for (BasketLine basketLine : this.basketLines) {
			if (basketLine.getProductId() == product.getId()) {
				basketLine.setQuantity(basketLine.getQuantity() + quantity);
				productExisteInBasket = true;
				break;
			}
		}
		
		if (productExisteInBasket == false) {
			this.basketLines.add(new BasketLine(product, quantity));
		}
		
	}
	
//	public void removeProduct(Product product) {
//		Iterator<BasketLine> iterator = this.basketLines.iterator();
//		while(iterator.hasNext()) {
//			BasketLine basketLine = iterator.next();
//			if(basketLine.getProductId().equals(product.getId())) {
//				iterator.remove();
//				break;
//			}
//		}
//	}
	
	public void removeProductFromBasket(Product product) {
		for (BasketLine basketLine : this.basketLines) {
			if (basketLine.getProductId() == product.getId()) {
				this.basketLines.remove(basketLine);
				break;
			}
		}
	}
	
	public void removeProduct(BasketLine line) {
		this.basketLines.remove(line);
	}
	
	public Command validBasket() {
		Command cmd = new Command();
		for (Iterator iterator = basketLines.iterator(); iterator.hasNext();) {
			BasketLine basketLine = (BasketLine) iterator.next();
			CommandLine cmdLine = new CommandLine();
			cmdLine.setProduct(basketLine.getProduct());
			cmdLine.setQuantity(basketLine.getQuantity());
			cmdLine.setUnitPrice(basketLine.getProductPrice());
			cmdLine.setTotalPrice(basketLine.getProductPrice() * basketLine.getQuantity());
			cmd.getCommandLine().add(cmdLine);
		}
		return cmd;
	}
	
	
}
