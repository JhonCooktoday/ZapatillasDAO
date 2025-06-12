<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String loginParam = request.getParameter("login");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  

    <style>
    
    @import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400..900&display=swap');
    
        body, html {
            height: 100%;
            font-family: "Orbitron", sans-serif;
            background: radial-gradient(circle,rgba(245, 228, 228, 1) 0%, rgba(235, 235, 235, 1) 50%, rgba(255, 198, 189, 1) 100%);
            font-size:20px;
        }

        .login-container {
            height: 100vh;
        }

        .card-custom {
            border: none;
            border-radius: 1rem;
            box-shadow: 0 0 40px rgba(0,0,0,0.1);
        }

        .form-control:focus {
            border-color: black;
            box-shadow: 0 0 0 0.2rem black;
        }

        .bg-image {
            background-image: url('imagenes/gif.gif');
            background-size: cover;
            background-position: center;
            border-top-right-radius: 1rem;
            border-bottom-right-radius: 1rem;
        }

        .btn-login {
            background-color: #6c63ff;
            color: white;
        }

        .btn-login:hover {
            background-color: #5548d9;
        }

        .text-muted a {
            text-decoration: none;
            color: #6c63ff;
        }

        .text-muted a:hover {
            text-decoration: underline;
        }
        
/* From Uiverse.io by thewizardofzen */ 
button {
  --primary-color: #ffff;
  --secondary-color: #002152;
  --hover-color: #eceff2;
  --arrow-width: 10px;
  --arrow-stroke: 2px;
  box-sizing: border-box;
  border: 0;
  border-radius: 50px;
  color: var(--secondary-color);
  padding: 1em 1.8em;
  background: var(--primary-color);
  display: flex;
  transition: 0.2s background;
  align-items: center;
  gap: 0.6em;
  font-weight: bold;
}

button .arrow-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
}

button .arrow {
  margin-top: 1px;
  width: var(--arrow-width);
  background: var(--primary-color);
  height: var(--arrow-stroke);
  position: relative;
  transition: 0.2s;
}

button .arrow::before {
  content: "";
  box-sizing: border-box;
  position: absolute;
  border: solid var(--secondary-color);
  border-width: 0 var(--arrow-stroke) var(--arrow-stroke) 0;
  display: inline-block;
  top: -3px;
  right: 3px;
  transition: 0.2s;
  padding: 3px;
  transform: rotate(-45deg);
}

button:hover {
  background-color: var(--hover-color);
}

button:hover .arrow {
  background: var(--secondary-color);
}

button:hover .arrow:before {
  right: 0;
}

        
    </style>
</head>
<body>

<div class="container login-container d-flex align-items-center justify-content-center">
    <div class="row w-100">
        <div class="col-md-10 col-lg-8 mx-auto">
            <div class="card card-custom overflow-hidden">
                <div class="row g-0">
                    <!-- Lado izquierdo -->
                    <div class="col-md-6 p-5">
                        <h3 class="fw-bold mb-4">Iniciar Sesión</h3><hr><br>
                        <form action="LoginServlet" method="post">
                            <div class="mb-4">
                                <label class="form-label">Nombre de Usuario</label>
                                <input type="text" name="username" class="form-control form-control-lg" required>
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Contraseña</label>
                                <input type="password" name="password" class="form-control form-control-lg" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit">
								  Iniciar Sesion
								  <div class="arrow-wrapper">
								    <div class="arrow"></div>
								  </div>
								</button>
                            </div>
                            
                        </form>
                    </div>
                   <!-- Carrusel lado derecho -->
				<div class="col-md-6 d-none d-md-block">
				    <div id="carouselLogin" class="carousel slide h-100" data-bs-ride="carousel">
				        <div class="carousel-inner h-100 rounded-end">
				            <div class="carousel-item active h-100">
				                <img src="imagenes/Ree.png" class="d-block w-100 h-100 object-fit-cover" alt="Slide 1">
				            </div>
				            <div class="carousel-item h-100">
				                <img src="imagenes/adidas.jpg" class="d-block w-100 h-100 object-fit-cover" alt="Slide 2">
				            </div>
				            <div class="carousel-item h-100">
				                <img src="imagenes/nike.jpg" class="d-block w-100 h-100 object-fit-cover" alt="Slide 3">
				            </div>
				            <div class="carousel-item h-100">
				                <img src="imagenes/converse.png" class="d-block w-100 h-100 object-fit-cover" alt="Slide 3">
				            </div>
				        </div>
				    </div>
				</div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- SweetAlert para mensajes -->
<script>
    <% if ("success".equals(loginParam)) { %>
        Swal.fire({
            icon: 'success',
            title: '¡Bienvenido!',
            text: 'Inicio de sesión exitoso.',
            confirmButtonColor: '#6c63ff'
        });
    <% } else if ("error".equals(loginParam)) { %>
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Usuario o contraseña incorrectos.',
            confirmButtonColor: '#6c63ff'
        });
    <% } %>
</script>

<script>
  const carouselElement = document.querySelector('#carouselLogin');
  if (carouselElement) {
    new bootstrap.Carousel(carouselElement, {
      interval: 500, // Cambia cada 3 segundos
      ride: 'carousel'
    });
  }
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
