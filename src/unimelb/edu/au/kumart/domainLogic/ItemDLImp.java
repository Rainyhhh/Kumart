package unimelb.edu.au.kumart.domainLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.mongodb.ItemMongo;
import java.util.*;

@Service
public class ItemDLImp implements ItemDL{
	
	@Autowired
	private ItemMongo itemMongo;
	
	public boolean newItem(Item item) {
		if(item.getDescription()!= null&& item.getName()!=null &&
			item.getNumber()!=0 && item.getPrice()!= 0){
		if(itemMongo.newItem(item)) {
			return true;
		}
		}
		return false;
	}
	public List<Item> getItemList(){
		List<Item> itemlist = itemMongo.getItemList();
		return itemlist;				
	}
	
	public boolean deleteItem(String id){
		if(itemMongo.deleteItem(id)){
			return true;
		}
		return false;
	}
	
	public boolean updateItem(String id, Item item){
		item.set_id(id);
		if(itemMongo.updateItem(item)) {
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
	
	public List<Item> searchByName(String query){
		List<Item> resultList= itemMongo.searchByName(query);
		return resultList;
	}

}
