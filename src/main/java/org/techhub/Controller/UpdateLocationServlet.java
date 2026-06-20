package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.CityModel;
import org.techhub.Model.LocationModel;
import org.techhub.Service.CityService;
import org.techhub.Service.CityServiceImpl;
import org.techhub.Service.*;

@WebServlet("/UpdateLocationServlet")
public class UpdateLocationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		
		int lId=Integer.parseInt(request.getParameter("lid"));
		String locationName=request.getParameter("lname");

		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container p-5 mt-1 bg-dark text-white'>");
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' name ='id' value='"+lId+"' placeholder='enter locationId' class='form-control/'>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name ='name' value='"+locationName+"' placeholder='Enter location name' class='form-control/'>");
		out.println("</div>");
	
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name ='s' value='Update location' class='form-control/'>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			locationName=request.getParameter("name");
			lId=Integer.parseInt(request.getParameter("id"));
			LocationModel lm=new LocationModel();
			lm.setLname(locationName);
			lm.setLid(lId);
			
			LocationService LService =new LocationServiceImpl();
			boolean b=LService.isUpdateLocation(lm);
			if(b) {
				out.println("<h1 style='color:green;'>Location updated</h1>");
				response.sendRedirect("ViewLocation");
			}
			else
			{
				out.println("<h1>Location is not updated...</h1>");
			}
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
