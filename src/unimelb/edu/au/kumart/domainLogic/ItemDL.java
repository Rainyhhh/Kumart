package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import unimelb.edu.au.kumart.entity.Item;

/**
 * This interface provides related CURD methods.
 *
 */
public interface ItemDL {
	/**
	 * this method provides the functionality to create a new item 
	 * @param item
	 * @return if successfully, return true; otherwise return false;
	 */
	public boolean newItem(Item item);
	
	/**
	 * this method provides the functionality to get a list of all items
	 * @return an Item list
	 */
	public List<Item> getItemList();
	
	/**
	 * this method provides the functionality to with provided id
	 * @param id
	 * @return if success, return true; otherwise, return false.
	 */
	public boolean deleteItem(String id);
	
	/**
	 * this method provides the functionality to with provided id and Item object
	 * @param id
	 * @param item
	 * @return if success, return true; otherwise, return false.
	 */
	public boolean updateItem(String id, Item item);
	
	 /**
	  *  this method provides the functionality to get an Item object with provided id 
	  * @param id
	  * @return if success, return true; otherwise, return false.
	  */
	public Item getOneItem(String id);
	
	/**
	 *  this method provides the functionality to get a list of Item objects with provided query
	 * @param query
	 * @return an Item list
	 */
	public List<Item> searchByName(String query);

}
