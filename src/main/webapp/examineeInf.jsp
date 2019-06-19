<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/17
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        .info{
            margin-left: 50px;
            margin-top: 70px;
        }
        table{
            border: 1px  solid black;
            width: 200px;
            height: 350px;
        }
    </style>
</head>
<body>
   <div class="info">
       <table>
           <tr>
               <td>
                   <div>
                       <label style="color: red">考生信息</label>
                   </div>
                   <div>
                       <label >考生姓名：王晓</label>
                   </div>
                   <div>
                       <label >考试题目：20道</label>
                   </div>
                   <div>
                       <label >考试时间：15分钟</label>
                   </div>
                   <div>
                       <label >合格标准：满分100分，90分及格</label>
                   </div>
               </td>
           </tr>
       </table>
   </div>
</body>
</html>
