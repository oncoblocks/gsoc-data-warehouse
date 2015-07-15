package org.oncoblocks.magpie.rest.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Log log = LogFactory.getLog(CopyNumberGeneCentricController.class);

    @Autowired
    private CopyNumberGeneCentricService copyNumberGeneCentricService;

    @RequestMapping(value="/all", method = {RequestMethod.GET, RequestMethod.HEAD})
    public Iterable<CopyNumberGeneCentric> findAll(){

        try{
            return copyNumberGeneCentricService.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @RequestMapping(value="/viewpage", method = {RequestMethod.GET, RequestMethod.HEAD})
    public Page<CopyNumberGeneCentric> findPage
            (@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
             @RequestParam(value = "sort", required = false) List<String> sortList){
        try{

            return copyNumberGeneCentricService.findPage(Url.parsePageRequest(page, size, sortList));
        }
        catch(Exception e){
            e.printStackTrace();
            return new PageImpl<>(new ArrayList<CopyNumberGeneCentric>());
        }
    }

    @RequestMapping(value="/geneId/{geneId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<List<CopyNumberGeneCentric>> findCopyNumberGeneCentricByGeneId(@PathVariable("geneId") Integer geneId){
        try{
            long startTime = System.nanoTime();
            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.findByGeneId(geneId);
            long endTime = System.nanoTime();
            long execTime_nano = endTime - startTime;
            log.info("findCopyNumberGeneCentricByGeneId() query finished; execution time: " +
                    TimeUnit.NANOSECONDS.toSeconds(execTime_nano) + "s" + "("  + execTime_nano + "ns)");
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set( "Query time", Long.toString(execTime_nano*1000) + "ms" );
            return new ResponseEntity<List<CopyNumberGeneCentric>>(queryResult,
                    responseHeaders, HttpStatus.OK);        }
        catch(Exception e){
            return null;
        }
    }

    @RequestMapping(value="/sampleId/{sampleId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public List<CopyNumberGeneCentric> findCopyNumberGeneCentricBySampleId(@PathVariable("sampleId") String sampleId){
        try{
            long startTime = System.nanoTime();
            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.findBySampleId(sampleId);
            long endTime = System.nanoTime();
            long execTime_nano = endTime - startTime;
            log.info("findCopyNumberGeneCentricBySampleId() query finished; execution time: " +
                    TimeUnit.NANOSECONDS.toSeconds(execTime_nano) + "s" + "("  + execTime_nano + "ns)");

            return queryResult;
        }
        catch(Exception e){
            return new ArrayList<CopyNumberGeneCentric>();
        }
    }

    @RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity< List<CopyNumberGeneCentric> > findCopyNumberGeneCentric(
            @RequestParam(value = "geneId", required = false) Integer geneId,
            @RequestParam(value = "sampleId", required = false) String sampleId,
            @RequestParam(value = "fields", required = false) String fields

    ){
        try{
            long startTime = System.nanoTime();
            HashMap<String, String> param = new HashMap<>();
            if (geneId != null) {
                String geneIdString = Integer.toString(geneId);
                param.put("geneId", geneIdString);
            }
            param.put("sampleId", sampleId);
            param.put("fields", fields);

            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.find(param);
            long endTime = System.nanoTime();
            long execTime_nano = endTime - startTime;
            log.info("findCopyNumberGeneCentric() query finished; execution time: " +
                    TimeUnit.NANOSECONDS.toSeconds(execTime_nano) + "s" + "("  + execTime_nano + "ns)");

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set( "Query time", Long.toString(execTime_nano/1000000) + "ms" );
            return new ResponseEntity<List<CopyNumberGeneCentric>>(queryResult,
                    responseHeaders, HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Exception caught: " + e.getMessage());
            return null;
        }
    }

}

