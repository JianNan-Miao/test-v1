package com.cheer.web.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "NumServlet", urlPatterns = "/servlet/NumServlet")
public class NumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String keys = request.getParameter("keys");

        HttpSession session = request.getSession();
        Map map = (Map) session.getAttribute("map");

        String values = (String) map.get(keys);

        Gson gson=new Gson();
        String s1 = gson.toJson(values);
        writer.write(s1);
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
