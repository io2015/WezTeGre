package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String genre;

    public Genre() {

    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre platform1 = (Genre) o;

        if (id != null ? !id.equals(platform1.id) : platform1.id != null) return false;
        return !(genre != null ? !genre.equals(platform1.genre) : platform1.genre != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return genre;
    }
}
