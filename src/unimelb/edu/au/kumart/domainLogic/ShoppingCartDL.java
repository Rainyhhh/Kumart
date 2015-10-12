package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import com.sun.javafx.binding.StringFormatter;

import unimelb.edu.au.kumart.entity.ShoppingCart;

public interface ShoppingCartDL {

//	public void addItem (String item_id,String item_name, int quantity);
	public void addItem (String username, ShoppingCart shoppingCart);
	public void deleteItem (int item_id, int user_id);
	public void updateItem (ShoppingCart shoppingCart); 
	public List<ShoppingCart> getShoppingCart(String username);
	public ShoppingCart getOneItem (int id);
}
