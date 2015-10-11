package unimelb.edu.au.kumart.domainLogic;

import java.util.Date;
import java.util.List;

import unimelb.edu.au.kumart.entity.ShoppingCart;
import unimelb.edu.au.kumart.mongodb.ShoppingCartMongo;

public class ShoppingCartDLImp implements ShoppingCartDL {
	ShoppingCartMongo shoppingCartMongo;
	
//	@Override
//	public void addItem(String item_id, String item_name, int quantity) {
//		ShoppingCart shoppingCart =new ShoppingCart();
//		shoppingCart.setItem_id(item_id);
//		shoppingCart.setItem_name(item_name);
//		shoppingCart.setQuantity(quantity);
//		shoppingCart.setCreateTime(new Date());
//		shoppingCart.setModifiedTime(shoppingCart.getCreateTime());
//		shoppingCartMongo.addItem(shoppingCart);
//	}

	@Override
	public void deleteItem(int item_id, int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShoppingCart> getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getOneItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		shoppingCart.setCreateTime(new Date());
		shoppingCart.setModifiedTime(shoppingCart.getCreateTime());
		shoppingCartMongo.addItem(shoppingCart);
	}
	
}
