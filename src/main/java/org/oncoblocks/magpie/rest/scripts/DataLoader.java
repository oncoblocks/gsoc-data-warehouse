package org.oncoblocks.magpie.rest.scripts;

import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.service.CopyNumberGeneCentricService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    private CopyNumberGeneCentricService getCopyNumberGeneCentricService(){
        return new CopyNumberGeneCentricService();
    }

    private static final Log log = LogFactory.getLog(DataLoader.class);

    public void loadCnvData() throws Exception{

        MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "magpie_test_1"));

        mongoTemplate.dropCollection("cnv_gene_centric");

        CopyNumberGeneCentric cnv = new CopyNumberGeneCentric();

        cnv.setEntrezGeneId(1);
        cnv.setSampleId("LOUNH91_LUNG");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0259);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(1);
        cnv.setSampleId("T98G_CENTRAL_NERVOUS_SYSTEM");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.1514);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(10);
        cnv.setSampleId("LOUNH91_LUNG");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0325);

        mongoTemplate.insert(cnv, "cnv_gene_centric");

        log.info("Insert: " + cnv);

        cnv.setEntrezGeneId(10);
        cnv.setSampleId("T98G_CENTRAL_NERVOUS_SYSTEM");
        cnv.setExperimentId("CCLE");
        cnv.setCopyNumberValue(-0.0742);

        //mongoTemplate.insert(cnv, "cnv_gene_centric");

        this.getCopyNumberGeneCentricService().save(cnv);

        log.info("Insert: " + cnv);
    }
}
