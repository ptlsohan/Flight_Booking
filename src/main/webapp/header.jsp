<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
   <a href="listFlight" style="float: left; text-align: center; padding: 14px 16px;"> List All Flight</a>
  </c:if>
  
    <a href="bookHistory" style="float: left; text-align: center; padding: 14px 16px;"> Booking History</a>
   <a href="profile.jsp" style="float: left; text-align: center; padding: 14px 16px;"> Edit Profile</a>
  <a href="logout" style="float: left; text-align: center; padding: 14px 16px;"> Logout</a>
  
  </c:if>
  
</div>
