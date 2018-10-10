<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${sessionScope.username !=null}">
	<div class="container" >
	<div class="row justify-content-center">
	<div class="jumbotron col-md-8" style="color:black; margin-top:10px;">
	<main role="main" class="inner cover">
       
        <h3 style="text-align: center;"><strong>Booking successful!</strong>
        </h3>
      </main>
	
	<table  class="table">

  <tbody>
  <tr><td><strong>Booking id:</strong></td><td>${sessionScope.bookId}</td></tr>
  <tr><td><strong>First name:</strong></td><td>${sessionScope.fname}</td></tr>
  <tr><td><strong>Last name:</strong></td><td>${sessionScope.lname}</td></tr>
  <tr><td><strong>Flight number:</strong></td><td>${sessionScope.f.getFlight_number()}</td></tr>
  <tr><td><strong>Departure city:</strong></td><td>${sessionScope.f.getDeparture_city()}</td></tr>
  <tr><td><strong>Departure date:</strong></td><td>${sessionScope.f.getDeparture_date()}</td></tr>
  <tr><td><strong>Departure time:</strong></td><td>${sessionScope.f.getDeparture_time()}</td></tr>
   <tr><td><strong>Arrival city:</strong></td><td>${sessionScope.f.getArrival_city()}</td></tr>
  <tr><td><strong>Arrival date:</strong></td><td>${sessionScope.f.getArrival_date()}</td></tr>
  <tr><td><strong>Arrival time:</strong></td><td>${sessionScope.f.getArrival_time()}</td></tr>
  <tr><td><strong>Class:</strong></td><td>${sessionScope.fclass}</td></tr>
  <tr><td><strong>Number of seat:</strong></td><td>${sessionScope.seat}</td></tr>
	</table>
</div>
</div>
</div>
</c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
  <div>
 Please login to edit profile <a href="./login.jsp">login page</a>
  </div>
  </c:if>
</body>
</html>