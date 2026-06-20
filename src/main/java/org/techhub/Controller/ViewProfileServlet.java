package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.PropertyModel;
import org.techhub.Model.RegisterModel;
import org.techhub.Service.*;
@WebServlet("/ViewProfile")
public class ViewProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
		r.include(request, response);
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("loginuserid");
		Integer userid=(Integer)obj;
		RegisterService rService=new RegisterServiceImpl();
		RegisterModel model=rService.getProfile(userid);
		
		
		out.println("<form action='ViewProfile' method='post'>");
		out.println("<div class='container p-5 m-5 bg-dark'>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='name' value='"+model.getRname()+"' class='form-control'>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='email' value='"+model.getEmail()+"' class='form-control'>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='contact' value='"+model.getContact()+"' class='form-control'>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='username' value='"+model.getUsername()+"' class='form-control'>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='text' name='password' value='"+model.getPassword()+"' class='form-control'>");
		out.println("</div>");
		
		out.println("<div class='form-group m-2 p-2'>");
		out.println("<input type='submit' name='s' value='Update Profile' class='form-control btn btn-success' >");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		

		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String RName=request.getParameter("name");
			int	rId=userid;
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			RegisterModel pm=new RegisterModel();
			pm.setRname(RName);
			pm.setRid(rId);
			pm.setEmail(email);
			pm.setContact(contact);
			pm.setPassword(password);
			pm.setUsername(username);
			
			RegisterService pService =new RegisterServiceImpl();
			boolean b=pService.isUpdate(pm);
			if(b) {
				out.println("<h1 style='color:green;'>Register updated</h1>");
				response.sendRedirect("ViewProfile");
			}
			else
			{
				out.println("<h1>profile is not updated...</h1>");
			}
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
