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


@WebServlet("/FetchStateWiseCityForLoc")
public class FetchStateWiseCityForLoc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		System.out.println("FULL QUERY STRING: "+request.getQueryString());
//		System.out.println("stid value: "+request.getParameter("stid"));
	int stateId=Integer.parseInt(request.getParameter("stid"));
//		out.println("stateid:"+stateId);
		CityService cityService=new CityServiceImpl();
		List<CityModel> cityList=cityService.getAllCitiesById(stateId);
		String str="";
		int cnt=0;
		str="<option value=''> select City </option>";
		for(CityModel model:cityList)
		{
			++cnt;
			str=str+"<option value='"+model.getCid()+"'>"+model.getCname()+"</option>";
			
		}
		out.println(str);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
