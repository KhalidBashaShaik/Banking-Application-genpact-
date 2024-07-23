package System.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawalDAO {

    public static double getUpdatedBalance(String accountNumber, Connection conn) throws SQLException {
        double balance = 0.0;
        String sql = "SELECT Balance FROM customers WHERE accountNumber = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("Balance");
            }
        }
        return balance;
    }

    public static boolean updateBalance(String accountNumber, double withdrawalAmount, Connection conn) throws SQLException {
        String updateSql = "UPDATE customers SET Balance = Balance - ? WHERE accountNumber = ?";
        try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql)) {
            pstmtUpdate.setDouble(1, withdrawalAmount);
            pstmtUpdate.setString(2, accountNumber);

            int rowsUpdated = pstmtUpdate.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public static boolean insertTransaction(String accountNumber, double withdrawalAmount, Connection conn) throws SQLException {
        String insertSql = "INSERT INTO transactions (accountNumber, transactionType, amount, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmtInsert = conn.prepareStatement(insertSql)) {
            pstmtInsert.setString(1, accountNumber);
            pstmtInsert.setString(2, "withdrawal");
            pstmtInsert.setDouble(3, withdrawalAmount);
            pstmtInsert.setString(4, "Withdrawal");

            int rowsInserted = pstmtInsert.executeUpdate();
            return rowsInserted > 0;
        }
    }
}