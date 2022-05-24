package fr.isika.cda.services;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.repositories.AccountRepository;
import fr.isika.cda.viewmodels.UserAccountCreationForm;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountService() {
    }

    public Account createUserAccount(UserAccountCreationForm accountCreationForm) {
        return accountRepository.create(accountCreationForm);
    }
}
