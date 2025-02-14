
package studentadmission;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ExamPaper {
    Connection con;
    Scanner s1;
    int roll;
    PreparedStatement ps;
    ResultSet rs;

    public ExamPaper(Connection con, Scanner s1, PreparedStatement ps,int roll) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        this.roll = roll;
        displayAndRecordCorrectAnswers();
    }

    private void displayAndRecordCorrectAnswers() {
        String query = "SELECT question_id,question,option_a,option_b,option_c,option_d,correct_option FROM java ORDER BY RAND() LIMIT 10;";
        
        try 
             {
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
            System.out.println("---------- Exam Paper ----------");

            while (rs.next()) {
                int questionId = rs.getInt("question_id");
                String question = rs.getString("question");
                String optionA = rs.getString("option_a");
                String optionB = rs.getString("option_b");
                String optionC = rs.getString("option_c");
                String optionD = rs.getString("option_d");
                String correctOption = rs.getString("correct_option");

                System.out.println("Q" + questionId + ". " + question);
                System.out.println("A. " + optionA);
                System.out.println("B. " + optionB);
                System.out.println("C. " + optionC);
                System.out.println("D. " + optionD);
                System.out.println("------------------------------------");
                System.out.print("Enter your choice (A/B/C/D): ");

                String chosenOption = s1.next().toUpperCase();

                if (chosenOption.equals(correctOption)) {
                    saveCorrectAnswer(roll, questionId, chosenOption);
                }
            }
            

        } catch (Exception e) {
            System.out.println("Error fetching exam paper: " + e.getMessage());
        }
        try
        {
            ps=con.prepareStatement("UPDATE exam_reg SET status = 'Completed' WHERE roll = ?;");
            ps.setInt(1,roll);
            rs=ps.executeQuery();
            ps=con.prepareStatement("");
            new StudentLogin(con,s1,ps);

        }
        catch (Exception e){
            System.out.println("error ="+e);
        }
    }

    private void saveCorrectAnswer(int roll, int questionId, String chosenOption) {
        
        //String insertQuery = "INSERT INTO stud_ans VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO stud_ans VALUES (?, ?, ?)")) {
            ps.setInt(1, roll);
            ps.setInt(2, questionId);
            ps.setString(3, chosenOption);

            ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error saving correct answer: " + e.getMessage());
        }
    }
    
}
