package com.moroz.randomquote.controller;

import com.moroz.randomquote.model.Quote;
import com.moroz.randomquote.service.QuouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class QuotesController {

    private final QuouteService quouteService;

    public QuotesController(QuouteService quouteService) {
        this.quouteService = quouteService;
    }

    @GetMapping("random")
    public String getRandomQuote(Model model) {
        Quote quote = quouteService.getSingleQuote();
        model.addAttribute("quote", quote);
        return "index";
    }
}
