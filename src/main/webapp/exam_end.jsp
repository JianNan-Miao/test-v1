<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/19
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .top{
            margin: 0 auto;

        }
        h1{
            margin-left: 600px;
            color: red;

        }
        table {
            margin: 50px auto 0 auto;
            border-collapse: collapse;
            text-align: center;
            vertical-align: center;
        }
        table, tr, td {
            border: 1px solid black;
        }
        tr, td {
            border: 1px solid black;
            width: 200px;
            height: 30px;
        }
        button {
            width: 100px;
            height: 34px;
            border-radius: 12px;
            border-width: 0;
        }
        div+div{
            margin-top: 20px;
        }
        .end{
            margin-left: 600px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
  <div class="top">
      <h1>考试成绩单</h1>
  </div>
  <div>
      <table >
          <tbody>
              <tr>
                  <td>准考证号</td>
                  <td>答对</td>
                  <td>答错</td>
                  <td>漏答</td>
                  <td>分数</td>
                  <td>是否合格</td>
              </tr>

          </tbody>
      </table>
  </div>
  <div  class="end">
          <button id="imports">确认</button>

  </div>


  <script>
      $(function () {

          let header = ["准考证号", "答对", "答错", "漏答", "分数","是否合格"];
          let header2=["id","correct","incorrect","miss_answer","score","pass"];
          let $tr=$("<tr></tr>");
          $tr.appendTo($("tbody"));
          $.ajax({
             url:"servlet/TotalServlet2",
              method:"post",
              dataType:"json",
              success:function (response) {
                 let inf=response[0];
                 for(let i=0;i<header.length;i++){
                     let $td=$("<td></td>");
                     $td.appendTo($tr);
                    let  $text=inf[header2[i]];
                    $td.append($text);
                 }
              }
          });
      });
  </script>

</body>
</html>
