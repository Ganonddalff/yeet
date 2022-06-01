package fr.isika.cda.model.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ne doit pas être nulle.")
    private Double ContributionAmount;

    @NotNull
    private Date DateContribution;

    @ManyToOne
    private Account account;

    @ManyToOne
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
}
