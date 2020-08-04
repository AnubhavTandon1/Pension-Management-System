<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pensioner's Detail Form</title>
</head>
<body>
    <div align="center">
        <h2>Pensioner's Detail Form</h2>
        <form:form action="register" method="post" modelAttribute="user">
            <form:label path="name">Full name:</form:label>
            <form:input path="name"/><br/>
       
             
                 
 
            <form:label path="birthday">Birthday (yyyy-mm-dd):</form:label>
            <form:input path="birthday"/><br/>
            
             <form:label path="Pan">PAN:</form:label>
            <form:input path="Pan"/><br/>
            
             <form:label path="aadhaar">Aadhaar:</form:label>
            <form:input path="aadhaar"/><br/>
             
            <form:label path="type">type:</form:label>
            <form:radiobutton path="type" value="Self"/>Self
            <form:radiobutton path="type" value="FamilyPension"/>FamilyPension<br/>
             
            
             
          
            <form:button>SUBMIT</form:button>
        </form:form>
    </div>
</body>
</html>