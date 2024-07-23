package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountDAO {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    public boolean createAccount(String accountName, String accountType, double initialDeposit) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement
            String sql = "INSERT INTO accounts (name, type, balance) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountName);
            pstmt.setString(2, accountType);
            pstmt.setDouble(3, initialDeposit);

            // Execute the statement
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } finally {
            // Close the resources
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
}