<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<div>
	<div class="row justify-content-center" style="color:black;">
  <div class="col-md-6">
<div class="card" style="margin:20px; padding:10px;" >
  <div class="card-header">
   <h4>Search Flight </h4> 
  </div>
				<form action="fetchAvailFlight" >
					
					
					<div class="form-group">
						
						<label class=" control-label" for="from"><strong>From</strong></label>
						<input type="text" class="form-control" id="from" name="from" placeholder="From"  />
					</div>
					<div class="form-group">
						<label class=" control-label" for="to"><strong>To</strong></label>
						<input type="text" class="form-control" id="to" name="to" placeholder="To" />
					</div>
					<div class="form-group">
						<label class=" control-label" for="ondate"><strong>Date</strong></label>
						<input type="date" class="form-control" id="ondate" required name="ondate" min="2018-08-19" placeholder="yyyy-mm-dd">
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				</div>
			
		</div>
			
		</div>
			</div>
			
		</div>
	


<script src="./JS/auto.js"></script>
<script type="text/javascript">
$().ready(function(){
	$.validator.addMethod( "dateNL", function( value, element ) {
		return this.optional( element ) || /^([12]\d)?(\d\d)[\.\/\-](0?[1-9]|1[012])[\.\/\-](0?[1-9]|[12]\d|3[01])$/.test( value );
	}, $.validator.messages.date );
	$('form').validate({
		rules: {
		from: {
		required: true	
		},
		to: {
			required: true	
			},
		ondate: {
			required: true,
			dateNL: true
		}
		},messages: {
			from: {
				required: "Please enter departure city"	
			},
			to: {
				required:  "Please enter destination city"		
				},
			ondate: {
					required: "Please enter departure date",
					dateNL : "Invalid date format"
				}
		}
		});
});
</script>
<script type="text/javascript">

var Msg ='<%=session.getAttribute("alertMsg")%>';
    if (Msg != "null") {
 function alertName(){
 alert(Msg);
 
 } 
 <%session.removeAttribute("alertMsg");%>
 }
    
  
 </script>
  
 <script type="text/javascript"> window.onload = alertName; </script>
</body>
</html>
