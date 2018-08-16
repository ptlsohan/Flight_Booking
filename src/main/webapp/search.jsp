<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	
				<form action="fetchAvailFlight" >
					
					
					<div class="form-group">
						<label for="from">From</label>
						<input type="text" class="form-control" id="from" name="from" />
					</div>
					<div class="form-group">
						<label for="to">To</label>
						<input type="text" class="form-control" id="to" name="to" />
					</div>
					<div class="form-group">
						<label for="ondate">On</label>
						<input type="date" class="form-control" id="ondate" required name="ondate">
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
					<!-- <input type="submit" value="search" /> -->
				</form>
				<!-- <form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form> -->
			</div>
			
		</div>
	</div> 


<script src="./JS/auto.js"></script>
</body>
</html>
