package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.Study;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudyRepository extends MongoRepository<Study, String> {
}
