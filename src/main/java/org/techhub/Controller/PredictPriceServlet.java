package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Service.*;

@WebServlet("/PredictPriceServlet")
public class PredictPriceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int lid=Integer.parseInt(request.getParameter("lid"));
		System.out.println(lid);
		double sqfeet=Double.parseDouble(request.getParameter("sqfeet"));

		InterestedService service=new InterestedServiceImpl();

		double result=service.predictPrice(lid,sqfeet);
		System.out.println(result);

		out.println("<h1 style='color:green;text-align:center;'>Predicted Price = ₹"+result+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
