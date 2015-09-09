package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import unimelb.edu.au.kumart.entity.Item;

public interface ItemDL {
	public boolean newItem(Item item);
	public List<Item> getItemList();
	public boolean deleteItem(String id);
	public boolean updateItem(String id, Item item);
	public Item getOneItem(String id);
	public List<Item> searchByName(String query);

}
