package net.golovach.firstspringsecurityapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.models.Role;
import net.golovach.firstspringsecurityapp.security.PersonDetails;
import net.golovach.firstspringsecurityapp.services.PersonService;
import net.golovach.firstspringsecurityapp.services.WeatherAPIService;
import net.golovach.firstspringsecurityapp.util.DontExistCityException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class FController {

    private final PersonService personService;
    private final ModelMapper modelMapper;
    private final WeatherAPIService weatherAPIService;

    @Autowired
    public FController(PersonService personService, ModelMapper modelMapper, WeatherAPIService weatherAPIService) {
        this.personService = personService;
        this.modelMapper = modelMapper;
        this.weatherAPIService = weatherAPIService;
    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value = "city",defaultValue = "Севастополь") String city) throws DontExistCityException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        if(personDetails.person().getRole().equals(Role.ROLE_ADMIN)) {
            return "redirect:/admin/"+personDetails.getUsername();
        }
        try {
            model.addAttribute("weatherResponse",weatherAPIService.getWeather(city));
        }catch (DontExistCityException e){
            model.addAttribute("error_message",e.getMessage());
            model.addAttribute("weatherResponse",weatherAPIService.getWeather(weatherAPIService.getCity()));
            model.addAttribute("city",weatherAPIService.getCity());
        }
        model.addAttribute("info",personDetails.person());

        return "userPage/hello";
    }
    @GetMapping("/guest_page")
    public String guestPage(Model model, @ModelAttribute("person") Person person,
                            @RequestParam(value = "city",defaultValue = "Севастополь") String city) throws DontExistCityException {
        try {
            model.addAttribute("weatherResponse",weatherAPIService.getWeather(city));
        }catch (DontExistCityException e){
            model.addAttribute("error_message",e.getMessage());
            model.addAttribute("weatherResponse",weatherAPIService.getWeather(weatherAPIService.getCity()));
            model.addAttribute("city",weatherAPIService.getCity());
        }

        person.setRole(Role.ROLE_GUEST);
        person.setUsername("Гость");
        model.addAttribute("info", person);
        return "guestPage/guest_page";
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
    @GetMapping("/error")
    public String errorPage(HttpServletRequest request, HttpStatus status, Model model){
        model.addAttribute("errorMsg",status.getReasonPhrase());

        return "errorPage/error_page";
    }

}
