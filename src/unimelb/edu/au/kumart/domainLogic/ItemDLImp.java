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
	
	@Override
	public boolean newItem(Item item) {
		// TODO Auto-generated method stub
		if(itemMongo.newItem(item)) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Item> getItemList(){
		// TODO Auto-generated method stub
		List<Item> itemlist = itemMongo.getItemList();
		if(itemlist!=null){
		return itemlist;
		}
		return null;
	}
	@Override
	public boolean deleteItem(String id){
		Item item = itemMongo.getOneItem(id);
		if(item == null) return false;
		if(itemMongo.deleteItem(item)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateItem(String id, Item item){
		// TODO Auto-generated method stub
		item.set_id(id);
		if(itemMongo.updateItem(item)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Item getOneItem(String id){
		// TODO Auto-generated method stub
		Item item = itemMongo.getOneItem(id);
		if(item!=null){
		return item;}
		return null;
	}
	
	@Override
	public List<Item> searchByName(String query){
		// TODO Auto-generated method stub
		List<Item> resultList= itemMongo.searchByName(query);
		return resultList;
	}

}
