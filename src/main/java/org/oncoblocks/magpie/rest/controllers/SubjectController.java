package org.oncoblocks.magpie.rest.controllers;

import org.oncoblocks.magpie.rest.models.Subject;
import org.oncoblocks.magpie.rest.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Subject> find(
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "cellLinePrimarySite", required = false) String cellLinePrimarySite,
            @RequestParam(value = "cellLineHistology", required = false) String cellLineHistology,
            @RequestParam(value = "fields", required = false) String fields
            ) {
                try {
                    HashMap<String, String> param = new HashMap<>();
                    param.put("gender", gender);
                    param.put("cellLinePrimarySite", cellLinePrimarySite);
                    param.put("cellLineHistology", cellLineHistology);
                    param.put("fields", fields);

                    return subjectService.find(param);
                }
                catch (Exception e) {
                    return new ArrayList<Subject>();
                }
    }
}
