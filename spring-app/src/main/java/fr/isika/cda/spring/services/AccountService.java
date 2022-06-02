package fr.isika.cda.spring.services;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.spring.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    public List<Account> listAll() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account get(Long id) {
        return accountRepository.findById(id).get();
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public List<Account> search(String keyword) {
        return accountRepository.search(keyword);
    }
}