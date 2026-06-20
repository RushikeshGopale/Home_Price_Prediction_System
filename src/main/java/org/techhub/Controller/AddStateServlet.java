package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.StateModel;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/AddStateServlet")
public class AddStateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		out.println("<form>");
		out.println("<div class='container bg-dark p-5 m-5'>");
		out.println("<div class='form-group m-2 p-2 ml-5'>");
		out.println("<h2 class='text-white'>Add new State</h2>");
		out.println("<input type='text' name='name' value='' class='form-control control ml-5'/>");
		out.println("</div>");
		out.println("<div class='form-group m-2 p-2 ml-5'>");
		out.println("<input type='submit' name='s' value='Add State' class='form-control control ml-5 bg-success'/>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			StateModel sm=new StateModel();
			String statename=request.getParameter("name");
			sm.setName(statename);
			StateService stateService=new StateServiceImpl();
			boolean b=stateService.isAddState(sm);
			if(b)
			{
				out.println("<h2> State Added Successfully </h2>");
			}
			else
			{
				out.println("<h2> State is not Added  </h2>");

			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
