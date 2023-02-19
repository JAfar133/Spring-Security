package net.golovach.firstspringsecurityapp.validators;

import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(personService.findPerson(person.getUsername()).isPresent()){
            errors.rejectValue("username","","username already exist");
        }
        if(errors.hasFieldErrors("dateOfBirth")){

            errors.rejectValue("dateOfBirth","","please enter correct date");
        }
    }
}
