package fr.isika.cda.model.entities;
import fr.isika.cda.model.enumeration.ProjectType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ce champ est obligatoire")
    @Size(min = 4, max = 25, message = "Doit contenir enter 4 et 25 caractères")
    private String name;

    @NotNull
    @Size(min=100,max=100000,message = "L'objectif doit être compris entre 100 et 100 000€.")
    private int RaiseTarget;

    @NotNull
    private Date startDate;
    @NotNull
    private Date finishDate;
    @NotNull
    private String location;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    private int projectAdminId;

    private int fundRaisingId;

    private int projectIllustration;
    @NotNull
    @Length(min = 20,max = 150,message = "La description doit comprendre entre 20 et 150 caractères.")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRaiseTarget() {
        return RaiseTarget;
    }

    public void setRaiseTarget(int raiseTarget) {
        RaiseTarget = raiseTarget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public fr.isika.cda.model.enumeration.ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(fr.isika.cda.model.enumeration.ProjectType projectType) {
        this.projectType = projectType;
    }

    public int getProjectAdminId() {
        return projectAdminId;
    }

    public void setProjectAdminId(int projectAdminId) {
        this.projectAdminId = projectAdminId;
    }

    public int getFundRaisingId() {
        return fundRaisingId;
    }

    public void setFundRaisingId(int fundRaisingId) {
        this.fundRaisingId = fundRaisingId;
    }

    public int getProjectIllustration() {
        return projectIllustration;
    }

    public void setProjectIllustration(int projectIllustration) {
        this.projectIllustration = projectIllustration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
