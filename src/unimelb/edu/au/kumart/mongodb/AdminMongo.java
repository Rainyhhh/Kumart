package unimelb.edu.au.kumart.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import unimelb.edu.au.kumart.entity.Admin;

@Repository
public class AdminMongo {

	@Autowired
	MongoTemplate mongoTemplate;

	private static String ADMIN_COLLECTION = "User";

	public Admin login(String username, String password) {
		Criteria criteria1 = Criteria.where("email").is(username);
		Criteria criteria2 = Criteria.where("password").is(password);
		if (null == criteria1 || null == criteria2)
			return null;
		Query query = new Query();
		query.addCriteria(criteria1);
		query.addCriteria(criteria2);
		Admin admin = this.mongoTemplate.findOne(query, Admin.class,
				ADMIN_COLLECTION);
		return admin;

	}
}
