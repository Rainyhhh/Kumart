package unimelb.edu.au.kumart.domainLogic;

import java.util.List;

import unimelb.edu.au.kumart.entity.Order;

public interface OrderDL {

	public boolean generateOrder(String user_id);
	
	public void applyCancellation(String order_id);
	
	public void handleCancellation(String order_id);
	
	public void deleteOrder(String order_id);
	
	public List<Order> getOrderList(String user_id);
	
	public List<Order> getWaitToCancelOrders();
}
