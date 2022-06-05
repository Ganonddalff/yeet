package fr.isika.cda.services;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.CreditCard;
import fr.isika.cda.model.entities.Payment;
import fr.isika.cda.model.enumeration.PaymentMethod;
import fr.isika.cda.model.factories.implementation.PaymentFactoryImpl;
import fr.isika.cda.repositories.PaymentRepository;
import fr.isika.cda.viewmodels.payment.CreditCardPaymentViewmodel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Stateless
public class PaymentService {
    @Inject
    private PaymentRepository paymentRepository;

    public PaymentService() {
    }

    public Payment createCreditCardPayment(CreditCardPaymentViewmodel viewmodel){
        Payment payment = PaymentFactoryImpl.getInstance().getPayment();
        payment.setPaymentReason(viewmodel.getPaymentReason());
        payment.setAmount(viewmodel.getAmount());
        payment.setPaymentMethod(PaymentMethod.CreditCard);
        payment.setAssociation(viewmodel.getAssociation());
        payment.setDate(Calendar.getInstance().getTime());
        payment.setUserAccount(viewmodel.getUserAccount());
        payment.setIdReason(viewmodel.getIdReason());
        return paymentRepository.create(payment);
    }

    public Optional<CreditCard> getCreditCard(Account account) {
        return paymentRepository.getCreditCard(account);
    }

    public CreditCard saveCard(CreditCard creditCard) {
        return paymentRepository.saveCard(creditCard);
    }

    public List<Payment> getAllPayments(){
        return  paymentRepository.getAllPayments();
    }
}