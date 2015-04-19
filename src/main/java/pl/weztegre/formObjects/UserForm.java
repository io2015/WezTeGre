package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import pl.weztegre.models.User;
import pl.weztegre.validators.FieldMatch;
import pl.weztegre.validators.Unique;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

@FieldMatch(first = "passwordConfirmation", second = "password", message = "Hasła muszą być takie same.")
public class UserForm {
    @Email(message = "To nie jest poprawny email")
    @NotEmpty(message = "Email nie może być pusty.")
    @Unique(clas = User.class, column = "email", message = "Taki email już istnieje")
    private String email;

    @Length(min = 3, max = 30, message = "Długość imienia musi zawierać się w przedziale 3-30.")
    private String name;

    @Length(min = 3, max = 30, message = "Długość nazwiska musi zawierać się w przedziale 3-30.")
    private String surname;

    @Pattern(regexp = "^\\w{4,30}$", message = "Hasło musi zawierać co najmniej 4 znaki i maksymalnie 30-ści znaków. Może składać się jedynie z liter, cyfr i znaków podkreslenia '_'.")
    private String password;

    private String passwordConfirmation;

    public UserForm() {
    }

    public UserForm(String email, String name, String surname, String password, String passwordConfirmation) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserForm userForm = (UserForm) o;

        if (email != null ? !email.equals(userForm.email) : userForm.email != null) return false;
        if (name != null ? !name.equals(userForm.name) : userForm.name != null) return false;
        if (surname != null ? !surname.equals(userForm.surname) : userForm.surname != null) return false;
        if (password != null ? !password.equals(userForm.password) : userForm.password != null) return false;
        return !(passwordConfirmation != null ? !passwordConfirmation.equals(userForm.passwordConfirmation) : userForm.passwordConfirmation != null);

    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordConfirmation != null ? passwordConfirmation.hashCode() : 0);
        return result;
    }
}
