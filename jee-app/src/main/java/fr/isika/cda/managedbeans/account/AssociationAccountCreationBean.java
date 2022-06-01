package fr.isika.cda.managedbeans.account;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class AssociationAccountCreationBean implements Serializable {
    private AssociationAccountCreationForm accountCreationForm;

    @Inject
    private AccountService accountService;

    public AssociationAccountCreationBean(){
        this.accountCreationForm = new AssociationAccountCreationForm();
    }

    public String create(){
        accountService.createAssociationAccount(this.accountCreationForm);
        return "/account/Login?faces-redirect=true";
    }

    public AssociationAccountCreationForm getAccountCreationForm() {
        return accountCreationForm;
    }

    public void setAccountCreationForm(AssociationAccountCreationForm accountCreationForm) {
        this.accountCreationForm = accountCreationForm;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}