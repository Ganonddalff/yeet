package fr.isika.cda.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class FundRaising {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 0,max = 100000)
    private Double RaisedFunds;

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
}
