package com.cheer.web.servlet;

import com.cheer.domain.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String accountName = request.getParameter("accountName");
        String password = request.getParameter("password");
        Administrator administrator=null;
        if("admin".equals(accountName)&&"admin".equals(password)){
            administrator=new Administrator(accountName,password);
            request.getSession().setAttribute("administrator",administrator);
            response.sendRedirect("../page_admin_index1.jsp");
        }else{
            request.getRequestDispatcher("../admin_login1.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
