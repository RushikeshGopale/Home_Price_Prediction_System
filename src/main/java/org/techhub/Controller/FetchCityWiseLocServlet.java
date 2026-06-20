package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.LocationModel;
import org.techhub.Service.LocationService;

import org.techhub.Service.*;
@WebServlet("/FetchCityWiseLoc")
public class FetchCityWiseLocServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cityId=Integer.parseInt(request.getParameter("cityid"));
		//out.println(cityId);
		LocationService locservice=new LocationServiceImpl();
		List<LocationModel> list=locservice.getAllLocationById(cityId);
		String str="";
		str="<option value=''> Select location </option>";
		for(LocationModel model:list)
		{
			str=str+"<option value='"+model.getLid()+"'>"+model.getLname()+"</option>";
		}
		out.println(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
