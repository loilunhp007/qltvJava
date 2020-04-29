package Model;
public class Student {
    private String studenID,accountID,studentName,StudentDOB,studenEmail,StudentClass;

    public Student() {
    }

    public Student(String studenID) {
        this.studenID = studenID;
    }

    public Student(String studenID, String studentName, String studentDOB, String studenEmail, String studentClass, String accountID) {
        this.studenID = studenID;
        this.studentName = studentName;
        StudentDOB = studentDOB;
        this.studenEmail = studenEmail;
        StudentClass = studentClass;
        this.accountID = accountID;
    }

    public String getStudenID() {
        return studenID;
    }

    public void setStudenID(String studenID) {
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

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
