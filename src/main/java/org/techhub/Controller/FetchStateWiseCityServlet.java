package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.CityModel;
import org.techhub.Service.CityService;
import org.techhub.Service.CityServiceImpl;

@WebServlet("/FetchStateWiseCity")
public class FetchStateWiseCityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	System.out.println("FULL QUERY STRING: "+request.getQueryString());
		//System.out.println("stid value: "+request.getParameter("stid"));
		int stateId=Integer.parseInt(request.getParameter("stid"));
		//out.println("stateid:"+stateId);
		CityService cityService=new CityServiceImpl();
		List<CityModel> cityList=cityService.getAllCitiesById(stateId);
		String str="";
		str="<table class='table table-striped'>";
		str=str+"<tr><th>SRNO</th><th>State Name</th><th>DELETE</th><th>UPDATE</th></tr>";
		int cnt=0;
		if(cityList!=null)
		{
		for(CityModel model:cityList)
		{
			++cnt;
			str=str+"<tr><td>"+cnt+"</td><td>"+model.getCname()+"</td><td><a href='DeleteCityServlet?cid="+model.getCid()+"&stid="+stateId+"'>DELETE<i class='bi bi-trash'></i></a></td><td><a href='UpdateCity?cid="+model.getCid()+"&cityname="+model.getCname()+"&stid="+stateId+"'>UPDATE<i class='bi bi-pencil-square'></i></a></td></tr>";	
		}
		}
		str=str+"</table>";
		out.println(str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
