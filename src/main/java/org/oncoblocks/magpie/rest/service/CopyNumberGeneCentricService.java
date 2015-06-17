package org.oncoblocks.magpie.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.oncoblocks.magpie.rest.repositories.CopyNumberGeneCentricRepository;
import org.oncoblocks.magpie.rest.repositories.CopyNumberGeneCentricRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CopyNumberGeneCentricService {

    private static final Log log = LogFactory.getLog(CopyNumberGeneCentricService.class);

    @Autowired
    private CopyNumberGeneCentricRepository copyNumberGeneCentricRepository;
    @Autowired
    private CopyNumberGeneCentricRepositoryImpl copyNumberGeneCentricRepositoryImpl;

    public Iterable<CopyNumberGeneCentric> findAll(){
        return copyNumberGeneCentricRepository.findAll();
    }

    public List<CopyNumberGeneCentric> findByGeneId(Integer geneId) throws Exception{
        return copyNumberGeneCentricRepositoryImpl.findByGeneId(geneId);
    }

    public CopyNumberGeneCentric save(CopyNumberGeneCentric copyNumberGeneCentric){
        log.debug("Trying to save " + copyNumberGeneCentric);
        copyNumberGeneCentricRepository.insert(copyNumberGeneCentric);
        return copyNumberGeneCentric;
    }

}
