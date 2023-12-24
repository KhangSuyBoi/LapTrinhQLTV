<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>List of categories</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="" class="bg-black text-light col-md-6 bg-light p-3 my-3">
                        <div class="row">
                    		<div class="col-md-9">
		                    	<h1 class=" tex-uppercase h3 py-2">List of categories</h1>
		                    </div>
		                    
		                    <div class="col-md-3 d-flex justify-content-end ">			                            	
	                           	<button type="button" class="btn btn-success mt-6" id="edit" onclick="location.href='add_category.jsp'">
							        <h6>Add categories</h6><i class="fa-solid fa-plus"></i> 
							    </button>
	                    	</div>
                    	</div>
                    	
                    	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
                    	
                        <div class="container mt-3">          
                            <table class="table table-dark">
                              <thead>
                                <tr class="">
                                  <th class="col-1">No.</th>
                                  <th>Category</th>
                                  <th class="col-1">Editing</th>
                                  <th class="col-1">Delete</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <td></td>
                                  <td></td>
                                  <td>
                                  	<div class="d-grid gap-2">			                            	
		                            	<button type="button" class="btn btn-primary mt-1" id="edit" onclick="location.href='edit_author.jsp'">
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
                          
    
                    </form>
                </div>
            </div>
        </div>

    </section>
</body>
</html>