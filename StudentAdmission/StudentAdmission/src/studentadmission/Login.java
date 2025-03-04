
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Login {
    Scanner s1;
    Connection con;
    PreparedStatement ps;
    int ch,no=3;

    public Login(Scanner s1){
        this.s1=s1;
        multiLogin();
    }
    
    public void multiLogin(){
        
        System.out.println("1. For Admin Login");
        System.out.println("2. For Student Login");
        System.out.println("ENTER YOUR CHOICE !");
        ch = s1.nextInt();
        switch (ch) {
                case 1:
                    new AdminLogin(s1);
                    break;
                case 2:
                    new StudentLogin(con,s1,ps);
                    break;
                
                default:
                    System.out.println("Enter Valid Choice !");
            }
    }
}
