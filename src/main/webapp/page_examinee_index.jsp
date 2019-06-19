<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        .info{
            float: left;
            margin-left: 50px;
            margin-top: 70px;
        }
        #clear{
            clear: both;
        }
        table{
            border: 1px  solid black;
            width: 200px;
            height: 350px;
        }
        .row{
            margin-top: 80px;
            margin-left: 400px;
        }
        button {
            width: 100px;
            height: 34px;
            border-radius: 12px;
            border-width: 0;
        }
        #before{
            margin-left: 150px;
        }
        #next {
            margin-left: 20px;
        }
        #submission{
            margin-left: 20px;
        }
        .question{
            margin-top: 200px;
            margin-left: 300px;
            width: 600px;
            height: 100px;
        }
        #numA ,#numB ,#numC ,#numD{
            width: 200px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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


    <div class="question">
        <label id="title"></label><br>
        <input type="radio" name="text1" value="A" id="rd1"><label id="numA"></label><br>
        <input type="radio" name="text1"  value="B"id="rd2"><label id="numB"></label><br>
        <input type="radio" name="text1" value="C" id="rd3"><label id="numC"></label><br>
        <input type="radio" name="text1" value="D"id="rd4"><label id="numD"></label><br>
    </div>
    <div id="clear"></div>

    <div class="row">
        <button id="before" type="submit">上一题</button> <button id="next"  >下一题</button>
        <button id="submission"  >交卷</button>
    </div>

    

 <script>
    $(function () {
         let val;
        let list=null;
        let num1="${num}";
        let num=parseInt(num1);

        let i=0;


        $.ajax({
            url:"servlet/QuestionServlet",
            method:"POST",
            dataType:"json",
            success:function (response) {
                list=response;

                if(num>0){
                    i=num;
                }else{
                    i=0;
                }

                $("#title").text(list[i]["title"]);
                $("#numA").text(list[i]["QA"]);
                $("#numB").text(list[i]["QB"]);
                $("#numC").text(list[i]["QC"]);
                $("#numD").text(list[i]["QD"]);




            }
        });


      $("#next").click(function () {
          i=i+1;
          val= $("input[type='radio']:checked").val();

          $("#title").text(list[i]["title"]);
          $("#numA").text(list[i]["QA"]);
          $("#numB").text(list[i]["QB"]);
          $("#numC").text(list[i]["QC"]);
          $("#numD").text(list[i]["QD"]);
          location.href="servlet/TotalServlet?val="+val+"&num="+i+"";
      });



        $("#before").click(function () {
            i=i-1;
            
             $.ajax({
                 url:"servlet/NumServlet",
                 method: "POST",
                 dataType: "json",
                 data:{"keys":(i+1)},
                 success:function (response) {

                     $("#title").text(list[i]["title"]);
                     $("#numA").text(list[i]["QA"]);
                     $("#numB").text(list[i]["QB"]);
                     $("#numC").text(list[i]["QC"]);
                     $("#numD").text(list[i]["QD"]);
                     if("A"===response){
                         $("#rd1").prop("checked",true);
                     }else if("B"===response){
                         $("#rd2").prop("checked",true);
                     }else if("C"===response){
                         $("#rd3").prop("checked",true);
                     }else if("D"===response){
                         $("#rd4").prop("checked",true);
                     }
                 }
             })


        })

        $("#submission").click(function () {
            i=i+1;
            val= $("input[type='radio']:checked").val();
            location.href="servlet/TotalServlet1?val="+val+"&num="+i+"";
        })



    })
 </script>


</body>
</html>
