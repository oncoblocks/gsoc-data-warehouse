package org.oncoblocks.magpie.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;



import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.oncoblocks.magpie.rest.service.CopyNumberGeneCentricService;

@RestController
@RequestMapping("/copynumbergenecentric")
public class CopyNumberGeneCentricController {

    @Autowired
    private CopyNumberGeneCentricService copyNumberGeneCentricService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public Iterable<CopyNumberGeneCentric> findAll(){

        try{
            return copyNumberGeneCentricService.findAll();
        }
        catch(Exception e){
            return new ArrayList<CopyNumberGeneCentric>();
        }
    }

    @RequestMapping(value="/geneId/{geneId}", method = RequestMethod.GET)
    public List<CopyNumberGeneCentric> findCopyNumberGeneCentricByGeneId(@PathVariable("geneId") Integer geneId){
        try{
            return copyNumberGeneCentricService.findByGeneId(geneId);
        }
        catch(Exception e){
            return new ArrayList<CopyNumberGeneCentric>();
        }
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<CopyNumberGeneCentric> find(
            @RequestParam(value = "geneId", required = false) Integer geneId,
            @RequestParam(value = "sampleId", required = false) String sampleId
    ){
        try{
            HashMap<String, String> param = new HashMap<>();
            String geneIdString = Integer.toString(geneId);
            param.put("geneId", geneIdString);
            param.put("sampleId", sampleId);

            return copyNumberGeneCentricService.find(param);
        }
        catch(Exception e){
            return new ArrayList<CopyNumberGeneCentric>();
        }
    }
}

