package net.golovach.firstspringsecurityapp.controllers;

import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.models.Role;
import net.golovach.firstspringsecurityapp.security.PersonDetails;
import net.golovach.firstspringsecurityapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FController {

    private final PersonService personService;

    @Autowired
    public FController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String hello(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        if(personDetails.person().getRole().equals(Role.ROLE_ADMIN)) {
            return "redirect:/admin/"+personDetails.getUsername();
        }
        model.addAttribute("info",personDetails.person());

        return "userPage/hello";
    }

    @GetMapping("/admin/{username}")
    public String adminPage(Model model, @PathVariable("username") String username ,@ModelAttribute("person") Person person){

        model.addAttribute("admin",personService.findPerson(username).get());
        model.addAttribute("people",personService.showAllPeople("role"));
        return "adminPage/admin";
    }
    @DeleteMapping("/admin/{username}/delete/{id}")
    public String adminDeletePerson(@PathVariable("id") int id, @PathVariable("username") String username){
        personService.deletePerson(id);

        return "redirect:/admin/"+username;
    }
    @PatchMapping("/admin/{username}/make_admin/{id}")
    public String giveRoleAdmin(@PathVariable("id") int id, @PathVariable("username") String username){
        personService.makeAdminRole(id);

        return "redirect:/admin/"+username;

    }

}
