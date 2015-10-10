package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.Order;
import unimelb.edu.au.kumart.mongodb.OrderMongo;

@Service
public class OrderDLImp implements OrderDL{
	
	@Autowired
	OrderMongo orderMongo = new OrderMongo();

	@Override
	public void generateOrder(Order order) {
		// TODO Auto-generated method stub
		
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
