<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing book information</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
		<div id="wrapper">
		    <div class="container">
		        <div class="row justify-content-around">
		            <form action="/upload" method="post" enctype="multipart/form-data" class="bg-black text-light col-md-5 bg-light p-3 my-3">
		            	<h1 class=" tex-uppercase h3">Editing book information</h1>
		            	
		            	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
		            	
							<div class="form-group">
							    <label for="title">Title</label>
							    <input type="text" name="title" id="title" class="form-control bg-dark">
							</div>
						                        
						    <div class="form-group">
							    <label for="category">Category</label>
							    <select name="category" id="category" class="form-control bg-dark">
							        <option value="0">a</option>
							        <option value="1">b</option>
							        <option value="2">c</option>
							    </select>
							</div>
						
						    <div class="form-group">
						        <label for="soluong">Quantity</label>
						        <input type="number" name="soluong" id="soluong" class="form-control bg-dark" min="0">
						    </div>
						                        
						    <div class="form-group">
							    <label for="id">Bookshelf's id</label>
							    <select name="id" id="id" class="form-control bg-dark">
							        <option value="0">101</option>
							        <option value="1">102</option>
							        <option value="2">103</option>
							    </select>
							</div>
						                        
						    <div class="form-group">
						    	<label for="image">Cover image</label>
						    	<input type="file" name="image" id="image" class="form-control bg-dark" accept="image/*" style="color:white;">
						    </div>
						                     	
			                <hr style="border-top: 1px solid white; margin-bottom: 20px;">
						                     	
						    <div class="form-group">
						    	<div class="d-grid gap-2">
						        	<input type="button" value="Submit" class=" btn btn-primary mt-1" onclick="location.href='manage_book.jsp'">
						     	</div>
						
						     	<div class="d-grid gap-2">
						         	<input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='manage_book.jsp'">
						     	</div>
						    </div>
		            </form>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>