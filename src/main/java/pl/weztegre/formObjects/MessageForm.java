package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Length;
import pl.weztegre.enums.State;
import pl.weztegre.models.*;

import java.util.List;

public class MessageForm {
    private User addressee;

    @Length(min = 3, max = 100, message = "Długość tematu musi zawierać się w przedziale 3-30.")
    private String subject;

    @Length(min = 5, max = 1000, message = "Długość opisu musi zawierać się w przedziale 5-1000.")
    private String content;

    public User getAddressee() {
        return addressee;
    }

    public void setAddressee(User addressee) {
        this.addressee = addressee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}