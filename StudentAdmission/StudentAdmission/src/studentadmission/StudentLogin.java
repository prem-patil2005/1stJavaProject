
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StudentLogin {
    
    Scanner s1;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sub;
    int roll;
    
      public StudentLogin(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;       
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/premdb","root", "root");
        
        }
        catch(Exception e)
        {
            System.out.println("Errorr "+e);
        }
            insert();
        
        }
        public void insert() {
            System.out.print("Enter Your Subject: ");
            sub = s1.next();

            System.out.print("Enter Your Password: ");
            roll = s1.nextInt();
            System.out.println("------------------------");
        
        validate();
        
        
    }
    public void validate() {
           try
        {
            
            ps=con.prepareStatement("select * from exam_reg where roll=? and subject=?");
            ps.setInt(1, roll);
            ps.setString(2, sub);
            
            rs=ps.executeQuery();
            
          
            if(rs.next())
            {
                new ExamPaper(con,s1,ps,roll);
            }
            else
            {
                System.out.println("\n rec not found");
            }
        }
        catch(Exception ee)
        {
            System.out.println("Errorr "+ee);
        }

      }
}
