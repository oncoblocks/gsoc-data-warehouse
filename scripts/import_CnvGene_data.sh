#!/bin/bash

# Import subject data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="copyNumberGeneCentric ./src/main/resources/data/copyNumberGeneCentric/cnv_ccle_magpie_10.txt"