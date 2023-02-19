package net.golovach.firstspringsecurityapp.repo;

import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
    Optional<Person> findByUsername(String username);
    List<Person> findByRole(Role role);
}
