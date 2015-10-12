package unimelb.edu.au.kumart.mongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.NEW;

import unimelb.edu.au.kumart.entity.Order;

@Repository
public class OrderMongo {

	@Autowired
	MongoTemplate mongoTemplate;

	// Collection name
	private static String ORDER_COLLECTION = "Order";
	
	/**
	 * 
	 * @param order
	 */
	public void generateOrder(Order order) {
		 mongoTemplate.insert(order, ORDER_COLLECTION);
	}
	
	/**
	 * 
	 * @param order
	 */
	public void deleteOrder(String order_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("order_id").is(order_id));
		mongoTemplate.findAndRemove(query, Order.class, ORDER_COLLECTION);
	}
	
	/**
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Order> getOrderList(String type, String value) {
		Query query = new Query(Criteria.where(type).is(value));
		if(type.equals("user")) {
			query.with(new Sort(Direction.DESC, "modifiedTime"));
		}
		else if(type.equals("state")) {
			query.with(new Sort(Direction.ASC, "modifiedTime"));
		}
		List<Order> list = new ArrayList<Order>();
		list = mongoTemplate.find(query, Order.class, ORDER_COLLECTION);
		return list;
	}
	
	/**
	 * 
	 * @param order_id
	 * @return
	 */
	public Order getOneOrder(String order_id) {
		Order order = mongoTemplate.findById(order_id, Order.class, ORDER_COLLECTION);
		return order;
	}
	
	/**
	 * 
	 * @param order_id
	 * @param state
	 * @return
	 */
	public boolean updateOrderState(String order_id, int state) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(order_id));		
		Update update = new Update();
		update.set("state", state);	
		update.set("modifiedTime", new Date());
		mongoTemplate.updateFirst(query, update, Order.class, ORDER_COLLECTION);
		return true;
	}
	
	
}
