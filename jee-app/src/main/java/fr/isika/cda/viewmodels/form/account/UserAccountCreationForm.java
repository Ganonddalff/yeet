package fr.isika.cda.viewmodels.form.account;

import fr.isika.cda.model.entities.Person;
import fr.isika.cda.model.factories.implementation.PersonFactoryImpl;

public class UserAccountCreationForm extends AccountCreationForm{
    private Person person;

    public UserAccountCreationForm(){
        super();
        this.person = PersonFactoryImpl.getInstance().getPerson();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
