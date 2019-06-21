<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/17
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
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
            width: 200px;
            height: 30px;
        }

        .dropdown {
            margin-top: 70px;
            margin-left: 20px;
            float: left;
        }

        #imports {
            width: 150px;
            height: 34px;
            margin-left: 262px;
            margin-top: 70px;
        }

        #u75 {
            margin-bottom: 20px;
            margin-left: 665px;
        }

        button + button {
            margin-left: 20px;
        }

        #left-button {
            margin-left: 170px;
            margin-top: 70px;
            width: 150px;
        }

        #right-button {
            margin-top: 70px;
            width: 150px;
        }

        #ti {
            margin-left: 262px;
        }
        #submit-button{
            margin-left: 24px;
        }
        #file{
            width: 83px;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div id="base" class="">

    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            管理
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">考生信息管理</a>
            <a class="dropdown-item" href="#">考试题目管理</a>
            <a class="dropdown-item" href="#">查看考生成绩</a>
        </div>
    </div>


    <div class="right">
        <div>
            <div>
                <button id="left-button" type="button" class="btn btn-primary">考生信息录入</button>
                <button id="right-button" type="button" class="btn btn-primary">刷新考生信息</button><br><br>
                <form id="ti" action="servlet/UploadServlet" method="post" enctype="multipart/form-data">excel表格<input
                        type="file" name="file" id="file">
                    <button id="submit-button" type="submit" class="btn btn-primary">提交</button>
                </form>
            </div>
            <div>
                <table id="top-table">
                    <tr>
                        <td>准考证号</td>
                        <td>姓名</td>
                        <td>密码</td>
                        <td>考试状态</td>
                        <td>删除</td>
                    </tr>

                </table>
            </div>
        </div>
        <div id="u77" class="ax_default primary_button">

            <%--<button id="imports">考试题目导入</button>--%>
            <button id="imports" type="button" class="btn btn-primary">考试题目导入</button>

        </div>

        <div>
            <table id="middle-table">
                <tr>
                    <td>序号</td>
                    <td>题干</td>
                    <td>题目内容</td>
                    <td>编辑</td>
                    <td>删除</td>
                </tr>

            </table>


        </div>


        <div id="u75" class="ax_default box_2">
            <p><span style="font-family:'Arial Normal', 'Arial';text-decoration:none;">其然软件 </span><span
                    style="font-family:'PingFangSC-Regular', 'PingFang SC';text-decoration:none;">Copyright © 2018</span>
            </p>
        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        let header = ["序号", "题干", "题目内容", "编辑", "删除"];
        let header2 = ["准考证号", "姓名", "密码", "考试状态", "删除"];
        $("#right-button").click(function () {
            $.ajax({
                url: "servlet/GetExamineeServlet",
                method: "post",
                dataType: "json",
                success: function (response) {
                    let list = response;
                    for (let i = 0; i < list.length; i++) {
                        let $tr = $("<tr></tr>");
                        $("#top-table").append($tr);
                        for (let j = 0; j < header2.length; j++) {
                            let $td = $("<td></td>");
                            $tr.append($td);
                            if ("准考证号" == header2[j]) {
                                $td.append(list[i]["id"])
                            }
                            if ("姓名" == header2[j]) {
                                $td.append(list[i]["username"])
                            }
                            if ("密码" == header2[j]) {
                                $td.append(list[i]["password"])
                            }
                            if ("考试状态" == header2[j]) {
                                let status = list[i]["status"];
                                if (status == 0) {
                                    $td.append("代考");
                                } else {
                                    $td.append("考试完毕");
                                }
                            }

                            if ("删除" == header2[j]) {
                                $td.append("删除");
                            }

                        }
                    }

                }
            });
            $("#right-button").attr("disabled", true);
        });


        $("#imports").click(function () {
            let resquestUrl = "servlet/QuestionServlet";
            $.ajax({
                url: resquestUrl,
                method: "Get",
                dataType: "json",
                success: function (response) {
                    let list = response;
                    for (let i = 0; i < list.length; i++) {
                        let $tr = $("<tr></tr>");
                        $("#middle-table").append($tr);
                        for (let j = 0; j < header.length; j++) {
                            let $td = $("<td></td>");
                            $tr.append($td);
                            if ("序号" == header[j]) {
                                let $num = list[i]["id"];
                                $td.append($num);
                            } else if ("题干" == header[j]) {
                                let $title = list[i]["title"];
                                $td.append($title);
                            } else if ("题目内容" == header[j]) {
                                let $text = "详细内容";
                                $td.append($text);
                            } else if ("编辑" == header[j]) {
                                let $upd = "编辑";
                                $td.append($upd);
                            } else if ("删除" == header[j]) {
                                let $del = "<a href='servlet/DeleteServlet?id=" + (i + 1) + "'>删除</a>";
                                $td.append($del);
                            }
                        }
                    }
                }

            })

            $("#imports").attr("disabled", true);
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>

