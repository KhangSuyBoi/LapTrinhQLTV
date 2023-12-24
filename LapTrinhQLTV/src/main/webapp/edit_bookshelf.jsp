<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing bookshelf information</title>
</head>
<body style="background-color: #343541;">
	<section class="content">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="/upload" method="post" enctype="multipart/form-data" class="bg-black text-light col-md-5 bg-light p-3 my-3">
                        <h1 class=" tex-uppercase h3">Editing bookshelf information</h1>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <label for="id">Bookshelf's id</label>
                            <input type="text" name="id" id="id" class="form-control bg-dark">
                        </div>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                        	<div class="d-grid gap-2">
	                            <input type="button" value="Submit" class=" btn btn-primary mt-1" onclick="location.href='manage_bookshelf.jsp'">
	                        </div>
	
	                        <div class="d-grid gap-2">
	                            <input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='manage_bookshelf.jsp'">
	                        </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>