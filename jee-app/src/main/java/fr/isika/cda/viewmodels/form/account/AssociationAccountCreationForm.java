package fr.isika.cda.viewmodels.form.account;

import fr.isika.cda.model.entities.*;
import fr.isika.cda.model.factories.implementation.AssociationFactoryImpl;

public class AssociationAccountCreationForm extends AccountCreationForm{
    private Association association;

    public AssociationAccountCreationForm(){
        super();
        this.association = AssociationFactoryImpl.getInstance().getAssociation();
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
