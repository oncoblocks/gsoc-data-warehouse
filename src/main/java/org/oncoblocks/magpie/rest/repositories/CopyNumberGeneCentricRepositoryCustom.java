package org.oncoblocks.magpie.rest.repositories;

import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;

import java.util.List;

public interface CopyNumberGeneCentricRepositoryCustom {
    List<CopyNumberGeneCentric> findByGeneId(Integer geneId) throws Exception;
}
