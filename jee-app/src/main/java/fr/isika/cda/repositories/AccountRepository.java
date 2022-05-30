package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.*;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.form.account.UserAccountCreationForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
}