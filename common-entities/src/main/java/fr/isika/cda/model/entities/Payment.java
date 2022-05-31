package fr.isika.cda.model.entities;

import fr.isika.cda.model.enumeration.PaymentMethod;
import fr.isika.cda.model.enumeration.PaymentReason;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentReason paymentReason;

    @Basic
    private Long idReason;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Account userAccount;

    @ManyToOne
    private Association association;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentReason getPaymentReason() {
        return paymentReason;
    }

    public void setPaymentReason(PaymentReason paymentReason) {
        this.paymentReason = paymentReason;
    }

    public Long getIdReason() {
        return idReason;
    }

    public void setIdReason(Long idReason) {
        this.idReason = idReason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
