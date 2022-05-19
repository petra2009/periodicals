package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.service.EditionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/editions")
public class EditionController {

    private EditionService editionService;


    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping("/all")
    public String getAllEdition(Model model) {
        List<Edition> editionList = editionService.findAllEdition();
        model.addAttribute("editList", editionList);
        return "editions";
    }

    @GetMapping("/edition")
    public String getByIdEdition (Model model, @RequestParam("id") int id) {
        List<Edition> editionList = editionService.findAllEdition();
        Edition edition = editionList.stream().filter(e -> e.getId()==id).findFirst().orElse(null);
        model.addAttribute("someEdition", edition);
        System.out.println(edition);
        return "description";
    }
}
