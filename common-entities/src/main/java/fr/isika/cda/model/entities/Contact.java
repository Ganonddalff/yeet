package fr.isika.cda.model.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Email(message = "L'adresse email n'est pas valide")
    private String email;

    @NotNull
    @Size(min = 10, max = 12, message = "Le numéro de téléphone doit être compris entre 10 et 12 caractères")
    @Pattern(regexp = "^[0-9]*$", message = "le numéro de téléphone ne peut contenir que des chiffres")
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
