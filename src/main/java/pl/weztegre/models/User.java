package pl.weztegre.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Length(min = 3, max = 30)
    private String nick;

    @NotNull
    @Length(min = 3, max = 30)
    private String name;

    @NotNull
    @Length(min = 3, max = 30)
    private String surname;

    @NotNull
    @Column(length = 60)
    private String password;

    @NotNull
    @Email
    @Size(max = 30)
    private String email;

    @Length(min = 3, max = 30)
    private String city;

    @Length(min = 9, max = 9)
    private String phoneNumber;

    @Length(min = 3, max = 50)
    private String address;

    @Length(min = 3, max = 30)
    private String skype;

    @Length(min = 3, max = 30)
    private String gaduGadu;

    @NotNull
    private Boolean enabled = false;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns =  {@JoinColumn(name = "idUser")}, inverseJoinColumns = {@JoinColumn(name = "idRole")})
    private List<Role> roles = new ArrayList<Role>();

    @ManyToMany
    @JoinTable(name = "users_resetedPassword", joinColumns =  {@JoinColumn(name = "idUser")}, inverseJoinColumns = {@JoinColumn(name = "idResetedPassword")})
    private List<ResetedPassword> resetedPasswords = new ArrayList<ResetedPassword>();

    public User(String nick, String name, String surname, String email, String password) {
        this.nick = nick;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (nick != null ? !nick.equals(user.nick) : user.nick != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (skype != null ? !skype.equals(user.skype) : user.skype != null) return false;
        if (gaduGadu != null ? !gaduGadu.equals(user.gaduGadu) : user.gaduGadu != null) return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
        return !(roles != null ? !roles.equals(user.roles) : user.roles != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (gaduGadu != null ? gaduGadu.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", skype='" + skype + '\'' +
                ", gaduGadu='" + gaduGadu + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
