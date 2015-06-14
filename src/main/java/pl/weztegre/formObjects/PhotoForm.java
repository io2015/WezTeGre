package pl.weztegre.formObjects;

/**
* Klasa formularza do dodawania obrazków
**/
public class PhotoForm {
    private Integer id;

    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
