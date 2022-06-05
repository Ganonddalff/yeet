package fr.isika.cda.managedbeans.dashboard;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.CommandService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.dashboard.StatsViewmodel;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class StatsBean {
    private StatsViewmodel stats;

    @Inject
    private AssociationService associationService;
    @Inject
    private AccountService accountService;
    @Inject
    private ProjectService projectService;
    @Inject
    private CommandService commandService;

    public StatsBean(){
        this.stats = new StatsViewmodel();
    }

    public void init(){
        this.stats.setAssociationNumber(accountService.getAllAssociationAccount().size());
        this.stats.setUserNumber(accountService.getAllUserAccount().size());
        this.stats.setTotalContribution(projectService.totalSum());
        this.stats.setTotalShopSales(commandService.totalSales());

        List<Association> allAsso = associationService.findAll();
        for(Association asso : allAsso){
            if(asso.getAdhesionSubscription() || asso.getShopSubscription() || asso.getCrowdfundingSubscription()) {
                int numberService = 0;
                this.stats.setAssociationsWithSubs(this.stats.getAssociationsWithSubs() + 1);
                if (asso.getAdhesionSubscription()) {
                    numberService++;
                    this.stats.setNumberAdhesionService(this.stats.getNumberAdhesionService() + 1);
                }
                if (asso.getShopSubscription()) {
                    numberService++;
                    this.stats.setNumberShopService(this.stats.getNumberShopService() + 1);
                }
                if (asso.getCrowdfundingSubscription()) {
                    numberService++;
                    this.stats.setNumberCrowdfundingService(this.stats.getNumberCrowdfundingService() + 1);
                }
                if(numberService==1) this.stats.setSubWithOneService(this.stats.getSubWithOneService()+1);
                if(numberService==2) this.stats.setSubWithTwoServices(this.stats.getSubWithTwoServices()+1);
                if(numberService==3) this.stats.setSubWithThreeServices(this.stats.getSubWithThreeServices()+1);
                this.stats.setTotalServices(this.stats.getTotalServices()+numberService);
            }
        }
        this.stats.setTotalEarnings(this.stats.getTotalServices()*15);
    }

    public StatsViewmodel getStats(){
        return stats;
    }

    public void setStats(StatsViewmodel stats) {
        this.stats = stats;
    }
}
