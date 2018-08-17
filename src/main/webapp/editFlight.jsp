<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	
	<c:if test="${sessionScope.username !=null && \"admin\".equals(sessionScope.usertype)}">
	
<form action="updateFlight" method="post" >
  <div class="form-group">
    
    <input type="hidden" class="form-control" id="fno" name="fno" value="${sessionScope.flist.getFlight_number() }"  >

  </div>
  <div class="form-group">
    <label for="dtime">Departure time</label>
    <input type="text" class="form-control" id="dtime" name="dtime" placeholder="HH:MM:SS" value="${sessionScope.flist.getDeparture_time() }">

  </div>
  
  <div class="form-group">
    <label for="ddate">Departure date</label>
    <input type="date" class="form-control" id="ddate" name="ddate"  value="${sessionScope.flist.getDeparture_date() }">

  </div>
  <div class="form-group">
    <label for="atime">Arrival time</label>
    <input type="text" class="form-control" id="atime" name="atime" placeholder="HH:MM:SS" value="${sessionScope.flist.getArrival_time() }">

  </div>
  
  <div class="form-group">
    <label for="adate">Arrival date</label>
    <input type="date" class="form-control" id="adate" name="adate" value="${sessionScope.flist.getArrival_date() }" >

  </div>
   
  <div class="form-group">
    <label for="air_id">Airplane Id</label>
    <input type="number" class="form-control" id="air_id" name="air_id" value="${sessionScope.flist.getAirplane_id() }" >

  </div>
  <div class="form-group">
    <label for="d_city">Departure city</label>
    <input type="text" class="form-control" id="d_city" name="d_city" value="${sessionScope.flist.getDeparture_city() }"  >

  </div>
  <div class="form-group">
    <label for="a_city">Arrival city</label>
    <input type="text" class="form-control" id="a_city" name="a_city"  value="${sessionScope.flist.getArrival_city() }">

  </div>

  <input type="submit" value="Update">
</form>
 </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
<div>
 Please login to continue <a href="./login.jsp">login page</a>
  </div>
  </c:if>

</div>
</body>
</html>