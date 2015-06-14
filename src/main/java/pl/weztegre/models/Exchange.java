package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "exchanges")
@Inheritance(strategy = InheritanceType.JOINED)
public class Exchange {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idAdvertisement", nullable = false)
    private Advertisement advertisement;

    @ManyToOne
    @JoinColumn(name = "idGame", nullable = false)
    private Game game;

    @NotNull
    private Date data;

    @Max(value = 1000)
    private String comment;

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

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange exchange = (Exchange) o;

        if (id != null ? !id.equals(exchange.id) : exchange.id != null) return false;
        if (user != null ? !user.equals(exchange.user) : exchange.user != null) return false;
        if (advertisement != null ? !advertisement.equals(exchange.advertisement) : exchange.advertisement != null)
            return false;
        if (game != null ? !game.equals(exchange.game) : exchange.game != null) return false;
        if (data != null ? !data.equals(exchange.data) : exchange.data != null) return false;
        if (comment != null ? !comment.equals(exchange.comment) : exchange.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (advertisement != null ? advertisement.hashCode() : 0);
        result = 31 * result + (game != null ? game.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", user=" + user +
                ", advertisement=" + advertisement +
                ", game=" + game +
                ", data=" + data +
                ", comment='" + comment + '\'' +
                '}';
    }
}
