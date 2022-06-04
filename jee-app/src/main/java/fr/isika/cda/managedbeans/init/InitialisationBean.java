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
        Association asso2 = newAssociationAccount("Terres d'amitié", "17/02/2001", "47565449851697", 0D,
                "Lutter contre la faim et la malnutrition, informer le public sur les problèmes concernant le tiers monde, coopérer sanitairement en faveur du tiers monde.",
                "/resources/images/profileImages/profileImage_1.jpg",
                "/resources/images/banners/standardBanner.png",
                "terreamitie", "aaaa", "terramitie@gmail.com", "0478950181",
                "327", "Rue André Phillip", "69003", "Lyon", "France");
        Association asso3 = newAssociationAccount("WWF", "39/04/1961", "72164654587456", 19.99D,
                "Le WWF ou Fonds mondial pour la nature est une organisation non gouvernementale internationale (ONGI) créée en 1961, vouée à la protection de l'environnement et au développement durable.",
                "/resources/images/profileImages/profileImage_3.png",
                "/resources/images/banners/standardBanner.png",
                "wwfasso", "aaaa", "wwf@gmail.com", "0246957112",
                "37", "Rue Baudin", "93310", "Le Pré-Saint-Gervais", "France");
        Association asso4 = newAssociationAccount("Les sauveteurs en mer", "17/02/2001", "64413002551697", 17.99D,
                "Les Sauveteurs en Mer effectuent les opérations de recherche en mer, assistent les navires en difficulté, évaluent l'état des personnes à secourir et leur donnent les premiers soins.",
                "/resources/images/profileImages/profileImage_4.jpg",
                "/resources/images/banners/standardBanner.png",
                "sauvenmer", "aaaa", "sauveteurenmer@gmail.com", "0541412398",
                "8", "Cité d'Antin", "75009", "Paris", "France");
        Association asso5 = newAssociationAccount("Sidaction", "11/02/1994", "54447891224597", 0D,
                "Lutter contre la faim et la malnutrition, informer le public sur les problèmes concernant le tiers monde, coopérer sanitairement en faveur du tiers monde.",
                "/resources/images/profileImages/profileImage_5.jpg",
                "/resources/images/banners/standardBanner.png",
                "Sidact", "aaaa", "sidaction@gmail.com", "0478950181",
                "228", "Rue du Faubourg Saint-Martin", "75010", "Paris", "France");
        Association asso6 = newAssociationAccount("Société Géologique de France", "17/02/2008", "74784414851697", 5.99D,
                "Concourir à l'avancement de la géologie en général et particulièrement de faire connaître le sol de la France tant en lui même que dans ses rapports avec les arts industriels et l'agriculture.",
                "/resources/images/profileImages/profileImage_6.jpg",
                "/resources/images/banners/standardBanner.png",
                "sgfasso", "aaaa", "sgf@gmail.com", "0544785465",
                "77", "Rue Claude Bernard", "75005", "Paris", "France");
        Association asso7 = newAssociationAccount("FFD", "08/10/1991", "45699631851697", 34.99D,
                "La Fédération Française des Diabétiques est une association de patients, au service des patients et dirigée par des patients.",
                "/resources/images/profileImages/profileImage_7.jpg",
                "/resources/images/banners/standardBanner.png",
                "FFDASSO", "aaaa", "ffd@gmail.com", "0578950181",
                "88", "Rue de la Roquette", "75011", "Paris", "France");
        Association asso8 = newAssociationAccount("Tous Au Sport", "12/08/2010", "46665249851697", 12.99D,
                "Cette association loi 1901 à but non lucratif, constituée le 25 juillet 2016, a pour objet de permettre l'accès le plus grand possible au sport à toutes et à tous et cela dans le cadre des cours collectifs.",
                "/resources/images/profileImages/profileImage_8.png",
                "/resources/images/banners/standardBanner.png",
                "tousausport", "aaaa", "tousausport@gmail.com", "0345651144",
                "5", "Rue du chateau", "68640", "Waldighoffen", "France");
        Association asso9 = newAssociationAccount("Energie jeunes", "03/09/2009", "77956632121587", 15D,
                "Notre combat, c’est la lutte pour l’égalité des chances par des actions de prévention du décrochage scolaire. Notre but est de permettre à tous les élèves d’aimer apprendre. Nous intervenons chaque année auprès de 120 000 élèves du CM2 à la 3e.",
                "/resources/images/profileImages/profileImage_9.jpg",
                "/resources/images/banners/standardBanner.png",
                "Energy", "aaaa", "energie_jeune@gmail.com", "0518185465",
                "12", "Rue Lord Byron", "75008", "Paris", "France");
        Association asso10 = newAssociationAccount("CCFD Terre solidaire", "14/11/1960", "31100012851697", 0D,
                "Le CCFD-Terre Solidaire agit depuis 60 ans aux côtés de celles et ceux qui luttent quotidiennement contre toutes les causes de la faim et qui font face aux injustices du modèle de développement actuel.",
                "/resources/images/profileImages/profileImage_10.jpg",
                "/resources/images/banners/standardBanner.png",
                "solidarity", "aaaa", "terresolidaire@gmail.com", "0238242825",
                "51", "Boulevard Aristide Briand", "45000", "Orléans", "France");

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