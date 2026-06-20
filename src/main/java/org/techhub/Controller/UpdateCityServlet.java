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
import org.techhub.Model.StateModel;
import org.techhub.Service.CityService;
import org.techhub.Service.CityServiceImpl;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;


@WebServlet("/UpdateCity")
public class UpdateCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		
		int cityId=Integer.parseInt(request.getParameter("cid"));
		String cityName=request.getParameter("cityname");

		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container p-5 mt-1 bg-dark text-white'>");
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' name ='id' value='"+cityId+"' placeholder='enter cityId' class='form-control/'>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name ='name' value='"+cityName+"' placeholder='Enter city name' class='form-control/'>");
		out.println("</div>");
	
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name ='s' value='Update city' class='form-control/'>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			cityName=request.getParameter("name");
			cityId=Integer.parseInt(request.getParameter("id"));
			CityModel cm=new CityModel();
			cm.setCname(cityName);
			cm.setCid(cityId);
			
			CityService cityService =new CityServiceImpl();
			boolean b=cityService.isUpdateCity(cm);
			if(b) {
				response.sendRedirect("ViewCity");
			}
			else
			{
				out.println("<h1>City is not updated...</h1>");
			}
			
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
