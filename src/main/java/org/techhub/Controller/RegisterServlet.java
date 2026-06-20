package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.RegisterModel;
import org.techhub.Service.RegisterService;
import org.techhub.Service.RegisterServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		RegisterModel model=new RegisterModel();
		model.setRname(name);
		model.setEmail(email);
		model.setContact(contact);
		model.setUsername(username);
		model.setPassword(password);
		
		RegisterService rService=new RegisterServiceImpl();
		boolean b=rService.isAddRegister(model);
		if(b)
		{
			out.println("<h1>Registration successful</h1>");
			RequestDispatcher r=request.getRequestDispatcher("userlogin.html");
			r.forward(request, response);
		}
			
		else
		{
			out.println("<h1>Registration failed</h1>");
		RequestDispatcher r=request.getRequestDispatcher("register.html");
		r.forward(request, response);
		}

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
