package fr.isika.cda.services;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Adhesion;
import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.factories.implementation.AdhesionFactoryImpl;
import fr.isika.cda.repositories.AdhesionRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class AdhesionService {
    @Inject
    AdhesionRepository adhesionRepository;

    public AdhesionService(){}

    public Adhesion create(Association association, Account userAccount){
        Adhesion adhesion = AdhesionFactoryImpl.getInstance().getAdhesion();
        adhesion.setAssociation(association);
        adhesion.setAccount(userAccount);
        return adhesionRepository.create(adhesion);
    }

    public Optional<Adhesion> findById(Long adhesionId) {
        return adhesionRepository.findById(adhesionId);
    }
}
