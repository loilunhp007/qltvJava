package Entity;

public class Staff {
    private String staffName,staffdob,staffAddr,staffGender;
    private  String staffPhone;
    private int staffID,staff_role;

    public Staff() {
    }

    public Staff(int staffID) {
        this.staffID = staffID;
    }

    public Staff(int staffID, String staffName, String staffDOB, String staffAddr,
    String staffGender,String staffPhone, int staff_role) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffdob = staffDOB;
        this.staffAddr = staffAddr;
        this.staffGender = staffGender;
        this.staffPhone = staffPhone;
        this.staff_role = staff_role;
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
        return staffdob;
    }

    public void setStaffDOB(String staffdob) {
        this.staffdob = staffdob;
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

    @Override
    public String toString() {
        return "Staff{" + "staffID='" + staffID + '\''
                +
                ", staffName='" + staffName + '\'' +
                ", staffDOB='" + staffdob + '\'' +
                ", staffAddr='" + staffAddr + '\'' +
                ", staffGender='" + staffGender + '\'' +
                ", staffPhone=" + staffPhone +
                ", staff_role=" + staff_role +
                '}';
    }
}
