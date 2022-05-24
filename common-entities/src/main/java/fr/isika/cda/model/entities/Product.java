package fr.isika.cda.model.entities;

import fr.isika.cda.model.enumeration.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision=10, scale=2)
    private Double price;

    @NotNull(message = "Ne doit pas être null")
    @Size(min = 1, max = 25, message = "Doit contenir entre 1 et 25 caractères.")
    @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir de chiffre")
    private String manufacturingCountry;

    @Basic
    private Long stock;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @ManyToOne
    private Association association;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
