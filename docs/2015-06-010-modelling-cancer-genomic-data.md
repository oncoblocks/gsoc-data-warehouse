---
layout: post
author: "Tewei Luo"
title: "Modeling Cancer Genomic Data"
date: 2015-06-01 18:00:00
permalink: "/data-model"
tags: news
---

As Will explained very lucidly in our first post, a carefully designed data model is crucial for the Magpie project. In this post I will introduce the types of data we would like to store, and they are logically related. 

### Data Levels
Many entities in the data warehouse fit into the following levels. Note that the relationship among these entities do not always reflect their real-world counterparts. The schema is designed for efficient data management.

#### Subject
A `subject` entity is the origin of any physical sample. For example, a patient participating in a cancer study is such a `subject` entity because biopsy samples are obtained from this patient. As many cancer genomic studies use cultured cells and therefore it is important to incorporate them into the data model as well. We decide to treat a source cell line, such as [Hep 3B2.1-7][hep 3b], as a `subject` entity.

#### Sample
A `sample` entity is a piece of physical object, originated from a `subject` entity, that is used in a biological experiment. In most cases, this level contains samples such as patient biopsies and cell lines. Note that cell lines here represent physical cells that are distributed by specific vendors or laboratories. For example, cell lines of the same source but distributed by two different vendors are treated as two separate `sample` entities.

#### Experiment 
An `experiment` entity is a biological experiment, such as whole exome sequencing (WES), that is performed on a `sample` entity. Multiple `example` entities can be related to the same `sample`. For example, the same cell line can be used in both WES and RNA sequencing experiments.

#### Record
A `record` entity represents actual data generated from an `experiment`. For example, a mutation that is found in a WES experiment is such a `record`.



[hep 3b]: http://www.atcc.org/products/all/HB-8064.aspx