
package studentadmission;

import Dao.ExamDao;
import Dao.ExamRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Exam_rec {

    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    
    public Exam_rec(Scanner s1) {
        this.s1 = s1;
        showAll();
    }
     public void showAll()
    {
        List<ExamRecord> examRecords = ExamDao.getAllExamRecords();

        if (examRecords.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("Records from exam registration:");
            System.out.println("--------------------------------------------------");
            System.out.println("Roll No | Subject | Registration Date | Status");
            System.out.println("--------------------------------------------------");

            for (ExamRecord record : examRecords) {
                System.out.printf("%-8d | %-8s | %-18s | %-8s\n", 
                        record.getRoll(), record.getSubject(), record.getRegisterDate(), record.getStatus());
                System.out.println("--------------------------------------------------");
            }
        }
        new Menu(s1);
    }
}
