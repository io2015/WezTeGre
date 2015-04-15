package pl.weztegre.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "settingsUser")
public class SettingUser implements Serializable {
    @Id
    private Integer idUser;

    @Id
    private Integer idSetting;

    @MapsId("idUser")
    @JoinColumn(name = "idUser")
    @ManyToOne
    private User user;

    @MapsId("idSetting")
    @JoinColumn(name = "idSetting")
    @ManyToOne
    private Setting setting;

    String value;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(Integer idSetting) {
        this.idSetting = idSetting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettingUser that = (SettingUser) o;

        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (idSetting != null ? !idSetting.equals(that.idSetting) : that.idSetting != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (setting != null ? !setting.equals(that.setting) : that.setting != null) return false;
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (idSetting != null ? idSetting.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (setting != null ? setting.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SettingUser{" +
                "idUser=" + idUser +
                ", idSetting=" + idSetting +
                ", user=" + user +
                ", setting=" + setting +
                ", value='" + value + '\'' +
                '}';
    }
}
