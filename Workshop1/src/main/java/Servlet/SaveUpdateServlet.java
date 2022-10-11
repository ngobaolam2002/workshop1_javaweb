package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.JobDAO;

/**
 * Servlet implementation class SaveUpdateServlet
 */
@WebServlet("/SaveUpdateServlet")
public class SaveUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String updateErr = "updateErr.jsp";
    private final String Home = "/Home";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		String url = updateErr;
		if(button.equals("Save")){
			String jobid = request.getParameter("txtJobID");
			String jobname = request.getParameter("txtJobName");
			String jobcompany = request.getParameter("txtJobCompany");
			int year = Integer.parseInt(request.getParameter("txtYear_of_Experience"));
			try {
				JobDAO dao = new JobDAO();
				
				boolean result = dao.updateRecord(jobid, jobname, jobcompany, year );
				System.out.println(result);
				if(result) {
					System.out.println("Result UPDATE " + result);
					url = Home;
				}
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			url = Home;
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
