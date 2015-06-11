package org.oncoblocks.magpie.rest.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.data.annotation.Id;

public class Subject {

    // Common attributes
    @Id
    private String subjectId;

    private String gender;
    private ArrayList< HashMap<String, String> > attributes;

    // Cell line-specific attributes
    private String cellLineSourceName;
    private ArrayList<String> cellLineAliases;
    private String cellLinePrimarySite;
    private String CellLineHistology;

    // Patient-specific attributes


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<HashMap<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<HashMap<String, String>> attributes) {
        this.attributes = attributes;
    }

    public String getCellLineSourceName() {
        return cellLineSourceName;
    }

    public void setCellLineSourceName(String cellLineSourceName) {
        this.cellLineSourceName = cellLineSourceName;
    }

    public ArrayList<String> getCellLineAliases() {
        return cellLineAliases;
    }

    public void setCellLineAliases(ArrayList<String> cellLineAliases) {
        this.cellLineAliases = cellLineAliases;
    }

    public String getCellLinePrimarySite() {
        return cellLinePrimarySite;
    }

    public void setCellLinePrimarySite(String cellLinePrimarySite) {
        this.cellLinePrimarySite = cellLinePrimarySite;
    }

    public String getCellLineHistology() {
        return CellLineHistology;
    }

    public void setCellLineHistology(String cellLineHistology) {
        CellLineHistology = cellLineHistology;
    }

}
