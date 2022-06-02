package fr.isika.cda.spring.repositories;

import fr.isika.cda.model.entities.Association;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssociationRepository extends CrudRepository<Association, Long>{
    @Query(value = "SELECT a FROM Association a WHERE a.name = '%'")
    public List<Association> search(@Param("keyword") String keyword);
}
