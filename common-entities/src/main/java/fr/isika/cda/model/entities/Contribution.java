package fr.isika.cda.model.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ne doit pas être nulle.")
    private Double contributionAmount;

    @NotNull
    private Date dateContribution;

    @ManyToOne
    private Account account;

    @ManyToOne
    private FundRaising fundRaising;

    @ManyToOne
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(Double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public Date getDateContribution() {
        return dateContribution;
    }

    public void setDateContribution(Date dateContribution) {
        this.dateContribution = dateContribution;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public FundRaising getFundRaising() {
        return fundRaising;
    }

    public void setFundRaising(FundRaising fundRaising) {
        this.fundRaising = fundRaising;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
