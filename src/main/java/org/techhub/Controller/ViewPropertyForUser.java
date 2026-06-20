package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.StateModel;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/ViewPropertyForUser")
public class ViewPropertyForUser extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
		r.include(request, response);
		
		StateService stateService=new StateServiceImpl();
		List<StateModel> stateList=stateService.getAllStates();
		
		//out.println("<form name='frm' action='' method='Post'>");
		out.println("<div class='container m-5 p-5 bg-dark text-white'>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<select name='state' id='state' class='form-control' onchange='fetchCitiesForLoc()'>");
		out.println("<option>select state</option>");
		for(StateModel model:stateList)
		{
		   
		      out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("</div>");
		
		out.println("<div id='d' class='form-group m-2 p-2'>");
		out.println("<select name='city' id='city' class='form-control' onchange='fetchLocForProperty()'>");
		
		
		out.println("</select>");
		out.println("</div>");
		
		out.println("<div id='l' class='form-group m-2 p-2'>");
		out.println("<select name='loc' id='loc' class='form-control' onchange='fetchUserProperty()'>");

		out.println("</select>");
		out.println("</div>");
		
		out.println("<div class='container'>");
		out.println("<table class='table table-striped'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<td> Property Name</td>");
		out.println("<td> Property sqfeet</td>");
		out.println("<td> Property price</td>");
		out.println("<td> location Name</td>");
		out.println("<td> state Name</td>");
		out.println("<td> city Name</td>");
		
		out.println("<td> select </td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody id='tbody'>");
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		
		
		
		out.println("</div>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
