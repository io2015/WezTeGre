package pl.weztegre.jsons;

/**
* Klasa wiadomości w formacie JSON
*/
public class MessageJSON {
    private String subjectError;
    private String contentError;
    private String redirect;

    public String getSubjectError() {
        return subjectError;
    }

    public void setSubjectError(String subjectError) {
        this.subjectError = subjectError;
    }

    public String getContentError() {
        return contentError;
    }

    public void setContentError(String contentError) {
        this.contentError = contentError;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
