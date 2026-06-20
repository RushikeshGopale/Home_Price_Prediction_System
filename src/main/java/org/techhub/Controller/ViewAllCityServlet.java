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
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/ViewCity")
public class ViewAllCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		String sid=request.getParameter("stid");
		int selectedStateId=0;

		if(sid!=null && !sid.isEmpty())
		{
		    selectedStateId=Integer.parseInt(sid);
		}
		StateService stateService=new StateServiceImpl();
		List<StateModel> stateList=stateService.getAllStates();
		out.println("<form name='frm' action='' method='Post'>");
		out.println("<div class='container m-5 p-5 bg-dark text-white'>");
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<select name='state' id='state' class='form-control' onchange='fetchCities()'>");
		out.println("<option>select state</option>");
		for(StateModel model:stateList)
		{
		    if(model.getId()==selectedStateId)
		    {
		        out.println("<option value='"+model.getId()+"' selected>"+model.getName()+"</option>");
		    }
		    else
		    {
		        out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
		    }
		}
		out.println("</select>");
		out.println("</div>");
		out.println("<div id='d' class='p-5'>");
		out.println("</div>");

		out.println("</div>");
		out.println("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
