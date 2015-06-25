#!/bin/bash

# Import subject data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="subject ./src/main/resources/data/Subject/ccle_subject_magpie.txt"