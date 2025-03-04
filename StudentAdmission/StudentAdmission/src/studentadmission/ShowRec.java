
package studentadmission;

import Dao.AdminDao;
import Dao.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class ShowRec 
{
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    String name;

    public ShowRec( Scanner s1) {
        this.s1 = s1;       
        showAll();
    }
     
    public void showAll() {
        List<Student> students = AdminDao.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        
        int i = 1;
        System.out.println("Records are: ");
        
        for (Student student : students) {
            System.out.println("Record no. : " + i);
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
            System.out.println("------------------------");
            i++;
        }
        
        // Call ManageRecord or any other class you want to call after showing the records.
        new ManageRecord(s1);
    }
     
}

