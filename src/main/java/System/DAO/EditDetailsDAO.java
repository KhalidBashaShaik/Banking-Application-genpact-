package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDetailsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "qwer@1234";

    public ResultSet getCustomerDetails(String accountNumber) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        String sql = "SELECT * FROM customers WHERE accountNumber = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, accountNumber);
        return stmt.executeQuery();
    }
}