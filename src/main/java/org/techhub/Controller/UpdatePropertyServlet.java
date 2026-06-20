package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.LocationModel;
import org.techhub.Model.PropertyModel;
import org.techhub.Service.LocationService;
import org.techhub.Service.LocationServiceImpl;
import org.techhub.Service.*;

@WebServlet("/UpdatePropertyServlet")
public class UpdatePropertyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		
		int pId=Integer.parseInt(request.getParameter("pid"));
		String propertyName=request.getParameter("pname");

		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container p-5 mt-1 bg-dark text-white'>");
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' name ='id' value='"+pId+"' placeholder='enter Id' class='form-control/'>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name ='name' value='"+propertyName+"' placeholder='Enter Property name' class='form-control/'>");
		out.println("</div>");
	
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name ='s' value='Update Property' class='form-control/'>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			propertyName=request.getParameter("name");
			pId=Integer.parseInt(request.getParameter("id"));
			PropertyModel pm=new PropertyModel();
			pm.setPname(propertyName);
			pm.setPid(pId);
			
			PropertyService pService =new PropertyServiceImpl();
			boolean b=pService.isUpdateProperty(pm);
			if(b) {
				out.println("<h1 style='color:green;'>Property updated</h1>");
				response.sendRedirect("ViewProperty");
			}
			else
			{
				out.println("<h1>Property is not updated...</h1>");
			}
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
