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
import org.techhub.Service.*;

@WebServlet("/DeleteLocationServlet")
public class DeleteLocationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		int lId=Integer.parseInt(request.getParameter("lid"));
		System.out.println(lId);
		LocationService lService=new LocationServiceImpl();
		boolean b=lService.isDeleteLocationById(lId);
		if(b)
			response.sendRedirect("ViewLocation?stid="+Integer.parseInt(request.getParameter("id")));
		else
			out.println("<h1>location not deleted....</h1>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
