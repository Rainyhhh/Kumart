package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import unimelb.edu.au.kumart.entity.ShoppingCart;

public class ShoppingCartMongo {
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Collection name
	private static String ADMIN_COLLECTION = "User";
	
	public void addItem(ShoppingCart shoppingCart){
		mongoTemplate.save(shoppingCart,ADMIN_COLLECTION);		
	}
	
	public void deleteRecord(String item_id){
		
	}
}
