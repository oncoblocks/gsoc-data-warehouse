package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SampleRepository extends MongoRepository<Sample, String> {
    List<Sample> findByCellLineOriginIgnoreCase(String cellLineOrigin);
}
