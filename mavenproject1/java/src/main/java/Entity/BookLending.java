package Entity;

public class BookLending {
    private int lendID,lendStudentID,issued_by;
    private String createDay,setdueday;
    private int total;

    public BookLending() {
    }

    public BookLending(int lendID, int lendStudentID, String createDay, String setdueday, int total, int issued_by) {
        this.lendID = lendID;
        this.lendStudentID = lendStudentID;
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

    public int getStudentUserID() {
        return lendStudentID;
    }

    public void setLendStudentID(int lendStudentID) {
        this.lendStudentID = lendStudentID;
    }

    public int getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(int issued_by) {
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
                ", lendStudentID='" + lendStudentID + '\'' +
                ", issued_by='" + issued_by + '\'' +
                ", createDay='" + createDay + '\'' +
                ", setdueday='" + setdueday + '\'' +
                ", total=" + total +
                '}';
    }
}
