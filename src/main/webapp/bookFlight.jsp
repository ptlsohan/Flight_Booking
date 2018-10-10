<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<c:if test="${sessionScope.username !=null}">
	<div class="container">
	<div class="row justify-content-center" style="color:black;">
  <div class="col-md-6">
<div class="card" style="margin:20px; padding:10px;" >
  <div class="card-header">Book Flight</div>
	<form action="BookFlight" method="post">
	<input type="hidden" name="fnum" id="fnum" value="${param.val}" />
	<input type="hidden" name="pid" value="${sessionScope.pid}" />
	<input type="hidden" id="version" name="version" value="0" />
	<div class="form-group">
    <label for="fclass">Class</label>
<select name="class" id="fclass"  class="form-control">
  <option value="Economy" selected>Economy</option>
  <option value="First class">First class</option>
  <option value="Business">Business</option>
  
</select>
</div>
 <label for="seatno" class="label-control">Number of Seat</label>
	<div class="input-group">
    
     <span class="input-group-btn">
              <button type="button" class="btn btn-danger btn-number" onclick="removeSeat(event)" data-type="minus" data-field="quant[2]">
                <span class="glyphicon glyphicon-minus">-</span>
              </button>
          </span>
   <!--  <button type="button" onclick="removeSeat(event)" class="rem">-</button> -->
	<input type="text" readonly id="seatno"  class="form-control input-number" name="seatno" min=1 value="1" />
	 <!-- <button type="button" onclick="addSeat(event)" class="add">+</button> -->
	 <span class="input-group-btn">
              <button type="button" onclick="addSeat(event)" class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                  <span class="glyphicon glyphicon-plus">+</span>
              </button>
          </span>
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



<input type="hidden" name="status" id="status" value="confirmed" />
 <button type="submit" class="btn btn-primary" id="submit" >Book</button>
	</form>
	</div>
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
	
</div>
<script  src="./JS/bookScript.js">
</script>
</body>
</html>