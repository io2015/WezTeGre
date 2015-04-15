package pl.weztegre.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "resetedPasswords")
public class ResetedPassword {
    @Transient
    public static final int CODE_LENGTH = 100;
    @Transient
    private static final int EXPIRATION = 60 * 48;

    @Id
    private Integer id;

    @JoinColumn(name = "idUser")
    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    private User user;

    @Column(length = CODE_LENGTH)
    private String token;

    private Date expiryDate;

    public ResetedPassword() {}

    public ResetedPassword(User user, String token) {
        this.user = user;
        this.token = token;
        expiryDate = calculateExpiryDate();
    }

    public void setNewExpiryDate() {
        expiryDate = calculateExpiryDate();
    }

    private Date calculateExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, EXPIRATION);
        return new Date(calendar.getTime().getTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResetedPassword that = (ResetedPassword) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return !(expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", user=" + user +
                ", token='" + token + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
