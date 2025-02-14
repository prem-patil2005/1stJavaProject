package studentadmission;

import java.util.Scanner;

public class Menu {
    Scanner s1;
    int sc;
    public Menu(Scanner s1) {
       this.s1 = s1;
       MenuDetail();
    }
    public void MenuDetail(){
        
          
            System.out.println("1. For Course Details");
            System.out.println("2. For Manage Record");
            System.out.println("3. for Registration of Exam.");
            System.out.println("4. for Show Registered Exams.");
            System.out.println("5. For logout");
            System.out.println("------------------------");
            System.out.println("ENTER YOUR CHOICE !");
            sc = s1.nextInt();
            System.out.println("------------------------");
            System.out.println("------------------------");
            switch (sc) {
                case 1:
                    new CourseDetail(s1);
                    break;
                case 2:
                    //new ManageRecord(s1);
                    break;
                case 3:
                    //new RegisterExam(s1);
                case 4:
                   // new Exam_rec(s1);
                case 5:
                    new Login(s1);
                    break;
                default:
                    System.out.println("Enter Valid Choice !");
            }
    }
}


