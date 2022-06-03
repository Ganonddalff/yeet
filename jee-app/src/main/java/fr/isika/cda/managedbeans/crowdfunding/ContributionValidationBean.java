package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.ContributionService;
import fr.isika.cda.services.ProjectService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ContributionValidationBean {
    private long contributionId;

    private Contribution contribution;

    @Inject
    private ContributionService contributionService;
    @Inject
    private AccountService accountService;
    @Inject
    private ProjectService projectService;


    public ContributionValidationBean(){}

    public void init(){
        this.contribution = contributionService.findById(this.contributionId);
    }

    public long getContributionId() {
        return contributionId;
    }

    public void setContributionId(long contributionId) {
        this.contributionId = contributionId;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }
}
