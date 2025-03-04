
package studentadmission;

import Dao.ExamDao;
import java.util.Scanner;
import java.util.Calendar;

public class RegisterExam {
    int Roll;
    String Sub;
    Scanner s1;

    java.util.Date currentDate=new java.util.Date();
    Calendar calendar = Calendar.getInstance();
    
    public RegisterExam(Scanner s1) {
        this.s1 = s1;
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE,3);
        
        regExam();
    }
    public void regExam(){
   
       System.out.println("EXAM REGISTRATION FORM");
       System.out.println("-------------------------");
       System.out.println("Enter Roll No :");
       Roll = s1.nextInt();
       System.out.println("-------------------------");
       System.out.println("Enter Subject :");
       Sub = s1.next();
       dataFill();
       
    }
    public void dataFill(){
        String status = "pending";
        java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
       
        boolean isInserted = ExamDao.insertExamRegistration(Roll, Sub, sqlDate, status);
        if (isInserted) {
            System.out.println("-------------------------");
            System.out.println("!! Registration Successful !!");
            System.out.println("-------------------------");
            new Menu(s1);
        } else {
            System.out.println("Error: Registration failed.");
            System.out.println("------------------------");
        }
    }
}
