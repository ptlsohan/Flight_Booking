<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<c:if test="${sessionScope.username !=null}">
<form action="addProfile" method="post" >
  <div class="form-group">
    <label for="fname">First name</label>
    <input type="text" class="form-control" id="fname"  name="fname" placeholder="firstname" required>

  </div>
  
    
    <input type="hidden" class="form-control" id="username"  name="username" value="${sessionScope.username}" >


<div class="form-group">
    <label for="lname">Last name</label>
    <input type="text" class="form-control" id="lname"  name="lname" placeholder="lastname" required>

  </div>
  <div class="form-group">
    <label for="ssn">SSN</label>
    <input type="text" class="form-control" id="ssn"  name="ssn" >

  </div>
   <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email"  name="email" >

  </div>
  <div class="form-group">
    <label for="age">Age</label>
    <input type="number" class="form-control" id="age"  name="age" >

  </div>
  <div class="form-group">
    <label for="street">Street Address</label>
    <input type="text" class="form-control" id="street"  name="street" >

  </div>
  <div class="form-group">
    <label for="apt">Apartment</label>
    <input type="number" class="form-control" id="apt"  name="apt" >

  </div>
  <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city"  name="city" >

  </div>
  <div class="form-group">
    <label for="state">State</label>
    <input type="text" class="form-control" id="state"  name="state" >

  </div>
  <div class="form-group">
    <label for="zip">Zip code</label>
    <input type="number" class="form-control" id="zip"  name="zip" >

  </div>
   <div class="form-group">
    <label for="thome">Telephone(Home)</label>
    <input type="text" class="form-control" id="thome"  name="thome" >

  </div>
   <div class="form-group">
    <label for="toffice">Telephone</label>
    <input type="text" class="form-control" id="toffice"  name="toffice" >

  </div>
   </div>
   <div class="form-group">
    
    <input type="submit" class="form-control" value="Done!" >

  </div>
  </form>
  </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
  <div>
 Please login to edit profile <a href="./login.jsp">login page</a>
  </div>
  </c:if>
</div>
</body>
</html>