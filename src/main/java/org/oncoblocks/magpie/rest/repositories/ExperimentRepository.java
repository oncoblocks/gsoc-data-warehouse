package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.Experiment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {
}
