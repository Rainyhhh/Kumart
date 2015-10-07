package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import unimelb.edu.au.kumart.entity.ShoppingCart;

public class ShoppingCartMongo {
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Collection name
	private static String SHOPPINGCART_COLLECTION = "ShoppingCart";
	
	public void addItem(ShoppingCart shoppingCart){
		mongoTemplate.insert(shoppingCart,SHOPPINGCART_COLLECTION);		
	}
}
