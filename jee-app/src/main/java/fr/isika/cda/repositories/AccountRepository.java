package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Address;
import fr.isika.cda.model.entities.Contact;
import fr.isika.cda.model.entities.Person;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.viewmodels.UserAccountCreationForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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
}