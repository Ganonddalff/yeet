package fr.isika.cda.managedbeans;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.UserAccountCreationForm;
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

    public void reset(){
        this.accountCreationForm = new AssociationAccountCreationForm();
    }

    public String create(){
        accountService.createAssociationAccount(this.accountCreationForm);
        return "index";
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