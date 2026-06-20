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
import java.util.List;
import org.techhub.Service.*;

@WebServlet("/ViewInterestedProperty")
public class ViewInterestedPropertyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
		r.include(request,response);

		HttpSession session=request.getSession();
		int rid=(Integer)session.getAttribute("loginuserid");
		//System.out.println(rid);
		InterestedService service=new InterestedServiceImpl();
		List<Object[]> list=service.getWishlist(rid);

		
		if(list.size()<0) {
			out.println("<h1>please select property where you are interested</h1>");
		}
		out.println("<div class='container m-5 p-5 bg-dark text-white'>");
		out.println("<table class='table table-striped'>");

		out.println("<tr>");
		out.println("<th>Property Name</th>");
		out.println("<th>Sqfeet</th>");
		out.println("<th>Price</th>");
		out.println("<th>Location</th>");
		out.println("<th>State</th>");
		out.println("<th>City</th>");
		out.println("</tr>");

		for(Object obj[]:list)
		{
			out.println("<tr>");
			out.println("<td>"+obj[0]+"</td>");
			out.println("<td>"+obj[1]+"</td>");
			out.println("<td>"+obj[2]+"</td>");
			out.println("<td>"+obj[3]+"</td>");
			out.println("<td>"+obj[4]+"</td>");
			out.println("<td>"+obj[5]+"</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</div>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
