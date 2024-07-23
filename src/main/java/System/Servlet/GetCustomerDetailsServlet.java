package System.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.GetCustomerDetailsDAO;
import System.Model.Customer;

@WebServlet("/GetCustomerDetailsServlet")
public class GetCustomerDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GetCustomerDetailsDAO customerDetailsDAO;

    public void init() throws ServletException {
        super.init();
        customerDetailsDAO = new GetCustomerDetailsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        Customer customer = customerDetailsDAO.getCustomerByAccountNumber(accountNumber);

        if (customer != null) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("bank-details.jsp").forward(request, response);
        } else {
            // If no customer found with the provided account number, handle accordingly
            response.sendRedirect("bank-details.jsp"); // Redirect to the same page with no customer details shown
        }
    }
}