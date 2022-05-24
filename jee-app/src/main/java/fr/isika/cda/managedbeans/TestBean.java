package fr.isika.cda.managedbeans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cda.entities.AnotherTestEntity;
import fr.isika.cda.entities.TestEntity;
import fr.isika.cda.service.TestService;

@Named
@ViewScoped
public class TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8174549242665123337L;
	
	@Inject
	private TestService service;
	
	public void create() {
		
		AnotherTestEntity anotherTestEntity = new AnotherTestEntity();
		anotherTestEntity.setDate(LocalDate.now());
		anotherTestEntity.setValue(50.2);
		
		TestEntity entity = new TestEntity();
		entity.setName("from jee");
		entity.setAnotherTestEntity(anotherTestEntity);
		
		service.create(entity);
	}
	
}
