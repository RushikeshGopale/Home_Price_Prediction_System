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
import org.techhub.Service.*;
@WebServlet("/UpdateStateServlet")
public class UpdateStateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		
		int stateId=Integer.parseInt(request.getParameter("stateid"));
		String stateName=request.getParameter("statename");

		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container p-5 mt-1 bg-dark text-white'>");
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' name ='id' value='"+stateId+"' placeholder='enter StateId' class='form-control/'>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name ='name' value='"+stateName+"' placeholder='Enter State name' class='form-control/'>");
		out.println("</div>");
	
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name ='s' value='Update State' class='form-control/'>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			stateName=request.getParameter("name");
			stateId=Integer.parseInt(request.getParameter("id"));
			StateModel sm=new StateModel();
			sm.setName(stateName);
			sm.setId(stateId);
			
			StateService stateService =new StateServiceImpl();
			boolean b=stateService.isUpdateState(sm);
			if(b) {
				response.sendRedirect("ViewAllState");
			}
			else
			{
				out.println("<h1>State is not updated...</h1>");
			}
			
			
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
