<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
display page
<table class="table" id="parent-list">
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
      <td><form><input type="hidden" id="val" value=${li}/><button id="book_flight">Book</button></form></td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>

<script src="./JS/bookScript.js"></script>
</body>
</html>