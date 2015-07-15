#!/bin/bash

# Import sample data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="sample ./data/Sample/ccle_sample_magpie_temp.txt"