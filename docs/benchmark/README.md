#Query performance benchmarking
Preliminary benchmarking has been performed on queries on CNV data. Specifically, tests were carried out using three database sizes namely 2,331,600, 5,829,000, and 24,388,536. The following queries were issued in the `mongo` shell. 

    db.cnv_gene_centric.find({"entrezGeneId" : 9962}).limit(10000)

    db.cnv_gene_centric.find({"sampleId": "HCT15_LARGE_INTESTINE"}).limit(10000)

    db.cnv_gene_centric.find({$and: [{"entrezGeneId" : 9962}, {"sampleId": "HCT15_LARGE_INTESTINE"}]})


The execution times of these queries were obtained using by first setting the system profiling level 

    db.setProfilingLevel(2)
    
and then accessed using

    db.system.profile.find({"ns" : "magpie_test_1.cnv_gene_centric"}, {"query":1, "execStats.executionTimeMillisEstimate":1, "ts": 1, "nreturned" : 1})
    
where the `nreturned` field was retrieved as a sanity check for the query.

Benchmark results can be found in this folder.