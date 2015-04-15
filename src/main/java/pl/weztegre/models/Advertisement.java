package pl.weztegre.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advertisements")
@Inheritance(strategy = InheritanceType.JOINED)
public class Advertisement {
    public enum State { New, UsedBad, UsedAverage, UsedGood };

    @Id
    @GeneratedValue
    private Integer id;

    @Length(min = 3, max = 100)
    private String title;

    @Length(min = 5, max = 1000)
    private String content;

    @Enumerated
    @NotNull
    private State state;

    @NotNull
    private Date addTime;

    @NotNull
    private Date potencialEndTime;

    @JoinColumn(name = "idNonexistentGame")
    @OneToOne
    private GameNonexistent nonexistentGame;

    @ManyToMany
    @JoinTable(name = "advertisement_platforms", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idPlatform")})
    private List<Platform> platforms = new ArrayList<Platform>();

    @ManyToMany
    @JoinTable(name = "advertisement_languages", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idLanguage")})
    private List<Language> languages = new ArrayList<Language>();

    @ManyToMany
    @JoinTable(name = "advertisement_distributions", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idDistribution")})
    private List<Distribution> distribution = new ArrayList<Distribution>();

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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getPotencialEndTime() {
        return potencialEndTime;
    }

    public void setPotencialEndTime(Date potencialEndTime) {
        this.potencialEndTime = potencialEndTime;
    }

    public GameNonexistent getNonexistentGame() {
        return nonexistentGame;
    }

    public void setNonexistentGame(GameNonexistent nonexistentGame) {
        this.nonexistentGame = nonexistentGame;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Distribution> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<Distribution> distribution) {
        this.distribution = distribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (state != that.state) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (potencialEndTime != null ? !potencialEndTime.equals(that.potencialEndTime) : that.potencialEndTime != null)
            return false;
        if (nonexistentGame != null ? !nonexistentGame.equals(that.nonexistentGame) : that.nonexistentGame != null)
            return false;
        if (platforms != null ? !platforms.equals(that.platforms) : that.platforms != null) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        return !(distribution != null ? !distribution.equals(that.distribution) : that.distribution != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (potencialEndTime != null ? potencialEndTime.hashCode() : 0);
        result = 31 * result + (nonexistentGame != null ? nonexistentGame.hashCode() : 0);
        result = 31 * result + (platforms != null ? platforms.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", addTime=" + addTime +
                ", potencialEndTime=" + potencialEndTime +
                ", nonexistentGame=" + nonexistentGame +
                ", platforms=" + platforms +
                ", languages=" + languages +
                ", distribution=" + distribution +
                '}';
    }
}
