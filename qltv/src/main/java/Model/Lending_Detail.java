package Model;

public class Lending_Detail {
    private String lendID,bookID,dueDay,lendStatus;

    public Lending_Detail() {
    }

    public Lending_Detail(String lendID) {
        this.lendID = lendID;
    }

    public Lending_Detail(String lendID, String bookID, String dueDay, String lendStatus) {
        this.lendID = lendID;
        this.bookID = bookID;
        this.dueDay = dueDay;
        this.lendStatus = lendStatus;
    }

    public String getLendID() {
        return lendID;
    }

    public void setLendID(String lendID) {
        this.lendID = lendID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }

    public String getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(String lendStatus) {
        this.lendStatus = lendStatus;
    }
}
