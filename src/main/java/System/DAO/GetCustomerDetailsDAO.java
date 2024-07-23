package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.Model.Customer;

public class GetCustomerDetailsDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/bankdatabase";
    private String dbUser = "root";
    private String dbPassword = "qwer@1234";

    public Customer getCustomerByAccountNumber(String accountNumber) {
        String sql = "SELECT * FROM customers WHERE accountNumber = ?";
        Customer customer = null;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("address"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getString("accountType"),
                        rs.getString("dob"),
                        rs.getString("idProofType"),
                        rs.getString("idProofInput"),
                        rs.getString("accountNumber"),
                        rs.getString("password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // You can throw a custom exception or handle it as needed
        }

        return customer;
    }
}