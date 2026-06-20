package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Service.RegisterServiceImpl;

import org.techhub.Service.*;
@WebServlet("/CheckUserExistence")
public class CheckUserExistence extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("u");
		RegisterService rService=new RegisterServiceImpl();
		boolean b=rService.isUsernameExit(uname);
		if(b)
			out.println("<h1 style=color:red;>username exit</h1>");
		else
			out.println("<h1 style=color:green;>username not exit</h1>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
