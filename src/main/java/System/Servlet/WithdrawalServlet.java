package System.Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.WithdrawalDAO;

@WebServlet("/WithdrawalServlet")
public class WithdrawalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("withdrawalForm.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");

        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        double withdrawalAmount = Double.parseDouble(request.getParameter("amount"));

        String jdbcUrl = "jdbc:mysql://localhost:3306/bankdatabase";
        String dbUser = "root";
        String dbPassword = "qwer@1234";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            conn.setAutoCommit(false);

            double currentBalance = WithdrawalDAO.getUpdatedBalance(accountNumber, conn);
            if (currentBalance < withdrawalAmount) {
                response.sendRedirect("error1.jsp");
                return;
            }

            boolean balanceUpdated = WithdrawalDAO.updateBalance(accountNumber, withdrawalAmount, conn);
            if (!balanceUpdated) {
                conn.rollback();
                response.sendRedirect("error1.jsp");
                return;
            }

            boolean transactionInserted = WithdrawalDAO.insertTransaction(accountNumber, withdrawalAmount, conn);
            if (!transactionInserted) {
                conn.rollback();
                response.sendRedirect("error1.jsp");
                return;
            }

            conn.commit();

            double updatedBalance = WithdrawalDAO.getUpdatedBalance(accountNumber, conn);
            session.setAttribute("Balance", updatedBalance);

            response.sendRedirect("customerHome.jsp");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}