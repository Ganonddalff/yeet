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

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
