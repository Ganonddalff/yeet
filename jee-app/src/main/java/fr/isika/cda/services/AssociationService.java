package fr.isika.cda.services;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.repositories.AssociationRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class AssociationService {
    @Inject
    private AssociationRepository associationRepository;

    public AssociationService() {
    }

    public Association update(Association association){
        return associationRepository.update(association);
    }
    public Optional<Association> findById(Long id) {
        return associationRepository.findById(id);
    }

    public List<Association> findAll() {
        return associationRepository.findAll();
    }
}
