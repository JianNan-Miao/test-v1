package com.cheer.web.servlet;

import com.cheer.dao.impl.QuestionMapperImpl;
import com.cheer.domain.Examinee;
import com.cheer.domain.Information;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TotalServlet2", urlPatterns = "/servlet/TotalServlet2")
public class TotalServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int correct=0;
        int incorrect=0;
        double score=0.0;
        String pass=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Map map = (Map) session.getAttribute("map");
        Examinee examinee = (Examinee) session.getAttribute("examinee");
        if(examinee!=null){
            int id=examinee.getId();
            QuestionMapperImpl quesImpl=new QuestionMapperImpl();
            List<Question> list = quesImpl.getQuestion();
            int  miss_answer=list.size()-map.size();
            for(int i=0;i<list.size();i++){
                String correct_answer = list.get(i).getAnswer();
                String my_answer = (String) map.get(String.valueOf((i + 1)));
                if(correct_answer.indexOf(my_answer)!=-1){
                    correct++;
                }else{
                    incorrect++;
                }
            }
            score=100/(list.size())*correct;
            if(score>=60){
                pass="及格";
            }else{
                pass="不及格";
            }

            Information inf=new Information(id,correct,incorrect,miss_answer,score,pass);
            /*request.getSession().setAttribute("inf",inf);
            response.sendRedirect("../exam_end.jsp");*/
            Gson gson=new Gson();
            List<Information> list1=new ArrayList<Information>();
            list1.add(inf);
            String s = gson.toJson(list1);
            writer.write(s);
        }
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
