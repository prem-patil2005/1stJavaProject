package studentadmission;

import Dao.AdminDao;
import Validation.ValidationUtil;
import java.util.Scanner;

public class AdmissionForm {
    Scanner s1;
    String name, add, mail;
    int mob;
    int fee;
    String courseName, du;
    int roll;

    public AdmissionForm(Scanner s1, String du, int fee, String courseName) {
        this.s1 = s1;
        this.du = du;
        this.fee = fee;
        this.courseName = courseName;
        form();
    }

    public void form() {
        System.out.println("!! ADMISSION FORM !!");

        while (true) {
            System.out.print("Enter Your Name: ");
            name = s1.next();
            s1.nextLine();
            if (ValidationUtil.isValidName(name)) {
                break;
            } else {
                System.out.println("Invalid Name! Please enter only alphabetic characters and spaces.");
            }
        }

        while (true) {
            System.out.print("Enter Your Address: ");
            add = s1.next();
            s1.nextLine();
            if (ValidationUtil.isValidAddress(add)) {
                break;
            } else {
                System.out.println("Invalid Address! Please enter only alphabetic characters, numbers, spaces, commas, periods, and hyphens.");
            }
        }

        while (true) {
            System.out.print("Enter Your Mobile Number: ");
            mob = s1.nextInt();
            s1.nextLine();
            if (ValidationUtil.isValidMobileNumber(mob)) {
                break;
            } else {
                System.out.println("Invalid Mobile Number! Please enter a 10-digit number.");
            }
        }

        while (true) {
            System.out.print("Enter Your Email ID: ");
            mail = s1.next();
            if (ValidationUtil.isValidEmail(mail)) {
                break;
            } else {
                System.out.println("Invalid Email! Please enter a valid email (e.g., example@mail.com).");
            }
        }

        while (true) {
            System.out.print("Enter Your Roll Number: ");
            roll = s1.nextInt();
            s1.nextLine();
            if (ValidationUtil.isValidRollNumber(roll)) {
                break;
            } else {
                System.out.println("Invalid Roll Number! Please enter a valid number.");
            }
        }

        System.out.println("------------------------");

        try {
            boolean status = AdminDao.infoFill(name, add, mob, mail, roll, courseName, du, fee);
            if (status) {
                System.out.println("Admission Successful !!");
                new CourseDetail(s1);
            } else {
                System.out.println("Error in Admission !!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
