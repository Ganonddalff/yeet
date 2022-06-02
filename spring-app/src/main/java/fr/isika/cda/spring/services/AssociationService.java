package fr.isika.cda.spring.services;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.spring.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssociationService {
    @Autowired
    AssociationRepository associationRepository;

    public void save(Association association) {
        associationRepository.save(association);
    }

    public List<Association> listAll() {
        return (List<Association>) associationRepository.findAll();
    }

    public Association get(Long id) {
        return associationRepository.findById(id).get();
    }

    public void delete(Long id) {
        associationRepository.deleteById(id);
    }

    public List<Association> search(String keyword) {
        return associationRepository.search(keyword);
    }
}
