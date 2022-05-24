package fr.isika.cda.spring.repo;
 
import org.springframework.data.repository.CrudRepository;

import fr.isika.cda.entities.TestEntity;
 
public interface TestRepo extends CrudRepository<TestEntity, Long> {
     
}