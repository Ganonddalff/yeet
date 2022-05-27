package fr.isika.cda.managedbeans;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AssociationService;
import jdk.jfr.Description;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@ManagedBean
@ViewScoped
public class AssociationProfileManagementBean {
    private Part uploadedBanner;
    private Part uploadedProfileImage;
    private String bannerPath;
    private String profileImagePath;
    private String description;

    @Inject
    private AssociationService associationService;
    public AssociationProfileManagementBean(){
    }

    @PostConstruct
    public void init(){
        this.description = getDescription();
        this.bannerPath = getBanner();
        this.profileImagePath = getProfileImage();
    }

    public void uploadProfileImage(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "profileImage_" + ((Long) session.getAttribute("id")).toString() + "." +
                uploadedProfileImage.getSubmittedFileName().substring(uploadedProfileImage.getSubmittedFileName().lastIndexOf('.') + 1);
        try {
            InputStream myInputStream = uploadedProfileImage.getInputStream();
            ServletContext servletContext = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
            File newFile = new File(servletContext.getRealPath("/resources/images/profileImages"), fileName);
            newFile.createNewFile();
            Path newPath = newFile.toPath();
            System.out.println(newPath);
            Files.copy(myInputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Association association = associationService.findById((Long) session.getAttribute("id")).get();
        association.setProfileImage("/resources/images/profileImages/" + fileName);
        associationService.update(association);
        this.profileImagePath = getProfileImage();
    }

    public void uploadBanner() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "banner_" + ((Long) session.getAttribute("id")).toString() + "." +
                uploadedBanner.getSubmittedFileName().substring(uploadedBanner.getSubmittedFileName().lastIndexOf('.') + 1);
        File savedFile = new File("/resources/images/banners", fileName);
        try (InputStream input = uploadedBanner.getInputStream()) {
            Files.copy(input, savedFile.toPath());
        }
        catch (IOException e) {
        }
        Association association = associationService.findById((Long) session.getAttribute("id")).get();
        association.setBanner("/resources/images/banners/" + fileName);
        associationService.update(association);
        this.bannerPath = getBanner();
    }

    public void saveDescription() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Association association = associationService.findById((Long) session.getAttribute("id")).get();
        association.setDescription("test");
        associationService.update(association);
        this.description = getDescription();
    }

    public String getProfileImage() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("id")).get().getProfileImage();
    }

    public String getBanner(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("id")).get().getBanner();
    }

    public String getDescription(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("id")).get().getDescription();
    }

    public Part getUploadedBanner() {
        return uploadedBanner;
    }

    public void setUploadedBanner(Part uploadedBanner) {
        this.uploadedBanner = uploadedBanner;
    }

    public Part getUploadedProfileImage() {
        return uploadedProfileImage;
    }

    public void setUploadedProfileImage(Part uploadedProfileImage) {
        this.uploadedProfileImage = uploadedProfileImage;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
