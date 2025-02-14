
package Dao;

import static connection.DatabaseConnection.getCon;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import studentadmission.AdminLogin;
import java.util.ArrayList;
import java.util.List;


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
 public static boolean search_Rec(String name) {
        
        boolean status=false;
        try
        {
             Connection con=getCon();
             PreparedStatement ps=con.prepareStatement("select * from stud_info where name=?");
            ps.setString(1,name);
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
  public static Student getStudentByName(String name) {
        Student student = null;
        try
        {
            Connection con=getCon();
            PreparedStatement ps = con.prepareStatement( "SELECT * FROM stud_info WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                student = new Student(
                        rs.getInt(1), // roll number
                        rs.getString(2), // name
                        rs.getString(3), // address
                        rs.getInt(4), // mobile number
                        rs.getString(5), // email
                        rs.getString(6), // counselor name
                        rs.getString(7), // admission date
                        rs.getString(8), // course name
                        rs.getString(9), // duration
                        rs.getInt(10) // fee
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching student details: " + e.getMessage());
        }
        return student;
    }
  public static boolean updateStudent(String column, String value, String name) {
        try
        {
            Connection con=getCon();
            PreparedStatement ps = con.prepareStatement( "UPDATE stud_info SET " + column + "=? WHERE name=?");
            ps.setString(1, value);
            ps.setString(2, name);
            int rowsAffected = ps.executeUpdate();
            con.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error updating student record: " + e.getMessage());
            return false;
        }
    }
  public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        
        try
           {
            Connection con=getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stud_info");
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1), // roll number
                        rs.getString(2), // name
                        rs.getString(3), // address
                        rs.getInt(4), // mobile number
                        rs.getString(5), // email
                        rs.getString(6), // counselor name
                        rs.getString(7), // admission date
                        rs.getString(8), // course name
                        rs.getString(9), // duration
                        rs.getInt(10) // fee
                );
                students.add(student);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        
        return students;
    }
}
