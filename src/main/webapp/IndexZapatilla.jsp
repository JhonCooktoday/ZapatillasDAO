<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="app.Modelo.Marca" %>
<%@ page import="app.Modelo.Zapatilla" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio | Tienda de Zapatillas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body {
            background-color: #212529; 
            color: #ffffff;
        }
        .card {
            background-color: #495057;
        }
        .card-header, .table th {
            background-color: #495057; 
            color: #ffffff; 
        }
        label, .form-label {
            color: #ffffff;
        }
    </style>
</head>
<body class="d-flex flex-column vh-100">
<header class="bg-info d-flex justify-content-around align-items-center bg-danger">
    <h5>Zapatillas Jhon</h5>
    <nav class="navbar navbar-expand-lg">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav d-flex flex-row">
                    <li class="nav-item me-3"><a href="bienvenido.jsp" class="nav-link">Regresar</a></li>
                    <li class="nav-item me-3"><a class="nav-link" href="Index">Inicio</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Zapatilla</a>
                        <ul class="dropdown-menu">
                            <li><a href="IndexZapatilla" class="dropdown-item">Buscar</a></li>
                            <li><a href="RegistrarZapatilla" class="dropdown-item">Registrar</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main class="container flex-fill py-4">
    <!-- Formulario de búsqueda -->
    <div class="card mb-4 shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Buscar zapatillas por marca</h5>
        </div>
        <div class="card-body">
            <form class="row g-3" action="IndexZapatilla" method="post">
                <div class="col-md-6">
                    <label for="marca" class="form-label">Marca</label>
                    <select name="cmbMarca" id="marca" class="form-select">
                        <option selected disabled>Selecciona una marca</option>
                        <c:forEach var="m" items="${atrListaMarcas}">
                            <option value="${m.idMarca}">${m.nombreMarca}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 d-flex align-items-end">
                    <button type="submit" class="btn btn-success w-100">Buscar</button>
                </div>
            </form>
        </div>
    </div>

    <c:if test="${not empty atrListaZapatillas}">
        <div class="card shadow-sm">
            <div class="card-header bg-secondary text-white">
                <h5 class="mb-0">Resultados de Zapatillas</h5>
            </div>
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle mb-0">
                        <thead class="table-light">
                            <tr>
                                <th>ID</th>
                                <th>Modelo</th>
                                <th>Color</th>
                                <th>Talla</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Género</th>
                                <th>Tipo</th>
                                <th>Fecha Ingreso</th>
                                <th>Marca</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="zp" items="${atrListaZapatillas}">
                                <tr>
                                    <td>${zp.idZapatilla}</td>
                                    <td>${zp.modelo}</td>
                                    <td>${zp.color}</td>
                                    <td>${zp.talla}</td>
                                    <td>${zp.precio}</td>
                                    <td>${zp.stock}</td>
                                    <td>${zp.genero}</td>
                                    <td>${zp.tipo}</td>
                                    <td>${zp.fechaIngreso}</td>
                                    <td>${zp.marca.nombreMarca}</td>
                                    <td>
                                        <div class="btn-group" role="group">
                                            <a href="ActualizarZapatilla?id=${zp.idZapatilla}" class="btn btn-sm btn-primary">Editar</a>
                                            <a href="DetalleZapatilla?id=${zp.idZapatilla}" class="btn btn-sm btn-info text-white">Ver Detalle</a>
                                            <a href="IndexZapatilla?accion=eliminar&id=${zp.idZapatilla}&marca=${zp.marca.idMarca}" class="btn btn-danger btn-sm">Eliminar</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>
</main>

<c:if test="${not empty mensaje}">
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            Swal.fire({
                icon: 'success',
                title: 'Aviso',
                text: '${mensaje}',
                confirmButtonText: 'Aceptar'
            });
        });
    </script>
</c:if>

<footer class="bg-info text-center fs-5 py-2 bg-danger">
    <p class="m-0">&copy;2025 by Jhon and Nicolas</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>