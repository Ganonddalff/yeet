package fr.isika.cda.managedbeans.init;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.enumeration.ProjectType;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.form.account.UserAccountCreationForm;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.annotation.PostConstruct;
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
        /*
         * Création de comptes utilisateurs
         */
        newUserAccount("Damien", "Parmenon", "08/10/1991", "MrDeaponnen", "aaaa",
                "parmenon.damien@gmail.com", "0677668054", "2", "Rue de bel air","45000", "Orléans", "France");
        newUserAccount("Fara", "Razanamanana", "01/01/2000", "Fara", "aaaa",
                "fara@gmail.com", "0666895422", "10", "Avenue des champs élysées","75000", "Paris", "France");
        newUserAccount("Mateusz", "Tirel", "01/01/2000", "Mateusz", "aaaa",
                "mateusz@gmail.com", "0654145414", "3", "Rue fleury","75000", "Paris", "France");
        newUserAccount("Fatoumata", "Kanfana", "01/01/2000", "Fatoumata", "aaaa",
                "Fatoumata@gmail.com", "0677668054", "7", "Rue des plantes","75000", "Paris", "France");
        newUserAccount("Billal", "benziane", "01/01/1991", "Billal", "aaaa",
                "Billal@gmail.com", "0643478855", "7", "Rue du colonel","92320", "Chatillon", "France");

        /*
         * Création de comptes associations
         */
        Association asso = newAssociationAccount("E-enfance", "11/12/1995", "45976249851697", 39.99D,
                "Protection des enfants et des adolescents contre les risques liés à l'utilisation de tous moyens de communication interactifs (internet, téléphone mobile, ordinateur, télévision)",
                "/resources/images/profileImages/profileImage_1.jpeg",
                "/resources/images/banners/standardBanner.png",
                "eenfance", "123456", "eenfance@gmail.com", "0156915656",
                "11", "Rue des halles", "75000", "Paris","France");
        Association asso2 = newAssociationAccount("Terres d'amitié", "17/02/2001", "45976249851697", 0D,
                "Lutter contre la faim et la malnutrition, informer le public sur les problèmes concernant le tiers monde, coopérer sanitairement en faveur du tiers monde.",
                "/resources/images/profileImages/profileImage_2.jpg",
                "/resources/images/banners/standardBanner.png",
                "terreamitie", "aaaa", "terramitie@gmail.com", "0478950181",
                "327", "Rue André Phillip", "69003", "Lyon", "France");

        /*
         * Création de projets
         */
        newProject("Permettre à tous les enfants de E-Enfance l'accès à un club de sport pour la rentrée 2022.",
                "Pour l'enfance", ProjectType.Sport, asso, "22/06/2022", "29/06/2022",
                "Paris", 17000);
    }

    public Association newAssociationAccount(String name, String date, String siret, Double adhesionPrice,
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
        form.getAssociation().setAdhesionPrice(adhesionPrice);
        form.getAccount().setIdentifier(identifier);
        form.getAccount().setPassword(password);
        Account account = accountService.createAssociationAccount(form);
        Association association = account.getAssociation();
        association.setDescription(description);
        association.setProfileImage(profileImage);
        association.setBanner(banner);
        return associationService.update(association);
    }

    public void newUserAccount(String firstname, String lastName, String date,
                                  String identifier, String password,
                                  String email, String phoneNumber,
                                  String roadNumber, String road, String postalCode, String city, String country){
        UserAccountCreationForm form = new UserAccountCreationForm();
        form.getContact().setEmail(email);
        form.getContact().setPhoneNumber(phoneNumber);
        form.getAddress().setNumber(roadNumber);
        form.getAddress().setRoad(road);
        form.getAddress().setPostalCode(postalCode);
        form.getAddress().setCity(city);
        form.getAddress().setCountry(country);
        form.getPerson().setFirstName(firstname);
        form.getPerson().setLastName(lastName);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            form.getPerson().setDateOfBirth(format.parse(date));
        } catch (ParseException e) {}
        form.getAccount().setIdentifier(identifier);
        form.getAccount().setPassword(password);
        accountService.createUserAccount(form);
    }

    public void newProject(String description, String name, ProjectType projectType, Association asso,
                           String startingDate, String finishDate, String location, double raiseTarget){
        ProjectCreationForm form = new ProjectCreationForm();
        form.getProject().setDescription(description);
        form.getProject().setName(name);
        form.getProject().setProjectType(projectType);
        form.getProject().setAssociation(asso);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            form.getProject().setStartDate(format.parse(startingDate));
            form.getProject().setFinishDate(format.parse(finishDate));
        } catch (ParseException e) {}
        form.getProject().setLocation(location);
        form.getProject().setRaiseTarget(raiseTarget);
        projectService.createProject(form);
    }

    public void ping(){}
}