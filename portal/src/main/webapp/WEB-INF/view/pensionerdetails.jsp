<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Pension Form</title>
  </head>
  <body>
  <center>
    <h1>Welcome Member</h1>
</center><br><br>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <div class="container">
  	<form:form action="/submitinfo" method="post" modelAttribute="pensionerInput">
 	<div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Name :</label>
    <div class="col-sm-10">
      <form:input path="name" placeholder="Enter Pensioner's Name"  class="form-control" required="required"/>
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="dateOfBirth" class="col-sm-2 col-form-label">D.O.B:</label>
    <div class="col-sm-10">
      <form:input path="dateOfBirth" placeholder="Enter your D.O.B"  class="form-control" required="required"/>
    </div>
  </div>
 
   <div class="form-group row">
    <label for="pan" class="col-sm-2 col-form-label">PAN Number:</label>
    <div class="col-sm-10">
      <form:input path="pan" placeholder="Enter your PanCard" class="form-control"  required="required"/>
    </div>
  </div>
 
 
   <div class="form-group row">
    <label for="aadhar" class="col-sm-2 col-form-label">AadharCard Number:</label>
    <div class="col-sm-10">
      <form:input path="aadharNumber" class="form-control" placeholder="Enter your AadharCard Number"  length="12"  required="required"/>
    </div>
  	  </div>		
  	 
  	 <div class="form-group row">
  			<label for="selfPension" class="col-sm-2 col-form-label">Self Pension:</label>
  			<form:checkbox path="selfPension" class="form-control"/>
  			
  			<label for="familyPension" class="col-sm-2 col-form-label">Family Pension:</label>
  			<form:checkbox path="familyPension" class="form-control"/>
		
		
	  </div>

             
 
  <br><br>
 <center>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Submit</button>
      <button type="reset" class="btn btn-primary">Reset</button>
    </div>
  </div>
</center>
</form:form>

  </div>
  </body>
</html>