<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<form action="addFlightDetail" method="post" >
  <div class="form-group">
    <label for="fno">Flight number</label>
    <input type="number" class="form-control" id="fno" name="fno"  >

  </div>
  <div class="form-group">
    <label for="dtime">Departure time</label>
    <input type="text" class="form-control" id="dtime" name="dtime" placeholder="HH:MM:SS" >

  </div>
  
  <div class="form-group">
    <label for="ddate">Departure date</label>
    <input type="date" class="form-control" id="ddate" name="ddate"  >

  </div>
  <div class="form-group">
    <label for="atime">Arrival time</label>
    <input type="text" class="form-control" id="atime" name="atime" placeholder="HH:MM:SS" >

  </div>
  
  <div class="form-group">
    <label for="adate">Arrival date</label>
    <input type="date" class="form-control" id="adate" name="adate"  >

  </div>
   
  <div class="form-group">
    <label for="air_id">Airplane Id</label>
    <input type="number" class="form-control" id="air_id" name="air_id"  >

  </div>
  <div class="form-group">
    <label for="d_city">Deaparture city</label>
    <input type="text" class="form-control" id="d_city" name="d_city"  >

  </div>
  <div class="form-group">
    <label for="a_city">Arrival city</label>
    <input type="text" class="form-control" id="a_city" name="a_city"  >

  </div>

  <input type="submit" value="Add">
</form>
</div>
</body>
</html>