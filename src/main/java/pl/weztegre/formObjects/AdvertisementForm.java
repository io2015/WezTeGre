package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Length;
import pl.weztegre.enums.State;
import pl.weztegre.models.*;

import java.util.List;

/**
* Klasa formularza służącego do dodawania nowych ogłoszeń na stronie.
*/
public class AdvertisementForm {
    @Length(min = 3, max = 100, message = "Długość tytułu musi zawierać się w przedziale 3-30.")
    private String title;

    @Length(min = 5, max = 1000, message = "Długość opisu musi zawierać się w przedziale 5-1000.")
    private String content;

    private State state;

    private Game game;

    private Platform platform;

    private Language language;

    private Distribution distribution;

    private List<GameForExchange> gamesForExchange;

    private List<PhotoForm> photos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<GameForExchange> getGamesForExchange() {
        return gamesForExchange;
    }

    public void setGamesForExchange(List<GameForExchange> gamesForExchange) {
        this.gamesForExchange = gamesForExchange;
    }

    public List<PhotoForm> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoForm> photos) {
        this.photos = photos;
    }
}