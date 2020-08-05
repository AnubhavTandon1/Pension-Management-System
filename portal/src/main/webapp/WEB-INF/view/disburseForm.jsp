<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Pension Process</title>
</head>
<body>
    <div class="container" align="center">
        <h2>Enter Pension Process Input</h2>
        <form:form action="/disburse" method="post" modelAttribute="processPensionInput">
            <form:label path="aadharNumber">Aadhar Number :</form:label>
            <form:input path="aadharNumber"  class="form-control" placeholder="Enter the Pensioner's Aadhar Number"  length="12" required="required"/><br/>
 
            <form:label path="pensionAmount">Pension Amount:</form:label>
            <form:input path="pensionAmount" class="form-control" placeholder="Enter the Pension Amount" required="required"/><br/>
            
             <form:label path="bankCharge">Bank Charge:</form:label>
            <form:input path="bankCharge" class="form-control"  placeholder="Enter the Bank Charge according to its type" required="required"/><br/>
            
            <input type="submit" value="Submit" >
			<input type="reset" value="Reset">

        </form:form>
    </div>
</body>
</html>