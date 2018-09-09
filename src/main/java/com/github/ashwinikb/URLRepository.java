package com.github.ashwinikb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * URL Repository to work with mongo
 */
public interface URLRepository extends MongoRepository<URLData, Long> {

	URLData findFirstByHash(String hash);
}
