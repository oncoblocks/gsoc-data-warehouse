#!/bin/bash

# Import subject data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="experiment ./data/Experiment/experiment_magpie_temp.txt"