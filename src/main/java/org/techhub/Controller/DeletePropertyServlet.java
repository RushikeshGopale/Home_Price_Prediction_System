package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Service.LocationService;
import org.techhub.Service.LocationServiceImpl;
import org.techhub.Service.PropertyServiceImpl;

import org.techhub.Service.*;
@WebServlet("/DeletePropertyServlet")
public class DeletePropertyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		int pId=Integer.parseInt(request.getParameter("pid"));
		PropertyService pService=new PropertyServiceImpl();
		boolean b=pService.isDeletePropertyById(pId);
		if(b)
		{
			response.sendRedirect("ViewProperty?pid="+Integer.parseInt(request.getParameter("id")));
		}
		else
			out.println("<h1>property not deleted....</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
