<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-4 column">
				<form action="fetchAvailFlight" >
					
					
					<div class="form-group">
						<label for="from">From</label>
						<input type="text" id="from" name="from" />
					</div>
					<div class="form-group">
						<label for="to">To</label>
						<input type="text" id="to" name="to" />
					</div>
					<div class="form-group">
						<label for="ondate">On</label><input type="date" class="form-control" id="ondate" required name="ondate">
					</div>
					
					
					<input type="submit" value="search" />
				</form>
			</div>
			
		</div>
	</div>


</body>
</html>
