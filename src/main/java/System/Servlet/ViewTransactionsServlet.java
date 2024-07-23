package System.Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.ViewTransactionsDAO;
import System.Model.Transaction;

@WebServlet("/ViewTransactionsServlet")
public class ViewTransactionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViewTransactionsDAO viewTransactionsDAO;

    public void init() throws ServletException {
        super.init();
        viewTransactionsDAO = new ViewTransactionsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("username");

        if (accountNumber == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        List<Transaction> transactions = viewTransactionsDAO.getTransactions(accountNumber);

        // Set transactions in request attribute to be accessed in JSP
        request.setAttribute("transactions", transactions);

        // Forward to JSP to display transactions
        request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
    }
}