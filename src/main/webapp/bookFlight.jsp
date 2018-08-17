<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<c:if test="${sessionScope.username !=null}">
	
	<form action="BookFlight" method="post">
	<input type="hidden" name="fnum" value="${param.val}" />
	<input type="hidden" name="pid" value="${sessionScope.pid}" />
	<div class="form-group">
    <label for="seatno">Seat no</label>
	<input type="number" id="seatno"  class="form-control" name="seatno" min=1 max=10 />
	</div>
	
	<div class="form-group">
    <label for="bag">Bags</label>
	<select name="baggage" id="bag"  class="form-control">
  <option value="1*checkin">1*checkin</option>
  <option value="2*checkin">2*checkin</option>
  <option value="3*checkin">3*checkin</option>
  <option value="no bag" selected>No Bags</option>
</select>
</div>

<div class="form-group">
    <label for="fclass">Class</label>
<select name="class" id="fclass"  class="form-control">
  <option value="Economy" selected>Economy</option>
  <option value="First class">First class</option>
  <option value="Businessn">Business</option>
  
</select>
</div>

<input type="hidden" name="status" id="status" value="confirmed" />
<input type="submit" value="submit"/>
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