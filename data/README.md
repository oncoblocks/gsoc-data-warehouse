## Data Source

The `data` folder contains files that would be mapped to `magpie`-specific entities and imported into persistence layer. 

### Gene
The source for annotating human genes comes from NCBI at 

    ftp://ftp.ncbi.nih.gov/gene/DATA/GENE_INFO/Mammalia/Homo_sapiens.gene_info.gz

A temporary file `gene_magpie_temp.txt` is generated from the above raw file. A small file with ten records, `gene_10.txt`, is created for testing purposes.