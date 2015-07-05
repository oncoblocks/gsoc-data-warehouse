#!/bin/bash

# Import subject data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="cellLine ./src/main/resources/data/Subject/ccle_cellLine_magpie_temp.txt"