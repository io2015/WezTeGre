package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String platform;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Platform() {
    }

    public Platform(String platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform1 = (Platform) o;

        if (id != null ? !id.equals(platform1.id) : platform1.id != null) return false;
        return !(platform != null ? !platform.equals(platform1.platform) : platform1.platform != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return platform;
    }
}
