package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.Model.Customers;

public class AccountDetailsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "qwer@1234";

    public Customers getCustomerDetails(String accountNumber) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customers WHERE accountNumber = ?";
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Customers customer = new Customers(
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
                    rs.getString("password"),
                    rs.getDouble("balance")
                );
                return customer;
            }
        }
        return null; // Return null if no customer found
    }
}