<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>List of book</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="" class="bg-black text-light col-md-10 bg-light p-3 my-3">
                        <div class="row">
                    		<div class="col-md-5">
		                    	<h1 class=" tex-uppercase h3 py-2">List of books</h1>
		                    </div>
		                    
		                    <div class="col-md-7 my-2 text-right">
		                    	<div class="input-group">
								  <input type="text" class="form-control bg-dark" placeholder="Title" aria-label="Recipient's username" aria-describedby="basic-addon2" style="color: white;">
								  <span class="input-group-text bg-primary text-light" id="basic-addon2" onclick="location.href='search_book.jsp'"><i class="fa-solid fa-magnifying-glass"></i></span>
								</div>
	                    	</div>
                    	</div>
                    	
                    	<div class="container">			                            	
                           	<button type="button" class="btn btn-success mt-1" id="edit" onclick="location.href='add_book.jsp'">
						        <i class="fa-solid fa-plus"></i> Add books
						    </button>
                    	</div>
                    	
                        <div class="container mt-3">          
                            <table class="table table-dark text-light">
                              <thead>
                                <tr class="">
                                  <th class="col-1">No.</th>
                                  <th class="col-2">Title</th>
                                  <th class="col-2">Category</th>
                                  <th>Quantity</th>
                                  <th>Bookshelf's id</th>
                                  <th>Cover image</th>
                                  <th class="col-1 text-center">Editing</th>
                                  <th class="col-1 text-center">Delete</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <th></th>
                                  <td></td>
                                  <td>
                                  	<div class="d-grid gap-2">			                            	
		                            	<button type="button" class="btn btn-primary mt-1" id="edit" onclick="location.href='edit_book.jsp'">
									        <i class="fa-solid fa-pen-to-square"></i>
									    </button>
		                        	</div>
                                  </td>
                                  <td>
                                  	<div class="d-grid gap-2">			                            	
		                            	<button type="button" class="btn btn-danger mt-1" id="delete">
									        <i class="fa-solid fa-trash"></i>
									    </button>
		                        	</div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                          
                          <div class="container">			                            	
	                           	<button type="button" class="btn btn-secondary mt-1" id="edit" onclick="location.href='manage_book.jsp'">
							        <i class="fa-solid fa-chevron-left"></i> Back
							    </button>
                    	  </div>
                          
                    </form>
                </div>
            </div>
        </div>

    </section>
</body>
</html>