package org.oncoblocks.magpie.rest.repositories;

import org.bson.types.ObjectId;
import org.oncoblocks.magpie.rest.models.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleRepository extends MongoRepository<Sample, ObjectId> {
}
