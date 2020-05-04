package Model;
public class Student {
    private int studenID,accountID;
    private String studentName,StudentDOB,studenEmail,StudentClass;

    public Student() {
    }

    public Student(int studenID) {
        this.studenID = studenID;
    }

    public Student(int studenID, String studentName, String studentDOB, String studenEmail, String studentClass, int accountID) {
        this.studenID = studenID;
        this.studentName = studentName;
        StudentDOB = studentDOB;
        this.studenEmail = studenEmail;
        StudentClass = studentClass;
        this.accountID = accountID;
    }

    public int getStudenID() {
        return studenID;
    }

    public void setStudenID(int studenID) {
        this.studenID = studenID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDOB() {
        return StudentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        StudentDOB = studentDOB;
    }

    public String getStudenEmail() {
        return studenEmail;
    }

    public void setStudenEmail(String studenEmail) {
        this.studenEmail = studenEmail;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studenID=" + studenID +
                ", accountID=" + accountID +
                ", studentName='" + studentName + '\'' +
                ", StudentDOB='" + StudentDOB + '\'' +
                ", studenEmail='" + studenEmail + '\'' +
                ", StudentClass='" + StudentClass + '\'' +
                '}';
    }
}
