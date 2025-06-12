<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Fondo claro */
        }
        .container {
            max-width: 600px;
            margin-top: 5rem;
        }
        .card {
            border-radius: 10px;
            border: 1px solid #343a40; /* Borde negro */
        }
        .card-body {
            padding: 2rem;
            background-color: #212529; /* Fondo oscuro */
        }
        .card-title {
            font-size: 1.8rem;
            font-weight: bold;
            color: #dc3545; /* Rojo */
            text-align: center;
        }
        .form-label {
            font-size: 1.1rem;
            font-weight: 500;
            color: #d1d1d1; /* Plomo */
        }
        .form-control {
            border-radius: 0.375rem;
            border-color: #343a40; /* Borde negro */
            background-color: #495057; /* Fondo plomo oscuro */
            color: #fff; /* Texto blanco */
        }
        .form-control:focus {
            border-color: #dc3545; /* Rojo */
            box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.25);
        }
        .btn-primary {
            background-color: #dc3545; /* Rojo */
            border-color: #dc3545;
            transition: background-color 0.3s ease;
            width: 100%;
        }
        .btn-primary:hover {
            background-color: #c82333; /* Rojo oscuro */
            border-color: #c82333;
        }
        .btn-secondary {
            background-color: #6c757d; /* Plomo */
            border-color: #6c757d;
            transition: background-color 0.3s ease;
            width: 100%;
            margin-top: 1rem; /* Separar el botón de regresar */
        }
        .btn-secondary:hover {
            background-color: #5a6268; /* Plomo oscuro */
            border-color: #5a6268;
        }
        .alert {
            text-align: center;
            font-size: 1rem;
            margin-top: 1rem;
        }
        .alert-success {
            background-color: #28a745; /* Verde */
            color: white;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card shadow-lg">
        <div class="card-body">
            <h3 class="card-title">Formulario de Registro</h3>
            <form action="Controller" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="mb-3">
                    <label for="contrasena" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                </div>
                <div class="mb-3">
                    <label for="fileFoto" class="form-label">Imagen</label>
                    <input type="file" class="form-control" id="fileFoto" name="fileFoto" required>
                </div>
                <div class="d-grid">
                    <button type="submit" name="accion" value="Guardar" class="btn btn-primary">Guardar</button>
                    <a href="bienvenido.jsp" class="btn btn-secondary">Regresar</a> <!-- Botón regresar -->
                </div>
            </form>

            <% String mensaje = (String) request.getAttribute("mensaje"); %>
            <% if ("ok".equals(mensaje)) { %>
                <div class="alert alert-success">¡Persona registrada correctamente!</div>
            <% } %>
        </div>
    </div>
</div>

<!-- Bootstrap JS (opcional para interactividad) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
