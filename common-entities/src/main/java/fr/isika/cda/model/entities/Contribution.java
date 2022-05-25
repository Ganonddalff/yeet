package fr.isika.cda.model.entities;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ne doit pas être nulle.")
    @Size(min=1,max=100000,message = "1 euro au minimum, fais pas ton radin.")
    private Double ContributionAmount;

    @NotNull
    private Date DateContribution;

    @NotNull
    private int ContributorId;

    private Account account;

    private int FundRaisingId;

    private FundRaising fundRaising;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getContributionAmount() {
        return ContributionAmount;
    }

    public void setContributionAmount(Double contributionAmount) {
        ContributionAmount = contributionAmount;
    }

    public Date getDateContribution() {
        return DateContribution;
    }

    public void setDateContribution(Date dateContribution) {
        DateContribution = dateContribution;
    }

    public int getContributorId() {
        return ContributorId;
    }

    public void setContributorId(int contributorId) {
        ContributorId = contributorId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getFundRaisingId() {
        return FundRaisingId;
    }

    public void setFundRaisingId(int fundRaisingId) {
        FundRaisingId = fundRaisingId;
    }

    public FundRaising getFundRaising() {
        return fundRaising;
    }

    public void setFundRaising(FundRaising fundRaising) {
        this.fundRaising = fundRaising;
    }
}
