package org.oncoblocks.magpie.rest.service;

import org.oncoblocks.magpie.rest.models.Sample;
import org.oncoblocks.magpie.rest.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public List<Sample> findByCellLineOriginIgnoreCase(String cellLineOrigin) throws Exception{
        return sampleRepository.findByCellLineOriginIgnoreCase(cellLineOrigin);
    }

    public Sample findById(String sampleId) throws Exception {
        return sampleRepository.findOne(sampleId);
    }
}
