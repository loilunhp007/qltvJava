package Entity;

public class BookLending {
    private int lendID;
    private String lendUserID,issued_by,createDay,setdueday;
    private int total;

    public BookLending() {
    }

    public BookLending(int lendID, String lendUserID, String createDay, String setdueday, int total, String issued_by) {
        this.lendID = lendID;
        this.lendUserID = lendUserID;
        this.createDay = createDay;
        this.setdueday = setdueday;
        this.issued_by = issued_by;
        this.total= total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLendID() {
        return lendID;
    }

    public void setLendID(int lendID) {
        this.lendID = lendID;
    }

    public String getLendUserID() {
        return lendUserID;
    }

    public void setLendUserID(String lendUserID) {
        this.lendUserID = lendUserID;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public String getSetdueday() {
        return setdueday;
    }

    public void setSetdueday(String setdueday) {
        this.setdueday = setdueday;
    }

    @Override
    public String toString() {
        return "BookLending{" +
                "lendID=" + lendID +
                ", lendUserID='" + lendUserID + '\'' +
                ", issued_by='" + issued_by + '\'' +
                ", createDay='" + createDay + '\'' +
                ", setdueday='" + setdueday + '\'' +
                ", total=" + total +
                '}';
    }
}