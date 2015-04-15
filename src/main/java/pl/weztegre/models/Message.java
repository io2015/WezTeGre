package pl.weztegre.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
public class Message {
    public enum Value { Advertisement, Ordinary, QuestionAboutAdvertisement };

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "addressee", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private User addressee;

    @NotNull
    @Length(min = 3, max = 200)
    private String subject;

    @NotNull
    @Length(min = 15, max = 1000)
    private String content;

    @NotNull
    @Length(min = 3, max = 50)
    private String city;

    @NotNull
    private Boolean senderRead = false;

    @NotNull
    private Boolean addresseeRead = false;

    @Enumerated
    @NotNull
    private Value value;

    @ManyToOne
    @JoinColumn(name = "advertisement", referencedColumnName = "id", insertable = false, updatable = false)
    private Advertisement advertisement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean isSenderRead() {
        return senderRead;
    }

    public void setSenderRead(Boolean senderRead) {
        this.senderRead = senderRead;
    }

    public Boolean isAddresseeRead() {
        return addresseeRead;
    }

    public void setAddresseeRead(Boolean addresseeRead) {
        this.addresseeRead = addresseeRead;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (sender != null ? !sender.equals(message.sender) : message.sender != null) return false;
        if (addressee != null ? !addressee.equals(message.addressee) : message.addressee != null) return false;
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (city != null ? !city.equals(message.city) : message.city != null) return false;
        if (senderRead != null ? !senderRead.equals(message.senderRead) : message.senderRead != null) return false;
        if (addresseeRead != null ? !addresseeRead.equals(message.addresseeRead) : message.addresseeRead != null)
            return false;
        if (value != message.value) return false;
        return !(advertisement != null ? !advertisement.equals(message.advertisement) : message.advertisement != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (addressee != null ? addressee.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (senderRead != null ? senderRead.hashCode() : 0);
        result = 31 * result + (addresseeRead != null ? addresseeRead.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (advertisement != null ? advertisement.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", addressee=" + addressee +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", city='" + city + '\'' +
                ", senderRead=" + senderRead +
                ", addresseeRead=" + addresseeRead +
                ", value=" + value +
                ", advertisement=" + advertisement +
                '}';
    }
}
