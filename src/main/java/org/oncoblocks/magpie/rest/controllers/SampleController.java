package org.oncoblocks.magpie.rest.controllers;


import org.oncoblocks.magpie.rest.models.Sample;
import org.oncoblocks.magpie.rest.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Sample> findByCellLineOrigin(@RequestParam(value = "cellLineOrigin") String cellLineOrigin)  {
        try {
            return sampleService.findByCellLineOriginIgnoreCase(cellLineOrigin);
        }
        catch (Exception e) {
            return new ArrayList<Sample>();
        }
    }

    @RequestMapping(value="/sampleId/{sampleId}", method = RequestMethod.GET)
    public Sample findById(@PathVariable("sampleId") String sampleId) {
        try {
            return sampleService.findById(sampleId);
        }
        catch (Exception e) {
            return new Sample();
        }
    }

}
