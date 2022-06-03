package fr.isika.cda.managedbeans.init;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.model.enumeration.ProjectType;
import fr.isika.cda.model.entities.Product;
import fr.isika.cda.model.enumeration.ProductCategory;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.services.ProductService;
import fr.isika.cda.viewmodels.form.account.AssociationAccountCreationForm;
import fr.isika.cda.viewmodels.form.account.UserAccountCreationForm;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;
import fr.isika.cda.viewmodels.form.shop.ProductCreateForm;

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
    @Inject
    private ProductService productService;

    @PostConstruct
    public void startup() {
        /*
         * Création d'un compte Administrator
         */
        newAccount("Eleanor", "Rouze", "08/10/1991", "Admin", "Admin",
                "eleanor@gmail.com", "0439973106", "57", "Avenue Ferdinand de Lesseps","38100", "Grenoble", "France", AccountCategory.Administrator);

        /*
         * Création de comptes utilisateurs
         */
        newAccount("Damien", "Parmenon", "08/10/1991", "MrDeaponnen", "aaaa",
                "parmenon.damien@gmail.com", "0677668054", "2", "Rue de bel air","45000", "Orléans", "France", AccountCategory.User);
        newAccount("Fara", "Razanamanana", "01/01/2000", "Fara", "aaaa",
                "fara@gmail.com", "0666895422", "10", "Avenue des champs élysées","75000", "Paris", "France", AccountCategory.User);
        newAccount("Mateusz", "Tirel", "01/01/2000", "Mateusz", "aaaa",
                "mateusz@gmail.com", "0654145414", "3", "Rue fleury","75000", "Paris", "France", AccountCategory.User);
        newAccount("Fatoumata", "Kanfana", "01/01/2000", "Fatoumata", "aaaa",
                "Fatoumata@gmail.com", "0677668054", "7", "Rue des plantes","75000", "Paris", "France", AccountCategory.User);
        newAccount("Billal", "benziane", "01/01/1991", "Billal", "aaaa",
                "Billal@gmail.com", "0643478855", "7", "Rue du colonel","92320", "Chatillon", "France", AccountCategory.User);

        /*
         * Création de comptes associations
         */
        Association asso = newAssociationAccount("E-enfance", "11/12/1995", "45976249851697", 39.99D,
                "Protection des enfants et des adolescents contre les risques liés à l'utilisation de tous moyens de communication interactifs (internet, téléphone mobile, ordinateur, télévision)",
                "/resources/images/profileImages/standardProfileImage.jpeg",
                "/resources/images/banners/standardBanner.png",
                "eenfance", "123456", "eenfance@gmail.com", "0156915656",
                "11", "Rue des halles", "75000", "Paris","France");
        Association asso2 = newAssociationAccount("Terres d'amitié", "17/02/2001", "45976249851697", 0D,
                "Lutter contre la faim et la malnutrition, informer le public sur les problèmes concernant le tiers monde, coopérer sanitairement en faveur du tiers monde.",
                "/resources/images/profileImages/profileImage_1.jpg",
                "/resources/images/banners/standardBanner.png",
                "terreamitie", "aaaa", "terramitie@gmail.com", "0478950181",
                "327", "Rue André Phillip", "69003", "Lyon", "France");

        /*
         * Création de projets
         */
        newProject("Permettre à tous les enfants de E-Enfance l'accès à un club de sport pour la rentrée 2022.",
                "Pour l'enfance", ProjectType.Sport, asso, "22/06/2022", "29/06/2022",
                "Paris", 17000,"/resources/images/crowdfunding/kidSoccer.jpg","/resources/images/crowdfunding/KidSportBanner.jpg");

        //Initialisation de la boutique
        Product product1 = newProductInShop("Tableau", ProductCategory.Decoration, "/resources/images/produits/tableau.jpeg",
                100D, "France", 45L, asso, "Tableau avec un cadre flamme, ludique pour la "
                        + "décoration murale de votre petit bout'chou");
        Product product2 = newProductInShop("Jeu", ProductCategory.Jeu,"/resources/images/produits/jeuChevaux.jpeg", 
        		50D, "France", 25L, asso, "Les petits chevaux font partie des grands classiques des jeux de société");
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

    public void newAccount(String firstname, String lastName, String date,
                                  String identifier, String password,
                                  String email, String phoneNumber,
                                  String roadNumber, String road, String postalCode, String city, String country,
                                  AccountCategory accountCategory){
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
        if(accountCategory == AccountCategory.User)
            accountService.createUserAccount(form);
        else
            accountService.createAdminAccount(form);
    }

    public void newProject(String description, String name, ProjectType projectType, Association asso,
                           String startingDate, String finishDate, String location, double raiseTarget, String illustration, String banner){
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
        form.getProject().setProjectIllustration(illustration);
        form.getProject().setProjectBanner(banner);
        projectService.createProject(form);
    }

	public Product newProductInShop(String name, ProductCategory category, String image, Double price, String manufacturingCountry,
			Long stock, Association asso, String description){

		ProductCreateForm form = new ProductCreateForm();
		form.getProduct().setNameProduct(name);
		form.getProduct().setCategory(category);
		form.getProduct().setImage(image);
		form.getProduct().setManufacturingCountry(manufacturingCountry);
		form.getProduct().setPrice(price);
		form.getProduct().setStock(stock);
		form.getProduct().setDescription(description);
		return productService.createProduct(form, asso);
	}

	public void ping(){}
}