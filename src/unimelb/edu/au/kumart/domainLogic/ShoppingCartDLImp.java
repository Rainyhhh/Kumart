package unimelb.edu.au.kumart.domainLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.javafx.binding.StringFormatter;

import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.ShoppingCart;
import unimelb.edu.au.kumart.mongodb.CustomerMongo;
import unimelb.edu.au.kumart.mongodb.ShoppingCartMongo;

@Service
public class ShoppingCartDLImp implements ShoppingCartDL {
	@Autowired
	ShoppingCartMongo shoppingCartMongo;
	@Autowired
	CustomerMongo customerMongo;

	@Override
	public void deleteItem(int item_id, int user_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItem(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShoppingCart> getShoppingCart(String username) {
		// TODO Auto-generated method stub
		Customer customer = customerMongo.getCustomer(username);
		List<ShoppingCart> shoppingCarts = customer.getShoppingCarts();
		return shoppingCarts;
	}

	@Override
	public ShoppingCart getOneItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(String username, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		Customer customer = customerMongo.getCustomer(username);
		try {
			List<ShoppingCart> shoppingCarts = customer.getShoppingCarts();
			for (int i = 0; i < shoppingCarts.size(); i++) {
				if (shoppingCarts.get(i).getItem_id()
						.equals(shoppingCart.getItem_id())) {
					int quantity = shoppingCarts.get(i).getQuantity()
							+ shoppingCart.getQuantity();
					shoppingCarts.get(i).setQuantity(quantity);
					shoppingCarts.get(i).setModifiedTime(new Date());
					customerMongo.updateCustomer(customer);
					return;
				}
			}
			System.out.println(customer.getRole());
			shoppingCart.setUsername(username);
			shoppingCart.setCreateTime(new Date());
			shoppingCart.setModifiedTime(shoppingCart.getCreateTime());
			customer.getShoppingCarts().add(shoppingCart);
			customerMongo.updateCustomer(customer);
		} catch (NullPointerException e) {
			shoppingCart.setUsername(username);
			shoppingCart.setCreateTime(new Date());
			shoppingCart.setModifiedTime(shoppingCart.getCreateTime());
			customer.getShoppingCarts().add(shoppingCart);
			customerMongo.updateCustomer(customer);
			//shoppingCartMongo.addItem(shoppingCart);
		}
	}

}
