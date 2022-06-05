package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.CreditCard;
import fr.isika.cda.model.entities.Payment;
import fr.isika.cda.services.PaymentService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class PaymentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PaymentRepository() {}

    public Payment create(Payment payment){
        entityManager.persist(payment);
        entityManager.flush();
        entityManager.clear();
        return payment;
    }

    public Optional<CreditCard> getCreditCard(Account account) {
        try {
            CreditCard creditCard = this.entityManager
                    .createQuery("select c from CreditCard c where c.account = :account", CreditCard.class)
                    .setParameter("account", account)
                    .getSingleResult();
            return Optional.ofNullable(creditCard);
        } catch (NoResultException ex) {}
        return Optional.empty();
    }

    public CreditCard saveCard(CreditCard creditCard) {
        entityManager.persist(creditCard);
        entityManager.flush();
        entityManager.clear();
        return creditCard;
    }

    public List<Payment> getAllPayments() {
        return this.entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
    }
}
