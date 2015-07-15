#!/bin/bash

# Import study data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="study ./data/Study/study_magpie_temp.txt"