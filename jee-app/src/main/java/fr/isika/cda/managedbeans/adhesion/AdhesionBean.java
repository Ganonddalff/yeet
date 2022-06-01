package fr.isika.cda.managedbeans.adhesion;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Adhesion;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AdhesionService;
import fr.isika.cda.services.AssociationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@ManagedBean
@ViewScoped
public class AdhesionBean {
    private Long associationId;
    private Association association;

    @Inject
    private AdhesionService adhesionService;
    @Inject
    private AccountService accountService;
    @Inject
    private AssociationService associationService;

    public AdhesionBean(){}

    public void init(){
        this.association = associationService.findById(associationId).get();
    }

    public boolean isFree(){
        return association.getAdhesionPrice() == 0D;
    }

    public void validateFree() throws IOException {
        this.association = associationService.findById(associationId).get();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Adhesion adhesion = adhesionService.
                create(this.association, accountService.findById((Long)session.getAttribute("idAccount")).get());
        String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/adhesion/AdhesionValidation.xhtml?id=" + adhesion.getId();
        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
    }

    public String validate(){
        this.association = associationService.findById(associationId).get();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        Adhesion adhesion = adhesionService.
                create(this.association, accountService.findById((Long)session.getAttribute("idAccount")).get());

        session.setAttribute("idAsso", this.association.getId());
        session.setAttribute("amount", this.association.getAdhesionPrice());
        session.setAttribute("reason", "Adhesion");
        session.setAttribute("idReason", adhesion.getId());
        return "/payment/CreditCardPayment?faces-redirect=true";
    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
