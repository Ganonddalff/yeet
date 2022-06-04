package fr.isika.cda.model.entities;

import jdk.jfr.BooleanFlag;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Association{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 50, message = "Doit contenir entre 1 et 50 caractères")
    @Column(unique=true)
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
    private double adhesionPrice;

    @NotNull
    @Column(length=14)
    @Pattern(regexp = "^[0-9]*$", message = "le SIRET ne peut contenir que des chiffres")
    private String Siret;

    @NotNull
    private String profileImage;
    @NotNull
    private String banner;

    @Size(max=8000)
    @NotNull
    private String description;

    private Boolean AdhesionSubscription;

    private Boolean CrowdfundingSubscription;

    private Boolean ShopSubscription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "association", orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "association", orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdhesionPrice() {
        return adhesionPrice;
    }

    public void setAdhesionPrice(double adhesionPrice) {
        this.adhesionPrice = adhesionPrice;
    }

    public Boolean getAdhesionSubscription() {
        return AdhesionSubscription;
    }

    public void setAdhesionSubscription(Boolean adhesionSubscription) {
        AdhesionSubscription = adhesionSubscription;
    }

    public Boolean getCrowdfundingSubscription() {
        return CrowdfundingSubscription;
    }

    public void setCrowdfundingSubscription(Boolean crowdfundingSubscription) {
        CrowdfundingSubscription = crowdfundingSubscription;
    }

    public Boolean getShopSubscription() {
        return ShopSubscription;
    }

    public void setShopSubscription(Boolean shopSubscription) {
        ShopSubscription = shopSubscription;
    }
}
