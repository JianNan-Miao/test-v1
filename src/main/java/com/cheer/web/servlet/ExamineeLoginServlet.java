package com.cheer.web.servlet;

import com.cheer.dao.impl.ExamineeMapperImpl;
import com.cheer.domain.Examinee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExamineeLoginServlet", urlPatterns = "/servlet/ExamineeLoginServlet")
public class ExamineeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamineeMapperImpl examineeImpl=new ExamineeMapperImpl();
        String idNumber = request.getParameter("IDNumber");
        String password = request.getParameter("password");
        Examinee examinee = examineeImpl.findExaminee(Integer.parseInt(idNumber));
        if(examinee==null||!password.equals(examinee.getPassword())){
            response.sendRedirect("../examinee_login1.html");
        }else{
            request.getSession().setAttribute("examinee",examinee);
            response.sendRedirect("../page_examinee_index.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
