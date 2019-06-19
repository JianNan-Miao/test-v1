<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/17
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    </style>
</head>
<body>
<div id="base" class="">

    <!-- Unnamed (Rectangle) -->
    <div id="u64" class="ax_default box_1">
        <div id="u64_div" class=""></div>
        <div id="u64_text" class="text " style="display:none; visibility: hidden">
            <p></p>
        </div>
    </div>

    <!-- Unnamed (Tree) -->
    <div id="u65" class="ax_default tree_node treeroot">
        <div id="u65_children" class="u65_children">

            <!-- Unnamed (Tree Node) -->
            <div id="u66" class="ax_default tree_node treenode">

                <!-- Unnamed (Rectangle) -->
                <div id="u68" class="" selectiongroup="u65_tree_group">
                    <div id="u68_div" class=""></div>
                    <div id="u68_text" class="text ">
                        <p><span style="text-decoration:none;">管理</span></p>
                    </div>
                </div>
                <div id="u66_children" class="u66_children">

                    <!-- Unnamed (Tree Node) -->
                    <div id="u69" class="ax_default tree_node treenode">
                        <!-- Unnamed (Rectangle) -->
                        <div id="u70" class="" selectiongroup="u65_tree_group">
                            <div id="u70_div" class=""></div>
                            <div id="u70_text" class="text ">
                                <p><span style="text-decoration:none;">考生信息管理</span></p>
                            </div>
                        </div>
                    </div>

                    <!-- Unnamed (Tree Node) -->
                    <div id="u71" class="ax_default tree_node treenode">
                        <!-- Unnamed (Rectangle) -->
                        <div id="u72" class="" selectiongroup="u65_tree_group">
                            <div id="u72_div" class=""></div>
                            <div id="u72_text" class="text ">
                                <p><span style="text-decoration:none;">考试题目管理</span></p>
                            </div>
                        </div>
                    </div>

                    <!-- Unnamed (Tree Node) -->
                    <div id="u73" class="ax_default tree_node treenode">
                        <!-- Unnamed (Rectangle) -->
                        <div id="u74" class="" selectiongroup="u65_tree_group">
                            <div id="u74_div" class=""></div>
                            <div id="u74_text" class="text ">
                                <p><span style="text-decoration:none;">查看考生成绩</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>





    <!-- Unnamed (Rectangle) -->
    <div id="u77" class="ax_default primary_button">
        <div id="u77_div" class=""></div>
        <div id="u77_text" class="text ">
            <button id="imports">考试题目导入</button>
        </div>
    </div>

    <div>
        <table>
            <tr>
                <td>序号</td>
                <td>题干</td>
                <td>题目内容</td>
                <td>编辑</td>
                <td>删除</td>
            </tr>

        </table>
    </div>


    <!-- Unnamed (Rectangle) -->
    <div id="u75" class="ax_default box_2">
        <div id="u75_div" class=""></div>
        <div id="u75_text" class="text ">
            <p><span style="font-family:'Arial Normal', 'Arial';text-decoration:none;">其然软件 </span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';text-decoration:none;">Copyright © 2018</span></p>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            let header=["序号","题干","题目内容","编辑","删除"];
            $("#imports").click(function () {
                let resquestUrl="servlet/QuestionServlet";
                $.ajax({
                    url:resquestUrl,
                    method:"Get",
                    dataType:"json",
                    success:function (response) {
                        let list=response;
                        for(let i=0;i<list.length;i++){
                            let $tr=$("<tr></tr>");
                             $("table").append($tr);
                             for(let j=0;j<header.length;j++){
                                 let $td=$("<td></td>");
                                 $tr.append($td);
                                 if("序号"==header[j]){
                                     let $num=i+1;
                                     $td.append($num);
                                 }else if("题干"==header[j]){
                                     let $title=list[i]["title"];
                                     $td.append($title);
                                 }else if("题目内容"==header[j]){
                                     let $text="详细内容";
                                     $td.append($text);
                                 }else if("编辑"==header[j]){
                                     let $upd="编辑";
                                     $td.append($upd);
                                 }else if("删除"==header[j]){
                                     let $del="删除";
                                     $td.append($del);
                                 }
                             }
                        }
                    }
                })
            });
        });
    </script>
</body>
</html>
