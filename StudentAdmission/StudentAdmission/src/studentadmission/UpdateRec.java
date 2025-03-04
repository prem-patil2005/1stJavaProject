package studentadmission;

import Dao.AdminDao;
import Dao.Student;
import java.sql.Connection;
import java.util.Scanner;

public class UpdateRec {
    
    Connection con;
    Scanner s1;
    String name, col, value;
       
    public UpdateRec( Scanner s1) {
        this.s1 = s1;
        updateMethod();
    }
    
    public void updateMethod() {
        System.out.println("Enter Name whose record you want to Update:");
        name = s1.next();
        System.out.println("------------------------");
        chkName(name);
    }

    public void chkName(String name) {
        Student student = AdminDao.getStudentByName(name);
        
        if (student == null) {
            System.out.println("Student not found!");
            return; 
        }

        System.out.println("Roll No. = " + student.getRoll());
        System.out.println("Name = " + student.getName());
        System.out.println("Address = " + student.getAddress());
        System.out.println("Mobile No. = " + student.getMob());
        System.out.println("Mail ID = " + student.getMail());
        System.out.println("Counselor Name = " + student.getCoun_name());
        System.out.println("Admission Date = " + student.getAdmission_date());
        System.out.println("Course Name = " + student.getCourseName());
        System.out.println("Duration = " + student.getDuration());
        System.out.println("Fees = " + student.getFee());
        
        System.out.println("Enter column name you want to update:");
        col = s1.next();
        System.out.println("------------------------");
        
        System.out.println("Enter new value for this column:");
        value = s1.next();
        System.out.println("------------------------");
    
        boolean status = AdminDao.updateStudent(col, value, name);
        
        if (status) {
            System.out.println("Record updated successfully!");
        } else {
            System.out.println("Record not found or update failed.");
        }
        new ManageRecord(s1);
    }
}
