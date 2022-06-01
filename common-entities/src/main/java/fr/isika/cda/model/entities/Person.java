package fr.isika.cda.model.entities;

import fr.isika.cda.model.enumeration.AccountCategory;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 25, message = "Le nombre de caractères doit être compris entre 1 et 25"	)
	@Pattern(regexp = "[^0-9]*", message = "Le prénom ne doit pas contenir de chiffre")
	private String firstName;

	@NotNull
	@Size(min = 1, max = 25, message = "Le nombre de caractères doit être compris entre 1 et 25")
	@Pattern(regexp = "[^0-9]*", message = "Le nom ne doit pas contenir de chiffre")
	private String lastName;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@NotNull
	@OneToOne(cascade = {CascadeType.ALL})
	private Contact contact;

	@NotNull
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
