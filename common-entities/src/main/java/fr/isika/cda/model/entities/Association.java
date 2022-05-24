package fr.isika.cda.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Association{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 50, message = "Doit contenir entre 1 et 50 caractères")
    private String name;

    @NotNull
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    @NotNull
    @OneToOne(cascade = {CascadeType.ALL})
    private Contact contact;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @Column(length=14)
    @Pattern(regexp = "^[0-9]*$", message = "le SIRET ne peut contenir que des chiffres")
    private String Siret;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSiret() {
        return Siret;
    }

    public void setSiret(String siret) {
        Siret = siret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
