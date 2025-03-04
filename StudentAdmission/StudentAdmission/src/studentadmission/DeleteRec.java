
package studentadmission;

import Dao.AdminDao;
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
    public DeleteRec( Scanner s1) {
        this.s1 = s1;
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
            if (AdminDao.recordExists(name)) {
                System.out.println("Record found");
                System.out.println("Are you sure you want to delete this record? Press Y to confirm:");
                String ch = s1.next();
                System.out.println("------------------------");
                if ("Y".equalsIgnoreCase(ch)) {
                    if (AdminDao.deleteRecord(name)) {
                        System.out.println("Record deleted successfully");
                        System.out.println("------------------------");
                    } else {
                        System.out.println("Failed to delete the record.");
                    }
                }
            } else {
                System.out.println("Record not found");
            }
            new ManageRecord(s1);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    }
    


