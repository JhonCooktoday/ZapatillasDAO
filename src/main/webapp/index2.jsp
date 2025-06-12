<%@ page import="app.Modelo.Zapatilla" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio | Tienda de Zapatillas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #1c1f23;
            color: white;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.4rem;
        }
        .card {
            border-radius: 1rem;
            box-shadow: 0 4px 8px rgba(0,0,0,0.5);
            transition: transform 0.2s ease-in-out;
        }
        .card:hover {
            transform: scale(1.02);
        }
        .card-title {
            color: #ffc107;
        }
        footer {
            border-top: 2px solid rgba(255, 255, 255, 0.2);
        }
    </style>
</head>
<body class="d-flex flex-column min-vh-100">
<header class="bg-danger py-3 shadow-sm">
    <div class="container d-flex justify-content-between align-items-center">
        <span class="navbar-brand text-white">Zapatillas Jhon</span>
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container-fluid p-0">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item me-3"><a href="bienvenido.jsp" class="nav-link text-white">Regresar</a></li>
                        <li class="nav-item me-3"><a class="nav-link text-white" href="Index">Inicio</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">Zapatilla</a>
                            <ul class="dropdown-menu">
                                <li><a href="IndexZapatilla" class="dropdown-item">Buscar</a></li>
                                <li><a href="RegistrarZapatilla" class="dropdown-item">Registrar</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>
	<main class="container py-5 flex-fill">
		<h1 class="text-center mb-5 text-warning">Zapatillas en Stock</h1>
		<div class="row g-4">
			<c:forEach var="z" items="${zapatillas}">
				<div class="col-sm-6 col-md-4">
					<a href="DetalleZapatilla?id=${z.idZapatilla}"
						class="text-decoration-none">
						<div class="card bg-dark text-white h-100">
							<div class="card-body">
								<h5 class="card-title text-warning">${z.modelo}</h5>
								<ul class="list-unstyled">
									<li><strong>Color:</strong> ${z.color}</li>
									<li><strong>Talla:</strong> ${z.talla}</li>
									<li><strong>Precio:</strong> S/.${z.precio}</li>
									<li><strong>Stock:</strong> ${z.stock}</li>
								</ul>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</main>
<footer class="bg-danger text-center text-white py-3 mt-auto">
    <p class="mb-0">&copy; 2025 by Jhon and Nicolas</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>