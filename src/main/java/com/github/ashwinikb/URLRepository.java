package com.github.ashwinikb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ashwini KB
 */

public interface URLRepository extends MongoRepository<URLData, Long> {

	URLData findFirstByHash(String hash);
}
