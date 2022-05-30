package fr.isika.cda.managedbeans.association;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.viewmodels.association.AssociationListViewmodel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class AssociationProfileBean implements Serializable{
    private Long id;
    private Association association;


    @Inject
    private AssociationService associationService;

    public AssociationProfileBean(){
    }

    public void init(){
        this.association = associationService.findById(this.id).get();
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
