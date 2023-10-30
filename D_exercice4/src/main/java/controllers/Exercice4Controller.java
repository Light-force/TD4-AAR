package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exercice4Controller {

    @Autowired
    Facade facade;

    @RequestMapping("")
    public String hello(Model model) {
        model.addAttribute("FindById",facade.findById(1));
        model.addAttribute("PlusGrosseVenteQuantite",facade.plusGrosseVenteQuantite());
        model.addAttribute("PLusGrosseVenteMontant",facade.plusGrosseVenteMontant());
        model.addAttribute("StockSous",facade.stockSous(23));
        model.addAttribute("ventesDe",facade.ventesDe(1));
        return("hello");
    }
}
