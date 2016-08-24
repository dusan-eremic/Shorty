package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Url;

/**
 * Access to MongoDB URL repository
 * 
 * @author Dusan Eremic
 *
 */
public interface UrlsRepository extends MongoRepository<Url, String> {

}
