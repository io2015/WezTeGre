package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "advertisements_platforms", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idPlatform")})
    private List<Platform> platforms = new ArrayList<Platform>();

    @ManyToMany
    @JoinTable(name = "advertisements_distributions", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idDistributin")})
    private List<Distribution> distributions = new ArrayList<Distribution>();

    @ManyToMany
    @JoinTable(name = "advertisements_languages", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idLanguage")})
    private List<Language> languages = new ArrayList<Language>();

    @ManyToMany
    @JoinTable(name = "advertisements_genres", joinColumns =  {@JoinColumn(name = "idAdvertisement")}, inverseJoinColumns = {@JoinColumn(name = "idGenre")})
    private List<Genre> genres = new ArrayList<Genre>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (id != null ? !id.equals(game.id) : game.id != null) return false;
        if (name != null ? !name.equals(game.name) : game.name != null) return false;
        if (platforms != null ? !platforms.equals(game.platforms) : game.platforms != null) return false;
        if (distributions != null ? !distributions.equals(game.distributions) : game.distributions != null)
            return false;
        if (languages != null ? !languages.equals(game.languages) : game.languages != null) return false;
        return !(genres != null ? !genres.equals(game.genres) : game.genres != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (platforms != null ? platforms.hashCode() : 0);
        result = 31 * result + (distributions != null ? distributions.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platforms=" + platforms +
                ", distributions=" + distributions +
                ", languages=" + languages +
                ", genres=" + genres +
                '}';
    }
}

