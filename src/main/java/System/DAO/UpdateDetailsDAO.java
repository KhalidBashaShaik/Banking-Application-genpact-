package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDetailsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "qwer@1234";

    public boolean updateCustomerDetails(String accountNumber, String fullname, String address, String mobile,
            String email, String accountType, String dob, String idProofInput) {
        boolean success = false;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE customers SET Fullname = ?, Address = ?, Mobile = ?, Email = ?, AccountType = ?, DOB = ?, IdProofInput = ? WHERE accountNumber = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullname);
            stmt.setString(2, address);
            stmt.setString(3, mobile);
            stmt.setString(4, email);
            stmt.setString(5, accountType);
            stmt.setString(6, dob);
            stmt.setString(7, idProofInput);
            stmt.setString(8, accountNumber);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // You can throw a custom exception or handle it as needed
        }

        return success;
    }
}