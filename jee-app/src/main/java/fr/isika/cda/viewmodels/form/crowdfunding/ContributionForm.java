package fr.isika.cda.viewmodels.form.crowdfunding;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.factories.implementation.ContributionFactoryImpl;
import fr.isika.cda.model.factories.implementation.FundRaisingFactoryImpl;
import fr.isika.cda.model.factories.implementation.ProjectFactoryImpl;

public class ContributionForm {
    private Project project;
    private FundRaising fundRaising;
    private Contribution contribution;

    public ContributionForm(){
        this.fundRaising = FundRaisingFactoryImpl.getInstance().getFundRaising();
        this.project = ProjectFactoryImpl.getInstance().getProject();
        this.contribution = ContributionFactoryImpl.getInstance().getContribution();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public FundRaising getFundRaising() {
        return fundRaising;
    }

    public void setFundRaising(FundRaising fundRaising) {
        this.fundRaising = fundRaising;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }
}
