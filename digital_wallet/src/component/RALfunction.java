package component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class RALfunction {
//  public String[] validPerson(String[] data) {
//      String[] result = {"true", ""};
//      return result;
//  }
//    public Boolean validAccount(String[] data) {
//        return true;
//    }
//    public Boolean validQA(String[] QA) {
//        return true;
//    }
//    public Boolean loginSuccess(String[] data) {
//        return true;
//    }
//    public String[] checkPerson(String[] data) {
//        String[] result = {"true", "someone"};
//        return result;
//    }
//    public void resetPassword(String Password){
//        
//    }
//    public String[] getQuestion(String Username){
//        String[] questions = {"Q1","Q2","Q3"};
//        return questions;
//    }
//    public String[] getAnswer(String Username){
//        String[] answers = {"A1","A2","A3"};
//        return answers;
//    }
    
    public static String DB_URL = "jdbc:mysql://localhost:3306/db_demo";
    public static String USER_NAME = "root";
    public static String PASSWORD = "";
    private static String[] data = new String[15];


    public static boolean registerData () {
        Connection conn = null;
        PreparedStatement pr = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            // Insert data
            String sql = "INSERT INTO registration (FullName, DateOfBirth, Gender, CitizenID, Email, Address, PhoneNumber, username, password, Q1, Q2, Q3, A1, A2, A3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pr = conn.prepareStatement(sql);

            pr.setString(1, data[0]);//fullname
            pr.setString(2, data[1]);//DoB
            pr.setString(3, data[2]);//Gender
            pr.setString(4, data[3]);//CitizenID
            pr.setString(5, data[4]);//Email
            pr.setString(6, data[5]);//Address
            pr.setString(7, data[6]);//PhoneNumber
            pr.setString(8, data[7]);//username
            pr.setString(9, data[8]);//password
            pr.setString(10, data[9]);//Q1
            pr.setString(11, data[10]);//Q2
            pr.setString(12, data[11]);//Q3
            pr.setString(13, data[12]);//A1
            pr.setString(14, data[13]);//A2
            pr.setString(15, data[14]);//A3

            int rowsInserted = pr.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối
            try {
                if (pr != null) pr.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] validPerson(String[] s) {
        String fullname = s[0];
        String dob = s[1];
        String gender = s[2];
        String citizenID = s[3];
        String email = s[4];
        String address = s[5];
        String phone = s[6];
        String[] result = new String[2];
        result[0] = "false";
        
        if (fullname.equals("")) {
            result[1] = "Please let us know your name";
            return result;
        }

        // Check DoB format
        if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
            result[1] = "Invalid DoB format. Use dd/mm/yyyy";
            return result;
        }

        // Check Gender Format
        if (!(gender.equals("Male") || gender.equals("Female"))) {
            result[1] = "Invalid Gender. Use 'Male' or 'Female'";
            return result;
        }
        
        if (citizenID.equals("")) {
            result[1] = "Please insert your CitizenID";
            return result;
        }
        
        if (email.equals("")) {
            result[1] = "Please insert your email address";
            return result;
        }
        
        if (address.equals("")) {
            result[1] = "Please insert your address";
            return result;
        }
        
        if (phone.equals("")) {
            result[1] = "Please insert your phone number";
            return result;
        }
        

        // Check for duplicate CitizenID or Email
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT CitizenID, Email, PhoneNumber FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                 ResultSet r1 = pr.executeQuery()) {
                while (r1.next()) {
                    if (r1.getString("CitizenID").equals(citizenID)) {
                        result[1] = "Duplicate CitizenID found.";
                        return result;
                    }
                    if (r1.getString("Email").equals(email)) {
                        result[1] = "Duplicate Email found.";
                        return result;
                    }
                    if (r1.getString("PhoneNumber").equals(phone)) {
                        result[1] = "Duplicate Phone number found.";
                        return result;
                    }
                }
                // insert data
                for (int i=0; i<7; i++) {
                    data[i] = s[i];
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result[1] = "There are some problem with our database";
            return result;
        }
        result[0] = "true";
        return result;
    }
    
    public static Boolean validAccount(String[] s) {
        String Username = s[0];
        String Password = s[1];

        // Check for username is in the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT UserName, Password FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                 ResultSet r1 = pr.executeQuery()) {

                while (r1.next()) {
                    if (r1.getString("UserName").equals(Username)) {
                        return false;
                    }
                }
                // insert data
                data[7] = Username;
                data[8] = Password;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static Boolean validQA(String[] s) {
        for (String str: s) {
            if (str.equals("")) {
                return false;
            }
        }
        for (int i=0; i<6; i++) {
            data[i+9] = s[i];
        }
        return registerData();
    }

    public static String[] loginSuccess(String[] s) {
        String Username = s[0];
        String Password = s[1];
        String[] result = new String[9];

        // Check for username is in the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT FullName, DateOfBirth, Gender, CitizenID, Email, Address, PhoneNumber, UserName, Password FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                 ResultSet r1 = pr.executeQuery()) {

                while (r1.next()) {
                    if (r1.getString("UserName").equals(Username) && r1.getString("Password").equals(Password)) {
                        result[0] = r1.getString("FullName");
                        result[1] = r1.getString("UserName");
                        result[2] = r1.getString("DateOfBirth");
                        result[3] = r1.getString("Gender");
                        result[4] = r1.getString("CitizenID");
                        result[5] = r1.getString("Email");
                        result[6] = r1.getString("PhoneNumber");
                        result[7] = r1.getString("Address");
                        result[8] = r1.getString("Password");
                        return result;
                    }
                }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        result[0] = null;
        return result;
    }

    public String[] checkPerson(String[] s) {
        String FullName =  s[0];
        String DoB = s[1];
        String Gender = s[2];
        String ID = s[3];
        String[] result = new String[2];
        result[0] = "true";

        // Check ID if it is UserName or CitizenID or Email
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT FullName, DateOfBirth, Gender, UserName, CitizenID, Email, PhoneNumber FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                 ResultSet r1 = pr.executeQuery()) {

                while (r1.next()) {
                    if (r1.getString("FullName").equals(FullName) && r1.getString("DateOfBirth").equals(DoB) && r1.getString("Gender").equals(Gender)) {
                        if (r1.getString("CitizenID").equals(ID) || r1.getString("Email").equals(ID) || r1.getString("UserName").equals(ID) || r1.getString("PhoneNumber").equals(ID)) {                   
                            result[1] = r1.getString("username");
                            return result;
                        }
                    }                  
                }
            }
        } catch (SQLException e) {
            result[0] = "false";
            return result;
        }
        result[0] = "false";
        return result;
    }

    public String[] getQuestion(String Username) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT UserName, Q1, Q2, Q3 FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                ResultSet r1 = pr.executeQuery()) {
                while (r1.next()) {
                    if (r1.getString("UserName").equals(Username)) {
                        String[] questions = new String[3];
                        questions[0] = r1.getString("Q1");
                        questions[1] = r1.getString("Q2");
                        questions[2] = r1.getString("Q3");
                        return questions;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getAnswer(String Username) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "SELECT UserName, A1, A2, A3 FROM registration";
            try (PreparedStatement pr = conn.prepareStatement(sql);
                ResultSet r1 = pr.executeQuery()) {
                while (r1.next()) {
                    if (r1.getString("UserName").equals(Username)) {
                        String[] answers = new String[3];
                        answers[0] = r1.getString("A1");
                        answers[1] = r1.getString("A2");
                        answers[2] = r1.getString("A3");
                        return answers;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void resetPassword(String[] s) {
        String Username = s[0];
        String Password = s[1];
        try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String sql = "UPDATE registration SET Password = ? WHERE UserName = ?";

            try (PreparedStatement pr = conn.prepareStatement(sql)) {
                pr.setString(1, Password);
                pr.setString(2, Username);
                int rowsUpdated = pr.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Record updated successfully!");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error!");
        }
    } 
}
    