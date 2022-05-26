package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.factories.implementation.FundRaisingFactoryImpl;
import fr.isika.cda.model.factories.implementation.ProjectFactoryImpl;

public class ProjectCreationForm {
    private Project project;
    protected FundRaising fundRaising;

    public ProjectCreationForm(){
        this.fundRaising = FundRaisingFactoryImpl.getInstance().getFundRaising();
        this.project= ProjectFactoryImpl.getInstance().getProject();
    }

    public FundRaising getFundRaising() {
        return fundRaising;
    }

    public void setFundRaising(FundRaising fundRaising) {
        this.fundRaising = fundRaising;
    }

    public Project getProject(){
        return project;
    }

    public void setProject(Project project){
        this.project=project;
    }
}
