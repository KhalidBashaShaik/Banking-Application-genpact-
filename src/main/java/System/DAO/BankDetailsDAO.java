package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.Model.Customer;

public class BankDetailsDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwer@1234";

    // SQL query to select all customers
    private static final String SQL_SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";

    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();

        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_ALL_CUSTOMERS);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(
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
                customerList.add(customer);
            }
        }
        return customerList;
    }
}