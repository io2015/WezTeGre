package pl.weztegre.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "exchangesArchive")
@PrimaryKeyJoinColumn(name = "id")
public class ExchangeArchive extends Exchange {
    @NotNull
    private Date endTime;

    @NotNull
    private Boolean accepted = false;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExchangeArchive that = (ExchangeArchive) o;

        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        return !(accepted != null ? !accepted.equals(that.accepted) : that.accepted != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExchangeArchive{" +
                "endTime=" + endTime +
                ", accepted=" + accepted +
                "} " + super.toString();
    }
}
