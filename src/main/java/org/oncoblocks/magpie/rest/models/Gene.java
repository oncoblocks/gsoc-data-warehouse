package org.oncoblocks.magpie.rest.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.data.annotation.Id;


public class Gene {

    @Id
    private Integer entrezGeneId;

    private Integer taxId;
    private String geneSymbol;
    private ArrayList<String> synonyms;
    private String chromosome;
    private String geneType;
    private ArrayList< HashMap<String, String> > attributes;

    public Integer getEntrezGeneId() {
        return entrezGeneId;
    }

    public void setEntrezGeneId(Integer entrezGeneId) {
        this.entrezGeneId = entrezGeneId;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<String> synonyms) {
        this.synonyms = synonyms;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public String getGeneType() {
        return geneType;
    }

    public void setGeneType(String geneType) {
        this.geneType = geneType;
    }

    public ArrayList<HashMap<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<HashMap<String, String>> attributes) {
        this.attributes = attributes;
    }

}
