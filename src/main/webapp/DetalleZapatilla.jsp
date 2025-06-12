<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <title>Detalle de la Zapatilla</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #212529;
            color: #f8f9fa;
        }
        .detalle-container {
            max-width: 650px;
            margin: 50px auto;
            background-color: #343a40;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.5);
        }
        .detalle-container h2 {
            color: #dc3545;
            margin-bottom: 30px;
            text-align: center;
        }
        .detalle-item {
            padding: 10px 0;
            border-bottom: 1px solid #495057;
        }
        .detalle-item:last-child {
            border-bottom: none;
        }
        .campo {
            font-weight: bold;
            color: #ffc107;
        }
        .btn-regresar {
            background-color: #dc3545;
            border: none;
        }
        .btn-regresar:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="detalle-container">
        <h2>Detalle de la Zapatilla</h2>
        
        <div class="detalle-item"><span class="campo">ID:</span> ${ atrZapatilla.getIdZapatilla() }</div>
        <div class="detalle-item"><span class="campo">Modelo:</span> ${ atrZapatilla.getModelo() }</div>
        <div class="detalle-item"><span class="campo">Color:</span> ${ atrZapatilla.getColor() }</div>
        <div class="detalle-item"><span class="campo">Talla:</span> ${ atrZapatilla.getTalla() }</div>
        <div class="detalle-item"><span class="campo">Precio:</span> S/.${ atrZapatilla.getPrecio() }</div>
        <div class="detalle-item"><span class="campo">Stock:</span> ${ atrZapatilla.getStock() }</div>
        <div class="detalle-item"><span class="campo">Género:</span> ${ atrZapatilla.getGenero() }</div>
        <div class="detalle-item"><span class="campo">Tipo:</span> ${ atrZapatilla.getTipo() }</div>
        <div class="detalle-item"><span class="campo">Fecha de Ingreso:</span> ${ atrZapatilla.getFechaIngreso() }</div>
        <div class="detalle-item"><span class="campo">Marca:</span> ${ atrZapatilla.getMarca().getNombreMarca() }</div>

        <div class="text-center mt-4">
            <a href="IndexZapatilla" class="btn btn-regresar text-white px-4">← Regresar</a>
        </div>
    </div>
</body>
</html>