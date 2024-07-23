package System.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.EditDetailsDAO;

@WebServlet("/EditDetailsServlet")
public class EditDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String accountNumber = request.getParameter("accountNumber");

        if (accountNumber == null || accountNumber.isEmpty()) {
            // Redirect to enterAccountNo.html to enter the account number
            response.sendRedirect("enterAccountNo.html");
            return;
        }

        try {
            EditDetailsDAO dao = new EditDetailsDAO();
            ResultSet rs = dao.getCustomerDetails(accountNumber);

            if (rs.next()) {
                request.setAttribute("fullname", rs.getString("Fullname"));
                request.setAttribute("address", rs.getString("Address"));
                request.setAttribute("mobile", rs.getString("Mobile"));
                request.setAttribute("email", rs.getString("Email"));
                request.setAttribute("accountType", rs.getString("AccountType"));
                request.setAttribute("dob", rs.getString("DOB"));
                request.setAttribute("idProofInput", rs.getString("IdProofInput"));

                request.getRequestDispatcher("/displayDetails.jsp").forward(request, response);
            } else {
                out.println("<html><body><h2>No customer found for account number " + accountNumber + "</h2></body></html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}