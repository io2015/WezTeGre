package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "advertisementsArchive")
@PrimaryKeyJoinColumn(name = "id")
public class AdvertisementArchive extends Advertisement {
    @NotNull
    private Date endTime;

    @NotNull
    private Boolean exchanged = false;

    public Boolean isExchanged() {
        return exchanged;
    }

    public void setExchanged(Boolean exchanged) {
        this.exchanged = exchanged;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementArchive that = (AdvertisementArchive) o;

        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (exchanged != null ? !exchanged.equals(that.exchanged) : that.exchanged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = endTime != null ? endTime.hashCode() : 0;
        result = 31 * result + (exchanged != null ? exchanged.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdvertisementArchive{" +
                "endTime=" + endTime +
                ", exchanged=" + exchanged +
                "} " + super.toString();
    }
}
