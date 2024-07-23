package System.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.UpdateDetailsDAO;

@WebServlet("/UpdateDetailsServlet")
public class UpdateDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UpdateDetailsDAO updateDetailsDAO;

    public void init() throws ServletException {
        super.init();
        updateDetailsDAO = new UpdateDetailsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String accountNumber = request.getParameter("accountNumber");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String accountType = request.getParameter("accountType");
        String dob = request.getParameter("dob");
        String idProofInput = request.getParameter("idProofInput");

        boolean updateSuccess = updateDetailsDAO.updateCustomerDetails(accountNumber, fullname, address, mobile,
                email, accountType, dob, idProofInput);

        if (updateSuccess) {
            response.sendRedirect("updateSuccess.jsp");
        } else {
            response.sendRedirect("updateFailed.jsp");
        }
    }
}