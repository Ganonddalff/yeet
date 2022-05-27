package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Product;
import fr.isika.cda.model.factories.interfaces.ProductFactory;

public class ProductFactoryImpl implements ProductFactory{
	
	  private static ProductFactoryImpl instance = null;

	    private ProductFactoryImpl(){}

	    public static synchronized ProductFactoryImpl getInstance() {
	        if (instance ==	null) {
	            instance = new ProductFactoryImpl();
	        }
	        return instance;
	    }
	    
	    @Override
	    public Object clone() throws CloneNotSupportedException	{
	        throw new CloneNotSupportedException();
	    }

	@Override
	public Product getProduct() {
		return new Product();
	}
	
	

}
