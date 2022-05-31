package fr.isika.cda.viewmodels.payment;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.CreditCard;
import fr.isika.cda.model.enumeration.PaymentReason;
import fr.isika.cda.model.factories.implementation.CreditCardFactoryImpl;

public class CreditCardPaymentViewmodel {
    private Association association;
    private Double amount;
    private CreditCard creditCard;
    private PaymentReason paymentReason;
    private Account userAccount;
    private Long idReason;

    public CreditCardPaymentViewmodel(){
        creditCard = CreditCardFactoryImpl.getInstance().getCreditCard();
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public PaymentReason getPaymentReason() {
        return paymentReason;
    }

    public void setPaymentReason(PaymentReason paymentReason) {
        this.paymentReason = paymentReason;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public Long getIdReason() {
        return idReason;
    }

    public void setIdReason(Long idReason) {
        this.idReason = idReason;
    }
}
