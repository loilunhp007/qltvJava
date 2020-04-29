package Model;

public class Staff {
    private String staffID,staffAccountID,staffName,staffDOB,staffAddr,staffGender;
    private  int staffPhone;

    public Staff() {
    }

    public Staff(String staffID) {
        this.staffID = staffID;
    }

    public Staff(String staffID, String staffName, String staffDOB, String staffAddr, String staffGender, int staffPhone, String staffAccountID) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffDOB = staffDOB;
        this.staffAddr = staffAddr;
        this.staffGender = staffGender;
        this.staffPhone = staffPhone;
        this.staffAccountID = staffAccountID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffAccountID() {
        return staffAccountID;
    }

    public void setStaffAccountID(String staffAccountID) {
        this.staffAccountID = staffAccountID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(String staffDOB) {
        this.staffDOB = staffDOB;
    }

    public String getStaffAddr() {
        return staffAddr;
    }

    public void setStaffAddr(String staffAddr) {
        this.staffAddr = staffAddr;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public int getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(int staffPhone) {
        this.staffPhone = staffPhone;
    }
}
