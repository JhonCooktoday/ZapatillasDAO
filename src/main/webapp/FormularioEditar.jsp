<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Empleado</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #333; 
      color: #f8f9fa; 
    }
    
    .container {
      max-width: 600px;
      background-color: #fff;
      border-radius: 10px;
      padding: 30px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    h4 {
      text-align: center;
      color: #e31c1c; /* Rojo oscuro para el encabezado */
      font-weight: bold;
    }

    .form-control {
      background-color: #f8f9fa; 
      border: 1px solid #ccc;
      color: #333; 
    }

    .form-label {
      font-size: 1.1rem;
      font-weight: bold;
      color: #000; 
      text-shadow: 0px 0px 0px #000; 
    }

    .btn-primary {
      background-color: #e31c1c; 
      border-color: #e31c1c;
    }

    .btn-primary:hover {
      background-color: #c71616; 
      border-color: #c71616;
    }

    .btn-secondary {
      background-color: #555; 
      border-color: #666;
    }

    .btn-secondary:hover {
      background-color: #666;
      border-color: #777;
    }

    .btn {
      font-weight: bold;
    }
  </style>
</head>
<body>

<div class="container mt-5">
  <h4 class="mb-4">Editar Empleado ✍️</h4>
  
  <!-- Formulario para editar el empleado -->
  <form action="SubirCambios?accion=actualizar" method="post">
    <input type="hidden" name="id" value="${empleado.id}" /> <!-- ID del empleado -->
    
    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre</label>
      <input type="text" class="form-control" id="nombre" name="nombre" value="${empleado.nombre}" required>
    </div>
    
    <div class="mb-3">
      <label for="apellido" class="form-label">Apellido</label>
      <input type="text" class="form-control" id="apellido" name="apellido" value="${empleado.apellido}" required>
    </div>
    
    <div class="mb-3">
      <label for="correo" class="form-label">Correo</label>
      <input type="email" class="form-control" id="correo" name="correo" value="${empleado.correo}" required>
    </div>
    
    <div class="mb-3">
      <label for="telefono" class="form-label">Teléfono</label>
      <input type="text" class="form-control" id="telefono" name="telefono" value="${empleado.telefono}" required>
    </div>
    
    <div class="mb-3">
      <label for="direccion" class="form-label">Dirección</label>
      <input type="text" class="form-control" id="direccion" name="direccion" value="${empleado.direccion}" required>
    </div>
    
    <div class="mb-3">
      <label for="fechaContratacion" class="form-label">Fecha de Contratación</label>
      <input type="date" class="form-control" id="fechaContratacion" name="fechaContratacion" value="${empleado.fechaContratacion}" required>
    </div>
    
    <div class="mb-3">
      <label for="salario" class="form-label">Salario</label>
      <input type="number" class="form-control" id="salario" name="salario" value="${empleado.salario}" required>
    </div>
    
    <button type="submit" class="btn btn-primary w-100">Actualizar</button>
  </form>
  
  <a href="bienvenido.jsp" class="btn btn-secondary mt-3 w-100">Regresar</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
