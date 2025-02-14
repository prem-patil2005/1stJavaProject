
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Java_Detail {
    Scanner s1;
    Connection con;
    PreparedStatement ps;
    int ch;
    String n;
    int fee = 150000;
    String du = "1 Years",courseName = "JAVA";
  

    public Java_Detail(Scanner s1) {
        this.s1 = s1;
        
    
            
            System.out.println("1 : Show Details of Course");
            System.out.println("2 : Admission Form");
            System.out.println("3 : Menu");
            System.out.println("------------------------");
            System.out.println("Enter Your Choice.");
            ch=s1.nextInt();
            System.out.println("------------------------");
            
            
                        
            
            switch (ch) {
           		 case 1:
                	 showDetail(s1);
                	break;
                        case 2:
                	 new AdmissionForm(s1,du,fee,courseName);
                	break;
                        case 3:
                	new CourseDetail(s1);
                	break;
                        default:
                	System.out.println("Enter Valid Choice !");
                        System.out.println("------------------------");
                        break;
        }
        }
        public void showDetail(Scanner s1){
            
            System.out.println("Name of The Course : JAVA.");
            System.out.println("Duration : 1 Years.");
            System.out.println("Fees : 1 Lakh 50 Thousand.");
            System.out.println("Popular Subjects : Core Java .");
            System.out.println("------------------------");
        
            System.out.println("Do You Want to Confirm Admission !!");
            System.out.println("If yes then press Y ");
            n=s1.next();
            System.out.println("------------------------");
            if(n.equals("Y")){
                new AdmissionForm(s1,du,fee,courseName);
            }
            else{
                new  CourseDetail(s1);
            }
        }
}

