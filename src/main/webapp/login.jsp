<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${ error!=null }">
	<div style="color:red">${error}</div>
</c:if>
<form action="validate" method="post" >
  <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="uname" name="uname"  placeholder="Username">

  </div>
  
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
 <div class="radio">
  <label><input type="radio" name="utype" value="customer" checked>customer</label>
</div>
<div class="radio">
  <label><input type="radio" name="utype" value="admin">admin</label>
</div>
  <input type="submit" value="login">
</form>
</div>
</body>
</html>