package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ViewSession")
public class ViewSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
		 String username=session.getAttribute("u").toString();
		 String password=session.getAttribute("p").toString();
		 String sesId=session.getId();
		 out.println("<h1>Hey user your session data "+sesId+"</h1>");
		
		 out.println("Login user details");
		 out.println("<h1>Username is "+username+"</h1>");
		 out.println("<h1>Password is "+password+"</h1>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
