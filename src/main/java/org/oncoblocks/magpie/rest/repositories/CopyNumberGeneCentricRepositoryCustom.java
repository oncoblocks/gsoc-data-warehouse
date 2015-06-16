package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CopyNumberGeneCentricRepositoryCustom {
    List<CopyNumberGeneCentric> findByGeneId(Integer geneId) throws Exception;
}
