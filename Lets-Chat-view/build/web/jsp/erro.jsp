<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!String erro = "";%>
<%erro = (String)request.getAttribute("erro");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title> Erro Lets Chat </title>
        <style>
            @import url("salachat.css");
        </style>
        
    </head>
    <body>
        <h2><%=erro%></h2>
    </body>
</html>
