package org.oncoblocks.magpie.rest.repositories;

import org.bson.types.ObjectId;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CopyNumberGeneCentricRepository extends
		MongoRepository<CopyNumberGeneCentric, ObjectId>, CopyNumberGeneCentricRepositoryCustom {
	
}
