package io.ashwinikb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<URLData, Long> {

	URLData findFirstByHash(String hash);	
}
