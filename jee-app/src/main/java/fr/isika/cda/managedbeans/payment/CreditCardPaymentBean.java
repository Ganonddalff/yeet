package fr.isika.cda.managedbeans.payment;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.CreditCard;
import fr.isika.cda.model.entities.Payment;
import fr.isika.cda.model.enumeration.PaymentReason;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.PaymentService;
import fr.isika.cda.viewmodels.payment.CreditCardPaymentViewmodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@ManagedBean
@ViewScoped
public class CreditCardPaymentBean {
    private Long associationId;
    private CreditCardPaymentViewmodel paymentVm;
    private String reason;
    private boolean saveCard;

    @Inject
    private AccountService accountService;
    @Inject
    private AssociationService associationService;
    @Inject
    private PaymentService paymentService;

    public CreditCardPaymentBean(){
        this.paymentVm = new CreditCardPaymentViewmodel();
    }

    public void init(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.paymentVm.setAssociation(associationService.findById((Long)session.getAttribute("idAsso")).get());
        this.reason = (String)session.getAttribute("reason");
        this.paymentVm.setIdReason((Long)session.getAttribute("idReason"));
        this.paymentVm.setAmount((Double)session.getAttribute("amount"));
        this.paymentVm.setUserAccount(accountService.findById((Long)session.getAttribute("idAccount")).get());
        this.paymentVm.getCreditCard().setAccount(accountService.findById((Long)session.getAttribute("idAccount")).get());
        Optional<CreditCard> creditCard = paymentService.
                getCreditCard(accountService.findById((Long)session.getAttribute("idAccount")).get());
        if(creditCard.isPresent())
            this.paymentVm.setCreditCard(creditCard.get());
        switch(reason){
            case "Adhesion" :
                this.paymentVm.setPaymentReason(PaymentReason.Adhesion);
                break;
            case "Command" :
                this.paymentVm.setPaymentReason(PaymentReason.Command);
                break;
            case "Contribution" :
                this.paymentVm.setPaymentReason(PaymentReason.Contribution);
        }
    }

    public void validate() throws IOException {
        if(this.saveCard)
            paymentService.saveCard(this.paymentVm.getCreditCard());
        Payment payment = paymentService.createCreditCardPayment(this.paymentVm);
        String url;
        switch(payment.getPaymentReason()){
            case Adhesion:
                url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/adhesion/AdhesionValidation.xhtml?id=" + payment.getIdReason();
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                break;
            case Command:
                url =  FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/shop/CommandValidation.xhtml?id=" + payment.getIdReason();
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                break;
            case Contribution:
                url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/crowdfunding/ContributionValidation.xhtml?id=" + payment.getIdReason();
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                break;
            case Subscription:
                url= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/association/AssociationDashBoard.xhtml?id="+payment.getIdReason();
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                break;
        }
    }

    public CreditCardPaymentViewmodel getPaymentVm() {
        return paymentVm;
    }

    public void setPaymentVm(CreditCardPaymentViewmodel payment) {
        this.paymentVm = payment;
    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSaveCard() {
        return saveCard;
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }
}
