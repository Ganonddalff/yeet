package fr.isika.cda.model.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.isika.cda.model.enumeration.AccountCategory;

@Entity
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 4, max = 15, message = "Doit contenir entre 4 et 15 caractères.")
    @Column(unique=true)
    private String identifier;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 4, max = 15, message = "Doit contenir entre 4 et 15 caractères.")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountCategory accountCategory;

	private Date creationDate;

    @OneToOne(cascade = {CascadeType.ALL})
    private Association association;

    @OneToOne(cascade = {CascadeType.ALL})
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public AccountCategory getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(AccountCategory accountCategory) {
        this.accountCategory = accountCategory;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date dateCreation) {
        this.creationDate = dateCreation;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}