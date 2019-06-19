package com.cheer.web.servlet;

import com.cheer.domain.Examinee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TotalServlet1", urlPatterns = "/servlet/TotalServlet1")
public class TotalServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String val = request.getParameter("val");
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        Map map = (Map) session.getAttribute("map");
        map.put(num,val);
        session.setAttribute("map",map);
        response.sendRedirect("../exam_end.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
