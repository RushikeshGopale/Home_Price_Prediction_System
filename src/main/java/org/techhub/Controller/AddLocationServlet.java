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
import org.techhub.Service.LocationService;
import org.techhub.Service.LocationServiceImpl;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;


@WebServlet("/AddLocation")
public class AddLocationServlet extends HttpServlet {
	
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
		out.println("<input type='text' name='name' value='' placeholder='enter location' class='form-control'/>");
		out.println("</div>");
		out.println("<select name='state' id='state' class='form-control m-2 p-2' onchange='fetchCitiesForLoc()'>");
		out.println("<option>select state</option>");
		for(StateModel model:stateList)
		{
		   
		      out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
		}
		out.println("</select>");
		
		out.println("<div id='d' class='form-group m-2 p-2'>");
		out.println("<select name='city' id='city' class='form-control'>");
		
		
		out.println("</select>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='submit' name='s' value='Add Location' class='form-control bg-success' />");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String locname=request.getParameter("name");
			int cityid=Integer.parseInt(request.getParameter("city"));
			//out.println("<h1>Locaton is"+locname+"</h1>");
			//out.println("<h1>city id is"+cityid+"</h1>");
			LocationModel lcmodel=new LocationModel();
			lcmodel.setLname(locname);
			lcmodel.setCid(cityid);
			LocationService locservice=new LocationServiceImpl();
			boolean b=locservice.isAddLocation(lcmodel);
			if(b)
				out.println("<h1>New location added</h1>");
			else
				out.println("<h1>New location Not added</h1>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
