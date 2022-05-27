package fr.isika.cda.managedbeans.association;

import fr.isika.cda.services.AssociationService;
import fr.isika.cda.viewmodels.association.AssociationListViewmodel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class AssociationListBean implements Serializable{
        private AssociationListViewmodel viewmodel;

        @Inject
        private AssociationService associationService;

        public AssociationListBean(){
        }

        @PostConstruct
        public void init() {
                this.viewmodel = new AssociationListViewmodel(associationService.findAll());
        }

        public AssociationListViewmodel getViewmodel() {
                return viewmodel;
        }

        public void setViewmodel(AssociationListViewmodel viewmodel) {
                this.viewmodel = viewmodel;
        }
}
