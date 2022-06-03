package fr.isika.cda.services;

import fr.isika.cda.model.entities.*;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.repositories.AccountRepository;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.form.account.UserAccountCreationForm;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountService() {
    }

    public Account createUserAccount(UserAccountCreationForm form) {
        Contact contact = form.getContact();
        Address address = form.getAddress();
        Person person = form.getPerson();
        person.setAddress(address);
        person.setContact(contact);
        Account userAccount = form.getAccount();
        userAccount.setAccountCategory(AccountCategory.User);
        userAccount.setCreationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        userAccount.setPerson(person);
        return accountRepository.create(userAccount);
    }

    public Account createAdminAccount(UserAccountCreationForm form) {
        Contact contact = form.getContact();
        Address address = form.getAddress();
        Person person = form.getPerson();
        person.setAddress(address);
        person.setContact(contact);
        Account userAccount = form.getAccount();
        userAccount.setAccountCategory(AccountCategory.Administrator);
        userAccount.setCreationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        userAccount.setPerson(person);
        return accountRepository.create(userAccount);
    }

    public Account createAssociationAccount(AssociationAccountCreationForm form) {
        Contact contact = form.getContact();
        Address address = form.getAddress();
        Association association = form.getAssociation();
        association.setAddress(address);
        association.setContact(contact);
        association.setBanner("/resources/images/banners/standardBanner.png");
        association.setProfileImage("/resources/images/profileImages/standardProfileImage.jpeg");
        association.setDescription("");
        Account associationAccount = form.getAccount();
        associationAccount.setAccountCategory(AccountCategory.Association);
        associationAccount.setCreationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        associationAccount.setAssociation(association);
        return accountRepository.create(associationAccount);
    }

    public Optional<Account> findByIdentifier(String identifier) {
        return accountRepository.findByIdentifier(identifier);
    }

    public Optional<Account> findById(Long id){
        return accountRepository.findById(id);
    }

    public List<Account> getAllAssociationAccount() {
        return accountRepository.getAllAssociationAccount();
    }

    public List<Account> getAllUserAccount() {
        return accountRepository.getAllUserAccount();
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
