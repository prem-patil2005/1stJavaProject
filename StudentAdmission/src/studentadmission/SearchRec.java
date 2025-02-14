
package studentadmission;

import Dao.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchRec 
{
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    String name;

    public SearchRec(Scanner s1) {
        this.s1 = s1;
        
        chkRec();
    }
     
     public void chkRec()
     {
         System.out.println("Enter student name");
         name=s1.next();
         System.out.println("------------------------");
         boolean status=AdminDao.show_Rec(name);
         
        try
        {
            if(status)
            {
                name=rs.getString(1);
                String address=rs.getString(2);
                int mob=rs.getInt(3);
                String mail=rs.getString(4);
                String coun_name=rs.getString(5);
                String admission_date=rs.getString(6);
                String courseName=rs.getString(7);
                String du=rs.getString(8);
                int fee=rs.getInt(9);
                int roll=rs.getInt(10);
                System.out.println("NAme= "+name);
                System.out.println("Addrss = "+address);
                System.out.println("Mobile no. = "+mob);
                System.out.println("mail ID = "+mail);
                System.out.println("Counsellor Name = "+coun_name);
                System.out.println("Amission Date = "+admission_date);
                System.out.println("Course Name = "+courseName);
                System.out.println("Duration = "+du);
                System.out.println("Fees = "+fee);
                System.out.println("ROll No. = "+roll);
                System.out.println("------------------------");
                System.out.println("------------------------");
        }
        }
        catch (Exception e){
            System.out.println("error ="+e);
        }
     }

}

