<%-- 
    Document   : nuevo
    Created on : 25 abr 2023, 18:00:07
    Author     : Roko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark navbar-li d-flex justify-content-between"
                 style="background-color: #739072">
                <h3 class="text-center mx-5" style="color: #EBE4D1">Creación módulos de Software - GA7-220501096-AA2-EV01</h3>
                <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarNav">
                    <ul class="navbar-nav mx-5">
                        <li class="nav-item">
                            <a class="nav-link fs-3" href="./">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-3" href="SvProductos?accion=nuevo">Añadir</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <br>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <h2>Agregar producto</h2>
                    <br/>

                    <form action="SvProductos?accion=insertar" method="POST">
                        <p>Código: <input id="codigo" type="text" name="txtcodigo" class="form-control"></p>
                        <p>Nombre: <input id="nombre" type="text" name="txtnombre" class="form-control"></p>
                        <p>Precio: <input id="precio" type="text" name="txtprecio" class="form-control"></p>
                        <p>Existencia: <input id="existencia" type="text" name="txtexistencia" class="form-control"></p>
                        <button id="registrar" name="registrar" type="submit"class="btn btn-success">Registrar</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
