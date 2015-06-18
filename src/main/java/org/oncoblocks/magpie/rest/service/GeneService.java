package org.oncoblocks.magpie.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.repositories.GeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneService {

    private static final Log log = LogFactory.getLog(GeneService.class);

    @Autowired
    private GeneRepository geneRepository;


}
