package pl.weztegre.formObjects;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import pl.weztegre.models.Distribution;
import pl.weztegre.models.GameNonexistent;
import pl.weztegre.models.Language;
import pl.weztegre.models.Platform;

import java.util.Date;
import java.util.List;

public class AdvertisementForm {


    public enum State {New, UsedBad, UsedAverage, UsedGood};

    @Length(min = 3, max = 100, message = "Długość tytułu musi zawierać się w przedziale 3-30.")
    private String title;

    @Length(min = 5, max = 1000, message = "Długość opisu musi zawierać się w przedziale 3-30.")
    private String content;

    @NotEmpty(message = "Stan nie może być pusty.")
    private State state;

    @NotEmpty(message = "Data nie może być pusta.")
    private Date addTime;

    @NotEmpty(message = "Data zakończenia nie może być pusta.")
    private Date potencialEndTime;

    @NotEmpty(message = "Czy jest w bazie nie może być puste.")
    private GameNonexistent nonexistentGame;

    @NotEmpty(message = "Platformy nie może być puste.")
    private List<Platform> platforms;

    @NotEmpty(message = "Języki nie może być puste.")
    private List<Language> languages;

    @NotEmpty(message = "Dystrybucje nie może być puste.")
    private List<Distribution> distribution;

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public State getState() {return state;}

    public void setState(State state) {this.state = state;}

    public Date getAddTime() {return addTime;}

    public void setAddTime(Date addTime) {this.addTime = addTime;}

    public Date getPotencialEndTime() {return potencialEndTime;}

    public void setPotencialEndTime(Date potencialEndTime) {this.potencialEndTime = potencialEndTime;}

    public GameNonexistent getNonexistentGame() {return nonexistentGame;}

    public void setNonexistentGame(GameNonexistent nonexistentGame) {this.nonexistentGame = nonexistentGame;}

    public List<Platform> getPlatforms() {return platforms;}

    public void setPlatforms(List<Platform> platforms) {this.platforms = platforms;}

    public List<Language> getLanguages() {return languages;}

    public void setLanguages(List<Language> languages) {this.languages = languages;}

    public List<Distribution> getDistribution() {return distribution;}

    public void setDistribution(List<Distribution> distribution) {this.distribution = distribution;}
}