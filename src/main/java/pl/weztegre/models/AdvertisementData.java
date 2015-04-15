package pl.weztegre.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "advertisementsData")
public class AdvertisementData {
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "idAdvertisement", nullable = false)
    @ManyToOne
    private Advertisement advertisement;

    @JoinColumn(name = "idGameNonexistent")
    @ManyToOne
    private GameNonexistent gameNonexistent;

    @JoinColumn(name = "idGame")
    @ManyToOne
    private Game game;

    @JoinColumn(name = "idCategory")
    @ManyToOne
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public GameNonexistent getGameNonexistent() {
        return gameNonexistent;
    }

    public void setGameNonexistent(GameNonexistent gameNonexistent) {
        this.gameNonexistent = gameNonexistent;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementData that = (AdvertisementData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advertisement != null ? !advertisement.equals(that.advertisement) : that.advertisement != null)
            return false;
        if (gameNonexistent != null ? !gameNonexistent.equals(that.gameNonexistent) : that.gameNonexistent != null)
            return false;
        if (game != null ? !game.equals(that.game) : that.game != null) return false;
        return !(category != null ? !category.equals(that.category) : that.category != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advertisement != null ? advertisement.hashCode() : 0);
        result = 31 * result + (gameNonexistent != null ? gameNonexistent.hashCode() : 0);
        result = 31 * result + (game != null ? game.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdvertisementData{" +
                "id=" + id +
                ", advertisement=" + advertisement +
                ", gameNonexistent=" + gameNonexistent +
                ", game=" + game +
                ", category=" + category +
                '}';
    }
}
