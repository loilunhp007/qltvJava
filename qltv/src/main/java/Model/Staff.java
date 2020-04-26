package Model;

public class Staff {
    private int staffID,staffAccountID;
    private String staffName,staffDOB,staffAddr,staffGender,staffPhone;

    public Staff(int staffID) {
        this.staffID = staffID;
    }

    public Staff(int staffID, String staffName, String staffDOB, String staffAddr, String staffGender, String staffPhone,int staffAccountID) {
        this.staffID = staffID;

        this.staffName = staffName;
        this.staffDOB = staffDOB;
        this.staffAddr = staffAddr;
        this.staffGender = staffGender;
        this.staffPhone = staffPhone;
        this.staffAccountID = staffAccountID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getStaffAccountID() {
        return staffAccountID;
    }

    public void setStaffAccountID(int staffAccountID) {
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

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }
}
