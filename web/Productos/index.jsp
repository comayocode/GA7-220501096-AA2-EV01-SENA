<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <a class="nav-link fs-3" href="JavaWebAlmacenProductos">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-3" href="SvProductos?accion=nuevo">Añadir</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <br>

        <div class="">
            <div class="container">
                <h1 class="text-center">Lista de Productos</h1>
                <hr/>
                <div class="container text-left">
                    <a href="SvProductos?accion=nuevo" class="btn btn-success">Nuevo Producto</a>
                </div>

                <br>

                <table class="table table-striped">
                    <thead style="background-color: #232D3F" class="table-dark">
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Existencia</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <!-- forEach que proviene de la librería JSTL -->
                        <c:forEach var="producto" items="${listaProductos}">

                            <tr>
                                <td><c:out value="${producto.codigo}" /></td>
                                <td><c:out value="${producto.nombre}" /></td>
                                <td><c:out value="${producto.precio}" /></td>
                                <td><c:out value="${producto.existencia}" /></td>
                                <td><a href="SvProductos?accion=vermodificar&urlid=<c:out value="${producto.id}" />">Modificar</a></td>
                                <td><a href="SvProductos?accion=eliminar&urlid=<c:out value="${producto.id}" />">Eliminar</a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
