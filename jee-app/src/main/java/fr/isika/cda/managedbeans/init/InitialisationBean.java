package fr.isika.cda.managedbeans.init;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.enumeration.ProjectType;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@ManagedBean
@ApplicationScoped
public class InitialisationBean implements Serializable {
    @Inject
    private AccountService accountService;
    @Inject
    private AssociationService associationService;
    @Inject
    private ProjectService projectService;

    @PostConstruct
    public void startup() {
        Association asso = newAssociationAccount("E-enfance", "11/12/1995", "45976249851697",
                "Protection des enfants et des adolescents contre les risques liés à l'utilisation de tous moyens de communication interactifs (internet, téléphone mobile, ordinateur, télévision)",
                "/resources/images/profileImages/profileImage_1.jpeg",
                "/resources/images/banners/standardBanner.png",
                "eenfance", "123456", "eenfance@gmail.com", "0156915656",
                "11", "Rue des halles", "75000", "Paris","France");
        newProject("Pour l'enfance",
                17000,
                "22/06/2022",
                "29/06/2022",
                "Paris",
                ProjectType.Sport,
                asso,
                "Permettre à tous les enfants de E-Enfance l'accès à un club de sport pour la rentrée 2022.");
    }

    @PreDestroy
    public void shutdown() {
        // ...
    }

    public Association newAssociationAccount(String name, String date, String siret,
                                      String description, String profileImage, String banner,
                                      String identifier, String password,
                                      String email, String phoneNumber,
                                      String roadNumber, String road, String postalCode, String city, String country){

        AssociationAccountCreationForm form = new AssociationAccountCreationForm();
        form.getContact().setEmail(email);
        form.getContact().setPhoneNumber(phoneNumber);
        form.getAddress().setNumber(roadNumber);
        form.getAddress().setRoad(road);
        form.getAddress().setPostalCode(postalCode);
        form.getAddress().setCity(city);
        form.getAddress().setCountry(country);
        form.getAssociation().setName(name);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            form.getAssociation().setCreationDate(format.parse(date));
        } catch (ParseException e) {}
        form.getAssociation().setSiret(siret);
        form.getAccount().setIdentifier(identifier);
        form.getAccount().setPassword(password);
        Account account = accountService.createAssociationAccount(form);
        Association association = account.getAssociation();
        association.setDescription(description);
        association.setProfileImage(profileImage);
        association.setBanner(banner);
        return associationService.update(association);
    }

    public void newProject(String name, double raiseTarget, String startDate, String finishDate,
                           String location, ProjectType projectType,Association asso,String description){
        ProjectCreationForm form = new ProjectCreationForm();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            form.getProject().setStartDate(format.parse(startDate));
            form.getProject().setFinishDate(format.parse(finishDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        form.getProject().setName(name);
        form.getProject().setRaiseTarget(raiseTarget);
        form.getProject().setLocation(location);
        form.getProject().setProjectType(projectType);
        form.getProject().setDescription(description);
        form.getProject().setAssociation(asso);
        Project project = projectService.createProject(form);

    }

    public void ping(){}
}