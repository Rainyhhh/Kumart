package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.User;

@Repository
public class CustomerMongo {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static String CUSTOMER_COLLECTION = "User";
	
	/**
	 * check if the username and password pair is exist in the databse
	 * @param username
	 * @param password
	 * @return an Customer object or null
	 */
	public Customer getOneCustomer(String username, String password) {
		Criteria criteria1 = Criteria.where("email").is(username);
		Criteria criteria2 = Criteria.where("password").is(password);
		if (null == criteria1 || null == criteria2)
			return null;
		Query query = new Query();
		query.addCriteria(criteria1);
		query.addCriteria(criteria2);
		Customer user = this.mongoTemplate.findOne(query, Customer.class,
				CUSTOMER_COLLECTION);
		return user;

	}
	
	public Customer getCustomer(String username) {
		Query query = new Query();
		Criteria criteria = Criteria.where("email").is(username);
		query.addCriteria(criteria);
		Customer customer = (Customer) mongoTemplate.findOne(query, User.class, CUSTOMER_COLLECTION);
		return customer;
	}
	
	/**
	 * Add a new customer into the database
	 * @param customer
	 */
	public void newCustomer(User customer) {
		mongoTemplate.insert(customer, CUSTOMER_COLLECTION);
	}
	
	public boolean getOneCustomer(String username) {
		Criteria criteria = Criteria.where("email").is(username);
		Query query = new Query();
		query.addCriteria(criteria);
		Customer customer = this.mongoTemplate.findOne(query, Customer.class, CUSTOMER_COLLECTION);
		if(customer != null)
			return true;
		return false;
	}
	
	public void updateCustomer(Customer customer) {
		mongoTemplate.save(customer, CUSTOMER_COLLECTION);
		
	}
}
