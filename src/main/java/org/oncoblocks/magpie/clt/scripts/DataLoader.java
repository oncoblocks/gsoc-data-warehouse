package org.oncoblocks.magpie.clt.scripts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.clt.config.ApplicationConfig;
import org.oncoblocks.magpie.clt.config.CltConfiguration;
import org.oncoblocks.magpie.rest.models.Gene;
import org.oncoblocks.magpie.rest.models.Sample;
import org.oncoblocks.magpie.rest.models.Study;
import org.oncoblocks.magpie.rest.models.Subject;
import org.oncoblocks.magpie.rest.repositories.GeneRepository;
import org.oncoblocks.magpie.rest.repositories.SampleRepository;
import org.oncoblocks.magpie.rest.repositories.StudyRepository;
import org.oncoblocks.magpie.rest.repositories.SubjectRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class DataLoader {

    private static final Log log = LogFactory.getLog(DataLoader.class);

    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
            ApplicationConfig.class, CltConfiguration.class);

//    private StudyRepository studyRepository = ctx.getBean(StudyRepository.class);
//    private GeneRepository geneRepository = ctx.getBean(GeneRepository.class);

    public void loadStudyData(File file) throws IOException {

        StudyRepository studyRepository = this.ctx.getBean(StudyRepository.class);

        if (studyRepository.count() > 0) {
            studyRepository.deleteAll();
        }

        String studyId;
        String description;

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int studyCount = 0;

        while (line != null) {
            if (!line.startsWith("#")) {
                // Parse a line of study record
                String fields[] = line.split("\t");

                studyId = fields[0];
                description = fields[1];

                Study study = new Study();
                study.setStudyId(studyId);
                study.setDescription(description);

                studyRepository.insert(study);
                ++studyCount;
//                log.info("Inserted " + study);
            }
            line = buf.readLine();
        }
        log.info("Loaded " + studyCount + " studies.");
        log.info(studyRepository.count() + " study records are found in the database.");

    }

    public void loadSubjectData(File file) throws IOException {

        SubjectRepository subjectRepository = ctx.getBean(SubjectRepository.class);
        if (subjectRepository.count() > 0) {
            subjectRepository.deleteAll();
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int subjectCount = 0;
        while (line != null) {
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                Subject subject = new Subject();

                subject.setSubjectId(fields[1]);
                subject.setCellLineSourceName(fields[1]);
                subject.setGender(fields[2]);
                subject.setCellLinePrimarySite(fields[3]);
                subject.setCellLineHistology(fields[4]);

                subjectRepository.insert(subject);
                ++subjectCount;
            }
            line = buf.readLine();
        }
        log.info("Loaded " + subjectCount + " subjects.");
        log.info(subjectRepository.count() + " subjects records are found in the database.");
    }

    public void loadSampleData(File file) throws IOException {

        SampleRepository sampleRepository = ctx.getBean(SampleRepository.class);
        if (sampleRepository.count() > 0) {
            sampleRepository.deleteAll();
        }


        String cellLineOrigin;

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int sampleCount = 0;
        while (line != null) {
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                Sample sample = new Sample();
                sample.setSampleId(fields[0]);
                sample.setSubjectId(fields[1]);
                if (fields.length == 3) {
                    cellLineOrigin = fields[2];
                }
                else {
                    cellLineOrigin = "N/A";
                }
                sample.setCellLineOrigin(cellLineOrigin);

                sampleRepository.insert(sample);
                ++sampleCount;
                log.info("Inserted " + sample);

            }
            line = buf.readLine();
        }
        log.info("Loaded " + sampleCount + " samples.");
        log.info(sampleRepository.count() + " samples records are found in the database.");
    }


    public void loadGeneData(File file) throws IOException {

        GeneRepository geneRepository = ctx.getBean(GeneRepository.class);
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
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                entrezGeneId = Integer.parseInt(fields[0]);
                taxId = Integer.parseInt(fields[1]);

                geneSymbol = fields[2];
                if (geneSymbol.equals("-")) {
                    geneSymbol = null;
                }

                if ( !( fields[3].equals("-") ) ) {
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

    private static void printUsage(){
        System.out.println("Usage: <MainClass> <data-type> <file-path>");
        System.out.println("Example: <MainClass> gene ./src/main/resources/data/Study/study_magpie_temp.txt\n");
        System.out.println("Supported data types:\n\tall\n\tgene\n\tstudy\n\tsubject");
    }

    public static void main(String args[]) throws Exception{

        if ( args.length != 2 ) {
            printUsage();
            return;
        }

        String dataType = args[0];
        File file = new File(args[1]);

        DataLoader dataLoader = new DataLoader();

        if ( dataType.equals("study") ) {
            dataLoader.loadStudyData(file);
        }
        else if ( dataType.equals("gene") ) {
            dataLoader.loadGeneData(file);
        }
        else if ( dataType.equals("subject") ) {
            dataLoader.loadSubjectData(file);
        }
        else if ( dataType.equals("sample")) {
            dataLoader.loadSampleData(file);
        }
        else {
            printUsage();
        }
    }
}
