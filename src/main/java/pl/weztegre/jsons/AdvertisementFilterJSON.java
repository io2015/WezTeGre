package pl.weztegre.jsons;

import java.util.List;

public class AdvertisementFilterJSON {
    private String find;
    private Boolean inDescription;
    private Boolean inTitle;

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public Boolean getInDescription() {
        return inDescription;
    }

    public void setInDescription(Boolean inDescription) {
        this.inDescription = inDescription;
    }

    public Boolean getInTitle() {
        return inTitle;
    }

    public void setInTitle(Boolean inTitle) {
        this.inTitle = inTitle;
    }
}
