package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.crowdfunding.ProjectsListViewModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
@ManagedBean
@ViewScoped
public class ProjectsListBean implements Serializable {
    private ProjectsListViewModel viewModel;
    @Inject
    private ProjectService projectService;
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
