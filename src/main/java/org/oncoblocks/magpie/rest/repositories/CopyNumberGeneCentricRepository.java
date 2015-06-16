package org.oncoblocks.magpie.rest.repositories;

import org.bson.types.ObjectId;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface CopyNumberGeneCentricRepository extends PagingAndSortingRepository<CopyNumberGeneCentric, ObjectId>, CopyNumberGeneCentricRepositoryCustom {
}
