<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Bienvenido a tu Dashboard!</h1>
        <p><a href="/nuevo" class=" btn btn-success">Nuevo Usuario!!</a></p>
    </div>
    <header>
       <table class="table table-hover">
           <thead> 
             <tr> 
                <th>Nombre<th>
                <th>Apellido<th>
                <th>Email<th>
                <th>Acciones<th>
             </tr>      
           </thead>
           <tbody>
               <c:forEach items="${usuarios}" var="usuario" >
					<tr>
						<td>${usuario.nombre}</td>
						<td>${usuario.apellido}</td>
						<td>${usuario.email}</td>
						<td>
							
							<form action="/borrar/${usuario.id}" method="post" >
							 	<!-- forzamos a que sea solicitud delete -->
								<input type="hidden" name="_method" value="DELETE" >
								<input type="submit" value="Borrar" class="btn btn-danger" >
							</form>
							<a href="/editar/${usuario.id}" class="btn btn-warning">Editar</a>
						</td>
					</tr>
				</c:forEach>
           
           </tbody>
       </table>
    </header>
</body>
</html>