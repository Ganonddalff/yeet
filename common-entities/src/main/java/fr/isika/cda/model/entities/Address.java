package fr.isika.cda.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 5, message = "Doit contenir entre 1 et 5 chiffres.")
    @Pattern(regexp = "^[0-9]*$", message = "Ne doit contenir que des chiffres")
    private String number;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 25, message = "Doit contenir entre 1 et 25 caractères.")
    private String road;

    @Size(min = 5, max = 10, message = "Doit contenir entre 1 et 10 chiffres.")
    @Pattern(regexp = "^[0-9]*$", message = "Ne doit contenir que des chiffres")
    private String postalCode;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 25, message = "Doit contenir entre 1 et 25 caractères.")
    @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir de chiffre")
    private String city;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 25, message = "Doit contenir entre 1 et 25 caractères.")
    @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir de chiffre")
    private String country;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
