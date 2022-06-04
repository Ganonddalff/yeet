package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.AccountService;
import fr.isika.cda.services.ContributionService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.crowdfunding.ContributionViewModel;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.function.Predicate;

@ManagedBean
@ViewScoped
public class ContributionBean implements Serializable {
    private ContributionForm contributionForm;
    @Inject
    private ContributionService contributionService;
    @Inject
    private AccountService accountService;
    @Inject
    private ProjectService projectService;
    private ContributionViewModel viewModel;


    private Long projectId;

    public ContributionBean(){
        this.contributionForm = new ContributionForm();
    }
    public void init(){
        this.viewModel = new ContributionViewModel();
        this.viewModel.setProject(this.projectService.findById(this.projectId).get());
        this.viewModel.setFundRaising(this.viewModel.getProject().getFundRaising());

    }
    public String create(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.contributionForm.getContribution().setAccount(accountService.findByIdentifier(session.getAttribute("identifier").toString()).get());
        this.contributionForm.setProject(viewModel.getProject());
        this.contributionForm.setFundRaising(viewModel.getFundRaising());
        this.contributionForm.getContribution().setFundRaising(viewModel.getFundRaising());
        this.contributionForm.getContribution().setProject(viewModel.getProject());
        Contribution contribution = contributionService.createContribution(this.contributionForm);
        session.setAttribute("idAsso", viewModel.getProject().getAssociation().getId());
        session.setAttribute("amount", this.contributionForm.getContribution().getContributionAmount());
        session.setAttribute("reason", "Contribution");
        session.setAttribute("idReason", contribution.getId());
        return "/payment/CreditCardPayment?faces-redirect=true";
    }

    public ContributionForm getContributionForm() {
        return contributionForm;
    }

    public void setContributionForm(ContributionForm contributionForm) {
        this.contributionForm = contributionForm;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
