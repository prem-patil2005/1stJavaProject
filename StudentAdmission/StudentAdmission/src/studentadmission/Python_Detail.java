
package studentadmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Python_Detail {
    Scanner s1;
    Connection con;
    PreparedStatement ps;
    int ch;
    String n;
    int fee = 250000;
    String du = "3 Years",courseName = "PYTHON";
  

    public Python_Detail(Scanner s1) {
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
                        break;
        }
        }
        public void showDetail(Scanner s1){
            
            System.out.println("Name of The Course : Masters of Computer Application.");
            System.out.println("Duration : 3 Years.");
            System.out.println("Fees : 2 Lakh 50 Thousand.");
            System.out.println("Popular Subjects : Java , C , C++ , Python , SQL .");
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

