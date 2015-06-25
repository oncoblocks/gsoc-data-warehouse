#!/bin/bash

# Import gene data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="gene ./src/main/resources/data/Gene/gene_magpie_temp.txt"

# Import study data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="study ./src/main/resources/data/Study/study_magpie_temp.txt"

# Import subject data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="subject ./src/main/resources/data/Subject/ccle_subject_magpie_temp.txt"

# Import sample data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="sample
 ./src/main/resources/data/Sample/ccle_sample_magpie_temp.txt"