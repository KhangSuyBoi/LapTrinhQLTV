<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing member information</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
		<div id="wrapper">
		    <div class="container">
		        <div class="row justify-content-around">
		            <form action="/upload" method="post" enctype="multipart/form-data" class="bg-black text-light col-md-5 p-3 my-3">
		            	<h1 class=" tex-uppercase h3 ">Editing member information</h1>
		            	
		            	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
		            	
						<div class="form-group">
						    <label for="name">Fullname</label>
						    <input type="text" name="name" id="name" class="form-control bg-dark">
						</div>
					                  
					    <div class="form-group">
						    <label for="id">Citizen identification</label>
						    <input type="text" name="id" id="id" class="form-control bg-dark">
						</div>
						
						<div class="form-group">
						    <label for="tel">Tel</label>
						    <input type="text" name="tel" id="tel" class="form-control bg-dark">
						</div>
	                    
	                    <hr style="border-top: 1px solid white; margin-bottom: 20px;">
	                    
					    <div class="form-group ">
					    	<div class="d-grid gap-2">
					        	<input type="button" value="Submit" class=" btn btn-primary mt-1" onclick="location.href='manage_reader.jsp'">
					     	</div>
					
					     	<div class="d-grid gap-2">
					         	<input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='manage_reader.jsp'">
					     	</div>
					    </div>
		            </form>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>