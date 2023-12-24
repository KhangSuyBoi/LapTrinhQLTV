<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing category information</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
		<div id="wrapper">
		    <div class="container">
		        <div class="row justify-content-around">
		            <form action="/upload" method="post" enctype="multipart/form-data" class="bg-black text-light col-md-5 bg-light p-3 my-3 rounded">
		            	<h1 class=" tex-uppercase h3">Editing category information</h1>
		            	
		            	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
		            	
						<div class="form-group">
						    <label for="category">Category</label>
						    <input type="text" name="category" id="category" class="form-control">
						</div>
	                  	
	                  	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
	                  	      
					    <div class="form-group">
					    	<div class="d-grid gap-2">
					        	<input type="button" value="Lưu" class=" btn btn-primary mt-1" onclick="location.href='manage_category.jsp'">
					     	</div>
						
					     	<div class="d-grid gap-2">
					         	<input type="button" value="Hủy" class="btn btn-secondary mt-1" onclick="location.href='manage_category.jsp'">
					     	</div>
					    </div>
		            </form>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>