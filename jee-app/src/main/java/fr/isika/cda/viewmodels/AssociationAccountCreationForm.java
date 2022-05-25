package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.*;
import fr.isika.cda.model.factories.implementation.AssociationFactoryImpl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class AssociationAccountCreationForm extends AccountCreationForm{
    private Association association;

    public AssociationAccountCreationForm(){
        super();
        this.association = AssociationFactoryImpl.getInstance().getAssociation();
    }

    public void fill(){
        this.association.setName("assoTest");
        this.association.setSiret("12345678912345");
        this.contact.setEmail("assoTest@gmail.com");
        this.contact.setPhoneNumber(("0607080910"));
        this.address.setNumber("125");
        this.address.setRoad("Avenue de la république");
        this.address.setPostalCode("75000");
        this.address.setCity("Paris");
        this.address.setCountry("France");
        this.account.setIdentifier("assoTest");
        this.account.setPassword("123456");
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
