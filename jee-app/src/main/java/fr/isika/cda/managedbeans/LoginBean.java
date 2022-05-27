package fr.isika.cda.managedbeans;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.viewmodels.LoginForm;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Optional;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
    private LoginForm loginForm;
    @Inject
    private AccountService accountService;

    public LoginBean(){
        this.loginForm = new LoginForm();
    }

    public String login(){
        Optional<Account> optional = accountService.findByIdentifier(loginForm.getIdentifier());
        if (optional.isPresent()) {
            Account account = optional.get();
            if (account.getPassword().equals(loginForm.getPassword())) {
                HttpSession session = (HttpSession) FacesContext.
                        getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("typeAccount", account.getAccountCategory().name());
                session.setAttribute("identifier", account.getIdentifier());
                if(account.getAccountCategory() == AccountCategory.User || account.getAccountCategory() == AccountCategory.Administrator)
                    session.setAttribute("id", account.getPerson().getId());
                else if(account.getAccountCategory() == AccountCategory.Association)
                    session.setAttribute("id", account.getAssociation().getId());
                session.setAttribute("idAccount", account.getId());
                return "index";
            } else {
                UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
                FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
                        new FacesMessage("L'identifiant et/ou le mot de passe ne correspondent pas à un compte existant"));
            }
        } else {
            UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
            FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
                    new FacesMessage("L'identifiant et/ou le mot de passe ne correspondent pas à un compte existant"));
        }
        return "login";
    }

    public String signOut() {
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false);
        session.invalidate();
        return "index?faces-redirect=true";
    }

    public boolean isAssociationConnected(){
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false);
        if((String)session.getAttribute("typeAccount") != null)
            return ((String)session.getAttribute("typeAccount")).equals("Association");
        return false;
    }

    public boolean isUserConnected(){
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false);
        if((String)session.getAttribute("typeAccount") != null)
            return ((String)session.getAttribute("typeAccount")).equals("User");
        return false;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
