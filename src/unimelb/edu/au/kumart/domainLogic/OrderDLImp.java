package unimelb.edu.au.kumart.domainLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.Item;
import unimelb.edu.au.kumart.entity.Order;
import unimelb.edu.au.kumart.entity.OrderItem;
import unimelb.edu.au.kumart.entity.ShoppingCart;
import unimelb.edu.au.kumart.mongodb.CustomerMongo;
import unimelb.edu.au.kumart.mongodb.ItemMongo;
import unimelb.edu.au.kumart.mongodb.OrderMongo;

@Service
public class OrderDLImp implements OrderDL{
	
	@Autowired
	OrderMongo orderMongo = new OrderMongo();
	
	@Autowired
	CustomerMongo customerMongo = new CustomerMongo();
	
	@Autowired
	ItemMongo itemMongo = new ItemMongo();

	@Override
	public boolean generateOrder(String username) {
		// TODO Auto-generated method stub
		Customer customer = customerMongo.getCustomer(username);
		for(int i = 0; i < customer.getShoppingCarts().size(); i ++) {
			int needs = customer.getShoppingCarts().get(i).getQuantity();
			String item_id = customer.getShoppingCarts().get(i).getItem_id();
			int quantity = itemMongo.getOneItem(item_id).getNumber();
			if(needs > quantity) return false;
		}
		Order order = new Order();
		for(int i = 0; i < customer.getShoppingCarts().size(); i ++) {
			int needs = customer.getShoppingCarts().get(i).getQuantity();
			String item_id = customer.getShoppingCarts().get(i).getItem_id();
			Item item = itemMongo.getOneItem(item_id);
			item.setNumber(item.getNumber() - needs);
			itemMongo.updateItem(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem_id(item_id);
			orderItem.setItem_name(item.getName());
			orderItem.setPrice(item.getPrice());
			orderItem.setQuantity(needs);
			order.getItemList().add(orderItem);
		}
		order.setUser(username);
		order.setState(0);
		order.setCreateTime(new Date());
		order.setModifiedTime(order.getCreateTime());
		orderMongo.generateOrder(order);
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		customer.setShoppingCarts(list);
		customerMongo.updateCustomer(customer);
		return true;
	}

	@Override
	public void applyCancellation(String order_id) {
		// TODO Auto-generated method stub
		orderMongo.updateOrderState(order_id, 1);
	}

	@Override
	public void handleCancellation(String order_id) {
		// TODO Auto-generated method stub
		orderMongo.updateOrderState(order_id, 2);
	}

	@Override
	public void deleteOrder(String order_id) {
		// TODO Auto-generated method stub
		orderMongo.deleteOrder(order_id);
	}

	@Override
	public List<Order> getOrderList(String user_id) {
		// TODO Auto-generated method stub
		List<Order> list = orderMongo.getOrderList("user_id", user_id);
		return list;
	}

	@Override
	public List<Order> getWaitToCancelOrders() {
		// TODO Auto-generated method stub
		List<Order> list = orderMongo.getOrderList("state", "1");
		return list;
	}

}
