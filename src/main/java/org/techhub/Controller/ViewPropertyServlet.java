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
import org.techhub.Model.PropertyModel;
import org.techhub.Model.StateModel;
import org.techhub.Service.LocationService;
import org.techhub.Service.LocationServiceImpl;
import org.techhub.Service.PropertyService;
import org.techhub.Service.PropertyServiceImpl;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/ViewProperty")
public class ViewPropertyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	String LocationIdParam=request.getParameter("lid");

	if(LocationIdParam==null)
	{
	RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
	r.include(request, response);
	
	StateService stateService=new StateServiceImpl();
	List<StateModel> stateList=stateService.getAllStates();
	
	//out.println("<form name='frm' action='' method='Post'>");
	out.println("<div class='container m-5 p-5 bg-dark text-white'>");
	
	out.println("<div class='form-group m-2 p-2'>");
	out.println("<select name='state' id='state' class='form-control' onchange='fetchCitiesForLoc()'>");
	out.println("<option>select state</option>");
	for(StateModel model:stateList)
	{
	   
	      out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
	}
	out.println("</select>");
	
	out.println("<div id='d' class='form-group m-2 p-2'>");
	out.println("<select name='city' id='city' class='form-control' onchange='fetchLocForProperty()'>");
	
	
	out.println("</select>");
	out.println("</div>");
	
	out.println("<div id='d' class='form-group m-2 p-2'>");
	out.println("<select name='loc' id='loc' class='form-control' onchange='fetchProperty()'>");
	out.println("</div>");
	out.println("</select>");
	out.println("</div>");
	
	out.println("<div id='propertyData'></div>");
	out.println("</div>");
	
	}
	else
	{
		int lId=Integer.parseInt(LocationIdParam);

		PropertyService propservice=new PropertyServiceImpl();
		List<PropertyModel> propList=propservice.getAllPropertyById(lId);

		String str="<table class='table table-striped'>";
		str+="<tr><th>SRNO</th><th>Property Name</th><th>Square feet</th><th>Price</th><th>DELETE</th><th>UPDATE</th></tr>";

		int cnt=0;
		for(PropertyModel model:propList)
		{
			cnt++;
			str+="<tr><td>"+cnt+"</td><td>"+model.getPname()+"</td><td>"+model.getSqfeet()+"</td><td>"+model.getPrice()+"</td><td><a href='DeletePropertyServlet?pid="+model.getPid()+"'>DELETE</a></td><td><a href='UpdatePropertyServlet?pid="+model.getPid()+"&pname="+model.getPname()+"'>UPDATE</a></td></tr>";
		}

		str+="</table>";

		out.println(str);

	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
