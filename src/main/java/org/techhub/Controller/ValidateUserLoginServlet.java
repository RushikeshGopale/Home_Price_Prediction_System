package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.techhub.Model.AdminLoginModel;
import org.techhub.Model.RegisterModel;
import org.techhub.Service.RegisterServiceImpl;
import org.techhub.Service.ValidateAdminService;
import org.techhub.Service.ValidateAdminServiceImpl;

import org.techhub.Service.*;
@WebServlet("/ValidateUser")
public class ValidateUserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//int uid=Integer.parseInt(request.getParameter("rid"));
		RegisterModel model=new RegisterModel();
		model.setUsername(username);
		model.setPassword(password);
		//model.setRid(uid);
		//model.setId(request.getParameter("id"));
		RegisterService rService=new RegisterServiceImpl();
		Optional<RegisterModel> o=rService.validateRegister(model);
		if(o.isPresent())
		{
			RegisterModel m=o.get();
			HttpSession session=request.getSession();
			session.setAttribute("loginuserid",m.getRid());
			//System.out.println(m.getRid());
			
			session.setAttribute("loginusername",m.getUsername());
			//System.out.println(m.getUsername());
			RequestDispatcher r=request.getRequestDispatcher("UserDashboardServlet");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("userlogin.html");
			r.include(request, response);
			out.println("<H2>Invalid username and password<H2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
