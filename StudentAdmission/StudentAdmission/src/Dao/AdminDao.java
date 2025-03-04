
package Dao;

import static connection.DatabaseConnection.getCon;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import studentadmission.AdminLogin;
import java.util.ArrayList;
import java.util.List;



public class AdminDao {
    
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    static{
        try {
            con = getCon();
        } catch (SQLException ex) {
            System.out.println("Errorr "+ex);
        }
    }
    
    public static boolean validate(String user,String pass) {
        boolean status=false;
           try
        {
            ps=null;
            rs=null;
            ps=con.prepareStatement("select * from user_pass where user=? and pass=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs=ps.executeQuery();
            status=rs.next();
           
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
            ps=null;
            rs=null;
            
           c=AdminLogin.coun_name;
            ps=con.prepareStatement("insert into stud_info values(?,?,?,?,?,?,?,?,?,?)");
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
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
            status = true;
            }
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
            ps=null;
            rs=null;
            ps=con.prepareStatement("select * from stud_info where name=?");
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
  public static Student getStudentByName(String name) {
        Student student = null;
        try
        {
           ps=null;
            rs=null;
            ps = con.prepareStatement( "SELECT * FROM stud_info WHERE name=?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10) 
                );
            }
          
        } catch (Exception e) {
            System.out.println("Error fetching student details: " + e.getMessage());
        }
        return student;
    }
  public static boolean updateStudent(String column, String value, String name) {
        try
        {
          ps=null;
            rs=null;
            ps = con.prepareStatement( "UPDATE stud_info SET " + column + "=? WHERE name=?");
            ps.setString(1, value);
            ps.setString(2, name);
            int rowsAffected = ps.executeUpdate();
           
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
            ps=null;
            rs=null;
            ps = con.prepareStatement("SELECT * FROM stud_info");
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                );
                students.add(student);
            }
            
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        
        return students;
    }
    public static boolean recordExists(String name) {
        ps=null;
        rs=null;
        try {
            ps = con.prepareStatement("SELECT * FROM stud_info WHERE name = ?");
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            System.out.println("Error in recordExists: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteRecord(String name) {
        try{
            ps=null;
            rs=null;
            ps = con.prepareStatement("DELETE FROM stud_info WHERE name = ?");
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error in deleteRecord: " + e.getMessage());
            return false;
        }
    }
}
