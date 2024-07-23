package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL query to update password
    private static final String SQL_UPDATE_PASSWORD = "UPDATE customers SET Password = ? WHERE accountNumber = ? AND Password = ?";

    public boolean updatePassword(String accountNumber, String currentPassword, String newPassword) throws SQLException, ClassNotFoundException {
        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_PASSWORD)) {

            // Set parameters for the prepared statement
            pstmt.setString(1, newPassword);
            pstmt.setString(2, accountNumber);
            pstmt.setString(3, currentPassword);

            // Execute the update statement
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}