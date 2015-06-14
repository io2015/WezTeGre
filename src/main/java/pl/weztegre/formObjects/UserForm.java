package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import pl.weztegre.models.User;
import pl.weztegre.validators.FieldMatch;
import pl.weztegre.validators.Unique;

import javax.validation.constraints.Pattern;

/**
* Klasa UserFom obsługuje dane użytkowników.
*/
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

	/**
	* Konstruktor klasy
	*/
    public UserForm() {
    }

	
	/**
	* Konstruktor klasy
	* @param email Email użytkownika
	* @param name Imię użytkownika
	* @param surname Nazwisko użytkownika
	* @param password Hasło użytkownika
	* @param passwordConfirmation Ponownie wprowadzone hasło użytkownika
	*/
    public UserForm(String email, String name, String surname, String password, String passwordConfirmation) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

	/**
	* Metoda zwraca maila użytkownika
	*/
    public String getEmail() {
        return email;
    }

	/**
	* Metoda ustawia maila na podany
	* @param email Nowy mail użytkownika
	*/
    public void setEmail(String email) {
        this.email = email;
    }

	/**
	* Metoda zwraca imię użytkownika
	*/
    public String getName() {
        return name;
    }

	/**
	* Metoda ustawia imię użytkownika
	* @param name Nowe imię
	*/
    public void setName(String name) {
        this.name = name;
    }

	/**
	* Metoda zwraca nazwisko użytkownika
	*/
    public String getSurname() {
        return surname;
    }

	/**
	* Metoda ustawia nazwisko użytkownika na podane
	* @param surname Nowe nazwisko
	*/
    public void setSurname(String surname) {
        this.surname = surname;
    }

	/**
	* Metoda zwraca hasło użytkownika
	*/
    public String getPassword() {
        return password;
    }

	/**
	* Metoda ustawia hasło na podane
	* @param password Nowe hasło
	*/
    public void setPassword(String password) {
        this.password = password;
    }

	/**
	* Metoda zwraca hasło użytkownika
	*/
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
	
	/**
	* Metoda ustawia hasło na podane
	* @param passwordConfirmation Nowe hasło
	*/
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

	/**
	* Metoda służąca do porównywania użytkowników
	*/
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

	/**
	* Metoda generująca hash
	*/
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
