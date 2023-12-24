<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of tickets</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="" class="bg-black text-light col-md-12 bg-light p-3 my-3">
                    	<div class="row">
                    		<div class="col-md-9">
		                    	<h1 class=" tex-uppercase h3 py-2">List of tickets</h1>
		                    </div>
		                    
		                    <div class="col-md-3 d-flex justify-content-end ">			                            	
	                           	<button type="button" class="btn btn-success mt-6" id="edit" onclick="location.href='add_ticket.jsp'">
							        <h6>Add tickets</h6><i class="fa-solid fa-plus"></i> 
							    </button>
	                    	</div>
                    	</div>
                    	
                    	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
                    	
                        <div class="container mt-3">          
                            <table class="table table-dark">
                              <thead>
                                <tr class="">
                                  <th class="col-1">No.</th>
                                  <th>Fullname</th>
                                  <th>Identification</th>
                                  <th>Title</th>
                                  <th>Borrow date</th>
                                  <th>Payment date</th>
                                  <th class="col-1">Status</th>
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
                                  <td></td>
                                  <td></td>
                                  <td>
                                  	<div class="d-grid gap-2">
			                            <input type="button" value="status" class=" btn btn-success mt-1">
			                        </div>
                                  </td>
                                  <td>
                                  	<div class="d-grid gap-2">			                            	
		                            	<button type="button" class="btn btn-primary mt-1" id="edit" onclick="location.href='edit_ticket.jsp'">
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
      </div>
    </section>
</body>
</html>