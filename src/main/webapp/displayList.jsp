<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${sessionScope.username !=null && \"admin\".equals(sessionScope.usertype)}">
<div>

<button type="button" class="btn btn-primary"><a href="addFlight.jsp">Add Flight</a></button>
</div>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Flight no</th>
      <th scope="col">Arrival time</th>
      <th scope="col">Arrival date</th>
      <th scope="col">Departure time</th>
      <th scope="col">Departure date</th>
      <th scope="col">Departure city</th>
      <th scope="col">Arrival city</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
 
<c:forEach items="${list}" var="li">
<tr>
      <th scope="row">${li.flight_number}</th>
      <td>${li.arrival_time}</td>
      <td>${li.arrival_date}</td>
      <td>${li.departure_time}</td>
      <th>${li.departure_date}</th>
      <td>${li.departure_city}</td>
      <td>${li.arrival_city}</td>
      <td><form action="editFlight.jsp" method="post"><input type="hidden" id="val" name="f" value="${li.flight_number}"/><button>Edit</button></form></td>
      <td><form action="deleteFlight" method="post"><input type="hidden" id="val" name="fno" value="${li.flight_number}"/><button>Delete</button></form></td>
    </tr>
</c:forEach>
</tbody>
</table>

</div>
 </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
<div>
 Please login to continue <a href="./login.jsp">login page</a>
  </div>
  </c:if>
</body>
</html>