package org.oncoblocks.magpie.rest.repositories;

import org.bson.types.ObjectId;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CopyNumberGeneCentricRepository extends
		MongoRepository<CopyNumberGeneCentric, ObjectId>, CopyNumberGeneCentricRepositoryCustom {
	List<CopyNumberGeneCentric> findByEntrezGeneId(Integer geneId);
	List<CopyNumberGeneCentric> findBySampleId(String sampleId);
	Page<CopyNumberGeneCentric> findAll(Pageable pageable);
}
