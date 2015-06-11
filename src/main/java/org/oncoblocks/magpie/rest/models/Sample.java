package org.oncoblocks.magpie.rest.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.data.annotation.Id;

public class Sample {

    @Id
    private String sampleId;

    private String subjectId;
    private String cellLineOrigin;
    private ArrayList< HashMap<String, String> > attributes;

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getCellLineOrigin() {
        return cellLineOrigin;
    }

    public void setCellLineOrigin(String cellLineOrigin) {
        this.cellLineOrigin = cellLineOrigin;
    }

    public ArrayList<HashMap<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<HashMap<String, String>> attributes) {
        this.attributes = attributes;
    }

}
