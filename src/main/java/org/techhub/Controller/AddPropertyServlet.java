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

import org.techhub.Model.PropertyModel;
import org.techhub.Model.StateModel;
import org.techhub.Service.*;


@WebServlet("/AddPropertyServlet")
public class AddPropertyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request, response);
		
		StateService stateService=new StateServiceImpl();
		List<StateModel> stateList=stateService.getAllStates();
		
		out.println("<form name='frm' action='' method='Post'>");
		out.println("<div class='container m-5 p-5 bg-dark text-white'>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='name' value='' placeholder='enter Property name' class='form-control'/>");
		out.println("</div>");
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='sqfeet' value='' placeholder='enter Property sqfeet' class='form-control'/>");
		out.println("</div>");
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='price' value='' placeholder='enter Property price' class='form-control'/>");
		out.println("</div>");

		
		
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
		out.println("<select name='loc' id='loc' class='form-control'>");
		
		out.println("</select>");
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='submit' name='s' value='Add Location' class='form-control bg-success' />");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String propname=request.getParameter("name");
			String sqfeet=request.getParameter("sqfeet");
			String pprice=request.getParameter("price");
			String locId=request.getParameter("loc");
			//out.println("<h1>property name:"+propname+"</h1>");
			PropertyModel model=new PropertyModel();
			model.setPname(propname);
			model.setSqfeet(Integer.parseInt(sqfeet));
			model.setPrice(Integer.parseInt(pprice));
			model.setLid(Integer.parseInt(locId));
			
			PropertyService pservice=new PropertyServiceImpl();
			boolean b=pservice.isAddProperty(model);
			if(b)
				out.println("<h1> Property Added </h1>");
			else
				out.println("<h1> Property not Added </h1>");
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
