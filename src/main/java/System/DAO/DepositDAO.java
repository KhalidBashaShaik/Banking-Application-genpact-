package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL queries
    private static final String SQL_UPDATE_BALANCE = "UPDATE customers SET Balance = Balance + ? WHERE accountNumber = ?";
    private static final String SQL_INSERT_TRANSACTION = "INSERT INTO transactions (accountNumber, transactionType, amount, description) VALUES (?, ?, ?, ?)";
    private static final String SQL_GET_BALANCE = "SELECT Balance FROM customers WHERE accountNumber = ?";

    public boolean deposit(String accountNumber, double amount) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmtUpdate = null;
        PreparedStatement pstmtInsert = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // Start transaction

            // Update balance
            pstmtUpdate = conn.prepareStatement(SQL_UPDATE_BALANCE);
            pstmtUpdate.setDouble(1, amount);
            pstmtUpdate.setString(2, accountNumber);

            int rowsUpdated = pstmtUpdate.executeUpdate();
            if (rowsUpdated == 0) {
                conn.rollback();
                return false;
            }

            // Insert transaction record
            pstmtInsert = conn.prepareStatement(SQL_INSERT_TRANSACTION);
            pstmtInsert.setString(1, accountNumber);
            pstmtInsert.setString(2, "deposit");
            pstmtInsert.setDouble(3, amount);
            pstmtInsert.setString(4, "Deposit");

            int rowsInserted = pstmtInsert.executeUpdate();
            if (rowsInserted == 0) {
                conn.rollback();
                return false;
            }

            conn.commit(); // Commit transaction
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Rollback transaction on error
            }
            throw e;
        } finally {
            // Close resources in finally block
            if (pstmtUpdate != null) pstmtUpdate.close();
            if (pstmtInsert != null) pstmtInsert.close();
            if (conn != null) conn.close();
        }
    }

    public double getBalance(String accountNumber) throws SQLException {
        double balance = 0.0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(SQL_GET_BALANCE)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("Balance");
            }

        } catch (SQLException e) {
            throw e;
        }

        return balance;
    }
}