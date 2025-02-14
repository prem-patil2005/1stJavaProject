
package studentadmission;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

class ManageRecord {
    Connection con;
    Scanner s1;
    PreparedStatement ps;
    int ch;

    public ManageRecord( Scanner s1) {
     
        this.s1 = s1;
    
        recordMenu();
    }
    public void recordMenu(){
        System.out.println("1. For Search Record");
        System.out.println("2. For Update Record");
        System.out.println("3. For Show Record");
        System.out.println("4. For Delete Record");
        System.out.println("5. Back");
        System.out.println("------------------------");
        System.out.println("ENTER YOUR CHOICE !");
        ch = s1.nextInt();
        System.out.println("------------------------");
        System.out.println("------------------------");
        
        switch (ch) {
                case 1:
                    new SearchRec(s1);
                    break;
                case 2:
                    new UpdateRec(s1);
                    break;
                case 3:
                    new ShowRec(s1);
                    break;
                case 4:
                    new DeleteRec(s1);
                case 5:
                    new Menu(s1);
                default:
                    System.out.println("Enter Valid Choice !");
            }
    }
}

