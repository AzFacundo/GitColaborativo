<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
   <div class="container">
      <h1>Nuevo Usuario</h1>
      <form:form action="/crear" method="post" modelAttribute="usuario">
         <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" class="form-control"/>
            <form:errors path="nombre" class="text-danger"/>
         </div>
         <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" class="form-control"/>
            <form:errors path="apellido" class="text-danger"/>
         </div>
         <div>
            <form:label path="email">Email:</form:label>
            <form:input path="email" class="form-control"/>
            <form:errors path="email" class="text-danger"/>
         </div>
         <div>
            <form:label path="Password">Password:</form:label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password" class="text-danger"/>
         </div>
         <input type="submit" value="guardar usuario" class="btn btn-success">
      </form:form>
   </div>
</body>
</html>