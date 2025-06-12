<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.Modelo.Usuario" %>
<%
    String loginParam = request.getParameter("login");
    HttpSession sesion = request.getSession(false);
    Usuario usuario = (sesion != null) ? (Usuario) sesion.getAttribute("usuario") : null;

    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Empleados</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body class="bg-dark text-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Panel de Empleados</a>
    <div class="d-flex align-items-center ms-auto">
      <span class="me-2 fw-semibold text-white">
        <%= usuario.getNombreUsuario() %>
      </span>
      <img src= "MostrarImagen?id=<%= usuario.getId() %>" alt="Foto" class="rounded-circle" width="40" height="40" style="object-fit: cover;">
    </div>
  </div>
</nav>

<!-- ALERTAS -->
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('registrado') === 'true') {
      Swal.fire({
        title: '¡Registro exitoso!',
        text: 'El empleado ha sido registrado correctamente.',
        icon: 'success',
        confirmButtonText: 'Aceptar'
      });
      const url = new URL(window.location);
      url.searchParams.delete('registrado');
      window.history.replaceState({}, document.title, url.toString());
    }

    if (urlParams.get('actualizado') === 'true') {
      Swal.fire({
        title: '¡Actualización Exitosa!',
        text: 'El empleado ha sido actualizado correctamente.',
        icon: 'success',
        confirmButtonText: 'Aceptar'
      });
    }
  });

  function eliminarEmpleado(id) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: "¡Este empleado será eliminado permanentemente!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '¡Sí, eliminarlo!',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        window.location.href = "ControllerEmp?accion=eliminar&id=" + id;
      }
    });
  }
</script>

<!-- TABLA DE EMPLEADOS -->
<div class="container mt-5">
  <h4 class="mb-4 text-center">Empleados Registrados</h4>

  <div class="table-responsive">
    <table class="table table-hover table-bordered align-middle shadow-sm rounded" style="font-size: 14px;">
      <thead class="text-white text-center" style="background: linear-gradient(90deg, #0d6efd, #6610f2);">
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Correo</th>
          <th>Teléfono</th>
          <th>Dirección</th>
          <th>Fecha Contratación</th>
          <th>Salario</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="empleado" items="${empleados}">
          <tr>
            <td class="text-center">${empleado.id}</td>
            <td>${empleado.nombre}</td>
            <td>${empleado.apellido}</td>
            <td>${empleado.correo}</td>
            <td>${empleado.telefono}</td>
            <td>${empleado.direccion}</td>
            <td class="text-center">${empleado.fechaContratacion}</td>
            <td class="text-end">S/ ${empleado.salario}</td>
            <td class="text-center">
              <div class="d-flex justify-content-center gap-2">
                <a href="Update?accion=editar&id=${empleado.id}" class="btn btn-sm btn-warning">
                  <i class="fas fa-pen me-1"></i> Editar
                </a>
                <a href="javascript:void(0);" onclick="eliminarEmpleado(${empleado.id});" class="btn btn-sm btn-danger">
                  <i class="fas fa-trash-alt me-1"></i> Eliminar
                </a>
              </div>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="text-center mt-4">
    <a href="bienvenido.jsp" class="btn btn-outline-light">Regresar</a>
  </div>
  <button class="btn btn-success" onclick="mostrarPDF()">
  <i class="fas fa-file-pdf"></i> Generar PDF
</button>



<div id="previewPDF" class="mt-4" style="display: none;">
  <h5 class="text-center">Vista previa del PDF</h5>
  <iframe src="" width="100%" height="500px" style="border: 2px solid #28a745; border-radius: 8px;"></iframe>
</div>

  
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<script>
  function mostrarPDF() {
    const preview = document.getElementById("previewPDF");
    const iframe = preview.querySelector("iframe");

    iframe.src = "Report"; // La URL del servlet PDF
    preview.style.display = "block";

    // Scroll automático hasta la vista previa
    preview.scrollIntoView({ behavior: "smooth" });
  }
</script>

