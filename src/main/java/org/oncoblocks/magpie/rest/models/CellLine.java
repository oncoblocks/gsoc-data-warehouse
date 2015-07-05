package org.oncoblocks.magpie.rest.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "subject")
public class CellLine extends Subject {

    private String cellLineSourceName;
    private List<String> cellLineAliases;
    private String cellLinePrimarySite;
    private String cellLineHistology;

    public String getCellLineSourceName() {
        return cellLineSourceName;
    }

    public void setCellLineSourceName(String cellLineSourceName) {
        this.cellLineSourceName = cellLineSourceName;
    }

    public List<String> getCellLineAliases() {
        return cellLineAliases;
    }

    public void setCellLineAliases(List<String> cellLineAliases) {
        this.cellLineAliases = cellLineAliases;
    }

    public String getCellLinePrimarySite() {
        return cellLinePrimarySite;
    }

    public void setCellLinePrimarySite(String cellLinePrimarySite) {
        this.cellLinePrimarySite = cellLinePrimarySite;
    }

    public String getCellLineHistology() {
        return cellLineHistology;
    }

    public void setCellLineHistology(String cellLineHistology) {
        this.cellLineHistology = cellLineHistology;
    }

}
