package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.Person;
import fr.isika.cda.model.factories.implementation.PersonFactoryImpl;
import java.sql.Date;

public class UserAccountCreationForm extends AccountCreationForm{
    private Person person;

    public UserAccountCreationForm(){
        super();
        this.person = PersonFactoryImpl.getInstance().getPerson();
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
        this.account.setIdentifier("Anatawé");
        this.account.setPassword("123456");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
