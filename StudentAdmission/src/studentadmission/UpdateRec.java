
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class UpdateRec 
{
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
    String name,col,value;
       
    public UpdateRec(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
  
        updateMethod();
    }
    
    public void updateMethod()
    {
        System.out.println("Enter Name whose rec u want to Update");
       name=s1.next();
       System.out.println("------------------------");
       chkName();
    }
    public void chkName()
    {
        String address;
        int fee,roll,mob;
        String courseName,du,mail,coun_name,admission_date;
        try
        {
        ps=con.prepareStatement("select * from stud_info where name=?");
        ps.setString(1, name);
        
        rs=ps.executeQuery();
        
        if(rs.next())
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
                
        }
        }        
        catch(Exception e)
        {
            System.out.println("Error= "+e);
        }   
        
           
            System.out.println("Enter column name whose rec u want to update");
            col=s1.next();
            System.out.println("------------------------");
            
            
        System.out.println("Enter new value for this column");
        value=s1.next();
        System.out.println("------------------------");
        
        try
        {
            ps=con.prepareStatement("update stud_info set "+col+"=? where name=?");
            ps.setString(1, value);
            ps.setString(2, name);
            
            int i=ps.executeUpdate();
            
            if(i>0)
            {
                System.out.println("Rec update successfully");
                System.out.println("------------------------");
                System.out.println("------------------------");
            }
            else
            {
                System.out.println("Rec not found");
                System.out.println("------------------------");
                System.out.println("------------------------");
            }
            new ManageRecord(con,s1,ps);
            }        
        catch(Exception ee)
        {
             System.out.println("Error ="+ee);
        }
    }
}

