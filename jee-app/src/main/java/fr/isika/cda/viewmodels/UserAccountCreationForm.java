package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Address;
import fr.isika.cda.model.entities.Contact;
import fr.isika.cda.model.entities.Person;

import java.sql.Date;

public class UserAccountCreationForm {
    private Address address;

    private Contact contact;

    private Person person;

    private Account account;

    public UserAccountCreationForm(){
        this.account = new Account();
        this.address = new Address();
        this.person = new Person();
        this.contact = new Contact();
        this.reset();
    }

    public void reset(){
        this.person.setFirstName("");
        this.person.setLastName("");
        this.person.setDateOfBirth(null);
        this.contact.setEmail("");
        this.contact.setPhoneNumber("");
        this.address.setNumber("");
        this.address.setRoad("");
        this.address.setPostalCode("");
        this.address.setCity("");
        this.address.setCountry("");
        this.account.setPseudonym("");
        this.account.setPassword("");
    }

    public void fill(){
        this.person.setFirstName("Anne");
        this.person.setLastName("Hathaway");
        this.person.setDateOfBirth(Date.valueOf("1982-11-12"));
        this.contact.setEmail("anne@gmail.com");
        this.contact.setPhoneNumber(("0607080910"));
        this.address.setNumber("8");
        this.address.setRoad("Rue de bel air");
        this.address.setPostalCode("75000");
        this.address.setCity("Paris");
        this.address.setCountry("France");
        this.account.setPseudonym("Anatawé");
        this.account.setPassword("123456");
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
