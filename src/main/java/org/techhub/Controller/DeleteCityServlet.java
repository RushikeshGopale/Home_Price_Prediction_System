package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Service.CityService;
import org.techhub.Service.CityServiceImpl;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/DeleteCityServlet")
public class DeleteCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		int cId=Integer.parseInt(request.getParameter("cid"));
		CityService cityService=new CityServiceImpl();
		boolean b=cityService.isDeleteCityById(cId);
		if(b)
		{
			out.println("<h1 style='color:green;'>City deleted successfully</h1>");
			response.sendRedirect("FetchStateWiseCity?stid="+Integer.parseInt(request.getParameter("id")));
			
		}
		else
			out.println("<h1>City not deleted....</h1>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
