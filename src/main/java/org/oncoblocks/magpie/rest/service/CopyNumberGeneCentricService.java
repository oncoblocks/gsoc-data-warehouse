package org.oncoblocks.magpie.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.oncoblocks.magpie.rest.repositories.CopyNumberGeneCentricRepository;
import org.oncoblocks.magpie.rest.repositories.CopyNumberGeneCentricRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    public List<CopyNumberGeneCentric> findByGeneId(Integer geneId) throws Exception {
        return copyNumberGeneCentricRepository.findByEntrezGeneId(geneId);
    }

    public List<CopyNumberGeneCentric> findBySampleId(String sampleId) throws Exception {
        return copyNumberGeneCentricRepository.findBySampleId(sampleId);
    }

    public CopyNumberGeneCentric save(CopyNumberGeneCentric copyNumberGeneCentric) {
        copyNumberGeneCentricRepository.insert(copyNumberGeneCentric);
        return copyNumberGeneCentric;
    }

    public List<CopyNumberGeneCentric> find(HashMap<String, String> param, List<String> sortList) throws Exception {
        return copyNumberGeneCentricRepositoryImpl.find(param, sortList);
    }

    public Page<CopyNumberGeneCentric> findPage(Pageable pageable) throws Exception {
        return copyNumberGeneCentricRepository.findAll(pageable);
    }
}
