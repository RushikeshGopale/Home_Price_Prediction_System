package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.InterestedModel;
import org.techhub.Service.*;

@WebServlet("/InterestedProperty")
public class UserInterestedProperty extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession session=request.getSession();
		int rid=(Integer)session.getAttribute("loginuserid");

		int pid=Integer.parseInt(request.getParameter("pid"));

		InterestedModel model=new InterestedModel();
		model.setRid(rid);
		model.setPid(pid);

		InterestedService service=new InterestedServiceImpl();

		boolean b=service.isAddInterested(model);

		if(b)
		{
			out.println("Property Added");
		}
		else
		{
			out.println("Not Added");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
