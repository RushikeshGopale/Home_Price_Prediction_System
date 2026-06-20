package org.techhub.Controller;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.techhub.Model.AdminLoginModel;
import org.techhub.Service.*;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		AdminLoginModel model=new AdminLoginModel();
		model.setUsername(username);
		model.setPassword(password);
		ValidateAdminService validateAdmin=new ValidateAdminServiceImpl();
		Optional<AdminLoginModel> o=validateAdmin.validateAdmin(model);
		if(o.isPresent())
		{
			RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("login.html");
			r.include(request, response);
			out.println("<H2>Invalid username and password<H2>");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
