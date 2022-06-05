package fr.isika.cda.viewmodels.dashboard;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Payment;

import java.util.List;

public class DashboardHomeViewmodel {
    private List<Payment> paymentList;
    private List<Account> accountList;

    public DashboardHomeViewmodel(){}

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
