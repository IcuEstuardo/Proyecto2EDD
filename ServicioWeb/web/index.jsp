<%-- 
    Document   : index
    Created on : 16/11/2016, 04:25:53 PM
    Author     : Estuardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Inicio</title>
    </head>
    <body>
        
        
        <div class="container">
            <div class="row">

                <div class="col-md-4">
                    <h2>Iniciar Sesion</h2>
                    
                    
                    <form action="Iniciar" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="txtUsername" placeholder="Username" required="">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="txtPass" placeholder="Password" required="">
                        </div>

                        <input type="submit" value="Iniciar" class="btn btn-primary" />
                    </form>
                </div>

                <div class="col-md-4 col-md-offset-3">
                    
                    <h2>Registrarse</h2>
                    <form action="AgregarUsuario" method="post">
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" class="form-control" name="txtUsername" placeholder="Nombre de usuario" required="">
                        </div>
                        <div class="form-group">
                            <label>Correo:</label>
                            <input type="text" class="form-control" name="txtPassword" placeholder="Password" required="">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" class="form-control" name="txtCorreo" placeholder="Direccion de correo" required="">
                        </div>

                        <input type="submit" value="Registrar" class="btn btn-primary" />
                    </form>
                </div>

            </div>
        </div>
        
        
    </body>
</html>

