package fr.isika.cda.spring.controllers;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.spring.services.AccountService;
import fr.isika.cda.spring.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class AssociationController {
    @Autowired
    AssociationService associationService;
    @Autowired
    AccountService accountService;

    @GetMapping("/association/list")
    public String associationList(Model model) {
        List<Account> listAssociationAccount = accountService.search("Association");
        System.out.println("88888888888888888888" + listAssociationAccount.get(0) + "88888888888888888888888888888888888888888888888888888888888888888888888888888");
        model.addAttribute("listAssociationAccount", listAssociationAccount);
        return "views/association/list";
    }
}
