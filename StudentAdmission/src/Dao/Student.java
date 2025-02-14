
package Dao;

public class Student {

    private int roll;
    private int mob;
    private int fee;
    private String name;
    private String address; 
    private String mail;
    private String coun_name;
    private String admission_date;
    private String courseName;
    private String duration;
   

    public Student(int roll, String name, String address, int mob, String mail,
                   String coun_name, String admission_date, String courseName,
                   String duration, int fee) {
        this.roll = roll;
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.mail = mail;
        this.coun_name = coun_name;
        this.admission_date = admission_date;
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMob() {
        return mob;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCoun_name() {
        return coun_name;
    }

    public void setCoun_name(String coun_name) {
        this.coun_name = coun_name;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}

