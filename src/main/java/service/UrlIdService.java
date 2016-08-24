package service;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import app.model.Counter;

/**
 * URL ID service
 * 
 * @author Dusan Eremic
 *
 */
public class UrlIdService {

	@Autowired
	private MongoOperations mongoOperations;
	private static Hashids hashids = new Hashids("this is my salt");

	public Long getNextId() {

		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is("urlid"));

		final Update update = new Update();
		update.inc("seq", 1);

		// Atomic access
		Counter counter = mongoOperations.findAndModify(query, update, Counter.class, "counters");
		return counter.getSeq();
	}

	public String encodeUrlId(String urlId) {
		return hashids.encode(Long.valueOf(urlId));
	}

	public String decodeUrlId(String urlId) {
		return String.valueOf(hashids.decode(urlId)[0]);
	}
}
