
package Dao;

import static connection.DatabaseConnection.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {
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

    public static boolean insertExamRegistration(int rollNo, String subject, java.sql.Date examDate, String status) {
        
        try{
            ps = con.prepareStatement("INSERT INTO exam_reg (roll_no, subject, register_date, status) VALUES (?, ?, ?, ?)");
            ps.setInt(1, rollNo);
            ps.setString(2, subject);
            ps.setDate(3, examDate);
            ps.setString(4, status);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error while inserting exam registration: " + e.getMessage());
            return false;
        }
    }
    public static List<ExamRecord> getAllExamRecords() {
        List<ExamRecord> records = new ArrayList<>();

        try {
             ps = con.prepareStatement("SELECT roll, subject, register_date, status FROM exam_reg");
             rs = ps.executeQuery();
            while (rs.next()) {
                int roll = rs.getInt("roll");
                String subject = rs.getString("subject");
                String registerDate = rs.getString("register_date");
                String status = rs.getString("status");

                ExamRecord record = new ExamRecord(roll, subject, registerDate, status);
                records.add(record);
            }
        } catch (Exception e) {
            System.out.println("Error fetching records: " + e.getMessage());
        }

        return records;
    }
}

