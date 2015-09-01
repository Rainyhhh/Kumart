package unimelb.edu.au.kumart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.mongodb.ItemMongo;

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

}
