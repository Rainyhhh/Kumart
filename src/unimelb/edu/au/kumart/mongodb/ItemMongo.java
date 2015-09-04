package unimelb.edu.au.kumart.mongodb;

import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	Logger logger ;
	
	
	//Collection name
	private static String ITEM_COLLECTION = "Item";
	
	public boolean addItem(Item item) {
		mongoTemplate.save(item, ITEM_COLLECTION);
		return true;
	}
	
	public List<Item> getItem(){	
		List<Item> list = new ArrayList<Item>();	
		list = this.mongoTemplate.findAll(Item.class, ITEM_COLLECTION);
		for(Item i : list){
			System.out.println(i.getName());
		}
		System.out.println(list.size());
		return list;

	}
}
