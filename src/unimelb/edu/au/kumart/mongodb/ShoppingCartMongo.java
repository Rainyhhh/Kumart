package unimelb.edu.au.kumart.mongodb;

import java.util.Date;

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
	private static String CUSTOMER_COLLECTION = "User";
	
	public void addItem(ShoppingCart shoppingCart){		
		Criteria criteria =Criteria.where("email").is(shoppingCart.getUsername());
		Query query = new Query(criteria);
		Update update = new Update();
		update.addToSet("shoppingCarts", shoppingCart);
		mongoTemplate.upsert(query, update, Customer.class, CUSTOMER_COLLECTION);				
	}
	
	public void deleteRecord(String username, String item_id){
		Criteria criteria = Criteria.where("email").is(username);
		Query query = new Query(criteria);
		Customer customer = mongoTemplate.findOne(query, Customer.class, CUSTOMER_COLLECTION);
		for(int i = 0; i < customer.getShoppingCarts().size(); i ++) {
			if(customer.getShoppingCarts().get(i).getItem_id().equals(item_id)) {
				customer.getShoppingCarts().remove(i);
				customer.setModifiedTime(new Date());
				mongoTemplate.save(customer, CUSTOMER_COLLECTION);
				return;
			}
		}

	}
}
