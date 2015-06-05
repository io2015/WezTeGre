package pl.weztegre.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import pl.weztegre.validators.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String password;

    private String city;

    private String address;

    private String phoneNumber;

    private String skype;

    private String gaduGadu;

    @NotNull
    private Boolean enabled = false;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns =  {@JoinColumn(name = "idUser")}, inverseJoinColumns = {@JoinColumn(name = "idRole")})
    private List<Role> roles = new ArrayList<Role>();

    @ManyToMany
    @JoinTable(name = "users_resetedPasswords", joinColumns =  {@JoinColumn(name = "idUser")}, inverseJoinColumns = {@JoinColumn(name = "idResetedPassword")})
    private List<ResetedPassword> resetedPasswords = new ArrayList<ResetedPassword>();

    public User() {
    }

    public User(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getGaduGadu() {
        return gaduGadu;
    }

    public void setGaduGadu(String gaduGadu) {
        this.gaduGadu = gaduGadu;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<ResetedPassword> getResetedPasswords() {
        return resetedPasswords;
    }

    public void setResetedPasswords(List<ResetedPassword> resetedPasswords) {
        this.resetedPasswords = resetedPasswords;
    }

    @Override
    public String toString() {
        return name + surname + "(" + email + ")";
    }
}
