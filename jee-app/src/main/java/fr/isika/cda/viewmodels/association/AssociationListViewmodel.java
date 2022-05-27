package fr.isika.cda.viewmodels.association;

import fr.isika.cda.model.entities.Association;

import java.util.List;

public class AssociationListViewmodel {
    private List<Association> associationList;

    public AssociationListViewmodel(List<Association> list){
        this.associationList = list;
    }

    public List<Association> getAssociationList() {
        return associationList;
    }

    public void setAssociationList(List<Association> associationList) {
        this.associationList = associationList;
    }
}
