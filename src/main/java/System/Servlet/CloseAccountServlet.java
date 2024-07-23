package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.CloseAccountDAO;

@WebServlet("/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CloseAccountDAO closeAccountDAO;

    @Override
    public void init() throws ServletException {
        closeAccountDAO = new CloseAccountDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests, for example, show a confirmation page
        // You can customize this according to your application flow
        response.sendRedirect("confirmCloseAccount.jsp"); // Example redirect
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");

        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        try {
            // Check if balance is zero
            double balance = closeAccountDAO.getBalance(accountNumber);

            if (balance != 0.0) {
                // Redirect to error page or display a message that account cannot be closed
                response.sendRedirect("error1.jsp");
                return;
            }

            // Proceed to close account
            if (closeAccountDAO.deleteAccount(accountNumber)) {
                // Account closure successful
                session.invalidate();
                response.sendRedirect("accountClosed.jsp");
            } else {
                // Account closure failed
                response.sendRedirect("error1.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        }
    }
}