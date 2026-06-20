package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.StateModel;
import org.techhub.Service.*;

@WebServlet("/ViewAllState")
public class ViewAllState extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);

		StateService stateservice=new StateServiceImpl();
		List<StateModel> list=stateservice.getAllStates();
		
		out.println("<div class='container p-5 mt-1 bg-dark text-white'>");
		out.println("<div class='form-group'>");
		out.println("<input type='text' name ='name' value='' placeholder='search State' class='form-control/' onkeyup='searchState(this.value)'>");
		out.println("</div>");
		out.println("</div>");

		
		out.println("<div class='container bg-dark text-white'>");
		out.println("<table class='table table-striped'>");
		out.println("<thead>");
		out.println("<tr><th>SRNO</th><th>State Name</th><th>DELETE</th><th>UPDATE</th>");
		out.println("</thead>");
		out.println("<tbody id='tbody'>");
		int cnt=0;
		for(StateModel sm:list)
		{
			++cnt;
			String Statename=sm.getName();
			out.println("<tr>");
			out.println("<td>"+cnt+"</td>");
			out.println("<td>"+Statename+"</td>");
			out.println("<td><a href='DeleteStateServlet?stateid="+sm.getId()+"'>DELETE</a></td>");
			out.println("<td><a href='UpdateStateServlet?stateid="+sm.getId() +"&statename="+sm.getName()+"'>UPDATE</a></td>");
			//out.println(sm.getId()+"\t"+sm.getName());
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
