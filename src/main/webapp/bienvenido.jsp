<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>Bienvenido</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body class="bg-dark text-white">

<style>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400..900&display=swap');

 body, html {
            height: 100%;
            font-family: "Orbitron", sans-serif;
            background: radial-gradient(circle,rgba(245, 228, 228, 1) 0%, rgba(235, 235, 235, 1) 50%, rgba(255, 198, 189, 1) 100%);
            font-size:20px;
        }



@keyframes zoomInOut {
  0%, 100% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.2);
  }
}

.zoom-animation {
  animation: zoomInOut 2s infinite ease-in-out;
}
</style>


<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-black">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">
            Bienvenido, <%= usuario.getNombreUsuario() %> ❤️
        </span>
        <form id="logoutForm" action="CerrarSesion" method="post" class="d-inline">
            <button type="button" class="btn btn-outline-light" onclick="confirmarCierreSesion()">Cerrar sesión</button>
        </form>
    </div>
</nav>

<!-- FOTO DE PERFIL -->
<div class="container mt-5 text-center">
    <h2 class="text-dark">Tu perfil</h2><br><br>
    <img src="MostrarImagen?id=<%= usuario.getId() %>" 
         class="rounded-circle border border-black zoom-animation" 
         width="250" height="250" />
</div>
<br><br>

<!-- BOTÓN NUEVO -->
<div class="container text-center mt-4">
    <a href="forminsertar.jsp" class="btn btn-danger">Nuevo Usuario</a>
</div>

<!-- BOTONES DE EMPLEADOS -->
<div class="container text-center mt-4">
    <div class="row justify-content-center">
        <div class="col-auto">
            <form action="ControllerEmp" method="get" class="d-inline">
                <input type="hidden" name="accion" value="listar">
                <button type="submit" class="btn btn-primary">Listar Empleados</button>
            </form>
        </div>
        <div class="col-auto">
            <form action="ControllerEmp" method="get" class="d-inline">
                <input type="hidden" name="accion" value="insertar">
                <button type="submit" class="btn btn-success">Insertar Empleado</button>
            </form>
        </div>
    </div>
    <div class="row justify-content-center mt-3">
        <div class="col-auto">
            <form action="Index" method="get" class="d-inline">
                <input type="hidden" name="accion" value="insertar">
                <button type="submit" class="btn btn-info">Gestionar Tienda Zapatillas</button>
            </form>
        </div>
    </div>
</div>





<!-- SWEETALERTS -->
<script>
    function confirmarCierreSesion() {
        Swal.fire({
            title: '¿Cerrar sesión?',
            text: 'Se cerrará tu sesión actual.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#6c757d',
            confirmButtonText: 'Sí, cerrar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                document.getElementById('logoutForm').submit();
            }
        });
    }

    <% if ("success".equals(loginParam)) { %>
        Swal.fire({
            icon: 'success',
            title: 'Bienvenido',
            text: 'Inicio de sesión exitoso.',
            confirmButtonColor: '#dc3545'
        });
    <% } %>
</script>

</body>
</html>
