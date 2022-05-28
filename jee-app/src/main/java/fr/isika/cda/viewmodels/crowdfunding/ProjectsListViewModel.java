package fr.isika.cda.viewmodels.crowdfunding;

import fr.isika.cda.model.entities.Project;

import java.util.List;

public class ProjectsListViewModel {
    private List<Project> projectsList;
    public ProjectsListViewModel(List<Project> list){
        this.projectsList = list;
    }
    public List<Project> getProjectsList(){
        return projectsList;
    }

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }
}
