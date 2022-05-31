package fr.isika.cda.managedbeans.adhesion;

import fr.isika.cda.model.entities.Adhesion;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AdhesionService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.PaymentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.JoinColumn;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@ManagedBean
@ViewScoped
public class AdhesionValidationBean {
    private Long adhesionId;
    private Association association;

    @Inject
    private AdhesionService adhesionService;
    @Inject
    private AssociationService associationService;
    @Inject
    private AccountService accountService;
    @Inject
    private PaymentService paymentService;

    public AdhesionValidationBean(){}

    public void init(){
        Optional<Adhesion> adhesion= adhesionService.findById(this.adhesionId);
        this.association = adhesion.get().getAssociation();
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Long getAdhesionId() {
        return adhesionId;
    }

    public void setAdhesionId(Long adhesionId) {
        this.adhesionId = adhesionId;
    }
}
