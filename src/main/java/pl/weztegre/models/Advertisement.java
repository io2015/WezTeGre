package pl.weztegre.models;

import pl.weztegre.enums.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advertisements")
@Inheritance(strategy = InheritanceType.JOINED)
public class Advertisement {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String content;

    @Enumerated
    @NotNull
    private State state;

    @ManyToOne
    @JoinColumn
    private Game game;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @ManyToOne
    @JoinColumn
    private Distribution distribution;

    @ManyToOne
    @JoinColumn
    private Language language;

    @ManyToOne
    @JoinColumn
    private Platform platform;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GameForExchange> gamesForExchange;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Photo> photos;

    public Advertisement() {

    }

    public Advertisement(String title, String content, State state, Game game, Date date, Date time, Date endDate, Date endTime,
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
