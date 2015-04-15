package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import pl.weztegre.validators.FieldMatch;

import javax.validation.constraints.Pattern;

@FieldMatch(first = "passwordConfirmation", second = "password", message = "Hasła muszą być takie same.")
public class UserForm {
    @Length(min = 3, max = 30, message = "Długość nicku musi zawierać się w przedziale 3-30.")
    private String nick;

    @Length(min = 3, max = 30, message = "Długość imienia musi zawierać się w przedziale 3-30.")
    private String name;

    @Length(min = 3, max = 30, message = "Długość nazwiska musi zawierać się w przedziale 3-30.")
    private String surname;

    @Pattern(regexp = "^\\w{4,30}$", message = "Hasło musi zawierać co najmniej 4 znaki i maksymalnie 30-ści znaków. Może składać się jedynie z liter, cyfr i znaków podkreslenia '_'.")
    private String password;

    private String passwordConfirmation;

    @Email(message = "To nie jest poprawny email")
    @NotEmpty(message = "Email nie może być pusty.")
    private String email;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
