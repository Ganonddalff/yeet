package fr.isika.cda.viewmodels.crowdfunding;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ContributionViewModel {
    private Long projectId;
    private Project project;
    private Account account;
    private FundRaising fundRaising;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public FundRaising getFundRaising() {
        return fundRaising;
    }

    public void setFundRaising(FundRaising fundRaising) {
        this.fundRaising = fundRaising;
    }


}
