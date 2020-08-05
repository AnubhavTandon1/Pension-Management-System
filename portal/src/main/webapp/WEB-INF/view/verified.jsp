<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pensioner Verified</title>
</head>
<body>
	
		<div class="container">
		<h3>Name : ${name}</h3>
		<h3>P.A.N  : ${pan}</h3>
		<h3>D.O.B  : ${dob}</h3>
		<h3>Pension Type  : ${pensionType}</h3>
		<h3>Pension Amount: ${pensionAmount}</h3>
		</div>
<a  href="http://localhost:8090/disburse" class="btn btn-default">Link for disbursement</a>
</body>
</html>