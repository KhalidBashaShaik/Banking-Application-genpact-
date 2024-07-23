package System.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.CreateAccountDAO;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CreateAccountDAO accountDAO;

    @Override
    public void init() throws ServletException {
        accountDAO = new CreateAccountDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String accountName = request.getParameter("accountName");
        String accountType = request.getParameter("accountType");
        double initialDeposit = Double.parseDouble(request.getParameter("initialDeposit"));

        try {
            boolean isSuccess = accountDAO.createAccount(accountName, accountType, initialDeposit);

            if (isSuccess) {
                out.println("<h2>Account created successfully!</h2>");
            } else {
                out.println("<h2>Failed to create account.</h2>");
            }
        } catch (ClassNotFoundException e) {
            out.println("<h2>Database driver not found.</h2>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<h2>Database error.</h2>");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("createAccountForm.jsp");
    }
}