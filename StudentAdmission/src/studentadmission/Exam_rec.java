
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam_rec {

    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    
    public Exam_rec(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        showAll();
    }
     public void showAll()
    {
        int roll;
        String subject,status,register_date;
        int i=1;
        try
        {
            ps=con.prepareStatement("select * from exam_reg");
            rs=ps.executeQuery();
            
            System.out.println("Record are ....");
            while(rs.next())
            {
                roll=rs.getInt(1);
                subject=rs.getString(2);
                register_date=rs.getString(3);
                status=rs.getString(4);
                
                
                
                System.out.println("ROll No. = "+roll);
                System.out.println("Subject= "+subject);
                System.out.println("Registration Date = "+register_date);
                System.out.println("Status : "+ status);
            
                System.out.println("------------------------");
                
               
            }
            new Menu(s1);
        }
        catch(Exception ee)
        {
            System.out.println("error ="+ee);
        }
    }
}
