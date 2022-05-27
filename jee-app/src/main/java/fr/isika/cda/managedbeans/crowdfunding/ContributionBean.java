package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.services.ContributionService;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ContributionBean implements Serializable {
    private ContributionForm contributionForm;
    @Inject
    private ContributionService contributionService;

    public ContributionBean(){
        this.contributionForm = new ContributionForm();
    }
    public void create(){

    }
}
