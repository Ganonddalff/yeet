package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;
    

    public AccountRepository(){

    }

    public Account create(Account associationAccount) {
        entityManager.persist(associationAccount);
        entityManager.flush();
        entityManager.clear();

        return associationAccount;
    }

    public Optional<Account> findByIdentifier(String identifier) {
        try {
            Account account = this.entityManager
                    .createQuery("select a from Account a where a.identifier = :identifier", Account.class)
                    .setParameter("identifier", identifier)
                    .getSingleResult();
            return Optional.ofNullable(account);
        } catch (NoResultException ex) {}
        return Optional.empty();
    }

    public Optional<Account> findById(Long id) {
        try {
            Account account = this.entityManager
                    .createQuery("select a from Account a where a.id = :id", Account.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(account);
        } catch (NoResultException ex) {}
        return Optional.empty();
    }

    public List<Account> getAllAssociationAccount() {
        return this.entityManager
                .createQuery("select a from Account a where a.accountCategory = 'Association'", Account.class)
                .getResultList();
    }

    public List<Account> getAllUserAccount() {
        return this.entityManager
                .createQuery("select a from Account a where a.accountCategory = 'User'", Account.class)
                .getResultList();
    }

    public List<Account> getAllAdministratorAccount() {
        return this.entityManager
                .createQuery("select a from Account a where a.accountCategory = 'Administrator'", Account.class)
                .getResultList();
    }

    public void delete(Account account) {
        account = entityManager.merge(account);
        entityManager.remove(account);
        entityManager.flush();
        entityManager.clear();
    }
}