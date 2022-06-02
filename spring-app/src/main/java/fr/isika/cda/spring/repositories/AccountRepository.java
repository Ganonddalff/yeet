package fr.isika.cda.spring.repositories;

import fr.isika.cda.model.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    //    @Query(value = "SELECT c FROM Account a WHERE c.name LIKE '%' || :keyword || '%'"
    //            + " OR c.email LIKE '%' || :keyword || '%'"
    //            + " OR c.address LIKE '%' || :keyword || '%'")
    @Query(value = "SELECT a FROM Account a WHERE a.accountCategory = '%'")
    public List<Account> search(@Param("keyword") String keyword);
}