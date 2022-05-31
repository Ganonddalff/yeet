package fr.isika.cda.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @Size(min = 16, max = 16, message = "le code de la carte est constitué de 16 chiffres")
    @Pattern(regexp = "^[0-9]*$", message = "le code de la carte est constitué de 16 chiffres")
    private String cardNumber;

    @NotNull
    @Size(min = 1, max = 25, message = "Le prénom doit être constitué de 1 à 25 caractères")
    @Pattern(regexp = "[^0-9]*", message = "Le prénom ne doit pas contenir de chiffre")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 25, message = "Le nom doit être constitué de 1 à 25 caractères")
    @Pattern(regexp = "[^0-9]*", message = "Le nom ne doit pas contenir de chiffre")
    private String lastName;

    @NotNull
    @Size(min = 3, max = 3, message = "le cvc est constitué de 3 chiffres")
    @Pattern(regexp = "^[0-9]*$", message = "le cvc est constitué de 3 chiffres")
    private String cvc;

    @NotNull
    @Size(min = 1, max = 2, message = "le mois est constitué de 1 ou 2 chiffres")
    @Pattern(regexp = "^[0-9]*$", message = "le mois est constitué de 1 ou 2 chiffres")
    private String expirationMonth;

    @NotNull
    @Size(min = 4, max = 4, message = "l'année est constituée de 4 chiffres")
    @Pattern(regexp = "^[0-9]*$", message = "l'année est constituée de 4 chiffres")
    private String expirationYear;

    @OneToOne
    private Account account;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
