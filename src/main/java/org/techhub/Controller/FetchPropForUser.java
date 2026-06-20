package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Service.*;

@WebServlet("/FetchPropForUser")
public class FetchPropForUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int locationid=Integer.parseInt(request.getParameter("locid"));
		System.out.println(locationid);
		UserPropertyService uservice=new UserPropertyServiceImpl();
		List<Object[]>list=uservice.getPropertyDetailByLoc(locationid);
		
		String str="";
		for(Object obj[]:list)
		{
			str=str+"<tr>";
			str=str+"<td>"+obj[1]+"</td>";
			str=str+"<td>"+obj[2]+"</td>";
			str=str+"<td>"+obj[3]+"</td>";
			str=str+"<td>"+obj[4]+"</td>";
			str=str+"<td>"+obj[5]+"</td>";
			str=str+"<td>"+obj[6]+"</td>";
			str=str+"<td><input type='button' value='select' style='background-color:red;color:white;' onclick='interested("+obj[0]+")'></td>";			str=str+"</tr>";
		}
		out.println(str);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
