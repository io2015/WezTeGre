package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "idExchange")
    @ManyToOne
    private Exchange exchange;

    @JoinColumn(name = "idAdvertisement")
    @ManyToOne
    private Advertisement advertisement;

    @NotNull
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (id != null ? !id.equals(picture.id) : picture.id != null) return false;
        if (exchange != null ? !exchange.equals(picture.exchange) : picture.exchange != null) return false;
        if (advertisement != null ? !advertisement.equals(picture.advertisement) : picture.advertisement != null)
            return false;
        return !(url != null ? !url.equals(picture.url) : picture.url != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (exchange != null ? exchange.hashCode() : 0);
        result = 31 * result + (advertisement != null ? advertisement.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", exchange=" + exchange +
                ", advertisement=" + advertisement +
                ", url='" + url + '\'' +
                '}';
    }
}
