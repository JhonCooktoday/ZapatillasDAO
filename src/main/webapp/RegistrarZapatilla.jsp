<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="app.Modelo.Marca" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Zapatilla</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            max-width: 600px;
            margin: 0 auto;
        }
        .form-label {
            font-weight: bold;
            color: #ffffff; 
        }
        .btn {
            width: 48%;
        }
        body {
            background-color: #212529;
        }
        .card {
            background-color: #343a40;
        }
        .form-control, .form-select {
            background-color: #495057;
            color: #fff;
        }
        .btn-secondary {
            background-color: #6c757d;
        }
        .btn-success {
            background-color: #28a745;
        }
    </style>
</head>
<body>

<div class="container mt-5" >
    <div class="card shadow-lg rounded" style="min-width: 1000px;">
        <div class="card-header text-white text-center bg-danger">
            <h4 class="mb-0">Registrar Nueva Zapatilla</h4>
        </div>
<div class="card-body">
    <form action="RegistrarZapatilla" method="post" id="formZapatilla" enctype="multipart/form-data" >
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="modelo" class="form-label">Modelo</label>
                    <input type="text" class="form-control" id="modelo" name="modelo" required>
                </div>

                <div class="mb-3">
                    <label for="color" class="form-label">Color</label>
                    <input type="text" class="form-control" id="color" name="color" required>
                </div>

                <div class="mb-3">
                    <label for="talla" class="form-label">Talla</label>
                    <input type="number" step="0.5" class="form-control" id="talla" name="talla" required>
                </div>

                <div class="mb-3">
                    <label for="precio" class="form-label">Precio (S/)</label>
                    <input type="number" step="0.01" class="form-control" id="precio" name="precio" required>
                </div>

                <div class="mb-3">
                    <label for="stock" class="form-label">Stock</label>
                    <input type="number" class="form-control" id="stock" name="stock" required>
                </div>

                <div class="mb-3">
                    <label for="genero" class="form-label">Género</label>
                    <select class="form-select" id="genero" name="genero" required>
                        <option value="">Seleccione</option>
                        <option value="Hombre">Hombre</option>
                        <option value="Femenino">Femenino</option>
                        <option value="Unisex">Unisex</option>
                    </select>
                </div>
            </div>

            <div class="col-md-6">
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo</label>
                    <input type="text" class="form-control" id="tipo" name="tipo" required>
                </div>

                <div class="mb-3">
                    <label for="fechaIngreso" class="form-label">Fecha de Ingreso</label>
                    <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso" required>
                </div>

                <div class="mb-3">
                    <label for="marca" class="form-label">Marca</label>
                    <select class="form-select" id="marca" name="marca" required>
                        <option value="">Seleccione una marca</option>
                        <%
                            List<Marca> marcas = (List<Marca>) request.getAttribute("atrListaMarcas");
                            if (marcas != null) {
                                for (Marca m : marcas) {
                        %>
                            <option value="<%= m.getIdMarca() %>"><%= m.getNombreMarca() %></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="imagen" class="form-label">Imagen</label>
                    <input type="file" class="form-control" id="imagen" name="imagen" accept="image/*" required>
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-between mt-4">
            <a href="IndexZapatilla" class="btn btn-secondary">Cancelar</a>
            <button type="submit" class="btn btn-success">Registrar</button>
        </div>
    </form>
</div>

    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    document.getElementById('formZapatilla').addEventListener('submit', function(event) {
        // Prevenir el envío del formulario para manejarlo después
        event.preventDefault(); 

        if (!this.checkValidity()) {
            Swal.fire({
                icon: 'error',
                title: '¡Error!',
                text: 'Por favor, rellene todos los campos obligatorios.',
                confirmButtonText: 'Cerrar'
            });
        } else {
            Swal.fire({
                icon: 'success',
                title: '¡Zapatilla registrada!',
                text: 'La zapatilla fue registrada correctamente.',
                confirmButtonText: 'Ir a la lista',
                allowOutsideClick: false, 
                showLoaderOnConfirm: true 
            }).then((result) => {
                if (result.isConfirmed) {
                    this.submit(); 
                }
            });
        }
    });
</script>
</body>
</html>