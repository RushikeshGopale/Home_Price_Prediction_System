package org.techhub.Controller;

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


@WebServlet("/SearchStateServlet")
public class SearchStateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String stateName=request.getParameter("s");
		out.println(stateName);
		StateService stateService =new StateServiceImpl();
		List<StateModel> list=stateService.getAStateListByName(stateName);
		String str="";
		int cnt=0;
		for(StateModel model:list)
		{
			++cnt;
			str=str+"<tr>";
			str=str+"<td>"+cnt+"</td>";
			str=str+"<td>"+model.getName()+"</td>";
			str=str+"<td><a href=''>DELETE</td>";
			str=str+"<td><a href=''>UPDATE</td>";
			str=str+"<tr>";
		}
		out.println(str);//send response as a table row
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
