package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.Item;

/**
 * 
 * Data source layer.
 * Insert, get, update the collection of Item.
 *
 */
@Repository
public class ItemMongo {

	@Autowired
	MongoTemplate mongoTemplate;
	
	//Collection name
	private static String ITEM_COLLECTION = "Item";
	
	public boolean addItem(Item item) {
		mongoTemplate.save(item, ITEM_COLLECTION);
		return true;
	}
}
