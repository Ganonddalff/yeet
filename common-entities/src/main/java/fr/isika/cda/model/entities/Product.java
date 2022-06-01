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
    
    private String image;
    
    @NotNull
	@Size(min = 1, max = 25, message = "Le nombre de caractères doit être compris entre 1 et 25")
	@Pattern(regexp = "[^0-9]*", message = "Le nom ne doit pas contenir de chiffre")
	private String nameProduct;

    @Column(precision=10, scale=2)
    private Double price;

    @NotNull(message = "Ne doit pas être nul")
    @Size(min = 1, max = 25, message = "Doit contenir entre 1 et 25 caractères.")
    @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir de chiffre")
    private String manufacturingCountry;
    
    @NotNull(message = "Ne doit pas être nul")
    @Size(max = 500, message = "Doit contenir au plus 500 caractères.")
    private String description;

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

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
	
    
}

