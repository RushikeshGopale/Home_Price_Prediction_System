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

import org.techhub.Model.CityModel;
import org.techhub.Model.StateModel;
import org.techhub.Service.CityService;
import org.techhub.Service.CityServiceImpl;
import org.techhub.Service.StateService;
import org.techhub.Service.StateServiceImpl;

@WebServlet("/AddCityServlet")
public class AddCityServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        // include dashboard
        RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
        r.include(request,response);

        // show message
        String msg=request.getParameter("msg");
        if(msg!=null)
        {
            if(msg.equals("success"))
            {
                out.println("<h3 style='color:green;text-align:center'>City Added Successfully</h3>");
            }
            else
            {
                out.println("<h3 style='color:red;text-align:center'>City Not Added</h3>");
            }
        }

        // get states
        StateService stateservice=new StateServiceImpl();
        List<StateModel> stateList=stateservice.getAllStates();

        // form
        out.println("<form name='frm' action='AddCityServlet' method='POST'>");
        out.println("<div class='container bg-dark p-5 m-5'>");
        out.println("<h2 class='text-white'>Add new City</h2>");

        out.println("<div class='form-group m-2 p-2 ml-3'>");
        out.println("<input type='text' name='cityname' class='form-control ' required/>");
        out.println("</div>");

        out.println("<div class='form-group m-2 p-2 ml-3'>");
        out.println("<select name='state' class='form-control ' required>");
        out.println("<option value=''>Select State</option>");

        for(StateModel model:stateList)
        {
            out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
        }

        out.println("</select>");
        out.println("</div>");

        out.println("<div class='form-group m-2 p-2 ml-3'>");
        out.println("<input type='submit' value='Add city' class='form-control  bg-success text-white'/>");
        out.println("</div>");

        out.println("</div>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        String cityname=request.getParameter("cityname");
        String stateParam=request.getParameter("state");

        // validation
        if(cityname==null||cityname.trim().equals("")||stateParam==null||stateParam.equals(""))
        {
            response.sendRedirect("AddCityServlet?msg=fail");
            return;
        }

        int stateId=Integer.parseInt(stateParam);

        System.out.println(cityname+"\t"+stateId);

        CityModel cm=new CityModel();
        cm.setCname(cityname);
        cm.setId(stateId);   // correct mapping

        CityService cityService=new CityServiceImpl();
        boolean b=cityService.isAddCity(cm);

        // PRG pattern (prevents duplicate insert)
        if(b)
        {
            response.sendRedirect("AddCityServlet?msg=success");
        }
        else
        {
            response.sendRedirect("AddCityServlet?msg=fail");
        }
    }
}