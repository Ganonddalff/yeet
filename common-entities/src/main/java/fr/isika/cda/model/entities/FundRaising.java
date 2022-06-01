package fr.isika.cda.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FundRaising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double RaisedFunds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fundRaising", fetch = FetchType.EAGER)
    private List<Contribution> contributions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRaisedFunds() {
        return RaisedFunds;
    }

    public void setRaisedFunds(Double raisedFunds) {
        RaisedFunds = raisedFunds;
    }

    public void addContribution(Contribution contribution) {
        contribution.setFundRaising(this);
        this.contributions.add(contribution);
    }
}
