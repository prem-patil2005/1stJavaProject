
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteRec 
{
 
     Connection con;
    Scanner s1;
    PreparedStatement ps;
    ResultSet rs;
     String name;
    public DeleteRec(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        
        delMethod();
    }
    
    public void delMethod()
    {
        System.out.println("Enter name whose rec u want to delete");
        name=s1.next();
        System.out.println("------------------------");
        chkRec();
    }
    
    public void chkRec()
    {
        try
        {
           
            ps=con.prepareStatement("select * from stud_info where name=?");
            ps.setString(1,name);
           rs=ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Record found");
                System.out.println("R u sure to del thi rec press Y");
                String ch;
                ch=s1.next();
                System.out.println("------------------------");
                
                if(ch.equals("Y"))
                {
                    try
                    {
                    ps=con.prepareStatement("delete  from stud_info where name=?");
                    ps.setString(1,name);
                    
                    int i=ps.executeUpdate();
                    
                    if(i>0)
                    {
                        System.out.println("rec deleted successfully");
                        System.out.println("------------------------");
                        System.out.println("------------------------");
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.println("errorr= "+e);
                        System.out.println("------------------------");
                        System.out.println("------------------------");
                    }
                    }
                }
            else{
                System.out.println("Record Not Found");
            }
            new ManageRecord(con,s1,ps);
            }
        catch(Exception e)
        {
            System.out.println("error= "+e);
        }
        }
        
    }
    


