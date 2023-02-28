package net.golovach.firstspringsecurityapp.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import net.golovach.firstspringsecurityapp.models.Person;
import net.golovach.firstspringsecurityapp.models.Role;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class PersonDTO {

    @NotEmpty
    @Size(min = 2, max = 100, message = "name length should be between 2 and 100 symbol")
    private String username;

    @NotEmpty
    @Size(min = 8, max = 100, message = "password length should be between 8 and 100 symbols")
    private String password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(fallbackPatterns = {"dd/MM/yyyy", "dd.MM.yyyy"})
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    public PersonDTO(String username, String password, Date dateOfBirth, Role role) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
