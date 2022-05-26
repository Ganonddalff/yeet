package fr.isika.cda.services;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.repositories.AccountRepository;
import fr.isika.cda.viewmodels.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.UserAccountCreationForm;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Stateless
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountService() {
    }

    public Account createUserAccount(UserAccountCreationForm userAccountCreationForm) {
        return accountRepository.create(userAccountCreationForm);
    }

    public Account createAssociationAccount(AssociationAccountCreationForm associationAccountCreationForm) {
        return accountRepository.create(associationAccountCreationForm);
    }

    public Optional<Account> findByIdentifier(String identifier) {
        return accountRepository.findByIdentifier(identifier);
    }
}
