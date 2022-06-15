package com.example.periodicals.web.controllers;

import com.example.periodicals.dao.model.Application;
import com.example.periodicals.dao.model.Edition;
import com.example.periodicals.service.EditionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/editions")
public class EditionController {

    private EditionService editionService;
    private Application application;
    private final ListEditionService editionServiceImpl;

    @Autowired
    public EditionController(EditionService editionService, ListEditionService editionServiceImpl) {
        this.editionService = editionService;
        this.editionServiceImpl = editionServiceImpl;
    }

    @GetMapping("/all")
    public String getAllEdition(Model model) {
        List<Edition> editionList = editionService.findAllEdition();
        model.addAttribute("editList", editionList);
        return "editions";
    }

    @GetMapping("/{id}")
    public String getByIdEdition (Model model, @RequestParam("id") int id) {
        List<Edition> editionList = editionService.findAllEdition();
        Edition edition = editionList.stream().filter(e -> e.getId()==id).findFirst().orElse(null);
        model.addAttribute("someEdition", edition);
        return "description";
    }

    @PostMapping("/subscription")
    public String getAddEditionInApplication(@RequestParam("months") int months, @RequestParam("id") int editionId) {
        editionServiceImpl.addEditionToApplication(editionId, months);
        return "redirect:/editions/all";
    }





}
