package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.JobDAO;
import Job.JobInsertErr;


@WebServlet("/CreateJobServlet")
public class CreateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String showInsertErr = "job.jsp";
    private final String home = "/Home";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobInsertErr err = new JobInsertErr();
		String jobid = request.getParameter("txtJobID");
		String jobname = request.getParameter("txtJobName");
		String jobcompany = request.getParameter("txtJobCompany");
		int year = Integer.parseInt(request.getParameter("txtYear_of_Experience"));
		System.out.println(jobid +":"+jobname +":"+jobcompany+":"+year);
		String url = showInsertErr;
		try {
			JobDAO dao = new JobDAO();
			boolean error = false;
			
			if(dao.searchJob_ID(jobid)) {
				error = true;
				err.setJobIDErr("Id da ton tai. Vui long thu lai");
			}
			if(jobid.length() != 4 || !(jobid.matches("J(.*)") )) {
				error = true;
				err.setJobIDErr("Job_ID must be 4 character: begin letter J and 3 number (ex: Jxxx)");
			}
			if(error) {
				request.setAttribute("insertErr", err);
			}else {
				
				System.out.println("da vo toi day");
				boolean result = dao.insertJob(jobid, jobname, jobcompany, year);
				if(result) {
					url = home;
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}catch (NamingException ex) {
			ex.getMessage();
		}catch (SQLException ex) {
			ex.getMessage();
			err.setJobIDIsExit(jobid + " da ton tai");
			request.setAttribute("insertERR", err);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
	}

}
