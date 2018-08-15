<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

   
<div class="navbar">
  <a href="search.jsp" style="float: left; text-align: center;padding: 14px 16px;">Home</a>
  
  <c:if test="${sessionScope.username==null}">
  <a href="login.jsp" style="float: left; text-align: center; padding: 14px 16px;"> Login</a>
  <a href="register.jsp" style="float: left; text-align: center; padding: 14px 16px;"> Register</a>
  
  </c:if>
  <c:if test="${sessionScope.username!=null}">
 
  <c:if test="${\"admin\".equals(sessionScope.usertype)}">
   <a href="displayList.jsp" style="float: left; text-align: center; padding: 14px 16px;"> List All Flight</a>
  </c:if>
  
   
   <a href="profile.jsp" style="float: left; text-align: center; padding: 14px 16px;"> Edit Profile</a>
  <a href="logout" style="float: left; text-align: center; padding: 14px 16px;"> Logout</a>
  
  </c:if>
  
</div>
