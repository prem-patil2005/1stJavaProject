package studentadmission;

import Dao.AdminDao;
import java.util.Scanner;

public class AdminLogin {
    String user,pass;
    Scanner s1;
    private int attempts = 3;
    public static String coun_name;

    public AdminLogin(Scanner s1) {
        this.s1 = s1;
        while (attempts > 0) {
            if (insert()) {
                break;
            } else {
                attempts--;
                System.out.println("You have " + attempts + " attempts left.");
            }
        }
        if (attempts == 0) {
            System.out.println("Maximum login attempts reached. Please try again later.");
        }
    }
    public boolean insert() {
        System.out.print("Enter Your Username: ");
        user = s1.next();
        s1.nextLine();

        System.out.print("Enter Your Password: ");
        pass = s1.next();
        s1.nextLine();
        System.out.println("------------------------");
        
        boolean status=AdminDao.validate(user, pass);
      try
        {
        if(status){
            coun_name=user;
           new Menu (s1);
           return true;
	}else{
            System.out.println("Invalid Username or Password");
            return false;
        }
        
        }
        catch (Exception e){
            System.out.println("error ="+e);
            return false;
        }
    }
}
