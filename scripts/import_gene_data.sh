#!/bin/bash

# Import gene data
mvn -e -q exec:java -Dexec.mainClass="org.oncoblocks.magpie.clt.scripts.DataLoader" -Dexec.args="gene ./src/main/resources/data/Gene/gene_magpie_temp.txt"