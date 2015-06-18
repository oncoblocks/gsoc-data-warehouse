package org.oncoblocks.magpie.rest.repositories;


import org.bson.types.ObjectId;
import org.oncoblocks.magpie.rest.models.Gene;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneRepository extends MongoRepository<Gene, ObjectId> {
}
