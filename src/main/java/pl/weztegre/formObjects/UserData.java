package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Length;
import pl.weztegre.models.User;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class UserData {
    @Length(min = 3, max = 30, message = "Długość imienia musi zawierać się w przedziale 3-30.")
    private String name;

    @Length(min = 3, max = 30, message = "Długość nazwiska musi zawierać się w przedziale 3-30.")
    private String surname;

    @Length
    private String city;

    private String address;

    @Pattern(regexp = "^[\\d ]*$", message = "Numer telefonu może składać się tylko z cyfr oraz znaków odstępów.")
    private String phoneNumber;

    private String skype;

    private String gaduGadu;

    public UserData() {}

    public UserData(User user) {
        name = user.getName();
        surname = user.getSurname();
        city = user.getCity();
        address = user.getAddress();
        phoneNumber = user.getPhoneNumber();
        skype = user.getSkype();
        gaduGadu = user.getGaduGadu();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
