package fr.isika.cda.managedbeans;

import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.UserAccountCreationForm;

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

    public void reset(){
        this.accountCreationForm = new UserAccountCreationForm();
    }

    public void fill(){
        this.accountCreationForm.fill();
    }

    public String create(){
        accountService.createUserAccount(this.accountCreationForm);
        return "index";
    }

    public UserAccountCreationForm getAccountCreationForm() {
        return accountCreationForm;
    }

    public void setAccountCreationForm(UserAccountCreationForm accountCreationForm) {
        this.accountCreationForm = accountCreationForm;
    }
}