<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>乘法表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%! 
    	String s(){
        String s = "";
        for(int a = 1; a<10;a++){
            for(int b = 1 ; b<=a;b++){
                if(a*b<10){
                    s += b +"*"+ a+ "="+ "&nbsp&nbsp" +(a*b)+"&nbsp&nbsp&nbsp&nbsp"; 
                }else
                s += b +"*"+ a+ "=" +(a*b)+"&nbsp&nbsp&nbsp&nbsp";
            }
            s+="<br>";
        }
        return s;
    }
    %>
    <h1>九九乘法表</h1>
    <hr>
    
    <%= s() %>
  </body>
</html>
