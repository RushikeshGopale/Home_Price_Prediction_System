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

@WebServlet("/UserDashboardServlet")
public class UserDashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
		r.include(request, response);
		HttpSession session=request.getSession(true);
		String sesId=session.getId();
		//out.println("<h1>Hey user your session data "+sesId+"</h1>");
		String name=session.getAttribute("loginusername").toString();
		int id=(int) session.getAttribute("loginuserid");
		out.println("<script>");
		out.println("document.getElementById('uname').innerHTML='"+name+"';");
		out.println("</script>");
//		out.println("<h1 style='text-align:center'>Welcome "+name+"</h1>");
		//out.println("<h1>id"+id+"</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
