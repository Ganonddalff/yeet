package fr.isika.cda.managedbeans.crowdfunding;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.IIOException;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@ManagedBean
@ViewScoped
public class ProjectCreationBean implements Serializable {
    private ProjectCreationForm projectCreationForm;
    private Part uploadedIllustration;
    private Part uploadedBanner;
    private String illustrationPath;
    private String bannerPath;
    @Inject
    private AssociationService associationService;

    @Inject
    private ProjectService projectService;
    public ProjectCreationBean(){
        this.projectCreationForm = new ProjectCreationForm();
    }

    public String create(){
        uploadProjectIllustration();
        uploadProjectBanner();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.projectCreationForm.getProject().setAssociation(associationService.findById((Long) session.getAttribute("idAssociation")).get());
        this.projectCreationForm.getProject().setProjectIllustration(this.illustrationPath);
        this.projectCreationForm.getProject().setProjectBanner(this.bannerPath);
        projectService.createProject(this.projectCreationForm);
        return "/crowdfunding/CrowdfundingManagement?faces-redirect=true";
    }

    public ProjectCreationForm getProjectCreationForm() {
        return projectCreationForm;
    }

    public void setProjectCreationForm(ProjectCreationForm projectCreationForm) {
        this.projectCreationForm = projectCreationForm;
    }

    public void uploadProjectIllustration(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "projectIllustration_"+((Long) session.getAttribute("idAssociation")).toString()+"."+
                uploadedIllustration.getSubmittedFileName().substring(uploadedIllustration.getSubmittedFileName().lastIndexOf('.')+1);
        try{
            InputStream inputStream = uploadedIllustration.getInputStream();
            ServletContext servletContext =((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
            File newFile = new File(servletContext.getRealPath("/resources/images/crowdfunding/"), fileName);
            newFile.createNewFile();
            Path newPath = newFile.toPath();
            Files.copy(inputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
            this.illustrationPath = "/resources/images/crowdfunding/"+fileName;
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public void uploadProjectBanner(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "banner_"+((Long) session.getAttribute("idAssociation")).toString()+"."+uploadedBanner.getSubmittedFileName().substring(uploadedBanner.getSubmittedFileName().lastIndexOf('.')+1);
        try{
            InputStream inputStream = uploadedBanner.getInputStream();
            ServletContext servletContext =((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
            File newFile = new File(servletContext.getRealPath("/resources/images/crowdfunding/"), fileName);
            newFile.createNewFile();
            Path newPath = newFile.toPath();
            Files.copy(inputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
            this.bannerPath = "/resources/images/crowdfunding/"+fileName;
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public ProjectService getProjectCreationService() {
        return projectService;
    }

    public Part getUploadedIllustration() {
        return uploadedIllustration;
    }

    public void setUploadedIllustration(Part uploadedIllustration) {
        this.uploadedIllustration = uploadedIllustration;
    }

    public Part getUploadedBanner() {
        return uploadedBanner;
    }

    public void setUploadedBanner(Part uploadedBanner) {
        this.uploadedBanner = uploadedBanner;
    }

    public String getIllustrationPath() {
        return illustrationPath;
    }

    public void setIllustrationPath(String illustrationPath) {
        this.illustrationPath = illustrationPath;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public void setProjectCreationService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
