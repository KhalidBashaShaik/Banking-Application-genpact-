package System.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.Model.Transaction;

public class ViewTransactionsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "qwer@1234";

    public List<Transaction> getTransactions(String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE accountNumber = ? AND (transactionType = 'deposit' OR transactionType = 'withdrawal') ORDER BY transactionDate DESC LIMIT 10";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String accountNumber1 = rs.getString("accountNumber");
                String transactionType = rs.getString("transactionType");
                double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                String transactionDate = rs.getString("transactionDate");

                Transaction transaction = new Transaction(accountNumber1, transactionType, amount, description, transactionDate);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException as needed
        }

        return transactions;
    }
}