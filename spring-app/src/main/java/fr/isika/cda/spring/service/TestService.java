package fr.isika.cda.spring.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.isika.cda.entities.AnotherTestEntity;
import fr.isika.cda.entities.TestEntity;
import fr.isika.cda.spring.repo.TestRepo;

@Service
@Transactional
public class TestService implements InitializingBean {
	
	@Autowired
	TestRepo repo;

	public void save(TestEntity entity) {
		repo.save(entity);
	}

	public List<TestEntity> listAll() {
		return (List<TestEntity>) repo.findAll();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		AnotherTestEntity anotherTestEntity = new AnotherTestEntity();
		anotherTestEntity.setDate(LocalDate.now());
		anotherTestEntity.setValue(25.);
		
		TestEntity entity = new TestEntity();
		entity.setName("from spring");
		entity.setAnotherTestEntity(anotherTestEntity);
		
		save(entity);
	}

}