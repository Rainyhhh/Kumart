package unimelb.edu.au.kumart.mongodb;

import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.Item;

/**
 * 
 * Data source layer.
 * Insert, delete, get, update the collection of Item.
 *
 */
@Repository
public class ItemMongo {

	@Autowired
	MongoTemplate mongoTemplate;
	Logger logger ;
	
	
	//Collection name
	private static String ITEM_COLLECTION = "Item";
	
	/**
	 * Insert a new item to the database
	 * @param item
	 * @return if success, return true; otherwise, return false.
	 */
	public boolean newItem(Item item) {
		mongoTemplate.insert(item, ITEM_COLLECTION);
		return true;
	}
	
	/**
	 * Get all items from the database as a list
	 * @return an Item list
	 */
	public List<Item> getItemList(){	
		List<Item> list = new ArrayList<Item>();	
		list = this.mongoTemplate.findAll(Item.class, ITEM_COLLECTION);
		return list;
	}

	/**
	 * Delete an Item from the database
	 * @param item
	 * @return if success, return true; otherwise, return false.
	 */
	public boolean deleteItem(Item item){
		// check if the item with this "id" exists in the database.
		mongoTemplate.remove(item, ITEM_COLLECTION);
		return true;
	}
	
	/**
	 * modify the information of a particular Item
	 * @param item
	 * @return if success, return true; otherwise, return false.
	 */
	public boolean updateItem(Item item){	
		mongoTemplate.save(item, ITEM_COLLECTION);
		return true;
	}
	
	/**
	 * Get a particular item from the database according to the "id"
	 * @param id
	 * @return An Item
	 */
	public Item getOneItem(String id){
		Criteria criteria = Criteria.where("_id").is(id);		
		if(null!=criteria){
	    Query query = new Query(criteria);
		Item item = this.mongoTemplate.findOne(query, Item.class,ITEM_COLLECTION);
		return item;
		}
		return null;
	}
	
	/**
	 * Get a list of items according to the query and it is a fuzzy matching
	 * @param query
	 * @return an Item list
	 */
	public List<Item> searchByName(String query){
		// fuzzy matching
		BasicQuery search = new BasicQuery("{\"name\": {$regex : '" + query + "'} }");
		List<Item> list = new ArrayList<Item>();
		list = this.mongoTemplate.find(search, Item.class, ITEM_COLLECTION);	        
		return list;
	}
}
