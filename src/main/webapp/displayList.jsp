<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
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
      <td><button>Edit</button></td>
      <td><button>Delete</button></td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>