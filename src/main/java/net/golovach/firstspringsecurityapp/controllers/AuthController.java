package net.golovach.firstspringsecurityapp.controllers;

import jakarta.validation.Valid;
import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.services.PersonDetailsService;
import net.golovach.firstspringsecurityapp.services.PersonService;
import net.golovach.firstspringsecurityapp.validators.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonDetailsService personDetailsService;
    private final PersonValidator personValidator;
    private final PersonService personService;

    @Autowired
    public AuthController(PersonDetailsService personDetailsService, PersonValidator personValidator, PersonService personService) {
        this.personDetailsService = personDetailsService;
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/signin")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/signin";
    }

    @PostMapping("/signin")
    public String performRegistration(@ModelAttribute("person1") @Valid Person person,
                                      BindingResult bindingResult){
        personValidator.validate(person,bindingResult);
        if(bindingResult.hasErrors()){
            return "auth/signin";
        }
        personService.savePerson(person);
        return "redirect:/hello";
    }
}
