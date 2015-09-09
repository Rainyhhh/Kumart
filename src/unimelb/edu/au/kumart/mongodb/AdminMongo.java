package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.User;






@Repository
public class AdminMongo {

	@Autowired
	MongoTemplate mongoTemplate;

	private static String ADMIN_COLLECTION = "User";
	
	public boolean login(String username, String password) {
		Criteria criteria1 = Criteria.where("email").is(username);
		Criteria criteria2 = Criteria.where("password").is(password);
		if(null == criteria1 || null == criteria2) return false;
		System.out.println(1);
		Query query = new Query();
		query.addCriteria(criteria1);
		query.addCriteria(criteria2);
		User admin = this.mongoTemplate.findOne(query, User.class, ADMIN_COLLECTION);
		if(admin != null) return true;
		return false;
	}
}
