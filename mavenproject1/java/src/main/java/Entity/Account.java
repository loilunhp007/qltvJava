package Entity;
import java.io.Serializable;

public class Account implements Serializable {
    static final long serialVersionUID=1;
    private int userID;
    private int staffID;
    private String userName;
    private String userPassword;
    private String createday,outofday;
    public Account() {
    }

    public Account(int userID) {
        this.userID=userID;
    }
    public int getStaffID(){
        return staffID;
    }
    public void setStaffID(int staffID){
        this.staffID =staffID;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getCreateday(){
        return createday;
    }
    public String getOutofday(){
        return outofday;
    }
    public void setCreateday(String createday){
        this.createday=createday;
    }
    /**
     * @param outofday the outofday to set
     */
    public void setOutofday(String outofday) {
        this.outofday = outofday;
    }
    @Override
    public String toString() {
        return "Account{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createday='"+ createday + '\'' +
                ",outofday='" + outofday + '\'' +
                ",staffID='" + staffID +
                '}';
    }

    public Account(int userID, String userName, String userPassword,int staffID, String createday, String outofday) {
        this.userID = userID;
        this.staffID = staffID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.createday = createday;
        this.outofday = outofday;
    }
}
