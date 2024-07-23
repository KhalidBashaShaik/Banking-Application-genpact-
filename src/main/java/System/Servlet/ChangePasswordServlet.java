package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.ChangePasswordDAO;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ChangePasswordDAO changePasswordDAO;

    @Override
    public void init() throws ServletException {
        changePasswordDAO = new ChangePasswordDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login if session is not valid
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        // Forward to JSP to display change password form
        request.getRequestDispatcher("changepassword.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login if session is not valid
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");
        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        // Get parameters from form
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Perform validation
        if (currentPassword == null || newPassword == null || confirmPassword == null ||
            newPassword.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
            response.sendRedirect("changepassword.jsp?error=emptyFields");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            response.sendRedirect("changepassword.jsp?error=passwordMismatch");
            return;
        }

        if (newPassword.length() < 8) {
            response.sendRedirect("changepassword.jsp?error=passwordLength");
            return;
        }

        try {
            boolean isUpdated = changePasswordDAO.updatePassword(accountNumber, currentPassword, newPassword);

            if (isUpdated) {
                // Password updated successfully
                response.sendRedirect("passwordChanged.jsp");
            } else {
                // Password update failed (current password incorrect)
                response.sendRedirect("changepassword.jsp?error=incorrectPassword");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        }
    }
}