package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "distributions")
public class Distribution {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String distribution;

    public Distribution() {
    }

    public Distribution(String distribution) {
        this.distribution = distribution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distribution distribution1 = (Distribution) o;

        if (id != null ? !id.equals(distribution1.id) : distribution1.id != null) return false;
        return !(distribution != null ? !distribution.equals(distribution1.distribution) : distribution1.distribution != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return distribution;
    }
}
