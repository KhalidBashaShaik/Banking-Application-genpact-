package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.DepositDAO;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DepositDAO depositDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        depositDAO = new DepositDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests (if any specific logic is needed)
        // For example, redirect to a form for deposit
        response.sendRedirect("depositForm.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");

        // Ensure the user is logged in
        if (accountNumber == null || accountNumber.isEmpty()) {
            response.sendRedirect("Login.jsp");
            return;
        }

        // Get amount from request parameter
        String amountStr = request.getParameter("amount");
        if (amountStr != null && !amountStr.isEmpty()) {
            try {
                double amount = Double.parseDouble(amountStr);

                // Perform deposit operation using DAO
                boolean success = depositDAO.deposit(accountNumber, amount);

                if (success) {
                    // Update session with new balance
                    double updatedBalance = depositDAO.getBalance(accountNumber);
                    session.setAttribute("Balance", updatedBalance);

                    // Redirect to customer home page
                    response.sendRedirect("customerHome.jsp");
                    return;
                } else {
                    // Deposit operation failed
                    response.sendRedirect("error1.jsp");
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid amount format
                e.printStackTrace();
            } catch (SQLException e) {
                // Handle database errors
                e.printStackTrace();
                response.sendRedirect("error1.jsp");
                return;
            }
        }

        // Handle invalid input or other errors
        response.sendRedirect("error1.jsp");
    }
}