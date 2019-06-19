package com.cheer.web.servlet;

import com.cheer.dao.impl.QuestionMapperImpl;
import com.cheer.domain.Question;
import com.cheer.service.QuestionService;
import com.cheer.service.QuestionService1;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuestionServlet", urlPatterns = "/servlet/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        List<Question> list = new QuestionMapperImpl().getQuestion();
        Gson gson=new Gson();
        String s = gson.toJson(list);
        writer.write(s);
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
