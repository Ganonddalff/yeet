package fr.isika.cda.managedbeans.association;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AssociationService;

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
    private Boolean wantAdhesion;
    private Boolean wantCrowdfunding;
    private Boolean wantShop;

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
    public String subscribe(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Association association = associationService.findById((Long) session.getAttribute("idAssociation")).get();

        if(!association.getAdhesionSubscription() && wantAdhesion){
            subscribeToAdhesion(association);
        }
        if (!association.getCrowdfundingSubscription() && wantCrowdfunding){
            subscribeToCrowdfunding(association);
        }
        if (!association.getShopSubscription()&&wantShop){
            subscribeToShop(association);
        }
        associationService.update(association);
        return "/association/AssociationProfileManagement.xhtml?faces-redirect=true";
    }
    public void subscribeToAdhesion(Association association){

        association.setAdhesionSubscription(true);
    }

    public void subscribeToCrowdfunding(Association association){
        association.setCrowdfundingSubscription(true);
    }

    public void subscribeToShop(Association association){
        association.setShopSubscription(true);
    }

    public String uploadProfileImage(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "profileImage_" + ((Long) session.getAttribute("idAssociation")).toString() + "." +
                uploadedProfileImage.getSubmittedFileName().substring(uploadedProfileImage.getSubmittedFileName().lastIndexOf('.') + 1);
        try {
            InputStream myInputStream = uploadedProfileImage.getInputStream();
            ServletContext servletContext = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
            File newFile = new File(servletContext.getRealPath("/resources/images/profileImages"), fileName);
            newFile.createNewFile();
            Path newPath = newFile.toPath();
            Files.copy(myInputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Association association = associationService.findById((Long) session.getAttribute("idAssociation")).get();
        association.setProfileImage("/resources/images/profileImages/" + fileName);
        associationService.update(association);
        this.profileImagePath = getProfileImage();
        return "/association/AssociationProfileManagement.xhtml?faces-redirect=true";
    }

    public String uploadBanner() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String fileName = "banner_" + ((Long) session.getAttribute("idAssociation")).toString() + "." +
                uploadedBanner.getSubmittedFileName().substring(uploadedBanner.getSubmittedFileName().lastIndexOf('.') + 1);
        try {
            InputStream myInputStream = uploadedBanner.getInputStream();
            ServletContext servletContext = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
            File newFile = new File(servletContext.getRealPath("/resources/images/banners"), fileName);
            newFile.createNewFile();
            Path newPath = newFile.toPath();
            Files.copy(myInputStream, newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Association association = associationService.findById((Long) session.getAttribute("idAssociation")).get();
        association.setBanner("/resources/images/banners/" + fileName);
        associationService.update(association);
        this.bannerPath = getBanner();
        return "/association/AssociationProfileManagement.xhtml?faces-redirect=true";
    }

    public void saveDescription() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Association association = associationService.findById((Long) session.getAttribute("idAssociation")).get();
        association.setDescription(this.description);
        associationService.update(association);
        this.description = getDescription();
    }

    public String getProfileImage() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("idAssociation")).get().getProfileImage();
    }

    public String getBanner(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("idAssociation")).get().getBanner();
    }

    public String getDescription(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return associationService.findById((Long)session.getAttribute("idAssociation")).get().getDescription();
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

    public Boolean getWantAdhesion() {
        return wantAdhesion;
    }

    public void setWantAdhesion(Boolean wantAdhesion) {
        this.wantAdhesion = wantAdhesion;
    }

    public Boolean getWantCrowdfunding() {
        return wantCrowdfunding;
    }

    public void setWantCrowdfunding(Boolean wantCrowdfunding) {
        this.wantCrowdfunding = wantCrowdfunding;
    }

    public Boolean getWantShop() {
        return wantShop;
    }

    public void setWantShop(Boolean wantShop) {
        this.wantShop = wantShop;
    }
}
