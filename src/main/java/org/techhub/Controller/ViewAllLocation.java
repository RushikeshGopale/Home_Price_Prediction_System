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

import org.techhub.Model.LocationModel;
import org.techhub.Model.StateModel;
import org.techhub.Service.*;

@WebServlet("/ViewLocation")
public class ViewAllLocation extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String cityIdParam=request.getParameter("cityid");

		if(cityIdParam==null)
		{
			RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
			r.include(request, response);

			StateService stateService=new StateServiceImpl();
			List<StateModel> stateList=stateService.getAllStates();

			out.println("<div class='container m-5 p-5 bg-dark text-white'>");

			// STATE
			out.println("<div class='form-group m-2 p-2'>");
			out.println("<select name='state' id='state' class='form-control' onchange='fetchCitiesForLoc()'>");
			out.println("<option>select state</option>");
			for(StateModel model:stateList)
			{
				out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
			}
			out.println("</select>");
			out.println("</div>");

			// CITY
			out.println("<div class='form-group m-2 p-2'>");
			out.println("<select name='city' id='city' class='form-control' onchange='fetchLocation()'>");
			out.println("</select>");
			out.println("</div>");

			out.println("<div id='locationData'></div>");

			out.println("</div>");
		}
		else
		{

			int cityId=Integer.parseInt(cityIdParam);

			LocationService locservice=new LocationServiceImpl();
			List<LocationModel> locList=locservice.getAllLocationById(cityId);

			String str="<table class='table table-striped'>";
			str+="<tr><th>SRNO</th><th>Location Name</th><th>DELETE</th><th>UPDATE</th></tr>";

			int cnt=0;
			for(LocationModel model:locList)
			{
				cnt++;
				str+="<tr><td>"+cnt+"</td><td>"+model.getLname()+"</td><td><a href='DeleteLocationServlet?lid="+model.getLid()+"'>DELETE</a></td><td><a href='UpdateLocationServlet?lid="+model.getLid()+"&lname="+model.getLname()+"'>UPDATE</a></td></tr>";
			}

			str+="</table>";

			out.println(str);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}