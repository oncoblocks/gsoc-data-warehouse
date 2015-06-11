package org.oncoblocks.magpie.rest.scripts;

import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;

public class LoadCnvData {
    private static final Log log = LogFactory.getLog(LoadCnvData.class);

    public static void main(String[] args) throws Exception{

        MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "magpie_test_1"));

        mongoTemplate.dropCollection("cnv_gene_centric");

        CopyNumberGeneCentric cnv = new CopyNumberGeneCentric();
        cnv.setEntrezGeneId(1);
        cnv.setGeneSymbol("A1BG");
        cnv.setChromosome("19");
        cnv.setChromosomeStartPosition(58858172);
        cnv.setChromosomeEndPosition(58864865);
        cnv.setSampleId("LOUNH91_LUNG");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0259);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(1);
        cnv.setGeneSymbol("A1BG");
        cnv.setChromosome("19");
        cnv.setChromosomeStartPosition(58858172);
        cnv.setChromosomeEndPosition(58864865);
        cnv.setSampleId("T98G_CENTRAL_NERVOUS_SYSTEM");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.1514);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(10);
        cnv.setGeneSymbol("NAT2");
        cnv.setChromosome("8");
        cnv.setChromosomeStartPosition(18248755);
        cnv.setChromosomeEndPosition(18258723);
        cnv.setSampleId("LOUNH91_LUNG");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0325);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(10);
        cnv.setGeneSymbol("NAT2");
        cnv.setChromosome("8");
        cnv.setChromosomeStartPosition(18248755);
        cnv.setChromosomeEndPosition(18258723);
        cnv.setSampleId("T98G_CENTRAL_NERVOUS_SYSTEM");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0742);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

    }
}
