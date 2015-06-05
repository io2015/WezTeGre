package pl.weztegre.pojos;

import pl.weztegre.enums.State;
import pl.weztegre.models.*;

import java.util.Date;
import java.util.List;

public class AdvertisementPOJO {
    private Integer id;

    private String title;

    private String content;

    private State state;

    private Game game;

    private Date date;

    private Date time;

    private Date endDate;

    private Date endTime;

    private Distribution distribution;

    private Language language;

    private Platform platform;

    private List<GameForExchange> gamesForExchange;

    private List<Photo> photos;

    public AdvertisementPOJO(Advertisement advertisement) {
        this.title = advertisement.getTitle();
        this.content = advertisement.getContent();
        this.state = advertisement.getState();
        this.game = advertisement.getGame();
        this.date = advertisement.getDate();
        this.time = advertisement.getTime();
        this.endDate = advertisement.getEndDate();
        this.endTime = advertisement.getTime();
        this.distribution = advertisement.getDistribution();
        this.language = advertisement.getLanguage();
        this.platform = advertisement.getPlatform();
        this.gamesForExchange = advertisement.getGamesForExchange();
        this.photos = advertisement.getPhotos();
    }

    public AdvertisementPOJO(String title, String content, State state, Game game, Date date, Date time, Date endDate, Date endTime,
                             Distribution distribution, Language language, Platform platform, List<GameForExchange> gamesForExchange, List<Photo> photos) {
        this.title = title;
        this.content = content;
        this.state = state;
        this.game = game;
        this.date = date;
        this.time = time;
        this.endDate = endDate;
        this.endTime = endTime;
        this.distribution = distribution;
        this.language = language;
        this.platform = platform;
        this.gamesForExchange = gamesForExchange;
        this.photos = photos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
}
