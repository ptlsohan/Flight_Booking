
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<form action="registerUser" method="post" >
  <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="uname"  name="uname" placeholder="Username">

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
  <input type="submit" value="register">
</form>
</div>
</body>
</html>