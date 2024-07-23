package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.RegisterCustomerDAO;

@WebServlet("/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RegisterCustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new RegisterCustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String accountType = request.getParameter("accountType");
        double balance = Double.parseDouble(request.getParameter("Balance"));
        String dob = request.getParameter("dob");
        String idProofType = request.getParameter("idProofType");
        String idProofInput = request.getParameter("idProofInput");

        // Generate 12-digit account number
        String accountNumber = customerDAO.generateAccountNumber();
        // Generate temporary password
        String temporaryPassword = customerDAO.generateTemporaryPassword();
        // Generate username
        String username = customerDAO.generateUsername(fullname);

        try {
            boolean isSuccess = customerDAO.registerCustomer(fullname, address, mobile, email, accountType, balance, dob, idProofType, idProofInput, accountNumber, username, temporaryPassword);

            if (isSuccess) {
                // Set the account number, username, and temporary password as request attributes
                request.setAttribute("accountNumber", accountNumber);
                request.setAttribute("username", username);
                request.setAttribute("temporaryPassword", temporaryPassword);

                // Forward to the success page
                request.getRequestDispatcher("registration-success.jsp").forward(request, response);
            } else {
                // Redirect to an error page or show an error message
                response.sendRedirect("registration-error.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Redirect to an error page or show an error message
            response.sendRedirect("registration-error.jsp");
        }
    }
}