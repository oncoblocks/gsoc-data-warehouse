package org.oncoblocks.magpie.rest.models;

/**
 * Created by tewei on 5/31/15.
 */
public class CopyNumberGeneCentric {
    private Integer entrezGeneId;
    private String geneSymbol;
    private Integer chromosome;
    private Integer chromosomeStartPosition;
    private Integer chromosomeEndPosition;
    // The following variables are normalized copy number signals
    // Variable names follow CCLE nomenclature
    private Float LOUNH91_LUNG;
    private Float T98G_CENTRAL_NERVOUS_SYSTEM;
    private Float IPC298_SKIN;

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

    public Integer getChromosome() {
        return chromosome;
    }

    public void setChromosome(Integer chromosome) {
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

    public Float getLOUNH91_LUNG() {
        return LOUNH91_LUNG;
    }

    public void setLOUNH91_LUNG(Float LOUNH91_LUNG) {
        this.LOUNH91_LUNG = LOUNH91_LUNG;
    }

    public Float getT98G_CENTRAL_NERVOUS_SYSTEM() {
        return T98G_CENTRAL_NERVOUS_SYSTEM;
    }

    public void setT98G_CENTRAL_NERVOUS_SYSTEM(Float t98G_CENTRAL_NERVOUS_SYSTEM) {
        T98G_CENTRAL_NERVOUS_SYSTEM = t98G_CENTRAL_NERVOUS_SYSTEM;
    }

    public Float getIPC298_SKIN() {
        return IPC298_SKIN;
    }

    public void setIPC298_SKIN(Float IPC298_SKIN) {
        this.IPC298_SKIN = IPC298_SKIN;
    }



}
