package org.oncoblocks.magpie.rest.controllers;

import java.util.HashMap;
import java.util.List;

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
    public ResponseEntity<Iterable<CopyNumberGeneCentric>> findAll(){
        HttpHeaders responseHeaders = new HttpHeaders();
        try{
            Iterable<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.findAll();
            return new ResponseEntity<>(queryResult, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            responseHeaders.set("Error message", e.getMessage());
            return new ResponseEntity<>(responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/viewpage", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Page<CopyNumberGeneCentric>> findPage
            (@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
             @RequestParam(value = "sort", required = false) List<String> sortList){

        HttpHeaders responseHeaders = new HttpHeaders();
        try{
            Page<CopyNumberGeneCentric> resultPage = copyNumberGeneCentricService.findPage(Url.parsePageRequest(page, size, sortList));
            return new ResponseEntity<>(resultPage, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            responseHeaders.set("Error message", e.getMessage());
            return new ResponseEntity<>(responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/geneId/{geneId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<List<CopyNumberGeneCentric>> findCopyNumberGeneCentricByGeneId(@PathVariable("geneId") Integer geneId){
        HttpHeaders responseHeaders = new HttpHeaders();
        try{
            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.findByGeneId(geneId);
            return new ResponseEntity<>(queryResult, responseHeaders, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            responseHeaders.set("Error message", e.getMessage());
            return new ResponseEntity<>(responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/sampleId/{sampleId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<List<CopyNumberGeneCentric>> findCopyNumberGeneCentricBySampleId(@PathVariable("sampleId") String sampleId){
        HttpHeaders responseHeaders = new HttpHeaders();
        try{
            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.findBySampleId(sampleId);
            return new ResponseEntity<>(queryResult, responseHeaders, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            responseHeaders.set("Error message", e.getMessage());
            return new ResponseEntity<>(responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity< List<CopyNumberGeneCentric> > findCopyNumberGeneCentric(
            @RequestParam(value = "geneId", required = false) Integer geneId,
            @RequestParam(value = "sampleId", required = false) String sampleId,
            @RequestParam(value = "fields", required = false) String fields

    ){
        HttpHeaders responseHeaders = new HttpHeaders();
        try{
            HashMap<String, String> param = new HashMap<>();
            if (geneId != null) {
                String geneIdString = Integer.toString(geneId);
                param.put("geneId", geneIdString);
            }
            param.put("sampleId", sampleId);
            param.put("fields", fields);

            List<CopyNumberGeneCentric> queryResult = copyNumberGeneCentricService.find(param);
            return new ResponseEntity<>(queryResult,
                    responseHeaders, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            responseHeaders.set("Error message", e.getMessage());
            return new ResponseEntity<>(responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }

}

