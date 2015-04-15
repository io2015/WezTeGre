package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "settings")
public class Setting {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 60)
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        Setting setting = (Setting) o;

        if (id != null ? !id.equals(setting.id) : setting.id != null) return false;
        return !(value != null ? !value.equals(setting.value) : setting.value != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
