package org.oncoblocks.magpie.rest.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CopyNumberGeneCentric {
    private Integer entrezGeneId;
    private String geneSymbol;
    private String chromosome;
    private Integer chromosomeStartPosition;
    private Integer chromosomeEndPosition;
    private String sampleId;
    private String experimentId;
    private Double copyNumberValue;
    // The following variables are normalized copy number signals
    // Variable names follow CCLE nomenclature


    public Integer getEntrezGeneId() {
        return entrezGeneId;
    }

    public void setEntrezGeneId(Integer entrezGeneId) {
        this.entrezGeneId = entrezGeneId;
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public Integer getChromosomeStartPosition() {
        return chromosomeStartPosition;
    }

    public void setChromosomeStartPosition(Integer chromosomeStartPosition) {
        this.chromosomeStartPosition = chromosomeStartPosition;
    }

    public Integer getChromosomeEndPosition() {
        return chromosomeEndPosition;
    }

    public void setChromosomeEndPosition(Integer chromosomeEndPosition) {
        this.chromosomeEndPosition = chromosomeEndPosition;
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

    public Double getCopyNumberValue() {
        return copyNumberValue;
    }

    public void setCopyNumberValue(Double copyNumberValue) {
        this.copyNumberValue = copyNumberValue;
    }

    @Override
    public String toString(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
