
package studentadmission;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class RegisterExam {
    int Roll;
    String Sub;
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    java.util.Date currentDate=new java.util.Date();
    Calendar calendar = Calendar.getInstance();
    
    public RegisterExam(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        
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
        String s= "pending";
        java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
         try
         {
            ps=con.prepareStatement("insert into exam_reg values(?,?,?,?)");
            ps.setInt(1, Roll);
            ps.setString(2,Sub);
            ps.setDate(3,sqlDate);
            ps.setString(4,s);
              
            int i=ps.executeUpdate();
            if(i>0)
            {
               
                  System.out.println("-------------------------");
                  System.out.println("!! Registration Succesfull !!");
                  System.out.println("------------------------");
                  new Menu(s1);
            }
            else
            {
                  System.out.println("Error  !!");
                  System.out.println("------------------------");
            }
            
         }
         catch(Exception e)
         {
            System.out.println("Errorr "+e);
         }
    }
}
