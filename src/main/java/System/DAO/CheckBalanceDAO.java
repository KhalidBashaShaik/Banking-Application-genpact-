package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL query to select balance by account number
    private static final String SQL_SELECT_BALANCE_BY_ACCOUNT_NUMBER = "SELECT balance FROM customers WHERE accountNumber = ?";

    public double getBalance(String accountNumber) throws SQLException, ClassNotFoundException {
        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_BALANCE_BY_ACCOUNT_NUMBER)) {

            // Set parameter for the prepared statement
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                return -1; // Return -1 to indicate balance not found
            }
        }
    }
}