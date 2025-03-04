
package Dao;


public class ExamRecord {
    private int roll;
    private String subject;
    private String registerDate;
    private String status;

    public ExamRecord(int roll, String subject, String registerDate, String status) {
        this.roll = roll;
        this.subject = subject;
        this.registerDate = registerDate;
        this.status = status;
    }

    public int getRoll() {
        return roll;
    }

    public String getSubject() {
        return subject;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Roll No: %d, Subject: %s, Registration Date: %s, Status: %s",
                roll, subject, registerDate, status);
    }
}
