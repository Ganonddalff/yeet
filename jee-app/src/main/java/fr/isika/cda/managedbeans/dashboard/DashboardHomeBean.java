package fr.isika.cda.managedbeans.dashboard;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Payment;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.PaymentService;
import fr.isika.cda.viewmodels.dashboard.DashboardHomeViewmodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class DashboardHomeBean {
    private DashboardHomeViewmodel activity;

    @Inject
    private PaymentService paymentService;
    @Inject
    private AccountService accountService;

    public DashboardHomeBean(){
        this.activity = new DashboardHomeViewmodel();
    }

    public void init(){
        List<Account> accounts = accountService.getAllAccount()
                .stream()
                .sorted(Comparator.comparing(Account::getCreationDate))
                .collect(Collectors.toList());
        Collections.reverse(accounts);
        this.activity.setAccountList(accounts.stream()
                .limit(15)
                .collect(Collectors.toList()));

        List<Payment> payments = paymentService.getAllPayments()
                .stream()
                .sorted(Comparator.comparing(Payment::getDate))
                .collect(Collectors.toList());
        Collections.reverse(payments);
        this.activity.setPaymentList(payments.stream()
                .limit(15)
                .collect(Collectors.toList()));
    }

    public boolean isAsso(Account account){
        return account.getAccountCategory() == AccountCategory.Association;
    }

    public DashboardHomeViewmodel getActivity() {
        return activity;
    }

    public void setActivity(DashboardHomeViewmodel activity) {
        this.activity = activity;
    }
}
