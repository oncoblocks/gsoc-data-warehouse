package org.oncoblocks.magpie.clt.scripts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.clt.config.ApplicationConfig;
import org.oncoblocks.magpie.clt.config.CltConfiguration;
import org.oncoblocks.magpie.rest.models.*;
import org.oncoblocks.magpie.rest.repositories.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DataLoader {

    private static final Log log = LogFactory.getLog(Data.class);

    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
            ApplicationConfig.class, CltConfiguration.class);

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

    public void loadPatientData(File file) throws IOException {

        SubjectRepository subjectRepository = ctx.getBean(SubjectRepository.class);
        if (subjectRepository.count() > 0) {
            subjectRepository.deleteAll();
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int subjectCount = 0;
        String subjectType = "patient";
        while (line != null) {
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                Patient patient = new Patient();

                patient.setSubjectId(fields[0]);
                patient.setSubjectType(subjectType);

                subjectRepository.insert(patient);
                ++subjectCount;
            }
            line = buf.readLine();
        }
        log.info("Loaded " + subjectCount + " subjects.");
        log.info(subjectRepository.count() + " subjects records are found in the database.");
    }


    public void loadCellLineData(File file) throws IOException {

        SubjectRepository subjectRepository = ctx.getBean(SubjectRepository.class);
        if (subjectRepository.count() > 0) {
            subjectRepository.deleteAll();
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int subjectCount = 0;
        String subjectType = "cellLine";
        while (line != null) {
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");

                CellLine cellLine = new CellLine();

                cellLine.setSubjectId(fields[0]);
                cellLine.setCellLineSourceName(fields[1]);
                cellLine.setGender(fields[2]);
                cellLine.setCellLinePrimarySite(fields[3]);
                cellLine.setCellLineHistology(fields[4]);
                cellLine.setSubjectType(subjectType);

                subjectRepository.insert(cellLine);
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

    public void loadExperimentData(File file) throws IOException {

        ExperimentRepository experimentRepository = this.ctx.getBean(ExperimentRepository.class);

        if (experimentRepository.count() > 0) {
            experimentRepository.deleteAll();
        }

        String experimentId;
        String experimentType;
        String description;
        String dataFile;
        String dateAccessed;

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int experimentCount = 0;

        while (line != null) {
            if (!line.startsWith("#")) {
                // Parse a line of study record
                String fields[] = line.split("\t");

                experimentId = fields[0];
                experimentType = fields[1];
                description = fields[2];
                dataFile = fields[3];
                dateAccessed = fields[4];

                Experiment experiment = new Experiment();
                experiment.setExperimentId(experimentId);
                experiment.setExperimentType(experimentType);
                experiment.setDescription(description);
                experiment.setDataFile(dataFile);
                experiment.setDateAccessed(dateAccessed);

                experimentRepository.insert(experiment);
                ++experimentCount;
            }
            line = buf.readLine();
        }
        log.info("Loaded " + experimentCount + " studies.");
        log.info(experimentRepository.count() + " study records are found in the database.");

    }

    public void loadCopyNumberGeneCentricData(File file) throws IOException {

        CopyNumberGeneCentricRepository copyNumberGeneCentricRepository
                = ctx.getBean(CopyNumberGeneCentricRepository.class);
        if (copyNumberGeneCentricRepository.count() > 0) {
            copyNumberGeneCentricRepository.deleteAll();
        }

        int entrezGeneId;
        String sampleId;
        Float cnvValue;

        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        int cnvCount = 0;

        while(line != null) {
            if ( !line.startsWith("#") ) {
                // Parse a line of gene record
                String fields[] = line.split("\t");
                CopyNumberGeneCentric cnv = new CopyNumberGeneCentric();

                entrezGeneId = Integer.parseInt( fields[0] );
                sampleId = fields[1];
                cnvValue = Float.parseFloat( fields[3] );

                cnv.setEntrezGeneId(entrezGeneId);
                cnv.setSampleId(sampleId);
                cnv.setCopyNumberValue(cnvValue);
                cnv.setExperimentId("ccle_cnv_byGene");

                copyNumberGeneCentricRepository.insert(cnv);
                ++cnvCount;
            }
            line = buf.readLine();
        }
        log.info("Loaded " + cnvCount + " CNV records.");
        log.info(copyNumberGeneCentricRepository.count() + " CNV records are found in the database.");
    }


    public void loadGeneData(File file) throws IOException {

        GeneRepository geneRepository = ctx.getBean(GeneRepository.class);
        geneRepository.deleteAll();

        int entrezGeneId;
        int taxId;
        String geneSymbol;
        List<String> geneSynonyms = new ArrayList<>();
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
                    geneSynonyms = Arrays.asList( fields[3].split("\\|") );
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
        else if ( dataType.equals("cellLine") ) {
            dataLoader.loadCellLineData(file);
        }
        else if ( dataType.equals("sample")) {
            dataLoader.loadSampleData(file);
        }
        else if ( dataType.equals("copyNumberGeneCentric") ) {
            try {
                long startTime = System.nanoTime();
                dataLoader.loadCopyNumberGeneCentricData(file);
                long endTime = System.nanoTime();
                long execTime_nano = endTime - startTime;
                log.info("loadCopyNumberGeneCentricData() finished; execution time: " +
                        TimeUnit.NANOSECONDS.toSeconds(execTime_nano) + "s" + "("  + execTime_nano + "ns)");
            }
            catch ( IOException e ) {
                System.err.println("Exception occurred: If execution is timed for this method, the result will no be shown.");
                System.err.println("IOException is caught: " + e.getMessage());
            }
        }
        else if ( dataType.equals("experiment")) {
            dataLoader.loadExperimentData(file);
        }
        else {
            printUsage();
        }
    }
}
