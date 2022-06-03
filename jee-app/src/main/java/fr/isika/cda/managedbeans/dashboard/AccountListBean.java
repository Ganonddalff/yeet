package fr.isika.cda.managedbeans.dashboard;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.dashboard.AccountListViewmodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class AccountListBean implements Serializable {
    private AccountListViewmodel associationListViewmodel;
    private AccountListViewmodel userListViewmodel;

    @Inject
    private AccountService accountService;

    public AccountListBean(){
        this.associationListViewmodel = new AccountListViewmodel();
        this.userListViewmodel = new AccountListViewmodel();
    }

    public void initAsso(){
        this.associationListViewmodel.setAccountList(accountService.getAllAssociationAccount());
    }

    public void initUser(){
        this.userListViewmodel.setAccountList(accountService.getAllUserAccount());
    }

    public void delete(Account account){
        accountService.delete(account);
    }

    public AccountListViewmodel getAssociationListViewmodel() {
        return associationListViewmodel;
    }

    public void setAssociationListViewmodel(AccountListViewmodel associationListViewmodel) {
        this.associationListViewmodel = associationListViewmodel;
    }

    public AccountListViewmodel getUserListViewmodel() {
        return userListViewmodel;
    }

    public void setUserListViewmodel(AccountListViewmodel userListViewmodel) {
        this.userListViewmodel = userListViewmodel;
    }
}