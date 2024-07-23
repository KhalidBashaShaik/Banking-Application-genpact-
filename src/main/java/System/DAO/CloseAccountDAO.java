package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseAccountDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL query to check balance by account number
    private static final String SQL_CHECK_BALANCE = "SELECT Balance FROM customers WHERE accountNumber = ?";

    // SQL query to delete customer account by account number
    private static final String SQL_DELETE_ACCOUNT = "DELETE FROM customers WHERE accountNumber = ?";

    public double getBalance(String accountNumber) throws SQLException {
        double balance = 0.0;

        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK_BALANCE)) {

            // Set parameter for the prepared statement
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("Balance");
            }
        }

        return balance;
    }

    public boolean deleteAccount(String accountNumber) throws SQLException {
        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_ACCOUNT)) {

            // Set parameter for the prepared statement
            pstmt.setString(1, accountNumber);
            int rowsDeleted = pstmt.executeUpdate();

            return rowsDeleted > 0;
        }
    }
}