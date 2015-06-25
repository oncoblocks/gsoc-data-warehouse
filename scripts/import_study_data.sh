#!/bin/bash

# Import study data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="study ./src/main/resources/data/Study/study_magpie.txt"