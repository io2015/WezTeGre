package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language1 = (Language) o;

        if (id != null ? !id.equals(language1.id) : language1.id != null) return false;
        return !(language != null ? !language.equals(language1.language) : language1.language != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", language='" + language + '\'' +
                '}';
    }
}
