package System.DAO;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterCustomerDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL query to insert data
    private static final String SQL_INSERT_CUSTOMER = "INSERT INTO customers (fullname, address, mobile, email, accountType, Balance, dob, idProofType, idProofInput, accountNumber, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean registerCustomer(String fullname, String address, String mobile, String email, String accountType, double balance, String dob, String idProofType, String idProofInput, String accountNumber, String username, String password) throws SQLException, ClassNotFoundException {
        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT_CUSTOMER)) {

            // Set parameters for the prepared statement
            pstmt.setString(1, fullname);
            pstmt.setString(2, address);
            pstmt.setString(3, mobile);
            pstmt.setString(4, email);
            pstmt.setString(5, accountType);
            pstmt.setDouble(6, balance);
            pstmt.setString(7, dob);
            pstmt.setString(8, idProofType);
            pstmt.setString(9, idProofInput);
            pstmt.setString(10, accountNumber);
            pstmt.setString(11, username);
            pstmt.setString(12, password);

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Generate a random 12-digit account number
    public String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }

    // Generate a random temporary password
    public String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 8; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Generate a username based on fullname and a random number
    public String generateUsername(String fullname) {
        SecureRandom random = new SecureRandom();
        String[] nameParts = fullname.split(" ");
        String baseUsername = nameParts[0].toLowerCase();
        int randomNumber = random.nextInt(10000);
        return baseUsername + randomNumber;
    }
}