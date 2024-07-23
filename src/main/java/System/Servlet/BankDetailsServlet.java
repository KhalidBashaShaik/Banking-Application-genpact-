package System.Servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.BankDetailsDAO;
import System.Model.Customer;

@WebServlet("/BankDetailsServlet")
public class BankDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private BankDetailsDAO bankDetailsDAO;

    @Override
    public void init() throws ServletException {
        bankDetailsDAO = new BankDetailsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Customer> customerList = bankDetailsDAO.getAllCustomers();
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("bank-details.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}