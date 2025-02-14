
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ShowRec 
{
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    String name;

    public ShowRec(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        
        showAll();
    }
     
    public void showAll()
    {
        String address;
        int fee,roll,mob;
        String courseName,du,mail,coun_name,admission_date;
        int i=1;
        try
        {
            ps=con.prepareStatement("select * from stud_info");
            rs=ps.executeQuery();
            
            System.out.println("Record are ....");
            while(rs.next())
            {
                roll=rs.getInt(1);
                name=rs.getString(2);
                address=rs.getString(3);
                mob=rs.getInt(4);
                mail=rs.getString(5);
                coun_name=rs.getString(6);
                admission_date=rs.getString(7);
                courseName=rs.getString(8);
                du=rs.getString(9);
                fee=rs.getInt(10);
                
                System.out.println("Record no. : "+i);
                System.out.println("ROll No. = "+roll);
                System.out.println("NAme= "+name);
                System.out.println("Addrss = "+address);
                System.out.println("Mobile no. = "+mob);
                System.out.println("mail ID = "+mail);
                System.out.println("Counsellor Name = "+coun_name);
                System.out.println("Amission Date = "+admission_date);
                System.out.println("Course Name = "+courseName);
                System.out.println("Duration = "+du);
                System.out.println("Fees = "+fee);
                
                i++;
                System.out.println("------------------------");
                
               
            }
            new ManageRecord(con,s1,ps);
        }
        catch(Exception ee)
        {
            System.out.println("error ="+ee);
        }
    }
     
}

