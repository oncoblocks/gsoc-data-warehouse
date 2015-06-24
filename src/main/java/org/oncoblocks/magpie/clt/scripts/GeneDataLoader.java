package org.oncoblocks.magpie.clt.scripts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.clt.config.ApplicationConfig;
import org.oncoblocks.magpie.clt.config.CltConfiguration;
import org.oncoblocks.magpie.rest.models.Gene;
import org.oncoblocks.magpie.rest.repositories.GeneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class GeneDataLoader {

    private static final Log log = LogFactory.getLog(GeneDataLoader.class);

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
            ApplicationConfig.class, CltConfiguration.class);
    GeneRepository geneRepository = ctx.getBean(GeneRepository.class);

    public void loadGeneData(File file) throws IOException {

        geneRepository.deleteAll();

        int entrezGeneId;
        int taxId;
        String geneSymbol;
        HashSet<String> geneSynonyms = new HashSet<String>();
        String chromosome;
        String geneType;
        String description;

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int geneCount = 0;
        while(line != null) {
            if( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                entrezGeneId = Integer.parseInt(fields[0]);
                taxId = Integer.parseInt(fields[1]);

                geneSymbol = fields[2];
                if(geneSymbol.equals("-")) {
                    geneSymbol = null;
                }

                if( !( fields[3].equals("-") ) ) {
                    geneSynonyms.addAll( Arrays.asList( fields[3].split("\\|") ) );
                }

                chromosome = fields[4];
                geneType = fields[5];
                description = fields[6];

                // Store this record line into a Gene object and then the database.
                Gene gene = new Gene();
                gene.setEntrezGeneId(entrezGeneId);
                gene.setTaxId(taxId);
                gene.setGeneSymbol(geneSymbol);
                gene.setSynonyms(geneSynonyms);
                gene.setChromosome(chromosome);
                gene.setGeneType(geneType);
                gene.setDescription(description);

                geneRepository.insert(gene);
                ++geneCount;
            }
            line = buf.readLine();
        }
        log.info("Loaded " + geneCount + " genes.");
        log.info(geneRepository.count() + " gene records are found in the database.");
    }

    public static void main(String args[]) throws Exception{
        File file = new File(args[0]);
        GeneDataLoader geneDataLoader = new GeneDataLoader();
        geneDataLoader.loadGeneData(file);
    }
}
