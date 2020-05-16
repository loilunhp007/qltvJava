package Entity;

public class Staff {
    private String staffName,staffDOB,staffAddr,staffGender;
    private  int staffPhone;
    private int staffID,staff_role;

    public Staff() {
    }

    public Staff(int staffID) {
        this.staffID = staffID;
    }

    public Staff(int staffID, String staffName, String staffDOB, String staffAddr, String staffGender,
     int staffPhone, int staff_role) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffDOB = staffDOB;
        this.staffAddr = staffAddr;
        this.staffGender = staffGender;
        this.staffPhone = staffPhone;
        this.staffID = staffID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getStaff_role() {
        return staff_role;
    }

    public void setStaff_role(int staff_role) {
        this.staff_role = staff_role;
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

    @Override
    public String toString() {
        return "Staff{" + "staffID='" + staffID + '\''
                +
                ", staffName='" + staffName + '\'' +
                ", staffDOB='" + staffDOB + '\'' +
                ", staffAddr='" + staffAddr + '\'' +
                ", staffGender='" + staffGender + '\'' +
                ", staffPhone=" + staffPhone +
                ", staff_role=" + staff_role +
                '}';
    }
}
