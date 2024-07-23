package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.CheckBalanceDAO;

@WebServlet("/CheckBalanceServlet")
public class CheckBalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CheckBalanceDAO checkBalanceDAO;

    @Override
    public void init() throws ServletException {
        checkBalanceDAO = new CheckBalanceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login if session is not valid
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");
        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        try {
            double balance = checkBalanceDAO.getBalance(accountNumber);

            if (balance != -1) {
                session.setAttribute("balance", balance);
                request.getRequestDispatcher("checkBalance.jsp").forward(request, response);
            } else {
                response.sendRedirect("error1.jsp");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        }
    }
}