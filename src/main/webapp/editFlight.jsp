<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	
	<c:if test="${sessionScope.username !=null && \"admin\".equals(sessionScope.usertype)}">
	<div class="row justify-content-center" style="color:black;">
  <div class="col-md-8">
<div class="card" style="margin:20px; padding:10px;" >
  <div class="card-header">
   <h4>Edit Flight </h4> 
  </div>
<form action="updateFlight" method="post"  id="editflight" >
  <div class="form-group">
    
    <input type="hidden" class="form-control" id="fno" name="fno" value="${flist.getFlight_number()}"  >

  </div>
  <div class="form-group">
    <label for="dtime">Departure time</label>
    <input type="text" class="form-control" id="dtime" name="dtime" placeholder="HH:MM:SS" value="${flist.getDeparture_time() }">

  </div>
  
  <div class="form-group">
    <label for="ddate">Departure date</label>
    <input type="date" class="form-control" id="ddate" name="ddate" placeholder="yyyy-mm-dd"  value="${flist.getDeparture_date() }">

  </div>
  <div class="form-group">
    <label for="atime">Arrival time</label>
    <input type="text" class="form-control" id="atime" name="atime" placeholder="HH:MM:SS" value="${flist.getArrival_time() }">

  </div>
  
  <div class="form-group">
    <label for="adate">Arrival date</label>
    <input type="date" class="form-control" id="adate" placeholder="yyyy-mm-dd" name="adate" value="${flist.getArrival_date() }" >

  </div>
   
  <div class="form-group">
    <label for="air_id">Airplane Id</label>
    <select name="air_id" id="air_id" form="editflight">
    <option  value="${flist.getAirplane_id() }" selected>${flist.getAirplane_id() }</option>
    </select>
<%--     <input type="number" class="form-control" id="air_id" name="air_id" value="${flist.getAirplane_id() }" > --%>

  </div>
  <div class="form-group">
    <label for="d_city">Departure city</label>
    <input type="text" class="form-control" id="d_city" name="d_city" value="${flist.getDeparture_city() }"  >

  </div>
  <div class="form-group">
    <label for="a_city">Arrival city</label>
    <input type="text" class="form-control" id="a_city" name="a_city"  value="${flist.getArrival_city() }">

  </div>
   
  <div class="form-group">
    <label for="eseat">Economy seat</label>
    <input type="number" class="form-control" id="eseat" name="eseat" min=0 value="${requestScope.seat.getEconomy_seat()}" >

  </div>
  <div class="form-group">
    <label for="fseat">First class Seat</label>
    <input type="number" class="form-control" id="fseat" name="fseat" min=0 value="${requestScope.seat.getFirst_seat()}" >

  </div>
  <div class="form-group">
    <label for="bseat">Business class seat</label>
    <input type="number" class="form-control" id="bseat" name="bseat"  min=0 value="${requestScope.seat.getBusiness_seat()}">

  </div>

  <button type="submit" class="btn btn-primary" style="margin:5px;">Update</button><a href="listFlight"><button type="button" class="btn btn-primary" style="margin:5px;">Cancel</button></a>
</form>
</div>
</div>
</div>
</div>
 </c:if>
  <c:if test="${sessionScope.username==null }">
  <div>
<div>
 Please login to continue <a href="./login.jsp">login page</a>
  </div>
  </c:if>

</div>
<script  src="./JS/fetchId.js">
</script>
<script  src="./JS/validate.js">
</script>
</body>
</html>