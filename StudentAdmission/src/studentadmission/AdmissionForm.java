
package studentadmission;

import Dao.AdminDao;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;


public class AdmissionForm {
    Scanner s1;
    String name,add,mail;
    int mob;
    Connection con;
    PreparedStatement ps;
    int fee;
    String courseName,du;
    int sc;
     int roll;
    
    public AdmissionForm(Scanner s1,String du,int fee,String courseName) {
        this.s1 = s1;
        this.du = du;
        this.fee = fee;
        this.courseName  = courseName;
        form();
    }
    public void form(){
        System.out.println("!! ADMISSION FORM !!");
        System.out.println("Enter Your Name");
        name = s1.next();
        System.out.println("Enter Your Address");
        add = s1.next();
        System.out.println("Enter Your Mobile Number");
        mob = s1.nextInt();
        System.out.println("Enter Your Email ID");
        mail = s1.next();
        System.out.println("Enter Your Roll Number");
        roll = s1.nextInt();
        System.out.println("------------------------");
        System.out.println("------------------------");
        
         boolean status=AdminDao.infoFill(name,add,mob,mail,roll,courseName,du,fee);
          try{
            if(status)
            {
                System.out.println("Admission Succesful !!");
                System.out.println("------------------------");
                System.out.println("------------------------");
            }
            else
            {
                System.out.println("Error  !!");
                System.out.println("------------------------");
            }
        }
        catch(Exception e){
            System.out.println("Errorr "+e);
        }
    }
 
}
