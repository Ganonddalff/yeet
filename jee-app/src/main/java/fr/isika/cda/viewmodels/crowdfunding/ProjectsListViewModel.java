package fr.isika.cda.viewmodels.crowdfunding;

import fr.isika.cda.model.entities.Project;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectsListViewModel {
    private List<Project> projectsList;
    public ProjectsListViewModel(List<Project> list){
        this.projectsList = list;
    }
    public List<Project> getProjectsList(){
        return projectsList;
    }
    public List<Project> getProjectListByAssociation(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Long assoId = (Long) session.getAttribute("idAssociation");
        return this.projectsList.stream().filter(project -> project.getAssociation().getId().equals(assoId)).collect(Collectors.toList());
    }

    //this.projectsList.stream().map(project -> project.getAssociation().getId()).

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }
}
