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
		return list;
	}

	
	public boolean deleteItem(String id){	
		Item item = getOneItem(id);
		if(item!=null){
		mongoTemplate.remove(item, ITEM_COLLECTION);
		return true;
		}
		return false;
	}
	
	public boolean updateItem(Item item){	
		mongoTemplate.save(item, ITEM_COLLECTION);
		return true;
	}
	
	public Item getOneItem(String id){
		Criteria criteria = Criteria.where("_id").is(id);		
		if(null!=criteria){
	    Query query = new Query(criteria);
		Item item = this.mongoTemplate.findOne(query, Item.class,ITEM_COLLECTION);
		return item;
		}
		return null;
	}
	
	public List<Item> searchByName(String query){
		System.out.println(query);
		BasicQuery search = new BasicQuery("{\"name\": {$regex : '" + query + "'} }");
		List<Item> list = new ArrayList<Item>();
		list = this.mongoTemplate.find(search, Item.class, ITEM_COLLECTION);	
        for (int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i));
          }
		return list;
	}
}
