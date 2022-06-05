package fr.isika.cda.viewmodels.dashboard;

public class StatsViewmodel {
    private int associationNumber;
    private int userNumber;
    private double totalShopSales;
    private double totalContribution;

    private int associationsWithSubs;

    private int subWithOneService;

    private int subWithTwoServices;

    private int subWithThreeServices;

    private int numberAdhesionService;

    private int numberShopService;

    private int numberCrowdfundingService;

    private int totalServices;
    private int totalEarnings;

    public StatsViewmodel(){
        this.associationNumber = 0;
        this.associationsWithSubs = 0;
        this.numberAdhesionService = 0;
        this.numberShopService = 0;
        this.numberCrowdfundingService = 0;
        this.subWithOneService = 0;
        this.subWithTwoServices = 0;
        this.subWithThreeServices = 0;
        this.totalEarnings = 0;
        this.totalServices = 0;
    }

    public int getAssociationNumber() {
        return associationNumber;
    }

    public void setAssociationNumber(int associationNumber) {
        this.associationNumber = associationNumber;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public double getTotalShopSales() {
        return totalShopSales;
    }

    public void setTotalShopSales(double totalShopSales) {
        this.totalShopSales = totalShopSales;
    }

    public double getTotalContribution() {
        return totalContribution;
    }

    public void setTotalContribution(double totalContribution) {
        this.totalContribution = totalContribution;
    }

    public int getAssociationsWithSubs() {
        return associationsWithSubs;
    }

    public void setAssociationsWithSubs(int associationsWithSubs) {
        this.associationsWithSubs = associationsWithSubs;
    }

    public int getSubWithOneService() {
        return subWithOneService;
    }

    public void setSubWithOneService(int subWithOneService) {
        this.subWithOneService = subWithOneService;
    }

    public int getSubWithTwoServices() {
        return subWithTwoServices;
    }

    public void setSubWithTwoServices(int subWithTwoServices) {
        this.subWithTwoServices = subWithTwoServices;
    }

    public int getSubWithThreeServices() {
        return subWithThreeServices;
    }

    public void setSubWithThreeServices(int subWithThreeServices) {
        this.subWithThreeServices = subWithThreeServices;
    }

    public int getNumberAdhesionService() {
        return numberAdhesionService;
    }

    public void setNumberAdhesionService(int numberAdhesionService) {
        this.numberAdhesionService = numberAdhesionService;
    }

    public int getNumberShopService() {
        return numberShopService;
    }

    public void setNumberShopService(int numberShopService) {
        this.numberShopService = numberShopService;
    }

    public int getNumberCrowdfundingService() {
        return numberCrowdfundingService;
    }

    public void setNumberCrowdfundingService(int numberCrowdfundingService) {
        this.numberCrowdfundingService = numberCrowdfundingService;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }
}
