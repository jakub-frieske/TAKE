package lab.bookings.controllers;

import lab.bookings.models.Apartment;
import lab.bookings.repositories.ApartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/apartments")
public class ApartmentController {
    private ApartmentRepository repository;

    public ApartmentController(ApartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(new Apartment());
        model.addAttribute("apartments", repository.findAll());
        return "apartments";
    }

    @PostMapping
    public String createTable(@Valid Apartment apartment,
                              Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("apartments", repository.findAll());
            return "apartments";
        } else {
            repository.save(apartment);
            return "redirect:/apartments";
        }
    }
}