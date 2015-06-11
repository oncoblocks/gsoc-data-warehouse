package org.oncoblocks.magpie.rest.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.data.annotation.Id;

public class Experiment {

    @Id
    private String experimentId;

    private String sampleId;
    private String publicFile;
    private ArrayList< HashMap<String, String> > attributes;

}
