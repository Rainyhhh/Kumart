package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.ShoppingCart;

@Repository
public class ShoppingCartMongo {
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Collection name
	private static String ADMIN_COLLECTION = "User";
	
//	public void addItem(ShoppingCart shoppingCart){		
//		Criteria criteria =Criteria.where("email").is(shoppingCart.getUsername());
//		Query query = new Query(criteria);
//		Update update = new Update();
//		update.addToSet("shoppingCart", shoppingCart);
//		mongoTemplate.upsert(query, update, Customer.class, ADMIN_COLLECTION);				
//	}
	
	public void deleteRecord(String item_id){
		
	}
}
