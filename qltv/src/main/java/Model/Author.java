package Model;

public class Author {
    private String authorID,authorName,authorGender,authorDOB,authorEmail;

    public Author() {
    }

    public Author(String authorID) {
        this.authorID = authorID;
    }

    public Author(String authorID, String authorName, String authorGender, String authorDOB, String authorEmail) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorGender = authorGender;
        this.authorDOB = authorDOB;
        this.authorEmail = authorEmail;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(String authorGender) {
        this.authorGender = authorGender;
    }

    public String getAuthorDOB() {
        return authorDOB;
    }

    public void setAuthorDOB(String authorDOB) {
        this.authorDOB = authorDOB;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
