<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registrar Empleado </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <style>
    body {
      background-color: #333;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .form-box {
      max-width: 420px;
      margin: 60px auto;
      background: #fff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 0 20px rgba(0,0,0,0.3);
      
    }
    h5 {
      font-weight: bold;
      text-align: center;
      color: #222;
      margin-bottom: 25px;
    }
    label {
      color: #000;
      text-shadow: 1px 1px 1px #aaa;
      font-weight: 500;
    }
    .form-control {
      border-radius: 6px;
      font-size: 0.95rem;
    }
    .btn-primary {
      background-color: #a60000;
      border: none;
    }
    .btn-primary:hover {
      background-color: #800000;
    }
    .btn-secondary {
      background-color: #555;
      border: none;
    }
    .btn-secondary:hover {
      background-color: #444;
    }
    
    input[type="text"]{
    border: 1px solid black;
    }
    input[type="email"]{
    border: 1px solid black;
    }
    input[type="date"]{
    border: 1px solid black;
    }
    input[type="number"]{
    border: 1px solid black;
    }
    
  </style>
</head>
<body>

<div class="form-box">
  <h5>Registrar Empleado</h5>
  <form action="ControllerEmp" method="post">
    <input type="hidden" name="accion" value="insertar">

    <div class="mb-3">
      <label class="form-label">Nombre</label>
      <input type="text" class="form-control" name="nombre" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Apellido</label>
      <input type="text" class="form-control" name="apellido" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Correo</label>
      <input type="email" class="form-control" name="correo" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Telefono</label>
      <input type="text" class="form-control" name="telefono" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Direccion</label>
      <input type="text" class="form-control" name="direccion" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Fecha Contratacion</label>
      <input type="date" class="form-control" name="fechaContratacion" required>
    </div>
    <div class="mb-4">
      <label class="form-label">Salario</label>
      <input type="number" class="form-control" name="salario" step="0.01" required>
    </div>

    <button class="btn btn-primary w-100 mb-2" type="submit">Registrar</button>
    <a href="bienvenido.jsp" class="btn btn-secondary w-100">Regresar</a>
  </form>
</div>

<script>
  const urlParams = new URLSearchParams(window.location.search);
  if (urlParams.get('registrado') === 'true') {
    Swal.fire({
      title: '¡Registro exitoso!',
      text: 'El empleado ha sido registrado correctamente.',
      icon: 'success',
      confirmButtonText: 'Aceptar'
    });
  }
</script>

</body>
</html>
