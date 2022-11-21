package com.example.demoMongo.repsitory;

import com.example.demoMongo.document.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonDocument, Long> {

}
