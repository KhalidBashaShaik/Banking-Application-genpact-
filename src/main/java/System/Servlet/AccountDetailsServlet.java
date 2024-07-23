package System.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.AccountDetailsDAO;
import System.Model.Customers;

@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDetailsDAO accountDetailsDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        accountDetailsDAO = new AccountDetailsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");

        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        try {
            Customers customer = accountDetailsDAO.getCustomerDetails(accountNumber);

            if (customer != null) {
                session.setAttribute("customerFullName", customer.getFullname());
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("accountDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect("error1.jsp");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error1.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}