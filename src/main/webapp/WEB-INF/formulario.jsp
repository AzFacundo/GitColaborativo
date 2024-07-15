<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
       <div class="col-6">
           <form action="/registro" method="POST">
               <div>
                 <label> Nombre:</label>
                 <input type="text" name="nombre" class="form-control">
                 <p class="text-danger">${errorNombre}</p>
               </div>
               <div>
                 <label> E-mail:</label>
                 <input type="email" name="email" class="form-control">
               </div>
               <input type="submit" class="btn btn-succes mt-3" value="enviar">
           </form>
       </div>
    </div>
</body>
</html>