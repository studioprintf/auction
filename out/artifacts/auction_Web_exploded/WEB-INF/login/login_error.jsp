<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/3/26
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="referrer" content="always">
    <title>提示</title>
    <style type="text/css">
        body {
            background-repeat: no-repeat;
            color: #000;
            font: 9pt/200% Verdana;
        }

        a {
            text-decoration: none;
            color: #659B28
        }

        a:hover {
            text-decoration: underline;
        }
    </style>

</head>
<body>
<center>
    <div style='padding:30px;padding:36px 80px;border:1px solid #a9a9a9;background:#ffffff ; text-align:center; margin:20% auto; background-repeat: no-repeat; width:55%;'>
        密码错误，请重新输入

        <br/><a href='http://localhost:8080/login'>如果你的浏览器没反应，请点击这里...</a>
        <script>
            var pgo = 0;
            function JumpUrl() {
                if (pgo == 0) {
                    location = 'http://localhost:8080/login';
                    pgo = 1;
                }
            }
            setTimeout('JumpUrl()', 1500);
        </script>
    </div>
</center>
</body>
</html>
