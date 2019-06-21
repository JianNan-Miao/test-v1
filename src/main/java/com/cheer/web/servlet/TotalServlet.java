package com.cheer.web.servlet;

import com.cheer.dao.impl.QuestionMapperImpl;
import com.cheer.domain.Question;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TotalServlet", urlPatterns = "/servlet/TotalServlet")
public class TotalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
        QuestionMapperImpl queImpl=new QuestionMapperImpl();
        List<Question> list = queImpl.getQuestion();

        String val = request.getParameter("val");
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        session.setAttribute("size",list.size());
        Map map1 = (Map) session.getAttribute("map");
        Map map=null;
        if(map1==null){
            map=new HashMap();
            map.put(num,val);
            request.getSession().setAttribute("map",map);
        }else{
            map1.put(num,val);
            request.getSession().setAttribute("map",map1);
        }
        PrintWriter writer = response.getWriter();



        request.getSession().setAttribute("num",Integer.parseInt(num));

        response.sendRedirect("../page_examinee_index.jsp");
        /*Gson gson=new Gson();
        String s = gson.toJson(map);
        writer.write(s);
        writer.close();*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
