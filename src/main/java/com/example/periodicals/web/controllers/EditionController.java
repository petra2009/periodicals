package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.service.EditionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EditionController {

    private EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping("/edition/all")
    public String getAllEdition(Model model) {
        List<Edition> editionList = editionService.findAllEdition();
        model.addAttribute("editList", editionList);
        return "editions";
    }
}
