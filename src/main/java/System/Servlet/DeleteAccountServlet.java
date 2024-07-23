package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.DeleteAccountDAO;

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeleteAccountDAO deleteAccountDAO;

    @Override
    public void init() throws ServletException {
        deleteAccountDAO = new DeleteAccountDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to DeleteAccountForm.jsp when the admin navigates to this servlet via GET request
        request.getRequestDispatcher("DeleteAccountForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        try {
            // Check account balance using DAO method
            double balance = deleteAccountDAO.getBalance(accountNumber);

            if (balance == 0) {
                // If balance is zero, proceed to delete the account
                boolean deletionSuccess = deleteAccountDAO.deleteAccount(accountNumber);

                if (deletionSuccess) {
                    // Redirect to a success page or show a success message
                    response.sendRedirect("deletion-success.jsp");
                } else {
                    // Redirect to an error page or show an error message
                    response.sendRedirect("deletion-error.jsp");
                }
            } else {
                // If balance is not zero, show a message that account cannot be deleted
                request.setAttribute("message", "Account cannot be deleted. Balance is not zero.");
                request.getRequestDispatcher("AccountDeletionError.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
            // Redirect to an error page or show an error message
            response.sendRedirect("deletion-error.jsp");
        }
    }
}