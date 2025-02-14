
package Dao;

import static connection.DatabaseConnection.getCon;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import studentadmission.AdminLogin;


public class AdminDao {
    public static boolean validate(String user,String pass) {
        boolean status=false;
           try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from user_pass where user=? and pass=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }
        catch(Exception ee)
        {
            System.out.println("Errorr "+ee);
        }
           return status;
    }
    public static boolean infoFill(String name,String add,int mob,String mail,int roll,String courseName,String du,int fee) {
        
        boolean status=false;
           try
        {
            String c;
            Connection con=getCon();
           c=AdminLogin.coun_name;
        PreparedStatement ps=con.prepareStatement("insert into stud_info values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setString(3, add);
            ps.setInt(4, mob);
            ps.setString(5,mail);
            ps.setString(6, c);
            ps.setDate(7, new java.sql.Date(new Date().getTime()));
            ps.setString(8, courseName);
            ps.setString(9, du);
            ps.setInt(10, fee);
            con.close();
        }
        catch(Exception ee)
        {
            System.out.println("Errorr "+ee);
        }
           return status;
    }
 public static boolean show_Rec(String name) {
        
        boolean status=false;
        try
        {
             Connection con=getCon();
             PreparedStatement ps=con.prepareStatement("select * from stud_info where name=?");
            ps.setString(1,name);
           ResultSet rs=ps.executeQuery();
           status=rs.next();
        }
        catch(Exception ee)
        {
            System.out.println("Errorr "+ee);
        }
           return status;
    }
}
