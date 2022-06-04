package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.crowdfunding.ProjectsListViewModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProjectsListBean implements Serializable {
    private ProjectsListViewModel viewModel;
    @Inject
    private ProjectService projectService;

    private List<Project> projectsList;
    public ProjectsListBean(){}
    @PostConstruct
    public void init(){
        this.viewModel = new ProjectsListViewModel(projectService.findAll());

    }
    public ProjectsListViewModel getViewModel(){
        return viewModel;
    }

    public void setViewModel (ProjectsListViewModel viewModel){
        this.viewModel = viewModel;
    }

}
