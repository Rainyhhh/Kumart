package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import unimelb.edu.au.kumart.entity.ShoppingCart;

public interface ShoppingCartDL {

	public void addItem (ShoppingCart shoppingCart);
	public void deleteItem (int item_id, int user_id);
	public void updateItem (ShoppingCart shoppingCart); 
	public List<ShoppingCart> getShoppingCart();
	public ShoppingCart getOneItem (int id);
}
