package org.oncoblocks.magpie.rest.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cnv_gene_centric")
public class CopyNumberGeneCentric {
    private Integer entrezGeneId;
    private String sampleId;
    private String experimentId;
    private Float copyNumberValue;
    // The following variables are normalized copy number signals
    // Variable names follow CCLE nomenclature


    public Integer getEntrezGeneId() {
        return entrezGeneId;
    }

    public void setEntrezGeneId(Integer entrezGeneId) {
        this.entrezGeneId = entrezGeneId;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public Float getCopyNumberValue() {
        return copyNumberValue;
    }

    public void setCopyNumberValue(Float copyNumberValue) {
        this.copyNumberValue = copyNumberValue;
    }

    @Override
    public String toString(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
