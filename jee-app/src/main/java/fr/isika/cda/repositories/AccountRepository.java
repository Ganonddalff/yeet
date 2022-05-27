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

    public Account create(UserAccountCreationForm form) {
        Contact contact = form.getContact();
        Address address = form.getAddress();
        Person person = form.getPerson();
        person.setAddress(address);
        person.setContact(contact);
        Account userAccount = form.getAccount();
        userAccount.setAccountCategory(AccountCategory.User);
        userAccount.setCreationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        userAccount.setPerson(person);

        entityManager.persist(userAccount);
        entityManager.flush();
        entityManager.clear();

        return userAccount;
    }

    public Account create(AssociationAccountCreationForm form) {
        Contact contact = form.getContact();
        Address address = form.getAddress();
        Association association = form.getAssociation();
        association.setAddress(address);
        association.setContact(contact);
        association.setBanner("/resources/images/banners/standardBanner.png");
        association.setProfileImage("/resources/images/profileImages/standardProfileImage.png");
        association.setDescription("");
        Account associationAccount = form.getAccount();
        associationAccount.setAccountCategory(AccountCategory.Association);
        associationAccount.setCreationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        associationAccount.setAssociation(association);

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