#!/bin/bash

# Import subject data
#mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="cellLine ./data/Subject/ccle_cellLine_magpie_temp.txt"

mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="cellLine ./data/Subject/cnv_ccle_magpie_10.txt"