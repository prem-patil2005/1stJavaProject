package studentadmission;


import Dao.AdminDao;
import java.util.Scanner;


public class AdminLogin {
    String user,pass;
    Scanner s1;
    int no=3;
    public static String coun_name;

    public AdminLogin(Scanner s1) {
        this.s1 = s1;
        do{
            insert();
            no--;
        }while(no!=0);
        
        
    }
    public void insert() {
        System.out.print("Enter Your Username: ");
        user = s1.next();

        System.out.print("Enter Your Password: ");
        pass = s1.next();
        System.out.println("------------------------");
        
        boolean status=AdminDao.validate(user, pass);
      try
        {
        if(status){
            coun_name=user;
           new Menu (s1);
	}
        }
        catch (Exception e){
            System.out.println("error ="+e);
        }
    }
}
