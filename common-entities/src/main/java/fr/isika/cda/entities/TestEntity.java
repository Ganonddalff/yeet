package fr.isika.cda.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_ENTITY")
public class TestEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "another_test_entity_id")
	private AnotherTestEntity anotherTestEntity;

	public void setAnotherTestEntity(AnotherTestEntity anotherTestEntity) {
		this.anotherTestEntity = anotherTestEntity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
