package fr.isika.cda.managedbeans.account;

import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.form.account.UserAccountCreationForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class UserAccountCreationBean implements Serializable {
    private UserAccountCreationForm accountCreationForm;

    @Inject
    private AccountService accountService;

    public UserAccountCreationBean(){
        this.accountCreationForm = new UserAccountCreationForm();
    }

    public String create(){
        accountService.createUserAccount(this.accountCreationForm);
        return "/account/Login.xhtml";
    }

    public UserAccountCreationForm getAccountCreationForm() {
        return accountCreationForm;
    }

    public void setAccountCreationForm(UserAccountCreationForm accountCreationForm) {
        this.accountCreationForm = accountCreationForm;
    }
}