package pl.weztegre.models;

import javax.persistence.*;

@Entity
@Table(name = "gameToExchange")
public class GameForExchange {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idGame")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "idPlatform")
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "idLanguage")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "idDistribution")
    private Distribution distribution;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }
}
