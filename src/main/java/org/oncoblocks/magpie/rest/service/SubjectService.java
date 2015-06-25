package org.oncoblocks.magpie.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.models.Subject;
import org.oncoblocks.magpie.rest.repositories.SubjectRepository;
import org.oncoblocks.magpie.rest.repositories.SubjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SubjectService {
    private static final Log log = LogFactory.getLog(SubjectService.class);

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectRepositoryImpl subjectRepositoryImpl;

    public List<Subject> find(HashMap<String, String> param) throws Exception {
        return subjectRepositoryImpl.find(param);
    }

}
