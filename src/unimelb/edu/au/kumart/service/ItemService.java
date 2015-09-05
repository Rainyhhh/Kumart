package unimelb.edu.au.kumart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.mongodb.ItemMongo;
import java.util.*;

@Service
public class ItemService {
	
	@Autowired
	private ItemMongo itemMongo;
	
	public boolean newItem(Item item) {
		if(itemMongo.addItem(item)) {
			return true;
		}
		return false;
	}
	public List<Item> getItem(){
		List<Item> itemlist = itemMongo.getItem();
		return itemlist;				
	}
	
	public boolean deleteItem(String id){
		if(itemMongo.deleteItem(id)){
			return true;
		}
		return false;
	}
	
	public boolean update(String id,Item item){
		if(itemMongo.updateItem(id,item)){
			return true;
		}
		return false;
	}
	
	public Item getOneItem(String id){
		Item item = itemMongo.getOneItem(id);
		if(item!=null){
		return item;}
		return null;
	}

}
