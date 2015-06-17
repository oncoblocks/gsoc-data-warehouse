package org.oncoblocks.magpie.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oncoblocks.magpie.clt.config.ApplicationConfig;
import org.oncoblocks.magpie.rest.models.CopyNumberGeneCentric;
import org.oncoblocks.magpie.rest.repositories.CopyNumberGeneCentricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, MongoTestConfiguration.class})
@FixMethodOrder
public class RepositoryTests {
	
	@Autowired
	private CopyNumberGeneCentricRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Before
	public void setup(){
		Assert.notNull(repository);
		repository.deleteAll();
	}
	
	private void createNewRecord(){
		CopyNumberGeneCentric cnv = new CopyNumberGeneCentric();
		cnv.setEntrezGeneId(1);
		cnv.setSampleId("LOUNH91_LUNG");
		cnv.setExperimentId("CCLE");
		cnv.setCopyNumberValue(-0.0259);
		repository.insert(cnv);
	}
	
	@Test
	public void findNothingTest(){
		List<CopyNumberGeneCentric> data = repository.findAll();
		Assert.isTrue(data.size() == 0);
	}
	
	@Test
	public void insertTest(){
		CopyNumberGeneCentric cnv = new CopyNumberGeneCentric();
		cnv.setEntrezGeneId(1);
		cnv.setSampleId("LOUNH91_LUNG");
		cnv.setExperimentId("CCLE");
		cnv.setCopyNumberValue(-0.0259);
		repository.insert(cnv);

		long count = repository.count();
		Assert.isTrue(count == 1L);
	}
	
	@Test
	public void mongoTemplateFindAllTest(){
		createNewRecord();
		List<CopyNumberGeneCentric> data = mongoTemplate.find(new Query(), CopyNumberGeneCentric.class);
		Assert.notNull(data);
		Assert.notEmpty(data);
		CopyNumberGeneCentric cnv = data.get(0);
		Assert.isTrue(cnv.getEntrezGeneId().equals(1));
		
	}
	
	@Test
	public void findAllTest(){
createNewRecord();
		List<CopyNumberGeneCentric> data = repository.findAll();
		System.out.println(data.toString());
		Assert.notEmpty(data);
		Assert.isTrue(data.size() == 1);
		CopyNumberGeneCentric cnv = data.get(0);
		Assert.notNull(cnv);
		Assert.isTrue(cnv.getEntrezGeneId().equals(1));
		
	}
	
	@Test
	public void findByEntrezGeneIdTest() throws Exception {
		createNewRecord();
		List<CopyNumberGeneCentric> cnv = repository.findByGeneId(1);
		Assert.notNull(cnv);
		Assert.notEmpty(cnv);
		System.out.println(cnv.toString());
		Assert.isTrue(cnv.size() == 1);
		Assert.isTrue(cnv.get(0).getEntrezGeneId().equals(1));
		System.out.println(cnv.get(0).toString());
	}
	
}
