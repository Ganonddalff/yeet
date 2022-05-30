package fr.isika.cda.managedbeans.init;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@ApplicationScoped
public class InitialisationBean implements Serializable {
    @Inject
    private AccountService accountService;
    @Inject
    private AssociationService associationService;

    @PostConstruct
    public void startup() {
        newAssociationAccount("E-enfance", "11/12/1995", "45976249851697",
                "Protection des enfants et des adolescents contre les risques liés à l'utilisation de tous moyens de communication interactifs (internet, téléphone mobile, ordinateur, télévision)",
                "/resources/images/profileImages/profileImage_1.jpeg",
                "/resources/images/banners/standardBanner.png",
                "eenfance", "123456", "eenfance@gmail.com", "0156915656",
                "11", "Rue des halles", "75000", "Paris","France");
    }

    @PreDestroy
    public void shutdown() {
        // ...
    }

    public void newAssociationAccount(String name, String date, String siret,
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
        associationService.update(association);
    }

    public void ping(){}
}