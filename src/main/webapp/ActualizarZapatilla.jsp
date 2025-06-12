<%@ page import="app.Modelo.Zapatilla, app.Modelo.Marca" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actualizar Zapatilla</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #212529; 
            color: #ffffff;
        }
        .container {
            background-color: #343a40; 
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            color: #ffffff; 
        }
        .btn-primary {
            background-color: #007bff; 
            color: #ffffff;
        }
        .btn-secondary {
            background-color: #dc3545; 
            color: #ffffff;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h3 class="mb-4">Actualizar Zapatilla</h3>
    <form action="ActualizarZapatilla" method="post" class="row g-3">

        <input type="hidden" name="id" value="${zapatilla.idZapatilla}">

        <div class="col-md-6">
            <label class="form-label">Modelo</label>
            <input type="text" name="modelo" class="form-control" value="${zapatilla.modelo}" required>
        </div>

        <div class="col-md-6">
            <label class="form-label">Color</label>
            <input type="text" name="color" class="form-control" value="${zapatilla.color}" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Talla</label>
            <input type="number" name="talla" class="form-control" value="${zapatilla.talla}" step="0.5" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Precio</label>
            <input type="number" name="precio" class="form-control" value="${zapatilla.precio}" step="0.01" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Stock</label>
            <input type="number" name="stock" class="form-control" value="${zapatilla.stock}" required>
        </div>

        <div class="col-md-4">
            <label for="genero" class="form-label">Género</label>
            <select class="form-select" id="genero" name="genero" required>
                <option value="">Seleccione</option>
                <option value="Hombre" <c:if test="${zapatilla.genero == 'Hombre'}">selected</c:if>>Hombre</option>
                <option value="Femenino" <c:if test="${zapatilla.genero == 'Femenino'}">selected</c:if>>Femenino</option>
                <option value="Unisex" <c:if test="${zapatilla.genero == 'Unisex'}">selected</c:if>>Unisex</option>
            </select>
        </div>

        <div class="col-md-4">
            <label class="form-label">Tipo</label>
            <input type="text" name="tipo" class="form-control" value="${zapatilla.tipo}" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Fecha Ingreso</label>
            <input type="date" name="fechaIngreso" class="form-control" value="${zapatilla.fechaIngreso}" required>
        </div>

        <div class="col-md-12">
            <label class="form-label">Marca</label>
            <select name="marca" class="form-select" required>
                <c:forEach var="marca" items="${marcas}">
                    <option value="${marca.idMarca}" ${zapatilla.marca.idMarca == marca.idMarca ? 'selected' : ''}>
                        ${marca.nombreMarca}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="IndexZapatilla?marca=${zapatilla.marca.idMarca}" class="btn btn-secondary">Cancelar</a>
        </div>
    </form>
</div>
</body>
</html>