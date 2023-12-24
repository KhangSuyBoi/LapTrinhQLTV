<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add ticket</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="/upload" method="post" enctype="multipart/form-data" class="bg-black text-light col-md-5 bg-light p-3 my-3">
                        <h1 class=" tex-uppercase h3">Add Ticket</h1>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <label for="name">Full name</label>
                            <input type="text" name="name" id="name" class="form-control bg-dark" style="color:white;">
                        </div>
                        
                        <div class="form-group">
                            <label for="id">Identification</label>
                            <input type="text" name="id" id="id" class="form-control bg-dark" style="color:white;">
                        </div>
                        
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" name="title" id="title" class="form-control bg-dark" style="color:white;">
                        </div>
                        
                        <div class="form-group">
						    <label for="bd">Borrow date</label>
						    <input type="date" name="bd" id="bd" class="form-control bg-dark" style="color:white;">
						</div>
                        
                        <div class="form-group">
                            <label for="pd">Payment date</label>
                            <input type="date" name="pd" id="pd" class="form-control bg-dark" style="color:white;">
                        </div>
            			
            			<hr style="border-top: 1px solid white; margin-bottom: 20px;">
            			
                        <div class="form-group">
                        	<div class="d-grid gap-2">
	                            <input type="button" value="Submit" class=" btn btn-primary mt-1" onclick="location.href='manage_ticket.jsp'">
	                        </div>
	
	                        <div class="d-grid gap-2">
	                            <input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='manage_ticket.jsp'">
	                        </div>
                        </div>
                        
    
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>