package net.golovach.firstspringsecurityapp.services;

import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.models.Role;
import net.golovach.firstspringsecurityapp.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepo personRepo, PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Person> findPerson(String name){
        return personRepo.findByUsername(name);
    }
    public Optional<Person> findPerson(int id){
        return personRepo.findById(id);
    }

    @Transactional
    public void savePerson(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(Role.ROLE_USER);
        personRepo.save(person);
    }
    public List<Person> showAllPeople(){
        return personRepo.findAll();
    }
    public List<Person> showAllPeople(String field){
        return personRepo.findAll(Sort.by(field));
    }
    @Transactional
    public void deletePerson(int id){
        findPerson(id).ifPresent(person->
            personRepo.delete(person));
    }
    @Transactional
    public void makeAdminRole(int id){
        findPerson(id).ifPresent(person ->
            person.setRole(Role.ROLE_ADMIN));
    }

}
