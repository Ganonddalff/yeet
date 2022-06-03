package fr.isika.cda.viewmodels.dashboard;

import fr.isika.cda.model.entities.Account;

import java.util.List;

public class AccountListViewmodel {
    private List<Account> accountList;
    private String keyword;

    public AccountListViewmodel(){}

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
