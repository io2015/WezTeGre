package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Lob
    private byte[] photo;

    public Photo() {
    }

    public Photo(String photo) {
        this.photo = photo.getBytes();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
